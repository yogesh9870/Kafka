package com.kafka.kafkaproducerconsumer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaproducerConfig {

    @Bean
    public NewTopic createTopic(){
        return new NewTopic("Kafka-test-sheshu1", 3, (short) 1);
    }
}
