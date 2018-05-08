package com.razz.restws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.razz.restws.exceptions.PatientBusinessException;
import com.razz.restws.model.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	Map<Long,Patient> patients= new HashMap<>();
	long currentId=123;
	
	public PatientServiceImpl() {
		System.out.println("Obejct created");
		init();
	}
	
	void init() {
		
		System.out.println("===========init method called==============");
		Patient patient=new Patient();
		patient.setId(currentId);
		patient.setName("John");
		patients.put(patient.getId(), patient);
		
		
//		for (Map.Entry<Long,Patient> entry : patients.entrySet()) 
//            System.out.println("Key = " + entry.getKey() +
//                             ", ID = " + entry.getValue().getId()+"Name"+entry.getValue().getName());
		
	}

	@Override
	public List<Patient> getPatients() {
		
		System.out.println("===========Getting list of patient============");
		Collection<Patient> results = patients.values();
		List<Patient> response = new ArrayList<>(results);
		return response;
		}

	
	@Override
	public Patient getPatient(Long id) {
		System.out.println("============getting single patient=============");
		return	patients.get(id);
	}
	

	@Override
	public Response createPatient(Patient patient) {
		System.out.println("===========creating new patient==============");
		patient.setId(++currentId);
		patients.put(patient.getId(), patient);
		return Response.ok(patient).build();
	}

	@Override
	public Response updatePatient(Patient patient) {
		Patient currentpatient = patients.get(patient.getId());
		
		Response response;
		if(currentpatient!=null) {
			patients.put(patient.getId(),patient);
			response=Response.ok(patient).build();
		}
		else {
			System.out.println("************Exception thrown**************");
			throw new PatientBusinessException();
		}
		return response;
	}

	@Override
	public Response deletePatient(Long id) {
		Patient patient=patients.get(id);
		
		Response response;
		if(patient!=null) {
			patients.remove(id);
			response=Response.ok(patient).build();
		}
		else {
			response=Response.notModified().build();
		}
		return response;
		
	}
}
