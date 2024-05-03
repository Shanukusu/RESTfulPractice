package com.example.springapi.service;

import com.example.springapi.entity.Worker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {

    public WorkerService() {
    }

    public Optional<Worker> getWorker (int id){
        Optional optional = Optional.empty();
        return optional;
    }
}
