### Submissão para Rinha de Backend, Segunda Edição: 2024/Q1 - Controle de Concorrência
![Imagem que representa o Drogon](./java_logo.png)

##### Stack:
    - Java 21
    - Spring framework
    - Postgres
    - Nginx

##### Repositório
- [Lipe1994/DevBankWithJava](https://github.com/Lipe1994/DevBankWithJava)

##### Filipe Ferreira:

- [@filipe-ferreira-425380123](https://www.linkedin.com/in/filipe-ferreira-425380123/) - Linkedin

- [@l1peferreira](https://www.instagram.com/l1peferreira/) - Instagram


###### Detalhes para executar do projeto:

- JDK 21 instalado;
    
- Configurar o banco de dados no arquivo de [properties](https://github.com/Lipe1994/DevBankWithJava/blob/main/src/main/resources/application.properties);
    
- Tem um arquivo de criação das tabelas necessárias no banco, na raiz do projeto [init.sql](https://github.com/Lipe1994/DevBankWithJava/blob/main/init.sql) ;
    
- Eu uso o Intellij e dou run.

###### Detalhes para dockerização do projeto:

 - Compilar o projeto:
```shell
./gradlew clean build  
```

 - Dockerizar o projeto após a compilação:
```shell
docker build -t lipeferreira1609/dev_bank_with_java:latest .  
```


###### Pode rodar direto no compose(a imagem setada no compose já está no docker-hub):

 - Montar um volume com docker-compose:
```shell
docker-compose up -d
```

 - Desmontar um volume com docker-compose:
```shell
docker-compose down
```
