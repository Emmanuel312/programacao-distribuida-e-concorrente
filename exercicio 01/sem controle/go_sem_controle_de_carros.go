package main

import (
	"fmt"
	"sync"
)

var wg = sync.WaitGroup{}

func f1() {
	defer wg.Done()
	for {
		fmt.Printf("Carro 1 entrou na pista\n")
		fmt.Printf("Carro 1 saiu da pista\n")
	}
}

func f2() {
	defer wg.Done()
	for {
		fmt.Printf("Carro 2 entrou na pista\n")
		fmt.Printf("Carro 2 saiu da pista\n")
	}
}

func main() {

	wg.Add(1)
	go f1()
	wg.Add(1)
	go f2()
	wg.Wait()
	fmt.Println("Done!")
}
