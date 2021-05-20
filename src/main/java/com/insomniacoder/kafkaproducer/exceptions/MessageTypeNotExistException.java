package com.insomniacoder.kafkaproducer.exceptions;

public class MessageTypeNotExistException extends Exception{

    public MessageTypeNotExistException(String type) {
        super(type);
    }
}
