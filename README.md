# Подзадание 1.1, результат

## Описание функий текущего монолита

Объекты, у каждого своя табличка в pg:
- Система отопления, состоит из
	- id, isOn, targetTemperature, currentTemperature
- Датчик температуры, состоит из
	- id, currentTemperature, lastUpdated

Сценарии использования системы пользователем:
- Смотрит информацию о конкретной системе отопления: включена или нет, какая текущая температура, а какая целевая
- Задает целевую температуру конкретной системе отопления
- Смотрит текущую температуру конкретной системы отопления
- Включает или выключет конкретную систему отопления

## Архитектура текущей системы

Монолит; Java; PostgreSQL; синхронное взаимодействие; ограниченная масштабируемость из-за блокирующих вызовов (ждем когда завершится синхронный запрос); развертывание требует остановки всего приложения, хотя потенциально можно настроить развертывание без остановки, используя существующий kubernetes.

## Проектирование новой системы

Основной домен:
- умный дом

Текущее разделение на поддомены:
- управление системой отопления
- мониторинг температуры системы отопления

Целевое разделение на поддомены:
- управление устройствами (подключить или отключить устройство, подключить или отключить модуль управления, задать автоматический сценарий для модуля управления)
	- контексты:
		- управление системой отопления (включить или выключить отопление, задать целевую температуру)
		- управление наблюдением за домом (наблюдать за домом)
		- управление воротами (открыть или закрыть ворота)
		- управление освещением (включить или выключить освещение)
- телеметрия устройств (посмотреть статусы по отоплению, воротам, освещению, по подключению устройства)

## Диаграмма контекста системы

Систему использоует пользователь, чтобы управлять своими устройствами:
- [Контекстная](./docs/diagrams/context/smart-home-context.puml)

## План перехода

1. Изучаем текущую систему;
2. Строим целевую архитектуру системы, приоритезируем компоненты которые нужно реализовать или извлечь первыми;
3. Разрабатываем микросервисы по приоритетам, - или выносим функции или добавляем новые;
4. Перенаправляем трафик на микросервисы;
5. Делаем мониторинг и снимаем метрики;
6. Переходим обратно к шагу 2.

# Подзадание 1.2, результат

## Разбиение на микросервисы

1. API Gateway.
   Маршрутизирует запросы на микросервисы.

2. Device Gateway.
   Маршрутизирует запросы на устройства.
   
3. Kafka.
   Для асинхронного взаимодействия.
   
3. Device Management
   Сервис будет содержать общую логику по управлению любым устройством: подключение, отключение и автоматизированные сценарии.
   
4. Heating Control
   Сервис будет содержать конкретную логику по поддомену управления отоплением.
   
5. Surveillance Control
   Сервис будет содержать конкретную логику по поддомену наблюдения за домом.
   
6. Gate Control
   Сервис будет содержать конкретную логику по поддомену управления воротами.
   
7. Lighting Control
   Сервис будет содержать конкретную логику по поддомену управления освещением.
   
8. Device Telemetry
   Сервис будет содержать общую логику по сбору метрик с устройств.

## Взаимодействие частей системы

Взаимодействие делаем асинхронное, для лучшей масштабируемости системы и для расширения функционала, следуя бизнес-целям.

## C4 диаграммы

Контейнерная:
- [Контейнерная](./docs/diagrams/container/smart-home-container.puml)

Компонентная:
- [API шлюз](./docs/diagrams/component/api-gateway-component.puml)
- [Device шлюз](./docs/diagrams/component/device-gateway-component.puml)
- [Кафка](./docs/diagrams/component/kafka-component.puml)
- [Управление устройствами](./docs/diagrams/component/device-management-component.puml)
- [Управление отоплением](./docs/diagrams/component/heating-control-component.puml)
- [Управление наблюдением](./docs/diagrams/component/surveillance-control-component.puml)
- [Управление воротами](./docs/diagrams/component/gate-control-component.puml)
- [Управление освещением](./docs/diagrams/component/lighting-control-component.puml)
- [Телеметрия](./docs/diagrams/component/device-telemetry-component.puml)

# Подзадание 1.3, результат

Пользователь может добавить себе дом, стать его владельцем и пригласить других пользователей в этот дом, чтобы они стали жильцами. Пользователь добавляет в свой дом устройства. Он управляет устройствами через интернет. Он может добавить сценарий к устройствам, которые будут срабатывать по тригеру и завершатся после выполнения. Телеметрия собирается от устройств.

ER-диаграмма
- [ER-диаграмма](./docs/diagrams/er.plantuml)

# Подзадание 1.4, результат

Сервис управления устройствами
- [Асинхронное](./docs/api/device_management/asyncapi.yaml)
- [Синхронное](./docs/api/device_management/openapi.yaml)

Телеметрия
- [Асинхронное](./docs/api/telemetry/asyncapi.yaml)

# Задание 2

## Запуск minikube

[Инструкция по установке](https://minikube.sigs.k8s.io/docs/start/)

```bash
minikube start
```


## Добавление токена авторизации GitHub

[Получение токена](https://github.com/settings/tokens/new)

```bash
kubectl create secret docker-registry ghcr --docker-server=https://ghcr.io --docker-username=<github_username> --docker-password=<github_token> -n default
```


## Установка API GW kusk

[Install Kusk CLI](https://docs.kusk.io/getting-started/install-kusk-cli)

```bash
kusk cluster install
```


## Настройка terraform

[Установите Terraform](https://yandex.cloud/ru/docs/tutorials/infrastructure-management/terraform-quickstart#install-terraform)


Создайте файл ~/.terraformrc

```hcl
provider_installation {
  network_mirror {
    url = "https://terraform-mirror.yandexcloud.net/"
    include = ["registry.terraform.io/*/*"]
  }
  direct {
    exclude = ["registry.terraform.io/*/*"]
  }
}
```

## Применяем terraform конфигурацию 

```bash
cd terraform
terraform apply
```

## Настройка API GW
<!-- 
```bash
kusk deploy -i api.yaml
``` -->

```bash
cd ..
kusk deploy -i device-management-kusk.yaml
```

## Проверяем работоспособность

<!-- ```bash
kubectl port-forward svc/kusk-gateway-envoy-fleet -n kusk-system 8080:80
curl localhost:8080/hello
``` -->


```bash
kubectl port-forward svc/kusk-gateway-envoy-fleet -n kusk-system 8080:80

curl -X POST localhost:8080/devices \
-H "Content-Type: application/json" \
-H "Accept: application/json" \
-d '{
  "name": "test_device",
  "deviceType": "lighting",
  "placeId": "9d4969d9-a72b-4346-ac2e-e87dc5872876",
  "accessData": "192.168.1.100"
}'
```

## Delete minikube

```bash
minikube delete
```
