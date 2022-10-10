package com.employee.entity;

import java.util.List;

public class Employee {
	private String id;
	private String firstName;
	private String lastName;
	private String  city;
	private float experience;
	private String domain;
	private List<String> subDomain;
	private boolean isActive;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Employee(String id, String firstName, String lastName, String city, float experience, String domain,
			List<String> subDomain, boolean isActive) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.experience = experience;
		this.domain = domain;
		this.subDomain = subDomain;
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", city=" + city
				+ ", experience=" + experience + ", domain=" + domain + ", subDomain=" + subDomain + ", isActive="
				+ isActive + "]";
	}
	
	
}
