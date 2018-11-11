---
# Mutante API
----
API que identica se um DNA é um humano é mutante. Esta API foi desenvolvida para atender as necessidades do Magneto.

---
# Funcionalidades 
---
   - **Validação de DNA:** Ao passar uma sequencia do DNA é feito uma analise, onde haver duas sequencia de quatro letras seguidas na linha, coluna e ou diagonals, é considerado como um mutante.
   - **Status:** Retorna a quantidade de DNAs mutantes e não mutantes, também a relação de mutantes com não mutantes
---
# Tecnologias utilizadas 
---
 Tecnologias utilizadas para atender as necessidades do Magneto.

 - **Liguagem de programação:** Java 8
 -  **Arquitetura de Aplicação:** Servless (AWS Lambda)
 - **Camada de persistencia de dados:** ElasticSearsh 6.3
 - **Ambiente de nuvem:** AWS
 - **Camada de API:** AWS API Gateway

---
# Descrição da API
---
 Essas API tem a capacidade de escalar automaticamente conforme a quantidade de requisições relaizadas
 
 Para utilizar a API é muito simples. Basta utilizar as sequintes intruções
 
APIS Validação de DNA
``` 
    https://5g2x36seb3.execute-api.us-east-1.amazonaws.com/api/mutant
```

 APIS Status
``` 
    https://5g2x36seb3.execute-api.us-east-1.amazonaws.com/api/stats
```

 ##### Validação de DNA
 
**Request**
```
    POST: api/mutant
    Host: https://5g2x36seb3.execute-api.us-east-1.amazonaws.com
    Content-Type: application/json
    Cache-Control: no-cache
    Body:
    {
        "dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
    }
```

 **Response**
```
    Status Code: 200 ou 403
    Body:
        true ou false
```
     
 ##### Exemplo DNA Mutante
 **Request**
```
    POST: api/mutant
    Host: https://5g2x36seb3.execute-api.us-east-1.amazonaws.com
    Content-Type: application/json
    Cache-Control: no-cache
    Body:
    {
	    "dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
    }
```

 **Response**
```
    Status Code: 200
    Body:
        true
```

 ##### Exemplo DNA não Mutante
 **Request**
```
    POST: api/mutant
    Host: https://5g2x36seb3.execute-api.us-east-1.amazonaws.com
    Content-Type: application/json
    Cache-Control: no-cache
    Body:
    {
	    "dna":["ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"]
    }
```

 **Response**
```
    Status Code: 403
    Body:
        false
```

 ##### Status de DNA
 
 **Request**
```
    GET: api/stats
    Host: https://5g2x36seb3.execute-api.us-east-1.amazonaws.com
```

 **Response**
``` 
    Status Code: 200
    Body:
        {
            "countMutantDna": 40,
            "countHumanDna": 100,
            "ratio": 0.4
        }
```
     
 ##### Exemplo DNA Mutante
 **Request**
```
    GET: api/stats
    Host: https://5g2x36seb3.execute-api.us-east-1.amazonaws.com
```

 **Response**
``` 
    Status Code: 200
    Body:
        {
            "countMutantDna": 164,
            "countHumanDna": 128,
            "ratio": 1
        }
```
### Encontrei um mutante para ajudar na equipe do MELI !!!
![N|Solid](https://cdn.cinepop.com.br/2018/01/magneto-ex-men4-750x380.jpg)