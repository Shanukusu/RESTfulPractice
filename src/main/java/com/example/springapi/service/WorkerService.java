package com.example.springapi.service;

import com.example.springapi.entity.Worker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {

    private List<Worker> workerList;

    public WorkerService() {
        workerList = new ArrayList<>();
        //Worker worker = new Worker(  "Sara","Lala","12345","12.10.2022",10000);

        //workerList.add(worker);
    }

    public Optional<Worker> getWorker (int id){
        Optional optional = Optional.empty();
        for (Worker worker: workerList) {
            if(id == worker.getId()){
                optional = Optional.of(worker);
                return optional;
            }
        }
        return optional;
    }
}
