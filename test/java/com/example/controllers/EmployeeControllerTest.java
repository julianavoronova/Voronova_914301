package com.example.controllers;

import com.example.models.Department;
import com.example.models.Employee;
import com.example.services.DepartmentService;
import com.example.services.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerTest {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeController employeeController;

    @Test
    public void list() {

        List<Employee> listKon = employeeController.list();
        assertEquals(4,listKon.size());

    }


    @Test
    public void add() {
        Employee employee = new Employee();
        //department.setId(1);
        employee.setName("Name");
        employee.setNationality("Nat");
        employee.setPosition("Sales");
        employee.setDepartment("Sales");
        employee.setKids(3);
        employee.setBank_account("account");

        Employee employee1 = employeeController.add(employee);


        assertEquals("Name", employee1.getName());


    }


    @Test
    public void delete() {
        String del = employeeController.deleteEmployee(7);

        assertEquals("Employee was deleted", del);


    }


    @Test
    public void edit() {
        Employee employee = new Employee();
        employee.setId(7);
        employee.setName("name");
        employee.setNationality("Nat");
        employee.setPosition("Sales");
        employee.setDepartment("Sales");
        employee.setKids(3);
        employee.setBank_account("account");
        Employee employee1 = employeeController.updateEmployee(7, "name", "e", "dfg","e","123456",5,"uyt");


        assertEquals("name",employee1.getName());


    }

    @Test
    public void countAllEmployee() {

        int k = employeeController.countAllEmployee();
        assertEquals(4,k);

    }

}

