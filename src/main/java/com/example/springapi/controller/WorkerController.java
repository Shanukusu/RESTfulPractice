package com.example.springapi.controller;

import com.example.springapi.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class WorkerController {
    private WorkerService workerService;
    @Autowired
    public WorkerController (WorkerService workerService){
        this.workerService = workerService;
    }

    @GetMapping("/workers")
    public ResponseEntity<?> getWorkers(Model model){
        return ResponseEntity.ok().body(workerService.getWorkers(model));
    }

    @GetMapping("/worker")
    public ResponseEntity<?> getWorker (@RequestParam long id, Model model){
        return ResponseEntity.ok().body(workerService.getWorker(id, model));
    }

    @PostMapping("/workers")
    public ResponseEntity<?> addWorker(@RequestParam String name, @RequestParam String surname, @RequestParam String passportNumber, @RequestParam String passportDate, @RequestParam double salary, Model model){
        workerService.addWorker(name, surname, passportNumber, passportDate, salary);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/workers/{id}/edit")
    public ResponseEntity<?> editWorker(@PathVariable (value = "id") long id, @RequestParam String name, @RequestParam String surname, @RequestParam String passportNumber, @RequestParam String passportDate, @RequestParam double salary, Model model){
        workerService.editWorker(id, name, surname, passportNumber, passportDate, salary);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/workers/{id}/editPassport")
    public ResponseEntity<?> editWorkerPassport(@PathVariable (value = "id") long id, @RequestParam String passportNumber, @RequestParam String passportDate, Model model){
        workerService.editWorkerPassport(id, passportNumber, passportDate);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/workers/{id}/editSalary")
    public ResponseEntity<?> editWorkerSalary(@PathVariable (value = "id") long id, @RequestParam double salary, Model model){
        workerService.editWorkerSalary(id, salary);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/workers/{id}/remove")
    public ResponseEntity<?> deleteWorker(@PathVariable (value = "id") long id , Model model){
        workerService.deleteWorker(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
