package com.lam.employeespringapi.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;


public interface EmployeeChannel {

    String CONSUME_MESSAGE = "employee-channel";
    String PRODUCE_MESSAGE = "employee-channel";

    @Input(CONSUME_MESSAGE)
    SubscribableChannel consumeMessage();

    @Output(PRODUCE_MESSAGE)
    MessageChannel produceMessage();
}
