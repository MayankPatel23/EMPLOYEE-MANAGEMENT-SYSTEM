package org.mayankproject.emproject;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class EmpController {
    // EmployeeService empservice=new EmployeeServiceImp1();
    //Dependency Injection
    @Autowired
    EmployeeService empservice;
    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        return empservice.readEmployees();
    }
    @GetMapping("employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return empservice.readEmployee(id);
    }
    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee){
        //employees.add(employee);
        return empservice.createEmployee(employee);   
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id)
    {
        if(empservice.deleteEmployee(id))
        return "Delete Succesfully";
        return "Not Found";
    }

    @PutMapping("path/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody Employee employee) {

        return empservice.updateEmployee(id, employee);
    }
    
}
