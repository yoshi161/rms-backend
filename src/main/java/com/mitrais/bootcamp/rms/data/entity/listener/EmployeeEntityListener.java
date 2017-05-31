package com.mitrais.bootcamp.rms.data.entity.listener;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import com.mitrais.bootcamp.rms.data.entity.Employee;

@Component
@RepositoryEventHandler(Employee.class)
public class EmployeeEntityListener {

    @HandleBeforeSave
    public void handleBeforeSave(Employee employee) {
        employee.setLastModified(new Timestamp(new Date().getTime()));
    }

    @HandleBeforeCreate
    public void handleBeforeCreate(Employee employee) {
        Date currentTime = new Date();
        String username = employee.getFirstName()+employee.getLastName();
        employee.setUsername(username.toLowerCase());
        employee.setPassword("$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri");
        employee.setDateAdded(new Timestamp(currentTime.getTime()));
        employee.setLastModified(new Timestamp(currentTime.getTime()));
    }
}
