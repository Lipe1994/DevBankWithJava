Este projeto usa Java 21

Compilar o projeto:
```shell
./gradlew clean build  
```

Dockerizar o projeto após a compilação:
```shell
docker build -t lipeferreira1609/dev_bank_with_java:latest .  
```

Montar um volume com docker-compose:
```shell
docker-compose up -d
```

Desmontar um volume com docker-compose:
```shell
docker-compose down
```
