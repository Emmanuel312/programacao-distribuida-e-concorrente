import numpy as np
import matplotlib.pyplot as plt 
import numpy as np

MAX_ITERATION = 10000

def plota_bar_dupla_1(media_TCP,media_UDP,media_middleware,media_mom, yLabel):
    global MAX_ITERATION
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
    plt.bar(indice + 3*bar_larg, media_mom, bar_larg, alpha=transp, color='black', label='mom')

    plt.xlabel('Número de clientes') 
    plt.ylabel(yLabel) 
    plt.title(f'N = {MAX_ITERATION}') 
    plt.xticks(indice + bar_larg, ('1', '2', '5', '10')) 
    plt.legend() 
    plt.tight_layout() 
    plt.show()

meanTCPArrayByClient = []
meanUDPArrayByClient = []
meanMiddlewareArrayByClient = []
meanMomArrayByClient = []

stdTCPArrayByClient = []
stdUDPArrayByClient = []
stdMiddlewareArrayByClient = []
stdMomArrayByClient = []

for type in ['udp','tcp', 'middleware', 'mom']:
    print("#######################################################")
    print(f"\t\t\tAnalisando {type}:")
    file = open(f"./data/{type}.txt", "r")
    arrayTextFile = file.read().split('\n')
    for timesByClient,i in zip(arrayTextFile,[1,2,5,10]):
        print(f"{i} cliente(s) ativo(s)")
        if timesByClient  != '':
            arrayTimesByClient = np.fromstring(timesByClient, dtype=float, sep=',')
            meanTime = arrayTimesByClient.mean()
            stdTime = arrayTimesByClient.std()
            print(arrayTimesByClient)
            print(f" -> Média {type}: {meanTime} nanoseconds")
            print(f" -> Desvio padrão {type}: {stdTime}")
            if(type=='tcp'):
                meanTCPArrayByClient.append(meanTime)
                stdTCPArrayByClient.append(stdTime)
            elif(type=='udp'):
                meanUDPArrayByClient.append(meanTime)
                stdUDPArrayByClient.append(stdTime)
            elif type == 'middleware':
                meanMiddlewareArrayByClient.append(meanTime)
                stdMiddlewareArrayByClient.append(stdTime)
            elif type == 'mom':
                meanMomArrayByClient.append(meanTime)
                stdMomArrayByClient.append(stdTime)
    
plota_bar_dupla_1(meanTCPArrayByClient,meanUDPArrayByClient,meanMiddlewareArrayByClient,meanMomArrayByClient, 'Tempo médio de respostas (nanosegundos)')
plota_bar_dupla_1(stdTCPArrayByClient,stdUDPArrayByClient,stdMiddlewareArrayByClient, stdMomArrayByClient, 'Desvio padrão do tempo de respostas (nanosegundos)')
