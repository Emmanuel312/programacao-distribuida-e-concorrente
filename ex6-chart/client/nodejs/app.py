import os
import numpy as np
import matplotlib.pyplot as plt 
MAX_ITERATION = 1000

tcoFileTCP = open("./tcp.txt", "wb")
tcoFileUDP = open("./udp.txt", "wb")
tcoFileMiddleware = open("./middleware.txt", "wb")
tcoFileTCP.close()
tcoFileUDP.close()
tcoFileMiddleware.close()

def plota_bar_dupla_1(media_TCP,media_UDP,media_middleware):
   grupos = 4
  #  media_TCP = (9, 5, 4, 7)
  #  media_UDP = (8, 6, 5, 3)
  #  media_middleware = (7, 1, 2, 5)
   fig, ax = plt.subplots()
   indice = np.arange(grupos)
   bar_larg = 0.2
   transp = 0.7
   plt.bar(indice, media_TCP, bar_larg, alpha=transp, color="blue", label='TCP')
   plt.bar(indice + bar_larg, media_UDP, bar_larg, alpha=transp, color='green', label='UDP')
   plt.bar(indice + 2*bar_larg, media_middleware, bar_larg, alpha=transp, color='red', label='middleware')

   plt.xlabel('Número de clientes') 
   plt.ylabel('Tempo médio de respostas (ms)') 
   plt.title(f'N = {MAX_ITERATION}') 
   plt.xticks(indice + bar_larg, ('1', '2', '5', '10')) 
   plt.legend() 
   plt.tight_layout() 
   plt.show()

def createCommand(command, client):
  model = command
  command = "SAVE_INFO=TRUE " + command  
  for i in range(client-1):
    command += " & " + model
  return command

# command = createCommand(f"""MAX_ITERATION={MAX_ITERATION} node ./{type}/index.js""",10)
# print(command)

meanTCPArray = []
meanUDPArray = []
meanMiddlewareArray = []

for type in ['tcp','udp','middleware']:
  print('############################################\n')
  print(f"Analisando o {type}:\n")
  for clients in [1,2,5,10]:
    print(f"Analisando para {clients} cliente(s) ativo(s):")
    command = createCommand(f"""MAX_ITERATION={MAX_ITERATION} node ./{type}/index.js""",clients)
    print(command)
    os.system(command)
    
    file = open(f"./{type}.txt", "r")
    arrayTimes = np.fromstring(file.read(), dtype=int, sep=',')
    meanTime = arrayTimes.mean()
    print(f"Média {type}: {meanTime} ms")
    print(f"Desvio padrão {type}: {arrayTimes.std()}")
    if(type=='tcp'):
      meanTCPArray.append(meanTime)
    elif(type=='udp'):
      meanUDPArray.append(meanTime)
    else:
      meanMiddlewareArray.append(meanTime)
    file.close()
    
plota_bar_dupla_1(meanTCPArray,meanUDPArray,meanMiddlewareArray)









