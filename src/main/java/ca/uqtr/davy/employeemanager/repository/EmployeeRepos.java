package ca.uqtr.davy.employeemanager.repository;

import ca.uqtr.davy.employeemanager.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepos extends JpaRepository<Employee,Long> {
}
