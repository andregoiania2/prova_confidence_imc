# prova_confidence_imc

Essa Api demonstra um pouco do que eu sei trabalhar com APIs, tem validações, documentação swagger, testes de integração.

# Instalação
após fazer o clone do projeto, em uma maquina que possua maven instalado e java 11+, execute o comando mvn clean install, após compilar, basta ir até o diretório /target e rodar o comando java -jar nomeDoProjeto.jar

# Para acessar o swagger
http://localhost:8080/swagger-ui/index.html

# Para Postman
curl --location --request POST 'localhost:8080/imc?peso=150&altura=0'


