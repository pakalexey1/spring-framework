package org.example.repository;

import org.example.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class DBEmployeeRepository implements EmployeeRepository{

    //Assume the data is coming from the DB
    @Override
    public int getHourlyRate(){
        Employee employee = new Employee("Harold Finch","IT", 65);

        return employee.getHourlyRate();
    }


}
