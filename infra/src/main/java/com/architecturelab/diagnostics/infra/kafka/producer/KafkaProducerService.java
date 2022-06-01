package com.architecturelab.diagnostics.infra.kafka.producer;

public interface KafkaProducerService {
    void send(String message);
}
