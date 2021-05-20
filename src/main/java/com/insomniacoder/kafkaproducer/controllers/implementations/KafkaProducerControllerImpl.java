package com.insomniacoder.kafkaproducer.controllers.implementations;

import com.insomniacoder.kafkaproducer.controllers.interfaces.KafkaProducerController;
import com.insomniacoder.kafkaproducer.models.MessagePayload;
import com.insomniacoder.kafkaproducer.models.MessageType;
import com.insomniacoder.kafkaproducer.services.interfaces.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class KafkaProducerControllerImpl implements KafkaProducerController {

    @Autowired
    private MessageProducer messageProducer;

    @PostMapping
    @Override
    public void saveMessageByType(@RequestParam MessageType messageType,
                                  @RequestBody MessagePayload messagePayload) {
        messageProducer.produceMessage(messageType, messagePayload);
    }
}
