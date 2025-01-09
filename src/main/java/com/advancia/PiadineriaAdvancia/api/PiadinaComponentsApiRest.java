package com.advancia.PiadineriaAdvancia.api;

import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.advancia.PiadineriaAdvancia.services.PiadinaComponentsService;

@Path("/piadina")
public class PiadinaComponentsApiRest {
	private PiadinaComponentsService piadinaComponentsService = new PiadinaComponentsService();
	
	@POST
    @Path("/load")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response loadComponents() {
		Map<String, Set<Object>> components = piadinaComponentsService.getPiadinaComponents();
        
        if(components != null && !components.isEmpty()) {
            return Response.ok(components).build();
        }
        
        return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid credentials").build();
	}
	
	@GET
    @Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
    public Response test() {
		return Response.status(Response.Status.ACCEPTED).entity("Test piadina success").build();
    }
}