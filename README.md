localstack sqs lambda
---

## 1. docker-compose up

```
make up
```

## 2. build lambda handler and setup localstack

```
make setup/all
# == make build setup/sqs setup/lambda setup/lambda/sourcemapping
```

## 3. send message to sqs

```
make send
# send message from awscli

make send/scala
# send message from scala application
```

You can see the log of "Hello World" in docker-compose logs 
