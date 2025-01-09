package com.advancia.PiadineriaAdvancia.api;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.advancia.PiadineriaAdvancia.model.classes.Employee;
import com.advancia.PiadineriaAdvancia.model.enums.Role;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsersApiRest {
	private static List<Employee> employees = new ArrayList<>();
	
	static {
        employees.add(new Employee("Mario", "Rossi", "mrossi", 1985, Role.OWNER));
        employees.get(0).setUID(1);
        employees.add(new Employee("Giulia", "Verdi", "gverdi", 1990, Role.WAITER));
        employees.get(1).setUID(2);
    }
	
	@GET
    public Response getAllEmployees() {
        return Response.ok(employees).build();
    }
	
	@GET
    @Path("/{id}")
    public Response getEmployeeById(@PathParam("id") int id) {
        Optional<Employee> employee = employees.stream().filter(e -> e.getUID() == id).findFirst();
        if(employee.isPresent()) {
            return Response.ok(employee.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Employee not found").build();
        }
    }
	
	@POST
    public Response createEmployee(Employee newEmployee) {
        newEmployee.setUID(employees.size() + 1);
        employees.add(newEmployee);
        return Response.status(Response.Status.CREATED).entity(newEmployee).build();
    }
	
	/*
	@PUT
    @Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Response updateEmployee(@PathParam("id") int id, Employee updatedEmployee) {
        Optional<Employee> existingEmployee = employees.stream().filter(e -> e.getUID() == id).findFirst();

        if(existingEmployee.isPresent()) {
            Employee employee = existingEmployee.get();
            employee.setName(updatedEmployee.getName());
            employee.setSurname(updatedEmployee.getSurname());
            employee.setUsername(updatedEmployee.getUsername());
            employee.setYob(updatedEmployee.getYob());
            employee.setRole(updatedEmployee.getRole());
            return Response.ok(employee).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Employee not found").build();
        }
    }
    */
	
	@DELETE
    @Path("/delete/{id}")
    public Response deleteEmployee(@PathParam("id") int id) {
        boolean removed = employees.removeIf(e -> e.getUID() == id);
        if(removed) {
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