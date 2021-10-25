package main

import (
	"fmt"
	"sync"
)

var (
	wg = sync.WaitGroup{}
	mu = sync.Mutex{}
)

func f1(ch chan int) {
	defer wg.Done()
	for 1 == 1 {
		mu.Lock()
		fmt.Printf("Carro 1 entrou na pista\n")
		fmt.Printf("Carro 1 saiu da pista\n")
		mu.Unlock()

	}
}

func f2(ch chan int) {
	defer wg.Done()
	for 1 == 1 {
		mu.Lock()
		fmt.Printf("Carro 2 entrou na pista\n")
		fmt.Printf("Carro 2 saiu da pista\n")
		mu.Unlock()
	}
}

func main() {
	var ch = make(chan int)
	wg.Add(1)
	go f1(ch)
	wg.Add(1)
	go f2(ch)
	wg.Wait()
	fmt.Println("Done!")
}
