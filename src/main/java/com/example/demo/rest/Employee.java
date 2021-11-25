package com.example.demo.rest;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String eid;
	private String dep;
	private String des;

	

	protected Employee() {
		
		
	}



	public Employee(String name, String eid, String dep, String des) {
		this.name = name;
		this.eid = eid;
		this.dep = dep;
		this.des = des;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEid() {
		return eid;
	}



	public void setEid(String eid) {
		this.eid = eid;
	}



	public String getDep() {
		return dep;
	}



	public void setDep(String dep) {
		this.dep = dep;
	}



	public String getDes() {
		return des;
	}



	public void setDes(String des) {
		this.des = des;
	}

	
	
	
	

}