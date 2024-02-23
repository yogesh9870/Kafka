package com.kafka.kafkaproducerconsumer.controller;

import com.kafka.kafkaproducerconsumer.model.Student;
import com.kafka.kafkaproducerconsumer.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer-app")

public class EventController {

    @Autowired
    private KafkaMessagePublisher publisher;

    @GetMapping("/publish/{name}/{age}")
    public ResponseEntity<?> publishMessage(@PathVariable String name, @PathVariable int age){
        try{
            Student student = new Student(name, age);
            publisher.sendMessageToTopic(student.toString());
            return ResponseEntity.ok("message published successfully ..");
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}