package com.project.springbootbackened.controller;

import com.project.springbootbackened.exception.ResourceNotFoundException;
import com.project.springbootbackened.model.Employee;
import com.project.springbootbackened.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeRepo employeeRepo;

    @GetMapping("/employee")
    public ResponseEntity<?> getAllEmployee(){
        return new ResponseEntity<>(employeeRepo.findAll(), HttpStatus.ACCEPTED);
    }
    @PostMapping("/employee/add")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeRepo.save(employee), HttpStatus.CREATED);
    }
    @PutMapping("/employee/update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable long id,@RequestBody Employee employee){
       Optional<Employee> employeeRecord = employeeRepo.findById(id);
       if(employeeRecord.isPresent()){
           Employee updateEmployee = employeeRecord.get();
           updateEmployee.setEmailId(employee.getEmailId());
           updateEmployee.setFirstName(employee.getFirstName());
           updateEmployee.setLastName(employee.getLastName());
           return new ResponseEntity<>(employeeRepo.save(updateEmployee),HttpStatus.FOUND);
       }
       else{
           throw new ResourceNotFoundException("no employee found"+id);
       }
    }

    @DeleteMapping("/employee/delete/{id}")
    public ResponseEntity<?> deleteMapping(@PathVariable long id){
        Optional<Employee> employeeRecord = employeeRepo.findById(id);
        if(employeeRecord.isPresent()){
            employeeRepo.delete(employeeRecord.get());
            return new ResponseEntity<>("sucess fully deleted",HttpStatus.FOUND);
        }
        else{
            throw new ResourceNotFoundException("no employee found"+id);
        }


    }
}
