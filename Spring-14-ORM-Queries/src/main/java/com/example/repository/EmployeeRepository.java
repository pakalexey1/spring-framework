package com.example.repository;

import com.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    //Display all employees with email address equals to ''
    List<Employee> findByEmail(String email);

    //Display all employees with first name '' and last name ', also show all employees with an email address
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    //Display all employees that first name is not ''
    List<Employee> findByFirstNameIsNot(String firstName);

    //Display all employees where last name starts with ''
    List<Employee> findByLastNameStartsWith(String lastName);

    //Display all employees with salaries higher than ''
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //Display all employee with salaries less than or equal ''
    List<Employee> findBySalaryLessThanEqual(Integer salary);

    //Display all employees that have been hired between 'date1' and 'date2'
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    //Display all employees where salaries are greater than or equal to '' sorted in desc order
    List<Employee> findBySalaryIsGreaterThanEqualOrderBySalaryDesc(Integer Salary);

    //Display top unique 3 employees that are making less than ''
    List<Employee> findDistinctTop3BySalaryIsLessThan(Integer salary);

    //Display all employees that do not have email address
    List<Employee> findByEmailIsNull();


    @Query("SELECT e FROM Employee e WHERE e.email='sdubber7@t-online.de'")
    Employee getEmployeeDetail();

    @Query("SELECT e.salary FROM Employee e WHERE e.email = 'sdubber7@t-online.de'")
    Integer getEmployeeSalary();

    @Query("SELECT e FROM Employee e WHERE e.email=?1")
    Optional<Employee> getEmployeeDetail(String email);

    @Query("SELECT e FROM Employee e WHERE e.email=?1 AND e.salary=?2")
    Employee getEmployeeDetail(String email, int salary);

}
