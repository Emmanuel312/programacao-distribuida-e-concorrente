package main

import (
	"fmt"
	"math/rand"
	"sync"
	"sync/atomic"
	"time"
)

var count = 0

type Car struct {
	boardQueue   *sync.Cond
	unboardQueue *sync.Cond
	board        *sync.Cond
	unboard      *sync.Cond
	boarding     int32
	unboarding   int32
	boarded      int32
	capacity     int32
}

type Passenger struct {
	id int
}

func carFactory(c int32) *Car {
	return &Car{
		sync.NewCond(new(sync.Mutex)),
		sync.NewCond(new(sync.Mutex)),
		sync.NewCond(new(sync.Mutex)),
		sync.NewCond(new(sync.Mutex)),
		0,
		0,
		0,
		c,
	}
}

func load(c *Car) {
	//signal para o passageiro
	c.boardQueue.L.Lock()
	c.board.Signal()
	// atomic.StoreInt32(&c.boarding, 1)
	for c.boarded < c.capacity {
		c.boardQueue.Wait()
		c.board.Signal()
		// fmt.Printf("Total embarcado até agora: %v \n", atomic.LoadInt32(&c.boarded))
	}
	// atomic.StoreInt32(&c.boarding, 0)
	fmt.Println("[E] Todos os passageiros embarcaram")
	c.boardQueue.L.Unlock()
}

func run(c *Car) {
	fmt.Println("[R] Vrum Vrum")
}

func unload(c *Car) {
	c.unboardQueue.L.Lock()
	c.unboard.Signal()
	// atomic.StoreInt32(&c.unboarding, 1)
	for c.boarded > 0 {
		c.unboardQueue.Wait()
		c.unboard.Signal()
	}

	fmt.Println("[D] Todos os passageiros desembarcaram")
	c.unboardQueue.L.Unlock()
}

func board(p *Passenger, c *Car) {

	c.board.L.Lock()
	c.boardQueue.Signal()
	c.board.Wait()
	//wait board
	for atomic.LoadInt32(&c.boarded) == c.capacity {
		fmt.Printf("[W] Passageiro %v aguardando para embarcar \n", p.id)
		c.board.Wait()
	}
	// if atomic.LoadInt32(&c.boarding) == 1 {
	fmt.Printf("[E] Passageiro %v embarcou no carro \n", p.id)
	atomic.AddInt32(&c.boarded, 1)
	c.boardQueue.Signal()
	// }

	c.board.L.Unlock()
}

func unboard(p *Passenger, c *Car) {
	c.unboard.L.Lock()
	c.unboard.Wait()
	//último passageiro diz para o carro que já está vazio
	// if atomic.LoadInt32(&c.boarded) == 1 {
	// }
	fmt.Printf("[D] Passageiro %v desembarcou\n", p.id)
	atomic.AddInt32(&c.boarded, -1)
	c.unboardQueue.Signal()
	c.unboard.L.Unlock()
}

func car(c *Car) {

	for {
		load(c)
		run(c)
		unload(c)
	}

}

func passenger(id int, c *Car) {
	p := &Passenger{id}

	time.Sleep(time.Duration(rand.Intn(400)))
	board(p, c)
	unboard(p, c)
}

func main() {

	var capacity int32 = 5
	var p = 30

	c := carFactory(capacity)
	go car(c)

	for i := 0; i < p; i++ {
		go passenger(i, c)
	}
	// milli, _ := time.ParseDuration("5s")
	// time.Sleep(milli)
	_, _ = fmt.Scanln()

}
