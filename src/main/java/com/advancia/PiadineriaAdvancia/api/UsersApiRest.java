package com.advancia.PiadineriaAdvancia.api;

import java.util.List;
import javax.ws.rs.PathParam;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.advancia.PiadineriaAdvancia.model.classes.Employee;
import com.advancia.PiadineriaAdvancia.services.UserService;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsersApiRest {
    private UserService userService = new UserService();

    @GET
    public Response getAllEmployees() {
        List<Employee> employees = userService.getUsers();
        return Response.ok(employees).build();
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