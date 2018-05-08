package com.razz.restws;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.razz.restws.exceptions.PatientBusinessException;

@Provider
public class PatientBusinessExceptionMapper implements ExceptionMapper<PatientBusinessException> {
	
	public PatientBusinessExceptionMapper() {
		System.out.println("************PatientBusinessExceptionMapper object created**************");
	}

	@Override
	public Response toResponse(PatientBusinessException e) {
		System.out.println("{{{{{{{{{{{{{{{{{{{{{toResponse method called of exceptionMapper}}}}}}}}}}}}}}}");
		StringBuilder sb= new StringBuilder();
		sb.append("{");
		sb.append("\"status\":\"error\"");
		sb.append(",");
		sb.append("\"message\":\"Try again latter\"");
		sb.append("}");
		
		return Response.serverError().entity(sb.toString()).type(MediaType.APPLICATION_JSON).build();
		
	}

}
