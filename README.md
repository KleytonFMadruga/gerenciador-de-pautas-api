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



