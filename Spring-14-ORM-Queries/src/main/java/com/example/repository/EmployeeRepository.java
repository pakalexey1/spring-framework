package com.example.repository;

import com.example.entity.Course;
import com.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.beans.Transient;
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

    //not equal
    @Query("SELECT e FROM Employee e WHERE e.salary <> ?1")
    List<Employee> getEmployeeSalaryNotEqual(int salary);

    //like/contains/startswith/endswith
    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE ?1")
    List<Employee> getEmployeeFirstNameLike(String pattern);

    //less than
    @Query("SELECT e FROM Employee e WHERE e.salary < ?1")
    List<Employee> getEmployeeSalaryLessThan(int salary);

    //greater than
    @Query("SELECT e FROM Employee e WHERE e.salary >?1")
    List<Employee> getEmployeeSalaryGreaterThan(int salary);

    //Before date
    @Query("SELECT e FROM Employee e WHERE e.hireDate > ?1")
    List<Employee> getEmployeeHireDateBefore(LocalDate date);


    //Between
    @Query("SELECT e FROM Employee e WHERE e.hireDate between ?1 and ?2 ")
    List<Employee> getEmployeeSalaryBetween(int salary1, int salary2);

    //Null
    @Query("SELECT e FROM Employee e WHERE e.email IS NULL")
    List<Employee> getEmployeeEMailIsNull();

    //Not Null
    @Query("SELECT e FROM Employee e WHERE e.email IS NOT NULL")
    List<Employee> getEmployeeEMailIsNotNull();

    //sorting in ascending order
    @Query("SELECT e FROM Employee e ORDER BY e.salary ASC")
    List<Employee> getEmployeeSalaryOrderAsc();

    //Sorting in descending order
    @Query("SELECT e FROM Employee e ORDER BY e.salary DESC ")
    List<Employee> findEmployeeSalaryOrderDesc();

    @Query(value = "SELECT * FROM employees WHERE salary ?1", nativeQuery = true)
    List<Employee> readEmployeeDetailsBySalary(int salary);

    @Query("SELECT e FROM Employee e WHERE e.salary= :salary")
    List<Employee> getEmployeeSalary(@Param("salary") int salary);

    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.email = 'admin@email.com' WHERE e.id=:id")
    void updateEmployeeJPQL(@Param("ud") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE employee SET email = 'admin@email.com' WHERE id=:id",nativeQuery = true)
    void updateEmployeeNativeQuery(@Param("id") int id);






}
