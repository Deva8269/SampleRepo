package com.employee.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@RestController
public class Controller {

	@Autowired
	EmployeeService empService;

	@GetMapping("/Employee/all")
	public List<Employee> fetchDetails() {
		return empService.fetchDetails();
	}

	@GetMapping("/Employee/{domain}")
	public Map<String, Object> fetchByDomain(@PathVariable String domain) {
		return empService.fetchByDomain(domain);
	}

	@GetMapping("/Employee/Details")
	public Map<String, Map<String, Object>> fetchDomainWise() {
		return empService.fetchDomainWise();
	}

	@GetMapping("/Employee/match")
	public List getDetails(@RequestBody Employee employee) {
		return empService.getDetails(employee.getDomain(), employee.getExperience(), employee.getSubDomain());
	}

	@GetMapping("/Employee/city")
	public Map<String, Map<String, Object>> fetchByCity(@RequestBody Employee employee) {
		return empService.fetchByCity(employee.getCity());
	}
}
