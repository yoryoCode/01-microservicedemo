package com.example.microservicedemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.microservicedemo.model.Employee;
import com.example.microservicedemo.model.Skill;
import com.example.microservicedemo.service.IEmployeesService;
import javax.annotation.PostConstruct;

public class EmployeesServiceImpl implements IEmployeesService<Employee, String> {
	
	private List<Employee> employees;
	
	@PostConstruct
	public void init(){
		employees = new ArrayList<Employee>();
		Employee emp1 = new Employee();
		emp1.setId("1");
		emp1.setName("Jorge Garcia");
		emp1.setAge(40);
		List<Skill> skills = new ArrayList<Skill>();
		Skill skill1 = new Skill("Java", 4);
		Skill skill2 = new Skill("REST", 4);
		skills.add(skill1);
		skills.add(skill2);
		emp1.setSkills(skills);
		employees.add(emp1);
	}
	
	@Override
	public Employee findById(String id) {
		return employees.get(0);
	}
	
	@Override
	public Iterable<Employee> findAll(Employee exampleEmployee) {
		return employees;
	}

	public Employee save(Employee employee) {
		return null;
	}

	@Override
	public void delete(String id) {
		//TODO
	}
	
}
