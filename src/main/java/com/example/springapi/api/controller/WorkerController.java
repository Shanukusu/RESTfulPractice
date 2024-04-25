package com.example.springapi.api.controller;

import com.example.springapi.api.model.Worker;
import com.example.springapi.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class WorkerController {

    private WorkerService workerService;

    @Autowired
    public WorkerController (WorkerService workerService){
        this.workerService = workerService;
    }

    @GetMapping("/worker")
    public Worker getWorker(@RequestParam int id){
        Optional worker = workerService.getWorker(id);
        if(worker.isPresent()){
            return (Worker) worker.get();
        }
        return null;
    }
}
