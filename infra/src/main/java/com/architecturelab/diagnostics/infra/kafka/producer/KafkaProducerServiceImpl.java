package com.architecturelab.diagnostics.infra.kafka.producer;

import com.architecturelab.diagnostics.infra.kafka.domain.Message;
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
    private KafkaTemplate<String, Message> kafkaTemplate;

    @Override
    public void send(Message message) {
        LOG.info(String.format("Message sent -> %s", message));
        this.kafkaTemplate.send(this.topic, message);
    }

}
