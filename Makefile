DOCKER_COMPOSE=docker-compose
AWS=aws

up:
	$(DOCKER_COMPOSE) up

build:
	$(MAKE) -C scala build

setup/all: build setup/sqs setup/lambda setup/lambda/sourcemapping

setup/sqs:
	$(AWS) --endpoint-url http://localhost:4576 \
		sqs create-queue --queue-name 'foo-queue'

setup/lambda:
	$(AWS) --endpoint-url http://localhost:4574 \
		lambda create-function \
		--function-name 'foo-function' \
		--runtime=java8 \
		--role=dummyrole \
		--handler=com.ru.waka.FooHandler \
		--zip-file=fileb://./scala/target/scala-2.12/scala-assembly-0.1.0-SNAPSHOT.jar

setup/lambda/sourcemapping:
	$(AWS) --endpoint-url http://localhost:4574 \
		lambda create-event-source-mapping \
		--event-source-arn arn:aws:sqs:ap-northeast-1:000000000000:foo-queue  \
		--function-name "foo-function"
	$(AWS) --endpoint-url http://localhost:4574 \
		lambda create-event-source-mapping \
		--event-source-arn arn:aws:sqs:us-east-1:000000000000:foo-queue  \
		--function-name "foo-function"

send: body=hogehoge
send:
	$(AWS) --endpoint-url http://localhost:4576 \
		sqs send-message \
		--queue-url 'http://localstack:4576/queue/foo-queue' \
		--message-body '$(body)'
