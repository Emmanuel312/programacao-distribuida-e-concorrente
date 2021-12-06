import numpy as np
import matplotlib.pyplot as plt 
MAX_ITERATION = 10

tcoFileTCP = open("./data/tcp.txt", "wb")
tcoFileUDP = open("./data/udp.txt", "wb")
tcoFileMiddleware = open("./data/middleware.txt", "wb")
tcoFileTCP.close()
tcoFileUDP.close()
tcoFileMiddleware.close()



def createCommand(command, client):
  model = command
  for i in range(client-1):
    if(i==client-2):
      command += " & SAVE_INFO=TRUE " + model
    else:
      command += " & " + model
  return command


meanTCPArray = []
meanUDPArray = []
meanMiddlewareArray = []

for type in ['udp','tcp', 'middleware']:
  print('############################################\n')
  sh = open("./test.sh", "a")
  print(f"Analisando o {type}:\n")
  for clients in [1,2,5,10]:
    print(f"Analisando para {clients} cliente(s) ativo(s):")
    command = createCommand(f"""MAX_ITERATION={MAX_ITERATION} node ../ex5/client/nodejs/{type}/index.js""", clients)
    if type == 'middleware':
      command = createCommand(f"""MAX_ITERATION={MAX_ITERATION} node ../ex6/client/index.js""", clients)

    sh.write(command + "\n")
 
   
    










