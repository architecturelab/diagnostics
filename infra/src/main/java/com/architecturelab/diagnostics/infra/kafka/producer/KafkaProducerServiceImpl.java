package com.architecturelab.diagnostics.infra.kafka.producer;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class KafkaProducerServiceImpl implements KafkaProducerService {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaProducerServiceImpl.class);

    @Value("${app.spring.kafka.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String message) {
        LOG.info(String.format("Message sent -> %s", message));
        this.kafkaTemplate.send(this.topic, message);
    }

}
