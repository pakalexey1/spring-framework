package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(url = "https://dummyapi.io", name = "EMPLOYEE-CLIENT")
public interface EmployeeClient {
}