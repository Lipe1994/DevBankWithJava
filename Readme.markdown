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



###### Detalhes de execução e montagem do projeto:

 - Compilar o projeto:
```shell
./gradlew clean build  
```

 - Dockerizar o projeto após a compilação:
```shell
docker build -t lipeferreira1609/dev_bank_with_java:latest .  
```

 - Montar um volume com docker-compose:
```shell
docker-compose up -d
```

 - Desmontar um volume com docker-compose:
```shell
docker-compose down
```
