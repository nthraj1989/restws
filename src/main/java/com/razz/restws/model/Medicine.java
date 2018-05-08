package com.razz.restws.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Medicine")
public class Medicine {
	
	private Long id;
	private String medicineName;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

}
