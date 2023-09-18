package org.example.service;

import org.example.repository.EmployeeRepository;
import org.example.repository.HoursRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OvertimeService {

    EmployeeRepository employeeRepository;
    HoursRepository hoursRepository;

    public OvertimeService(EmployeeRepository employeeRepository, @Qualifier("OTH") HoursRepository hoursRepository) {
        this.employeeRepository = employeeRepository;
        this.hoursRepository = hoursRepository;
    }

    public void calculateOvertimeSalary(){
        System.out.println(hoursRepository.getHours() * employeeRepository.getHourlyRate());
    }
}
