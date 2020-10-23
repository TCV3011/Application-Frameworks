package be.ehb.opdracht_orm.dao;

import be.ehb.opdracht_orm.models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDAO extends CrudRepository<Employee, Integer> {
    public Employee findByName(String name);
    public Iterable<Employee> findAllByName(String name);
}
