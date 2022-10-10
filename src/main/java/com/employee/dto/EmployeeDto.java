package com.employee.dto;

import java.util.List;

public class EmployeeDto {
	private String firstName;
	private String lastName;
	private float experience;
	private String domain;
	private List<String> subDomain;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public float getExperience() {
		return experience;
	}

	public void setExperience(float experience) {
		this.experience = experience;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public List<String> getSubDomain() {
		return subDomain;
	}

	public void setSubDomain(List<String> subDomain) {
		this.subDomain = subDomain;
	}

	public EmployeeDto(String firstName, String lastName, float experience, String domain, List<String> subDomain) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.experience = experience;
		this.domain = domain;
		this.subDomain = subDomain;
	}

	@Override
	public String toString() {
		return "EmployeeDto [firstName=" + firstName + ", lastName=" + lastName + ", experience=" + experience
				+ ", domain=" + domain + ", subDomain=" + subDomain + "]";
	}

}
