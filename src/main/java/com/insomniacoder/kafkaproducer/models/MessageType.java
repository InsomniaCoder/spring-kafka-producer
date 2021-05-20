package com.insomniacoder.kafkaproducer.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum MessageType {
    TYPE_ONE("one"),
    TYPE_TWO("two"),
    TYPE_THREE("three"),
    TYPE_FOUR("four"),
    TYPE_FIVE("five");

    @Getter
    private String value;

}
