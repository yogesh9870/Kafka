package com.kafka.kafkaproducerconsumer.consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaMessageListener {

    Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics = "Kafka-test-sheshu1", groupId = "demo-group")
    public void consumer(String message){
        log.info("consumer consume the message {}", message);
    }
}
