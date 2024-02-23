package com.kafka.kafkaproducerconsumer.service;

import com.kafka.kafkaproducerconsumer.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String, Object> template;

    public void sendMessageToTopic(String student) {
        CompletableFuture<SendResult<String, Object>> future = template.send("Kafka-test-sheshu1", student);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[" + student +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        student + "] due to : " + ex.getMessage());
            }
        });
    }
}
