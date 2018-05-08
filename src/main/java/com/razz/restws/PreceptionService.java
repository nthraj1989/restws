package com.razz.restws;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import com.razz.restws.model.Preception;

@Path("/preceptionservice")
public interface PreceptionService {
	
	@Path("/preceptions")
	@GET
	List<Preception> getPerceptions();
	
	
	@Path("/preception/{id}")
	@GET
	Preception getPatient(@PathParam(value="id") Long id);
	
	
	@Path("/preception")
	@POST
	Response createPatient(Preception preception);
	
	@Path("/preception")
	@PUT
	Response updatePatient(Preception preception);
	
	@Path("/preception/{id}")
	@DELETE
	Response deletePatient(@PathParam("id") Long id);
	

}
