package com.psl.springbot.assignment.employeecrudassignment.controller;

import com.psl.springbot.assignment.employeecrudassignment.exceptions.ResourceNotFoundException;
import com.psl.springbot.assignment.employeecrudassignment.model.Employee;
import com.psl.springbot.assignment.employeecrudassignment.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final int check=0;

    @Autowired
    private EmployeeRepository employeeRepository;

    //get all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() throws ResourceNotFoundException {
        List<Employee> list= employeeRepository.findByIsdeleted(check);
        if(list.isEmpty()){
            throw new ResourceNotFoundException("No data available ");
        }
        return list;
    }

    //get employee with a specific id
    @GetMapping("/employee")
   public Optional<Employee> getEmployeeById(@RequestParam(value = "id")Integer id) throws ResourceNotFoundException {
        Optional<Employee> employee = Optional.ofNullable(employeeRepository.findByIsDeletedAndId(check, id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :" + id)));
        return employee;
    }

    //get employee reporting to same manager
    @GetMapping("/employee/manager")
    public List<Employee> getEmployeeByMgrid(@RequestParam(value = "mgrid")Integer mgrid) throws ResourceNotFoundException {
        List<Employee> list= employeeRepository.findByMgrid(check,mgrid);
        if(list.isEmpty()){
            throw new ResourceNotFoundException("no data available for manager id :: "+mgrid);
        }
        return list;
    }
    //add employee
    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    //update employee
    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee) throws ResourceNotFoundException {
        Employee emp = employeeRepository.findByIsDeletedAndId(check,employee.getId()).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :"+employee.getId()));
        emp.setFname(employee.getFname());
        emp.setEmpno(employee.getEmpno());
        emp.setLname(employee.getLname());
        emp.setMgrid(employee.getMgrid());
        return employeeRepository.save(emp);
    }

    //soft delete employee
    @PutMapping("/employee/delete")
    public String deleteEmployee(@RequestParam(value="id")Integer id) throws ResourceNotFoundException {
        Employee emp = employeeRepository.findByIsDeletedAndId(check,id).orElseThrow(()->new ResourceNotFoundException("Employee not found for this is : "+id));
        emp.setIsdeleted(1);
        employeeRepository.save(emp);
        return "employee deleted with id :: "+id;
    }
}
