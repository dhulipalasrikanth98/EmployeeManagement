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
@RequestMapping("api")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping("/employees")
    public ResponseEntity<?> getAllEmployees(){
        return new ResponseEntity<>(employeeRepo.findAll(), HttpStatus.ACCEPTED);
    }
    @PostMapping("/employees/add")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee){

        return new ResponseEntity<>(employeeRepo.save(employee),HttpStatus.CREATED);
    }

    @PutMapping("employees/update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable long id,@RequestBody Employee employee){

        Optional<Employee> employeeRecord = employeeRepo.findById(id);
        Employee updatedEmployee = employeeRecord.orElseThrow(()-> new ResourceNotFoundException("no employee found with the id"+id));
        updatedEmployee.setLastName(employee.getLastName());
        updatedEmployee.setFirstName(employee.getFirstName());
        updatedEmployee.setEmailId(employee.getEmailId());

        return new ResponseEntity<>(employeeRepo.save(updatedEmployee),HttpStatus.OK);
    }

    @DeleteMapping("employees/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable long id){
        Optional<Employee> employeeRecord = employeeRepo.findById(id);
        Employee currentEmployee = employeeRecord.orElseThrow(()-> new ResourceNotFoundException("no employee found with the id"+id));
        employeeRepo.delete(currentEmployee);
       return new ResponseEntity<>("deleted id : "+id +"successfully",HttpStatus.OK);
    }

}
