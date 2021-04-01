# hh-career-solution
Школьный проект 2021 - Сервис подбора карьерного решения

## Клиент

После каждого изменения клиента надо пересобирать образ. Первый вариант для быстрого обновления клиентского кода. Второй вариант для случая, когда зависимости сломаются.

```bash
docker-compose build front
docker-compose build --no-cache front
```

Клиент доступен по адресу [http://localhost:8011](http://localhost:8011)

## Build
`mvn clean install`

## Run
`mvn exec:java`
