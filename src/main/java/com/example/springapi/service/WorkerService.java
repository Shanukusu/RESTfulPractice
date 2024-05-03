package com.example.springapi.service;

import com.example.springapi.entity.WorkerEntity;
import com.example.springapi.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class WorkerService {
    @Autowired
    private WorkerRepository workerRepository;

    public WorkerService() {}

    public Iterable<WorkerEntity> getWorkers(Model model){
        Iterable<WorkerEntity> workers = workerRepository.findAll();
        model.addAttribute("workers",workers);
        return workers;
    }

    public ArrayList<WorkerEntity> getWorker (long id, Model model){
        ArrayList<WorkerEntity> res = new ArrayList<>();
        if(workerRepository.existsById(id)) {
            Optional<WorkerEntity> worker = workerRepository.findById(id);
            worker.ifPresent(res::add);
            model.addAttribute("worker", res);
        }
        return res;
    }

    public void addWorker(String name, String surname, String passportNumber, String passportDate, double salary){
        WorkerEntity worker = new WorkerEntity(name, surname, passportNumber, passportDate, salary);
        workerRepository.save(worker);
    }

    public void editWorker( long id, String name, String surname, String passportNumber, String passportDate, double salary){
        WorkerEntity worker = workerRepository.findById(id).orElseThrow();
        worker.setName(name);
        worker.setSurname(surname);
        worker.setPassportNumber(passportNumber);
        worker.setPassportDate(passportDate);
        worker.setSalary(salary);
        workerRepository.save(worker);
    }

    public void editWorkerPassport(long id, String passportNumber, String passportDate){
        WorkerEntity worker = workerRepository.findById(id).orElseThrow();
        worker.setPassportNumber(passportNumber);
        worker.setPassportDate(passportDate);
        workerRepository.save(worker);
    }

    public void editWorkerSalary(long id, double salary){
        WorkerEntity worker = workerRepository.findById(id).orElseThrow();
        worker.setSalary(salary);
        workerRepository.save(worker);
    }

    public void deleteWorker(long id){
        WorkerEntity worker = workerRepository.findById(id).orElseThrow();
        workerRepository.delete(worker);
    }
}
