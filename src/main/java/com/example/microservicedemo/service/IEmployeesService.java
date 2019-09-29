package com.example.microservicedemo.service;

import com.example.microservicedemo.model.Employee;

public interface IEmployeesService<T, ID> {
	
	public T findById(ID id);
	
	public Iterable<T> findAll(T exampleEmployee);
	
	public T save(Employee employee);
	
	public void delete(ID id);

}

