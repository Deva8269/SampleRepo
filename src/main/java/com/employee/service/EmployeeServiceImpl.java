package com.employee.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeDto;
import com.employee.entity.Employee;
import com.employee.response.EmployeeResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public List<Employee> fetchDetails() {
		List<Employee> empData = readJson();
		return empData;
	}

	@Override
	public Map<String, Object> fetchByDomain(String domain) {
		EmployeeResponse employeeResponse = new EmployeeResponse();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Employee> empData = readJson();
		List<EmployeeDto> empDataDto = entityToDto(empData);
		System.out.println(empDataDto);
		List<Object> domainWise = new ArrayList<>();
		Integer c = 0;
		for (EmployeeDto emp : empDataDto) {
			if (emp.getDomain().equals(domain)) {
				c++;
				domainWise.add(emp);
			}
		}
		map.put("empCount", c);
		map.put(domain, domainWise);
		return map;
	}

	@Override
	public Map<String, Map<String, Object>> fetchDomainWise() {
		List<Employee> empData = readJson();
		Set<String> domain = new HashSet<>();
		for (Employee emp : empData) {
			domain.add(emp.getDomain());
		}
		Map<String, Map<String, Object>> finalmap = new HashMap<String, Map<String, Object>>();
		for (String s : domain) {
			Map<String, Object> innermap = new HashMap<String, Object>();
			Integer empcount = 0;
			List<Object> empDetails = new ArrayList<>();
			for (Employee emp : empData) {
				if (emp.getDomain().equals(s)) {
					System.out.println(s);
					empcount++;
					empDetails.add(emp);

				}
				innermap.put("empCount", empcount);
				innermap.put("empDetails", empDetails);
			}
			System.out.println(innermap);

			finalmap.put(s, innermap);

		}
		return finalmap;
	}

	@Override
	public List<Object> getDetails(String domain, float experience, List<String> subDomain) {
		List<Employee> empdata = readJson();
		List<Object> list = new ArrayList<>();
		for (Employee emp : empdata) {

			System.out.println(emp.getExperience());
			if (emp.getDomain().equals(domain) && emp.getExperience() == experience
					&& emp.getSubDomain().equals(subDomain)) {
				list.add(emp);
				System.out.println(list);
			}
		}
		return list;
	}

	@Override
	public Map<String, Map<String, Object>> fetchByCity(String city) {
		List<Employee> empData = readJson();
		Map<String, Map<String, Object>> outmap = new HashMap<String, Map<String, Object>>();
		Set<String> domain = new HashSet<>();
		List<Employee> list = new ArrayList<>();
		for (Employee emp : empData) {
			domain.add(emp.getDomain());
		}
		System.out.println(domain);
		Integer empCount = 0;

		for (String s : domain) {
			List<Object> list1 = new ArrayList<>();
			Map<String, Object> inmap = new HashMap<>();
			for (Employee emp : empData) {
				if (s.equals(emp.getDomain()) && emp.getCity().equals(city)) {

					empCount++;
					list1.add(emp);
				}

			}
			inmap.put("empCount", list1.size());
			inmap.put("empDetails", list1);
			System.out.println(inmap);
			outmap.put(s, inmap);
		}
		System.out.println(outmap);
		return outmap;
	}

	private List<EmployeeDto> entityToDto(List<Employee> empData) {
		List<EmployeeDto> employeeDto = new ArrayList<>();
		for (Employee emp : empData) {
			employeeDto.add(new EmployeeDto(emp.getFirstName(), emp.getLastName(), emp.getExperience(), emp.getDomain(),
					emp.getSubDomain()));
		}
		return employeeDto;
	}

	public List<Employee> readJson() {
		List<Employee> devices = new ArrayList<>();
		try {
			String json = Files.readString(Path.of("Employee.json"));
			devices = new Gson().fromJson(json, new TypeToken<List<Employee>>() {
			}.getType());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return devices;
	}

}
