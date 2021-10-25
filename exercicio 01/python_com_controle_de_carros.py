from threading import Thread, Lock
import sys

# Quantidaade de Carros na Esquerda e na direita
COUNTDOWN = 1000
lock = Lock()


class Th(Thread):
  global locks
  
  def __init__ (self, num):
    Thread.__init__(self)
    self.num = num
    self.countdown = COUNTDOWN

  def run(self):
    global lock
    while (self.countdown):
      lock.acquire()
      # esse trecho de bloco é executado apenas quando a flag lock estiver livre, ou seja apenas quando lock.release() for chamado
      sys.stdout.write("Carro " + str(self.num) + " entrou na ponte\n")
      sys.stdout.flush()
      sys.stdout.write("Carro " + str(self.num) + " saiu da ponte\n")
      sys.stdout.flush()
      lock.release()
      self.countdown -= 1

for thread_number in range (2):
        thread = Th(thread_number)
        thread.start()