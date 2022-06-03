package com.architecturelab.diagnostics.infra.kafka.producer;

import com.architecturelab.diagnostics.infra.kafka.domain.Message;

public interface KafkaProducerService {
    void send(Message message);
}
