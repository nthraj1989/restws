package com.razz.restws.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Patient")
public class Patient {

	private long id;
	private String name;

	public long getId() {
		System.out.println("===============GetID in POJO===========");
		return id;
	}

	public void setId(long id) {
		System.out.println("===============SetID in POJO===========");
		this.id = id;
	}

	public String getName() {
		System.out.println("===============GetNAME in POJO===========");
		return name;
	}

	public void setName(String name) {
		System.out.println("===============SETNAME in POJO===========");
		this.name = name;
	}

}
