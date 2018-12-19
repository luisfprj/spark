

# API rest em Java Springboot utilizando Spark.

Aplicação em springboot para aprendizado do funcionamento do framework Spark na analise de dados.

Rotas disponibilizadas:

# POST - http://localhost:8080/api/dados
Filtra todos os dados fornecidos pelo CSV, por estado e modelo.

Requisição Body:
```
{
	"estado":"BA",
	"modelo": "RMX01"
}
```
Response esperado:
```
    [{
        "periodoInicio": "21/10/18",
        "periodoFinal": "21/11/18",
        "cidade": "AFA02",
        "estado": "BA",
        "modelo": "RMX01",
        "nome": "BAAFA02-RMX01",
        "porcentagem": 75.948
    },
    {
        "periodoInicio": "21/10/18",
        "periodoFinal": "21/11/18",
        "cidade": "ALC80",
        "estado": "BA",
        "modelo": "RMX01",
        "nome": "BAALC80-RMX01",
        "porcentagem": 39.613
    }] ```

# GET http://localhost:8080/api/buscaQuantidadeEquipamentoPorEstado
Pesquisa a quantidade de equipamento por estado
realizando operação pelo spark.

Response esperado:

  ``` [{
        "estado": "RR",
        "mediaPorcentagem": 2
    },
    {
        "estado": "GO",
        "mediaPorcentagem": 9
    },
    {
        "estado": "MT",
        "mediaPorcentagem": 4
    },
    {
        "estado": "PB",
        "mediaPorcentagem": 3
    },
    {
        "estado": "AL",
        "mediaPorcentagem": 2
    },
    {
        "estado": "MG",
        "mediaPorcentagem": 11
    },
    {
        "estado": "BA",
        "mediaPorcentagem": 42
    },
    {
        "estado": "SE",
        "mediaPorcentagem": 1
    },
    {
        "estado": "CE",
        "mediaPorcentagem": 2
    }] ```

# GET - http://localhost:8080/api/buscaMEdiaDeUsoPorEstado
busca a media de orcentagem obtida por estado, dados agregados utilizando o Spark.

Response esperado:


  [
    {
        "estado": "RR",
        "mediaPorcentagem": 88.554
    },
    {
        "estado": "GO",
        "mediaPorcentagem": 38.323249999999994
    },
    {
        "estado": "MT",
        "mediaPorcentagem": 39.73925
    },
    {
        "estado": "PB",
        "mediaPorcentagem": 61.204
    },
    {
        "estado": "AL",
        "mediaPorcentagem": 74.0465
    },
    {
        "estado": "MG",
        "mediaPorcentagem": 75.15536363636365
    },
    {
        "estado": "BA",
        "mediaPorcentagem": 60.25340000000001
    },
    {
        "estado": "SE",
        "mediaPorcentagem": 71.864
    },
    {
        "estado": "CE",
        "mediaPorcentagem": 39.1295
    }
  ]
