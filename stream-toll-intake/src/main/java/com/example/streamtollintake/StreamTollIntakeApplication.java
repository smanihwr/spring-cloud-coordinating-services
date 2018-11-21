package com.example.streamtollintake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;

@EnableBinding(Sink.class)
//@EnableBinding(Processor.class)
@SpringBootApplication
public class StreamTollIntakeApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamTollIntakeApplication.class, args);
    }

//        @ServiceActivator(inputChannel = Sink.INPUT)
//        @StreamListener(Sink.INPUT)
//    @StreamListener(Processor.INPUT)
//    @SendTo(Processor.OUTPUT)
    @StreamListener(value = Sink.INPUT, condition = "headers['speed'] > 40")
    public void logFast(String message) {
        System.out.println("FAST: Received message " + message);
    }

    @StreamListener(value = Sink.INPUT, condition = "headers['speed'] <= 40")
    public void logSlow(String message) {
        System.out.println("SLOW: Received message " + message);
    }
}
