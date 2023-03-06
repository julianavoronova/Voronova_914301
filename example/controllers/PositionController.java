package com.example.controllers;

import com.example.models.Position;
import com.example.models.Worker;
import com.example.services.PositionService;
import com.example.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/position")
public class PositionController
{
    @Autowired
    private PositionService positionService;

    @PostMapping("/add")
    public Position add (@RequestBody Position position) {
        positionService.savePosition(position);
        return position;
    }
    @GetMapping("/getAll")
    public List<Position> list(){
        return positionService.getAllPositions();
    }

    @GetMapping ("/delete/{id}")
    public String deletePosition (@PathVariable(name = "id") Integer id) {
        positionService.deleteById(id);
        return "Position was deleted";
    }

    @GetMapping ("/calculate/{id}")
    public double calculateSalary (@PathVariable(name = "id") Integer id) {
        Position position = positionService.get(id);
        double salary = position.getSalary();
        return salary * 1.13;
    }

    @PostMapping ("/edit/{id}")
    public Position updatePosition (@PathVariable (name = "id") Integer id, @RequestParam String name, int salary, Model model) {
        Position position = positionService.get(id);
        position.setName(name);
        position.setSalary(salary);
        positionService.savePosition(position);

        return position;
    }

}
