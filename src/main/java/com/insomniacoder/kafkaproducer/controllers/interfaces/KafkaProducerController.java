package com.insomniacoder.kafkaproducer.controllers.interfaces;

import com.insomniacoder.kafkaproducer.models.MessagePayload;
import com.insomniacoder.kafkaproducer.models.MessageType;

public interface KafkaProducerController {

    public void saveMessageByType(MessageType messageType, MessagePayload messagePayload);
}
