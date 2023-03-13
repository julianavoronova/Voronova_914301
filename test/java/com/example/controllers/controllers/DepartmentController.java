package com.example.controllers;

import com.example.models.Department;
import com.example.models.Position;
import com.example.services.DepartmentService;
import com.example.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/add")
    public Department add (@RequestBody Department department) {
        departmentService.saveDepartment(department);
        return department;
    }
    @GetMapping("/getAll")
    public List<Department> list(){
        return departmentService.getAllDepartments();
    }

    @DeleteMapping ("/delete/{id}")
    public String deleteDepartment (@PathVariable(name = "id") Integer id) {
        departmentService.deleteById(id);
        return "Department was deleted";}

    @GetMapping ("/find/{id}")
    public Department find (@PathVariable(name = "id") Integer id) {
        Department department = departmentService.get(id);
        return department;
    }

    @PostMapping ("/edit/{id}")
    public Department updateDepartment (@PathVariable (name = "id") Integer id, @RequestParam String name, String address, String phone) {
        Department department = departmentService.get(id);
        department.setName(name);
        department.setAddress(address);
        department.setPhone(phone);
        departmentService.saveDepartment(department);
        return department;
    }

}
