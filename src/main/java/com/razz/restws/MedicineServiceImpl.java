package com.razz.restws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.razz.restws.model.Medicine;

@Service
public class MedicineServiceImpl implements MedicineService {

	Map<Long,Medicine> medicines = new HashMap<>();
	long currentId=123;
	
	public MedicineServiceImpl() {
		System.out.println("################Medicine object created################");
		init();
	}
	
	void init() {
		Medicine medicine = new Medicine();
		medicine.setId(currentId);
		medicine.setMedicineName("parachematol");
		medicines.put(medicine.getId(), medicine);
		
	}
	
	
	@Override
	public List<Medicine> getAllMedicine() {
		Collection<Medicine> result = medicines.values();
		ArrayList<Medicine> response = new ArrayList<>(result);
		return response;
	}

	@Override
	public Medicine getMedicine(Long id) {
		return medicines.get(id);
	}

	@Override
	public Response createMedicine(Medicine medicine) {
		
		medicine.setId(++currentId);
		medicines.put(medicine.getId(), medicine);
		return Response.ok(medicine).build();
	}

	@Override
	public Response updateMedicine(Medicine medicine) {
		Medicine currentId = medicines.get(medicine.getId());
		Response response;
		if(currentId!=null) {
			medicines.put(medicine.getId(), medicine);
			response=Response.ok().build();
		}
		else {
			response=Response.notModified().build();	
		}
		return response;
	}

	@Override
	public Response deleteMedicine(Long id) {
		
		Medicine currentId = medicines.get(id);
		Response response;
		if(currentId!=null) {
			medicines.remove(id);
			response=Response.ok().build();
		}
		else {
			response=Response.notModified().build();	
		}
		return response;
	}
	
}
