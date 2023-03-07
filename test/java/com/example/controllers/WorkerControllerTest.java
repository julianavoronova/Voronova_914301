package com.example.controllers;

import com.example.models.Post;
import com.example.models.Worker;
import com.example.services.PositionService;
import com.example.services.WorkerService;
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
public class WorkerControllerTest {


    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private WorkerService workerService;
    @Autowired
    private WorkerController workerController;

    @Test
    public void list() {

        List<Worker> listKon = workerController.list();
        assertEquals(3,listKon.size());

    }


    @Test
    public void edit() {

        Worker worker = new Worker();
        worker.setName("name");
        worker.setAddress("hgfd");
        worker.setPhone("gfd");

        Worker worker1 = workerController.updateWorker(4, "name", "hgfd", "fgh");



        assertEquals("name",worker1.getName());

    }

    @Test
    public void delete() {
        String del = workerController.deleteWorker(4);

        assertEquals("Worker was deleted", del);


    }


}
