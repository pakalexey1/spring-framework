package com.example.Bootstrap;

import com.example.repository.CourseRepository;
import com.example.repository.DepartmentRepository;
import com.example.repository.EmployeeRepository;
import com.example.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final CourseRepository courseRepository;

    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, CourseRepository courseRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("-----------------Region Start----------------------");

        System.out.println("findByCountr:" +regionRepository.findByCountry("Canada"));
        System.out.println("findDistinctByCountry:" + regionRepository.findDistinctByCountry("Country"));
        System.out.println("findByCountryContaining:" + regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryContainingOrderByRegion" + regionRepository.findByCountryContainingOrderByCountry("Asia"));
        System.out.println("findTopByCountry" + regionRepository.findTop2ByCountry("Canada"));

        System.out.println("-----------------Region End----------------------");

        System.out.println("-----------------Department Start----------------------");

        System.out.println("findByDepartment:" + departmentRepository.findByDepartment("Toys"));
        System.out.println("findByDivisionIs:" + departmentRepository.findByDivisionIs("Outdoors"));
        System.out.println("findDistinctTop3ByDivisionContains:" + departmentRepository.findDistinctTop3ByDivisionContains("Hea"));
        System.out.println("-----------------Department End----------------------");

        System.out.println("-----------------Employee Start----------------------");

        System.out.println("getEmployeeDetail:" + employeeRepository.getEmployeeDetail());
        System.out.println("getEmployeeSalary:" + employeeRepository.getEmployeeSalary());

        System.out.println("-----------------Employee End----------------------");

        System.out.println("-----------------Course Start----------------------");

        courseRepository.findByCategory("Spring").forEach(System.out::println);
        System.out.println("----------------------");
        courseRepository.findByCategoryOrderByName("Spring").forEach(System.out::println);

        System.out.println(courseRepository.existsByName("JavaScript for All"));
        System.out.println(courseRepository.countByCategory("Spring"));
        courseRepository.findByNameStartingWith("Scala").forEach(System.out::println);
        courseRepository.streamByCategory("Spring").forEach(System.out::println);

        System.out.println("-----------------Course End----------------------");


    }
}
