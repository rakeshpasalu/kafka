package com.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    private static final String KAFKA_TOPIC = "test1";
    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    @PostMapping("/publish")
    public String publishKafka(@RequestParam String data){
        try {
            kafkaTemplate.send(KAFKA_TOPIC,data);
        } catch (Exception e){
            return "found error during publishing kafka topic"+e;
        }

        return "hurre the data "+ data+" was successfully published.";
    }

}
