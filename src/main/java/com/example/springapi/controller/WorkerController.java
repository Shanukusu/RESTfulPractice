package com.example.springapi.controller;

import com.example.springapi.entity.Worker;
import com.example.springapi.repository.WorkerRepository;
import com.example.springapi.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class WorkerController {
    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping("/workers")
    public String getWorkers(Model model){
        Iterable<Worker> workers = workerRepository.findAll();
        model.addAttribute("workers",workers);
        return "workers";
    }

    @GetMapping("/worker")
    public String getWorker (@RequestParam long id, Model model){
        if(workerRepository.existsById(id)) {
            Optional<Worker> worker = workerRepository.findById(id);
            ArrayList<Worker> res = new ArrayList<>();
            worker.ifPresent(res::add);
            model.addAttribute("worker", res);
        }
        return "worker";
    }

    @PostMapping("/workers")
    public String addWorker(@RequestParam String name, @RequestParam String surname, @RequestParam String passportNumber, @RequestParam String passportDate, @RequestParam double salary, Model model){
        Worker worker = new Worker (name, surname, passportNumber, passportDate, salary);
        workerRepository.save(worker);
        return "workers";
    }

    @PostMapping("/workers/{id}/edit")
    public String editWorker(@PathVariable (value = "id") long id, @RequestParam String name, @RequestParam String surname, @RequestParam String passportNumber, @RequestParam String passportDate, @RequestParam double salary, Model model){
        Worker worker = workerRepository.findById(id).orElseThrow();
        worker.setName(name);
        worker.setSurname(surname);
        worker.setPassportNumber(passportNumber);
        worker.setPassportDate(passportDate);
        worker.setSalary(salary);
        workerRepository.save(worker);
        return "workers";
    }

    @PostMapping("/workers/{id}/editPassport")
    public String editWorkerPassport(@PathVariable (value = "id") long id, @RequestParam String passportNumber, @RequestParam String passportDate, Model model){
        Worker worker = workerRepository.findById(id).orElseThrow();
        worker.setPassportNumber(passportNumber);
        worker.setPassportDate(passportDate);
        workerRepository.save(worker);
        return "workers";
    }

    @PostMapping("/workers/{id}/editSalary")
    public String editWorkerSalary(@PathVariable (value = "id") long id, @RequestParam double salary, Model model){
        Worker worker = workerRepository.findById(id).orElseThrow();
        worker.setSalary(salary);
        workerRepository.save(worker);
        return "workers";
    }

    @PostMapping("/workers/{id}/remove")
    public String deleteWorker(@PathVariable (value = "id") long id , Model model){
        Worker worker = workerRepository.findById(id).orElseThrow();
        workerRepository.delete(worker);
        return "workers";
    }

    /*
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
     */
}
