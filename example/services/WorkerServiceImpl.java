package com.example.services;

import com.example.models.Worker;
import com.example.repo.WorkerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerRepo workerRepo;
    @Override
    public Worker saveWorker(Worker worker) {
        return workerRepo.save(worker);
    }

    @Override
    public List<Worker> getAllWorkers() {
        return workerRepo.findAll();
    }

    public void deleteById(Integer id) {
        workerRepo.deleteById(id);
    }

    public Worker get(Integer id) {
        return workerRepo.findById(id).get();
    }
}
