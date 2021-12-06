import numpy as np
import matplotlib.pyplot as plt 
MAX_ITERATION = 1000

def createCommand(command, client):
  model = command

  if client == 1:
    return "SAVE_INFO=TRUE " + command

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
  print(f"Analisando o {type}:\n")
  sh = open(f"""./test-{type}.sh""", "w")
  sh.write("#!/bin/bash\n")
  for clients in [1,2,5,10]:
    print(f"Analisando para {clients} cliente(s) ativo(s):")
    command = createCommand(f"""MAX_ITERATION={MAX_ITERATION} node ../ex5/client/nodejs/{type}/index.js""", clients)
    if type == 'middleware':
      command = createCommand(f"""MAX_ITERATION={MAX_ITERATION} node ../ex6/client/index.js""", clients)

    sh.write(command + "\n")
  sh.close()
