from threading import Thread
import sys
import time


# Quantidaade de Carros na Esquerda e na direita
COUNTDOWN = 1000

class Th(Thread):

  def __init__ (self, num):
    Thread.__init__(self)
    self.num = num
    self.countdown = COUNTDOWN

  def run(self):
    while (self.countdown):
      sys.stdout.write("Carro " + str(self.num) + " entrou na ponte)\n")
      sys.stdout.flush()
      sys.stdout.write("Carro " + str(self.num) + " saiu da ponte)\n")
      sys.stdout.flush()
      self.countdown -= 1

for thread_number in range (2):
        thread = Th(thread_number)
        thread.start()