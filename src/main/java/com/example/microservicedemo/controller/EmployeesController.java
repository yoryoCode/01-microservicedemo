package com.example.microservicedemo.controller;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.microservicedemo.model.Employee;
import com.example.microservicedemo.service.IEmployeesService;

@RestController
@Path("/api/employees")
public class EmployeesController implements CrudController<Employee>{
	
	@Autowired
	public IEmployeesService<Employee, String> employeesService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		int statusCode = 200;
		Response response = null;
		Iterable<Employee> employees = employeesService.findAll(null);
		response = Response.status(statusCode).entity(employees).build();
		return response;
	}
	
	@GET
	@Path("/{employeeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findOne(@PathParam("employeeId") final String employeeId) {
		Employee employee = (Employee) employeesService.findById(employeeId);
		return Response.status(200).entity(employee).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Employee resource) {
		resource.setId(null);
		Employee savedResource = employeesService.save(resource);
		return Response.status(201).entity(savedResource).build();
	}

	@Override
	public Response update(String id, Employee resource) {
		//TODO
		return null;
	}

	@DELETE
	@Path("/{employeeId}")
	public Response delete(@PathParam("employeeId") String employeeId) {
		return null;
		//TODO
	}	

}
