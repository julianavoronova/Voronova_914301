package com.example.controllers;

import com.example.models.Worker;
import com.example.repo.PositionRepo;
import com.example.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/worker")
public class WorkerController {
    @Autowired
    private WorkerService workerService;
    private PositionRepo positionRepo;

//    @PostMapping ("/add")
//    public Worker add (@PathVariable(value = "positionId") int positionId, @RequestBody Worker worker) throws Exception {
//        Worker worker1 = positionRepo.findById(positionId).map(position -> {
//            worker.setPosition(position);
//        workerService.saveWorker(worker);
//        return worker;}).orElseThrow(() -> new Exception  ("Not found Tutorial with id"));
//        return worker;
//    }


        @GetMapping("/getAll")
    public List<Worker> list(){
        return workerService.getAllWorkers();
    }

    @GetMapping ("/delete/{id}")
    public String deleteWorker (@PathVariable(name = "id") Integer id) {
        workerService.deleteById(id);
        return "Worker was deleted";
    }

    @PostMapping ("/edit/{id}")
    public Worker updateWorker (@PathVariable (name = "id") Integer id, @RequestParam String name, String address, String phone, Model model) {
        Worker worker = workerService.get(id);
        worker.setName(name);
        worker.setAddress(address);
        worker.setPhone(phone);
        workerService.saveWorker(worker);

        return worker;
    }


}
