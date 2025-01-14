package com.advancia.PiadineriaAdvancia.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.advancia.PiadineriaAdvancia.model.api.LoginRequest;
import com.advancia.PiadineriaAdvancia.model.classes.Employee;
import com.advancia.PiadineriaAdvancia.services.UserService;

@Path("/login")
public class UserLoginApiRest {
	private UserService userService = new UserService();
    
    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response login(LoginRequest request) {
        Employee employee = userService.getUser(request.getUsername(), request.getPassword());
        if(employee != null) {
            return Response.ok(employee).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid credentials").build();
    }
    
    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public Response test() {
    	return Response.status(Response.Status.ACCEPTED).entity("Test login success").build();
    }
}