package com.advancia.PiadineriaAdvancia.api;

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

@Path("/users")
public class UserApiServlet {
	private UserService userService = new UserService();
    
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(LoginRequest request) {
        Employee employee = userService.getUser(request.getUsername(), request.getPassword());
        
        if(employee != null) {
            return Response.ok(employee).build();
        }
        
        return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid credentials").build();
    }
	
    @GET
    @Path("/test")
    public Response test() {
		return Response.status(409).build();
    }
}