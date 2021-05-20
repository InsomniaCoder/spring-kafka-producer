package com.insomniacoder.kafkaproducer.converters;

import com.insomniacoder.kafkaproducer.exceptions.MessageTypeNotExistException;
import com.insomniacoder.kafkaproducer.models.MessageType;
import lombok.SneakyThrows;
import org.springframework.core.convert.converter.Converter;

public class MessageTypeConverter implements Converter<String, MessageType>  {

    @SneakyThrows
    @Override
    public MessageType convert(String type) {
        try {
            return MessageType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new MessageTypeNotExistException(type);
        }
    }
}
