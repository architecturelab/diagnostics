package com.architecturelab.diagnostics.infra.config.kafka.producer;

import com.architecturelab.diagnostics.infra.kafka.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {
    @Autowired
    private ProducerFactory<Integer, Object> producerFactory;

    public Map<String, Object> producerConfig() {
        Map<String, Object> producerConfig = new HashMap<>(producerFactory.getConfigurationProperties());
        return producerConfig;
    }

    @Bean
    public KafkaTemplate<String, Message> kafkaTemplate() {
        return new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(producerConfig()));
    }
}
