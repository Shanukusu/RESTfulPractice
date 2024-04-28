package com.example.springapi.api.repo;

import com.example.springapi.api.model.Worker;
import org.springframework.data.repository.CrudRepository;

public interface WorkerRepository extends CrudRepository<Worker, Long> {


}
