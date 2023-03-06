package com.example.services;


import com.example.models.Position;
import com.example.repo.PositionRepo;
import com.example.repo.WorkerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService{


    @Autowired
    private PositionRepo positionRepo;
    @Override
    public Position savePosition(Position position) {
        return positionRepo.save(position);
    }

    @Override
    public List<Position> getAllPositions() {
        return positionRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
positionRepo.deleteById(id);
    }

    @Override
    public Position get(Integer id) {
        return positionRepo.findById(id).get();
    }
}
