// alunos:
// Emmanuel Felipe Nery (efn)
// Jonathan Kilner dos Santos (jkss)
// Luiz Antonio de Albuquerque Junior (laaj)

package main

import (
	"fmt"
	"math/rand"
	"sync"
	"sync/atomic"
	"time"
)

type Store struct {
	buffer          []int
	producerCond    *sync.Cond
	consumerCond    *sync.Cond
	wg              *sync.WaitGroup
	offset          int32
	consumerCount   int32
	producerWaiting int32
}

func storeFactory() *Store {
	return &Store{make([]int, 0), sync.NewCond(new(sync.Mutex)), sync.NewCond(new(sync.Mutex)), &sync.WaitGroup{}, 0, 0, 0}
}

func consumer(store *Store, id int) {
	fmt.Printf("Consumidor %v consumindo o valor %v \n", id, store.consume(id))
	time.Sleep(time.Duration(rand.Intn(100)) * time.Millisecond)
	store.wg.Done()
}

func (store *Store) consume(id int) int {

	store.consumerCond.L.Lock()

	if atomic.LoadInt32(&store.producerWaiting) == 1 {
		store.producerCond.Signal()
	}

	atomic.AddInt32(&store.consumerCount, 1)

	fmt.Printf("Consumidor %v bloqueado até que o produtor envie algo...\n", id)
	store.consumerCond.Wait()
	value := store.buffer[store.offset]

	store.consumerCond.L.Unlock()
	return value
}

func producer(store *Store, value int) {
	store.produce(value)
	store.wg.Wait()
	fmt.Println("Todos os consumidores encerraram")
	atomic.StoreInt32(&store.offset, 1)
	atomic.StoreInt32(&store.consumerCount, 0)

	fmt.Println("Offset e a quantidade de consumidores ativos foram alterado")
}

func (store *Store) produce(value int) {
	store.producerCond.L.Lock()

	store.buffer = append(store.buffer, value)

	for atomic.LoadInt32(&store.consumerCount) == 0 {
		atomic.AddInt32(&store.producerWaiting, 1)
		store.producerCond.Wait()
	}

	atomic.StoreInt32(&store.producerWaiting, 0)
	fmt.Println("Produz o valor ", value)

	store.consumerCond.L.Lock()
	fmt.Println("Liberando os consumidores...")
	store.consumerCond.Broadcast()
	store.consumerCond.L.Unlock()

	store.producerCond.L.Unlock()
}

func generateRandomNumberOfConsumers() int {
	min := 1
	max := 10
	rand.Seed(time.Now().UnixNano())
	randomNumberOfConsumers := rand.Intn((max - min)) + min
	fmt.Printf("Quantidade de consumidores = %v \n", randomNumberOfConsumers)

	return randomNumberOfConsumers
}

func case1(store *Store) {
	for i := 0; i < 1; i++ {
		randomNumberOfConsumers := generateRandomNumberOfConsumers()

		for i := 0; i < randomNumberOfConsumers; i++ {
			store.wg.Add(1)
			go consumer(store, i)
		}

		time.Sleep(3000)

		rand.Seed(time.Now().UnixNano())
		go producer(store, rand.Intn(100))
	}
}

func case2(store *Store) {
	for i := 0; i < 1; i++ {
		randomNumberOfConsumers := generateRandomNumberOfConsumers()

		rand.Seed(time.Now().UnixNano())
		go producer(store, rand.Intn(100))
		time.Sleep(3000)
		for i := 0; i < randomNumberOfConsumers; i++ {
			store.wg.Add(1)
			go consumer(store, i)
		}
	}
}

func generalCase(store *Store) {
	for i := 0; i < 1; i++ {
		randomNumberOfConsumers := generateRandomNumberOfConsumers()

		rand.Seed(time.Now().UnixNano())
		go producer(store, rand.Intn(100))

		for i := 0; i < randomNumberOfConsumers; i++ {
			store.wg.Add(1)
			go consumer(store, i)
		}
	}
}

func main() {
	store := storeFactory()

	generalCase(store)

	_, _ = fmt.Scanln()

}
