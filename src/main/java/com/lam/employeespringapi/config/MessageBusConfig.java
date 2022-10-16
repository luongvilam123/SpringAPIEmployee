package com.lam.employeespringapi.config;


import com.lam.employeespringapi.message.EmployeeChannel;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(EmployeeChannel.class)
public class MessageBusConfig {
}
