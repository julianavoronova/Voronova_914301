package com.example.services;

import com.example.models.Position;
import com.example.models.Worker;

import java.util.List;

public interface PositionService {

    public Position savePosition (Position position);
    public List<Position> getAllPositions();

    public void deleteById (Integer id);

    public Position get(Integer id);

}
