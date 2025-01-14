package com.advancia.PiadineriaAdvancia.api.rest;

import java.util.List;
import javax.ws.rs.PathParam;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.advancia.PiadineriaAdvancia.model.classes.Employee;
import com.advancia.PiadineriaAdvancia.services.UserService;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Path("/users")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class UsersApiRest {
    private UserService userService = new UserService();
    
    @Context
    private HttpHeaders headers;

    @GET
    public Response getAllEmployees() {
    	try {
	    	List<Employee> employees = userService.getUsers();
	    	String responseString;
	        String acceptHeader = headers.getHeaderString(HttpHeaders.ACCEPT);
	
	        if(acceptHeader != null && acceptHeader.contains(MediaType.APPLICATION_XML)) {
	            XmlMapper xmlMapper = new XmlMapper();
	            responseString = xmlMapper.writeValueAsString(employees);
	            return Response.ok(responseString, MediaType.APPLICATION_XML).build();
	        } else {
	            return Response.ok(employees, MediaType.APPLICATION_JSON).build();
	        }
    	} catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while loading the employees").build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getEmployeeById(@PathParam("id") Integer id) {
        if(id == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("ID must be an integer").build();
        }
        Employee employee = userService.getUserByID(id);
        if(employee != null) {
            return Response.ok(employee).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Employee not found").build();
        }
    }

    @POST
    public Response createEmployee(Employee newEmployee) {
        userService.createUser(newEmployee);
        return Response.status(Response.Status.CREATED).entity(newEmployee).build();
    }
    
    @PUT
    @Path("/{id}")
    public Response updateEmployee(@PathParam("id") int id, Employee updatedEmployee) {
        Employee existingEmployee = userService.getUserByID(id);
        if(existingEmployee != null) {
            userService.updateUser(id, updatedEmployee);
            return Response.ok(updatedEmployee).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Employee not found").build();
        }
    }
	
    @DELETE
    @Path("/delete/{id}")
    public Response deleteEmployee(@PathParam("id") Integer id) {
        Employee existingEmployee = userService.getUserByID(id);
        if(existingEmployee != null) {
            userService.deleteUser(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Employee not found").build();
        }
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public Response test() {
        return Response.status(Response.Status.ACCEPTED).entity("Test users success").build();
    }
}