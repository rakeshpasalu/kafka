# to run kafka alone in local:

step 1
Start the zookeeper server with  properties

step 2
start the kafka server with properties

step 3
create topic for ver 2.1
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test

create topic for kafka > ver 2.1
bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test

step 4 
start producing the msg's to the topic
C:\kafka\bin\windows>kafka-console-producer.bat --broker-list localhost:9092 --topic test1

step 5
consume the produced topic
C:\kafka\bin\windows>kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test1