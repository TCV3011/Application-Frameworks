package be.ehb.opdracht_orm.controllers;

import be.ehb.opdracht_orm.dao.EmployeeDAO;
import be.ehb.opdracht_orm.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getAllEmployees() {
        ArrayList<Employee> employeesList = new ArrayList<>();

        employeeDAO.findAll().forEach(employeesList::add);

        return employeesList;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Employee getEmployeeById(@PathVariable(name = "id") int id) {
        return employeeDAO.findById(id);
    }

    @RequestMapping(value = "?{name}", method = RequestMethod.GET)
    @ResponseBody
    public Employee getEmployeeByName(@PathVariable(name = "name") String name) {
        return employeeDAO.findByName(name);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public HttpStatus addEmployee(@RequestParam(name = "name") String name, @RequestParam(name = "telNumber") String telNumber, @RequestParam(name = "email") String email) {
        Employee temp = new Employee();
        temp.setId(0);
        temp.setName(name);
        temp.setTelNumber(telNumber);
        temp.setEmail(email);

        employeeDAO.save(temp);

        return HttpStatus.OK;
    }
}
