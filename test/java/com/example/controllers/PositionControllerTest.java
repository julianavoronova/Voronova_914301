package com.example.controllers;


import com.example.models.Employee;
import com.example.models.Position;
import com.example.services.EmployeeService;
import com.example.services.PositionService;
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
public class PositionControllerTest {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private PositionService positionService;
    @Autowired
    private PositionController positionController;

    @Test
    public void list() {

        List<Position> listKon = positionController.list();
        assertEquals(4,listKon.size());

    }


    @Test
    public void add() {
        Position position = new Position();
        position.setName("name");
        position.setSalary(123);

        Position position1 = positionController.add(position);




        assertEquals("name", position1.getName());


    }


    @Test
    public void delete() {
        String del = positionController.deletePosition(7);

        assertEquals("Position was deleted", del);


    }


    @Test
    public void edit() {
        Position position = new Position();
        position.setId(7);
        position.setName("new");
        position.setSalary(1234);

        Position position1 = positionController.updatePosition(8, "new", 1234);



        assertEquals("new",position1.getName());


    }


}
