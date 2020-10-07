package be.ehb.opdracht_orm.dao;

import be.ehb.opdracht_orm.models.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeDAO extends CrudRepository<Employee, Integer> {
    public Employee findByName(String name);
    public List<Employee> findAllByName(String name);
    public Employee findById(int id);


}
