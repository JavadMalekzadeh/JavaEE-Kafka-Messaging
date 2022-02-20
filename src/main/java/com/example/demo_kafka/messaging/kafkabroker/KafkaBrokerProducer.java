package com.example.demo_kafka.messaging.kafkabroker;

import com.example.demo_kafka.messaging.events.MessageEvent;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaBrokerProducer {
    public static boolean sendMessage(MessageEvent messageEvent){
        Properties properties=new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,KafkaConstants.KAFKA_BROKERS);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());

        KafkaProducer<String,String> producer=new KafkaProducer<String, String>
                (properties);
        ProducerRecord<String,String> record=
                new ProducerRecord<String,String>
                        (KafkaConstants.TOPIC_NAME,messageEvent.toString());
        producer.send(record);
        producer.close();
        return true;
    }
}
