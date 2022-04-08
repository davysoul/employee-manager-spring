package ca.uqtr.davy.employeemanager.service;

import ca.uqtr.davy.employeemanager.entity.Employee;
import ca.uqtr.davy.employeemanager.repository.EmployeeRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepos employeeRepos;

    @Autowired
    public EmployeeService(EmployeeRepos employeeRepos) {
        this.employeeRepos = employeeRepos;
    }
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepos.save(employee);
    }
    public List<Employee> getAll(){
        return employeeRepos.findAll();
    }
    public Employee updateEmployee(Employee employee){
        return employeeRepos.save(employee);
    }
    public void deleteEmployee(Long id){
         employeeRepos.deleteById(id);
    }
    public Employee getEmployee(Long id){return employeeRepos.findById(id).get();}
}
