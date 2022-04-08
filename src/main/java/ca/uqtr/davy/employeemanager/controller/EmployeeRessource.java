package ca.uqtr.davy.employeemanager.controller;

import ca.uqtr.davy.employeemanager.entity.Employee;
import ca.uqtr.davy.employeemanager.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeRessource {
    private final EmployeeService employeeService;

    public EmployeeRessource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {
        Employee employee = employeeService.getEmployee(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee employee1 = employeeService.addEmployee(employee);
        return new ResponseEntity<>(employee1, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
    

