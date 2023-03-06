package com.example.services;

import com.example.models.Worker;

import java.util.List;

public interface WorkerService {
    public Worker saveWorker (Worker worker);
    public List<Worker> getAllWorkers();

    public void deleteById (Integer id);

    public Worker get(Integer id);


}
