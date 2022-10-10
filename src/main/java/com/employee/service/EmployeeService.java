package com.employee.service;

import java.util.List;
import java.util.Map;

import com.employee.entity.Employee;

public interface EmployeeService {

	public List<Employee> fetchDetails();

	public Map<String, Object> fetchByDomain(String domain);

	public Map<String, Map<String, Object>> fetchDomainWise();

	public Map<String, Map<String, Object>> fetchByCity(String city);

	public List<Object> getDetails(String domain, float experience, List<String> subDomain);
}
