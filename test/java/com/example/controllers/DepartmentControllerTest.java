package com.example.controllers;

import com.example.models.Department;
import com.example.services.DepartmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
//@AutoConfigureMockMvс
public class DepartmentControllerTest extends TestCase {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DepartmentController departmentController;

    @Test
    public void list() {

        List<Department> listKon = departmentController.list();
        assertEquals(5, listKon.size());
    }


    @Test
    public void add() {
        Department department = new Department();
        //department.setId(1);
        department.setName("Name");
        department.setAddress("Address");

        Department department2 = departmentController.add(department);

        assertEquals("Name", department2.getName());


    }


    @Test
    public void delete() {
        String del = departmentController.deleteDepartment(6);

        assertEquals("Department was deleted", del);


    }


    @Test
    public void edit() {
        Department department = new Department();
        department.setId(6);
        department.setName("Name");
        department.setAddress("Address");

        Department department2 = departmentController.updateDepartment(7, "Name", "12", "234");

        assertEquals("Name", department2.getName());


    }
}
