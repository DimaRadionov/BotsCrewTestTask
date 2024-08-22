package com.example.botscrewtask.service;

public interface DepartmentService {
    String getHeadOfDepartment(String departmentName);
    String getDepartmentStatistics(String departmentName);
    String getAverageSalary(String departmentName);
    String getCountOfEmployee(String departmentName);
}
