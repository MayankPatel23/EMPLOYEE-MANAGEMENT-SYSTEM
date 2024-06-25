package org.mayankproject.emproject;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    String createEmployee(Employee employee);
    List<Employee> readEmployees();
    boolean deleteEmployee(long id);
    String updateEmployee(long id,Employee employee);
    Employee readEmployee(Long id);
} 