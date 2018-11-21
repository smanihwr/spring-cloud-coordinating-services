package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class FastPassRestController {

    @Autowired
    TollSource tollSource;

    @PostMapping(value = "/toll")
    public String publicMessage(@RequestBody String msg) {
        System.out.println(msg);
        Random r = new Random();
        tollSource.fastpassToll().send(
                MessageBuilder.withPayload(msg)
                        .setHeader("speed", r.nextInt(8)*10).build());
        return "success";

    }

}
