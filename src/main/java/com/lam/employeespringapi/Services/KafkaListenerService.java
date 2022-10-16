package com.lam.employeespringapi.Services;

import com.lam.employeespringapi.Entity.EmployeeEntity;
import com.lam.employeespringapi.Model.Employee;
import com.lam.employeespringapi.Repository.EmployeeRepository;
import com.lam.employeespringapi.message.EmployeeChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaListenerService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @StreamListener(EmployeeChannel.CONSUME_MESSAGE)
    public void consumeMessage(Employee input){
        EmployeeEntity employeeEntity = EmployeeEntity
                .builder()
                .id(input.getId())
                .email(input.getEmail())
                .firstName(input.getFirstName())
                .lastName(input.getLastName())
                .build();
        employeeRepository.save(employeeEntity);
        log.info(" =====> " + input );


    }
}
