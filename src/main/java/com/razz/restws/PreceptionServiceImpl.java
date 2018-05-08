package com.razz.restws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.razz.restws.model.Preception;

@Service
public class PreceptionServiceImpl implements PreceptionService {

	Map<Long,Preception> preceptions= new HashMap<>();
	long currentId=123;
	
	public PreceptionServiceImpl() {
		init();
	}
	
	void init() {
		
		Preception preception= new Preception();
		preception.setId(currentId);
		preception.setName("Rajnish");
		
		preceptions.put(preception.getId(), preception);
	}
	
	@Override
	public List<Preception> getPerceptions() {
		
		Collection<Preception> result = preceptions.values();
		List<Preception> response = new ArrayList<>(result);
		return response;
	}

	@Override
	public Preception getPatient(Long id) {
		return preceptions.get(id) ;
	}

	@Override
	public Response createPatient(Preception preception) {
		preception.setId(++currentId); 
		
		preceptions.put(preception.getId(), preception);
		return Response.ok(preception).build();
	}

	@Override
	public Response updatePatient(Preception preception) {
		
		Preception currentId = preceptions.get(preception.getId());
		Response response;
		if(currentId!=null) {
			preceptions.put(preception.getId(), preception);
			 response=Response.ok(preception).build();
		}
		
		else {
			
			response=Response.notModified().build();
		}
		
		return response;
		
	}

	@Override
	public Response deletePatient(Long id) {
        
		Preception deleteID = preceptions.get(id);
		
		Response response;
		if(deleteID!=null) {
			preceptions.remove(id);
			response= Response.ok().build();
		}
		else {
			response= Response.notModified().build();
		}
		
		return response;
	}

	
	

}
