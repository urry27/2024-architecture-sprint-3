## Запуск

1.

``` shell
docker run --name postgres-db \
  -e POSTGRES_DB=device_management \
  -e POSTGRES_USER=your_username \
  -e POSTGRES_PASSWORD=your_password \
  -p 5432:5432 \
  -d postgres:13-alpine
```

2.

``` shell
mvn spring-boot:run
```