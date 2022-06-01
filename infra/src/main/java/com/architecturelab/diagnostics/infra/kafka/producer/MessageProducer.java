package com.architecturelab.diagnostics.infra.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class MessageProducer {

    private String topic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        System.out.println(String.format("#### -> Producing message -> %s", message));
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(this.topic, message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println(String.format("Message {} has been sent ", message));
            }
            @Override
            public void onFailure(Throwable ex) {
                System.out.println(String.format("Something went wrong with the message {} ", message));
            }
        });
    }

}
