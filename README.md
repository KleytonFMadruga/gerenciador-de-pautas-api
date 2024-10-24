# Gerar imagem de Docker da aplicação:

## Faça o build da aplicação
Na raiz do projeto, utilize o comando "`./mvnw package`" para gerar o arquivo .jar dentro do diretório ./target.
Verifique se o projeto está conseguindo subir normalmente usando o comando "`java -jar target/gerenciador-de-pautas-api-0.0.1-SNAPSHOT.jar`".

## Faça o build da imagem
Use o comando "`sudo docker build -t kleytonmadruga/gerenciador_de_pautas:1.0.0 .`".
A tag da imagem (nome:versao) que está sendo construída deve ser a mesma a ser utilizada no arquivo docker-compose.yml.

## Suba os contêineres
Use o comando "`sudo docker-compose up`" para subir os contêineres.
O terminal ficará exibindo os logs das aplicações. Se desejar que o terminal não seja usado como saída padrão para as aplicações em execução, utilize o comando acima com a opção -d (--detach) da seguinte forma: "`sudo docker-compose up -d`".
Para encerrar os contêineres em segundo plano, caso tenha usado a opção -d, use o comando "`sudo docker-compose down`".



# gerenciador-de-pautas-api

## Visão Geral
O Gerenciador-de-Pautas-API é uma interface de programação de aplicações (API) desenvolvida para facilitar a criação, organização, e gerenciamento de pautas em diversas reuniões ou sessões deliberativas. Esta API permite que os usuários gerenciem de forma eficiente as pautas, votações e resultados, proporcionando uma plataforma centralizada e automatizada para o processo decisório.

## Funcionalidades Principais

- Criação de Reuniões:

Permite a criação de novas reuniões com informações detalhadas, como data e hora da reunião, tema, e as pautas associadas.


- Criação de Pautas:

Cada reunião pode ter múltiplas pautas a serem votadas.

Facilita o processo de votação para cada item da pauta.
Suporta votos  SIM, NÃO e contabiliza os resultados.
Garante a segurança e integridade dos votos através de autenticação e autorização dos participantes.

- Resultados e Relatórios:

Gera e disponibiliza relatórios sobre os resultados das votações.
Oferece estatísticas e análises dos votos, permitindo uma visão clara e transparente das decisões tomadas.


## Endpoins e body's suportados

- Associados:


    - POST: `/associados`

```json
{
 "nome": "José",
 "cpf": "123.123.123-23"
}
```

- Reuniões:


    - POST: `/reunioes`

```json
{
    "tema": "Melhorias",
    "dataHora": "2007-12-03T10:15:30"
}
```
-----------------------------------------------------------------------------------


    - GET: `/reunioes`


```json
{
    "id": 2102,
    "pautas": [],
    "dataHora": "2007-12-03T10:15:30",
    "tema": "Melhorias"
}
```


- Pautas:


    - POST: `/reunioes/{id_reuniao}/pautas`

```json
{
    "descricao": "Gatilhos no banco de dados"
  
}
```
-----------------------------------------------------------------------------------


    - GET: `/reunioes/{id_reuniao}/pautas`


```json
[
    {
        "id": 1953,
        "votos": [],
        "descricao": "Gatilhos no banco de dados",
        "inicioDeSessao": null,
        "fimDeSessao": null
    },
    {
        "id": 1954,
        "votos": [],
        "descricao": "Gerenciamento de tempo",
        "inicioDeSessao": null,
        "fimDeSessao": null
    }
]
```

-----------------------------------------------------------------------------------


    - GET: `/reunioes/{id_reuniao}/pautas/{id_pauta}`


```json
{
    "id": 1953,
    "votos": [],
    "descricao": "Gatilhos no banco de dados",
    "inicioDeSessao": null,
    "fimDeSessao": null
}
```

-----------------------------------------------------------------------------------


    - POST: `/pautas/{id_pauta}/sessao_de_votacao`


```json
{
    "tempoDuracaoMin": "7"
}
```

-----------------------------------------------------------------------------------


    - GET: `/pautas/{id_pauta}/votos_apurados`


```
"Para a pauta 1902 foram totalizados 1 votos. Sendo, 1 Votos SIM, e 0 votos NÃO."
```




- Votos:


    - POST: `/{id_pauta}/{id_associado}/sessao_de_votacao/votos`

```json
{
    "valor":"SIM"
}
```
