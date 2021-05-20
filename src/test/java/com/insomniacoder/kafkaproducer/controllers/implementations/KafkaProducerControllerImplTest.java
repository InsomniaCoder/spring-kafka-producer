package com.insomniacoder.kafkaproducer.controllers.implementations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.insomniacoder.kafkaproducer.models.MessagePayload;
import com.insomniacoder.kafkaproducer.models.MessageType;
import com.insomniacoder.kafkaproducer.services.interfaces.MessageProducer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = KafkaProducerControllerImpl.class)
class KafkaProducerControllerImplTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    MessageProducer messageProducer;

    @Test
    public void testControllerProduceShouldSaveMessage() throws Exception {

        doNothing().when(messageProducer).produceMessage(any(),any());

        MessagePayload payload = MessagePayload.builder().message("test").build();

        this.mockMvc.perform(post("/api/messages")
                .contentType("application/json")
                .param("messageType", "ONE")
                .content(objectMapper.writeValueAsString(payload)))
                .andExpect(status().isOk());
        verify(messageProducer).produceMessage(eq(MessageType.ONE),eq(payload));
    }

    @Test
    public void testControllerProduceMessageTypeNotExistShouldThrow() throws Exception {
        MessagePayload payload = new MessagePayload("test");

        this.mockMvc.perform(post("/api/messages")
                .contentType("application/json")
                .param("messageType", "random")
                .content(objectMapper.writeValueAsString(payload)))
                .andExpect(status().isBadRequest());
    }

}