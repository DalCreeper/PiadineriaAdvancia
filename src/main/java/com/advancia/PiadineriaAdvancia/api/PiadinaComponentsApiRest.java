package com.advancia.PiadineriaAdvancia.api;

import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.advancia.PiadineriaAdvancia.model.classes.Dough;
import com.advancia.PiadineriaAdvancia.model.classes.MeatBase;
import com.advancia.PiadineriaAdvancia.model.classes.OptionalElements;
import com.advancia.PiadineriaAdvancia.model.classes.Sauces;
import com.advancia.PiadineriaAdvancia.services.PiadinaComponentsService;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Path("/piadina")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class PiadinaComponentsApiRest {
	private PiadinaComponentsService piadinaComponentsService = new PiadinaComponentsService();
	
	@Context
    private HttpHeaders headers;
	
	@POST
    @Path("/components")
    public Response loadComponents() {
		try {
            Map<String, Set<Object>> components = piadinaComponentsService.getPiadinaComponents();
            if(components != null && !components.isEmpty()) {
            	String responseString;
                String acceptHeader = headers.getHeaderString(HttpHeaders.ACCEPT);

                if(acceptHeader != null && acceptHeader.contains(MediaType.APPLICATION_XML)) {
                    XmlMapper xmlMapper = new XmlMapper();
                    responseString = xmlMapper.writeValueAsString(components);
                    return Response.ok(responseString, MediaType.APPLICATION_XML).build();
                } else {
                    return Response.ok(components, MediaType.APPLICATION_JSON).build();
                }
            }
            return Response.status(Response.Status.NOT_FOUND).entity("No components found").build();
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while loading components").build();
        }
	}
	
	@POST
    @Path("/dough")
    public Response addDough(Dough newDough) {
        try {
        	String acceptHeader = headers.getHeaderString(HttpHeaders.ACCEPT);
        	
            piadinaComponentsService.addDough(newDough);
            if(acceptHeader != null && acceptHeader.contains(MediaType.APPLICATION_XML)) {
                XmlMapper xmlMapper = new XmlMapper();
                String xmlResponse = xmlMapper.writeValueAsString(newDough);
                return Response.status(Response.Status.CREATED).entity(xmlResponse).type(MediaType.APPLICATION_XML).build();
            } else {
                return Response.status(Response.Status.CREATED).entity(newDough).type(MediaType.APPLICATION_JSON).build();
            }
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while adding dough").build();
        }
    }

    @POST
    @Path("/meat-base")
    public Response addMeatBase(MeatBase newMeatBase) {
        try {
    		String acceptHeader = headers.getHeaderString(HttpHeaders.ACCEPT);
        	
    		piadinaComponentsService.addMeatBase(newMeatBase);
            if(acceptHeader != null && acceptHeader.contains(MediaType.APPLICATION_XML)) {
                XmlMapper xmlMapper = new XmlMapper();
                String xmlResponse = xmlMapper.writeValueAsString(newMeatBase);
                return Response.status(Response.Status.CREATED).entity(xmlResponse).type(MediaType.APPLICATION_XML).build();
            } else {
                return Response.status(Response.Status.CREATED).entity(newMeatBase).type(MediaType.APPLICATION_JSON).build();
            }
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while adding meat base").build();
        }
    }

    @POST
    @Path("/sauces")
    public Response addSauces(Sauces newSauces) {
        try {
        	String acceptHeader = headers.getHeaderString(HttpHeaders.ACCEPT);
        	
        	piadinaComponentsService.addSauces(newSauces);
            if(acceptHeader != null && acceptHeader.contains(MediaType.APPLICATION_XML)) {
                XmlMapper xmlMapper = new XmlMapper();
                String xmlResponse = xmlMapper.writeValueAsString(newSauces);
                return Response.status(Response.Status.CREATED).entity(xmlResponse).type(MediaType.APPLICATION_XML).build();
            } else {
                return Response.status(Response.Status.CREATED).entity(newSauces).type(MediaType.APPLICATION_JSON).build();
            }
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while adding sauces").build();
        }
    }

    @POST
    @Path("/optional-elements")
    public Response addOptionalElements(OptionalElements newOptionalElement) {
        try {
        	String acceptHeader = headers.getHeaderString(HttpHeaders.ACCEPT);
        	
        	piadinaComponentsService.addOptionalElements(newOptionalElement);
            if(acceptHeader != null && acceptHeader.contains(MediaType.APPLICATION_XML)) {
                XmlMapper xmlMapper = new XmlMapper();
                String xmlResponse = xmlMapper.writeValueAsString(newOptionalElement);
                return Response.status(Response.Status.CREATED).entity(xmlResponse).type(MediaType.APPLICATION_XML).build();
            } else {
                return Response.status(Response.Status.CREATED).entity(newOptionalElement).type(MediaType.APPLICATION_JSON).build();
            }
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while adding optional elements").build();
        }
    }

    @GET
    @Path("/dough/{id}")
    public Response getDoughById(@PathParam("id") Integer id) {
        if(id == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("ID must be an integer").build();
        }
        Dough dough = piadinaComponentsService.getDoughById(id);
        if(dough != null) {
        	String acceptHeader = headers.getHeaderString(HttpHeaders.ACCEPT);

            if(acceptHeader != null && acceptHeader.contains(MediaType.APPLICATION_XML)) {
                XmlMapper xmlMapper = new XmlMapper();
                try {
                    String xmlResponse = xmlMapper.writeValueAsString(dough);
                    return Response.ok(xmlResponse, MediaType.APPLICATION_XML).build();
                } catch(Exception e) {
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error serializing to XML").build();
                }
            } else {
                return Response.ok(dough, MediaType.APPLICATION_JSON).build();
            }
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Dough not found").build();
        }
    }

    @GET
    @Path("/meat-base/{id}")
    public Response getMeatBaseById(@PathParam("id") Integer id) {
        if(id == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("ID must be an integer").build();
        }
        MeatBase meatBase = piadinaComponentsService.getMeatBaseById(id);
        if(meatBase != null) {
        	String acceptHeader = headers.getHeaderString(HttpHeaders.ACCEPT);

            if(acceptHeader != null && acceptHeader.contains(MediaType.APPLICATION_XML)) {
                XmlMapper xmlMapper = new XmlMapper();
                try {
                    String xmlResponse = xmlMapper.writeValueAsString(meatBase);
                    return Response.ok(xmlResponse, MediaType.APPLICATION_XML).build();
                } catch(Exception e) {
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error serializing to XML").build();
                }
            } else {
                return Response.ok(meatBase, MediaType.APPLICATION_JSON).build();
            }
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("MeatBase not found").build();
        }
    }

    @GET
    @Path("/sauces/{id}")
    public Response getSaucesById(@PathParam("id") Integer id) {
        if(id == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("ID must be an integer").build();
        }
        Sauces sauces = piadinaComponentsService.getSaucesById(id);
        if(sauces != null) {
        	String acceptHeader = headers.getHeaderString(HttpHeaders.ACCEPT);

            if(acceptHeader != null && acceptHeader.contains(MediaType.APPLICATION_XML)) {
                XmlMapper xmlMapper = new XmlMapper();
                try {
                    String xmlResponse = xmlMapper.writeValueAsString(sauces);
                    return Response.ok(xmlResponse, MediaType.APPLICATION_XML).build();
                } catch(Exception e) {
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error serializing to XML").build();
                }
            } else {
                return Response.ok(sauces, MediaType.APPLICATION_JSON).build();
            }
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Sauces not found").build();
        }
    }

    @GET
    @Path("/optional-elements/{id}")
    public Response getOptionalElementsById(@PathParam("id") Integer id) {
        if(id == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("ID must be an integer").build();
        }
        OptionalElements optionalElements = piadinaComponentsService.getOptionalElementsById(id);
        if(optionalElements != null) {
        	String acceptHeader = headers.getHeaderString(HttpHeaders.ACCEPT);

            if(acceptHeader != null && acceptHeader.contains(MediaType.APPLICATION_XML)) {
                XmlMapper xmlMapper = new XmlMapper();
                try {
                    String xmlResponse = xmlMapper.writeValueAsString(optionalElements);
                    return Response.ok(xmlResponse, MediaType.APPLICATION_XML).build();
                } catch(Exception e) {
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error serializing to XML").build();
                }
            } else {
                return Response.ok(optionalElements, MediaType.APPLICATION_JSON).build();
            }
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Optional Elements not found").build();
        }
    }

    @PUT
    @Path("/dough/{id}")
    public Response updateDough(@PathParam("id") Integer id, Dough updatedDough) {
        if(id == null || updatedDough == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input").build();
        }
        try {
        	String acceptHeader = headers.getHeaderString(HttpHeaders.ACCEPT);
        	
        	piadinaComponentsService.updateDough(id, updatedDough);
            if(acceptHeader != null && acceptHeader.contains(MediaType.APPLICATION_XML)) {
                XmlMapper xmlMapper = new XmlMapper();
                try {
                    String xmlResponse = xmlMapper.writeValueAsString(updatedDough);
                    return Response.ok(xmlResponse, MediaType.APPLICATION_XML).build();
                } catch(Exception e) {
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error serializing to XML").build();
                }
            } else {
                return Response.ok(updatedDough, MediaType.APPLICATION_JSON).build();
            }
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while updating dough").build();
        }
    }

    @PUT
    @Path("/meat-base/{id}")
    public Response updateMeatBase(@PathParam("id") Integer id, MeatBase updatedMeatBase) {
        if(id == null || updatedMeatBase == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input").build();
        }
        try {
        	String acceptHeader = headers.getHeaderString(HttpHeaders.ACCEPT);
        	
        	piadinaComponentsService.updateMeatBase(id, updatedMeatBase);
            if(acceptHeader != null && acceptHeader.contains(MediaType.APPLICATION_XML)) {
                XmlMapper xmlMapper = new XmlMapper();
                try {
                    String xmlResponse = xmlMapper.writeValueAsString(updatedMeatBase);
                    return Response.ok(xmlResponse, MediaType.APPLICATION_XML).build();
                } catch(Exception e) {
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error serializing to XML").build();
                }
            } else {
                return Response.ok(updatedMeatBase, MediaType.APPLICATION_JSON).build();
            }
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while updating meat base").build();
        }
    }

    @PUT
    @Path("/sauces/{id}")
    public Response updateSauces(@PathParam("id") Integer id, Sauces updatedSauces) {
        if(id == null || updatedSauces == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input").build();
        }
        try {
        	String acceptHeader = headers.getHeaderString(HttpHeaders.ACCEPT);
        	
        	piadinaComponentsService.updateSauces(id, updatedSauces);
            if(acceptHeader != null && acceptHeader.contains(MediaType.APPLICATION_XML)) {
                XmlMapper xmlMapper = new XmlMapper();
                try {
                    String xmlResponse = xmlMapper.writeValueAsString(updatedSauces);
                    return Response.ok(xmlResponse, MediaType.APPLICATION_XML).build();
                } catch(Exception e) {
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error serializing to XML").build();
                }
            } else {
                return Response.ok(updatedSauces, MediaType.APPLICATION_JSON).build();
            }
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while updating sauces").build();
        }
    }

    @PUT
    @Path("/optional-elements/{id}")
    public Response updateOptionalElements(@PathParam("id") Integer id, OptionalElements updatedOptionalElements) {
        if(id == null || updatedOptionalElements == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input").build();
        }
        try {
        	String acceptHeader = headers.getHeaderString(HttpHeaders.ACCEPT);
        	
        	piadinaComponentsService.updateOptionalElements(id, updatedOptionalElements);
            if(acceptHeader != null && acceptHeader.contains(MediaType.APPLICATION_XML)) {
                XmlMapper xmlMapper = new XmlMapper();
                try {
                    String xmlResponse = xmlMapper.writeValueAsString(updatedOptionalElements);
                    return Response.ok(xmlResponse, MediaType.APPLICATION_XML).build();
                } catch(Exception e) {
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error serializing to XML").build();
                }
            } else {
                return Response.ok(updatedOptionalElements, MediaType.APPLICATION_JSON).build();
            }
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while updating optional elements").build();
        }
    }

    @DELETE
    @Path("/dough/{id}")
    public Response deleteDough(@PathParam("id") Integer id) {
        try {
        	piadinaComponentsService.deleteDough(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while deleting dough").build();
        }
    }

    @DELETE
    @Path("/meat-base/{id}")
    public Response deleteMeatBase(@PathParam("id") Integer id) {
        try {
            piadinaComponentsService.deleteMeatBase(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while deleting meat base").build();
        }
    }

    @DELETE
    @Path("/sauces/{id}")
    public Response deleteSauces(@PathParam("id") Integer id) {
        try {
            piadinaComponentsService.deleteSauces(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while deleting sauces").build();
        }
    }

    @DELETE
    @Path("/optional-elements/{id}")
    public Response deleteOptionalElements(@PathParam("id") Integer id) {
        try {
            piadinaComponentsService.deleteOptionalElements(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while deleting optional elements").build();
        }
    }
	
	@GET
    @Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response test() {
		return Response.status(Response.Status.ACCEPTED).entity("Test piadina success").build();
    }
}