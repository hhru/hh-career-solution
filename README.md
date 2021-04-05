# hh-career-solution
Школьный проект 2021 - Сервис подбора карьерного решения

## Project
### Build
```bash
docker-compose build
```

### Run
```bash
docker-compose up
```

### Clean
```bash
docker-compose down --remove-orphans
```

## Frontend

### Build
После каждого изменения клиента надо пересобирать образ. Первый вариант для быстрого обновления клиентского кода. Второй вариант для случая, когда зависимости сломаются.

```bash
docker-compose build front
docker-compose build --no-cache front
```

### Run
```bash
docker-compose up front
```

Клиент доступен по адресу [http://localhost:8011](http://localhost:8011)

## Backend

### Build
```bash
docker-compose build backend
```

### Run
```bash
docker-compose up backend
```

Если же требуется запуск на локальной машине, то достаточно поднять postgresql на порте 5435. Например, при помощи команды `docker-compose up postgres`, а дальше стандартный запуск Java, например, при помощи `mvn exec:java`

На время разработки бэкэнд доступен напрямую по адресу [http://localhost:9999](http://localhost:9999)
