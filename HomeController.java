package com.gloify.OneToMany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gloify.OneToMany.model.Employee;
import com.gloify.OneToMany.repository.EmpRepository;
@RestController
@RequestMapping("employee")
public class HomeController {
	 @Autowired
	    EmpRepository empRepository;

	    public EmpRepository getEmpRepository() {
		return empRepository;
	}

	public void setEmpRepository(EmpRepository empRepository) {
		this.empRepository = empRepository;
	}

		@GetMapping
	    public List<Employee> findAll() {

	        return empRepository.findAll();

	    }

	    @PostMapping
	    public Employee saveEmployee(@RequestBody Employee employee) {
	        return empRepository.save(employee);

	    }

	    @GetMapping("/{employeeName}")
	    public List<Employee> findByName(@PathVariable("employeeName") 
	              String employeeName) {
	        return empRepository.findByName(employeeName);

	    }

	    @DeleteMapping("/{id}")
	    public String deleteEmployee(@PathVariable("id") Integer id) {
	        try {
	            empRepository.deleteById(id);
	            return "Deleted successfully";
	        } catch (Exception e) {
	            return "Failed to delete";
	        }
	    }

}
