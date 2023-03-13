package com.example.controllers;

import com.example.models.Employee;
import com.example.models.Position;
import com.example.services.EmployeeService;
import com.example.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public Employee add (@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }
    @GetMapping("/getAll")
    public List<Employee> list(){
        return employeeService.getAllEmployees();
    }

    @GetMapping ("/delete/{id}")
    public String deleteEmployee (@PathVariable(name = "id") Integer id) {
        employeeService.deleteById(id);
        return "Employee was deleted";
    }

//    @GetMapping ("/calculate/{id}")
//    public double calculateSalary (@PathVariable(name = "id") Integer id) {
//        Position position = positionService.get(id);
//        double salary = position.getSalary();
//        return salary * 1.13;
//    }

    @PostMapping ("/edit/{id}")
    public Employee updateEmployee (@PathVariable (name = "id") Integer id, @RequestParam String name, String nationality, String department, String position, String date_hire, int kids, String bank_account) {
        Employee employee = employeeService.get(id);
        employee.setName(name);
        employee.setNationality(nationality);
        employee.setDepartment(department);
        employee.setPosition(position);
        employee.setDate_hire(date_hire);
        employee.setKids(kids);
        employee.setBank_account(bank_account);

        employeeService.saveEmployee(employee);

        return employee;
    }

    @GetMapping ("/deleteAll")
    public String deleteAllEmployee () {
        employeeService.deleteAll();
        return "Employees were deleted";
    }

    @GetMapping ("/count")
    public int countAllEmployee () {
        int k = employeeService.getAllEmployees().size();
        return k;
    }


}
