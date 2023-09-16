package org.example.service;

import org.example.repository.EmployeeRepository;
import org.example.repository.HoursRepository;
import org.springframework.stereotype.Component;

@Component
public class SalaryService {

    EmployeeRepository employeeRepository;
    HoursRepository hoursRepository;

    //implicitely Autowired
    public SalaryService(EmployeeRepository employeeRepository, HoursRepository hoursRepository) {
        this.employeeRepository = employeeRepository;
        this.hoursRepository = hoursRepository;
    }

    public void calculateRegularSalary(){
        //HourlyRate * Regular Hours
        System.out.println(employeeRepository.getHourlyRate() * hoursRepository.getHours());


    }
}
