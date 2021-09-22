package com.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    private static final String KAFKA_TOPIC = "test1";
    @Autowired
    KafkaTemplate<String,Player> kafkaTemplate;

    @PostMapping("/publish")
    public String publishKafka(@RequestBody Player player){
//        Player player = new Player();
//        player.setId("1");
//        player.setId("rakesh");
//        player.setTeam("rcb");

        try {
            kafkaTemplate.send(KAFKA_TOPIC,player);
        } catch (Exception e){
            return "found error during publishing kafka topic"+e;
        }

        return "hurre the data "+ player+" was successfully published.";
    }

    @KafkaListener(id="foo",topics=KAFKA_TOPIC)
    public void listnerData(Player player){

        System.out.println(player.toString()+" consumed");
    }

}
