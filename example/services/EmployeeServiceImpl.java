package com.example.services;

import com.example.models.Employee;
import com.example.repo.DepartmentRepo;
import com.example.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepo.deleteById(id);

    }

    @Override
    public void deleteAll() {
        employeeRepo.deleteAll();
    }

    @Override
    public Employee get(Integer id) {
        return employeeRepo.findById(id).get();
    }
}
