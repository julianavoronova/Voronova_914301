package com.example.services;

import com.example.models.Department;
import com.example.models.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee saveEmployee (Employee employee);
    public List<Employee> getAllEmployees();

    public void deleteById (Integer id);

    public void deleteAll ();

    public Employee get(Integer id);

}
