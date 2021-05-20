package com.insomniacoder.kafkaproducer.services.interfaces;

import com.insomniacoder.kafkaproducer.models.MessagePayload;
import com.insomniacoder.kafkaproducer.models.MessageType;

public interface MessageProducer {
    void produceMessage(MessageType messageType, MessagePayload messagePayload);
}
