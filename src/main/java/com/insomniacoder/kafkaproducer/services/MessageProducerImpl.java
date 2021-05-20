package com.insomniacoder.kafkaproducer.services;

import com.insomniacoder.kafkaproducer.models.MessagePayload;
import com.insomniacoder.kafkaproducer.models.MessageType;
import com.insomniacoder.kafkaproducer.services.interfaces.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerImpl implements MessageProducer {

    @Autowired
    private KafkaTemplate<String, Object> template;

    @Value("${topic-name}")
    private String topicName;

    @Override
    public void produceMessage(MessageType messageType, MessagePayload messagePayload) {
        this.template.send(topicName, messageType.name(), messagePayload);
    }
}
