package com.razz.restws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.razz.restws.model.Medicine;

//Jax-RS annotation.
@Consumes("application/xml,application/json")
@Produces("application/xml,application/json")
@Path("/medicineservice")
public interface MedicineService {
	
	@Path("/medicine")
	@GET
	List<Medicine> getAllMedicine();

	@Path("/medicine/{id}")
	@GET
	Medicine getMedicine(@PathParam("id") Long id);
	
	@Path("/medicine")
	@POST
	Response createMedicine(Medicine medicine);
	
	@Path("/medicine")
	@PUT
	Response updateMedicine(Medicine medicine);
	
	@Path("/medicine/{id}")
	@DELETE
	Response deleteMedicine(@PathParam("id") Long id);

}
