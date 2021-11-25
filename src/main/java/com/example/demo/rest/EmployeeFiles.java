package com.example.demo.rest;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "files")
public class EmployeeFiles {
	
	@Id
    private String id;
    
    private String eid;
        
    private Binary aad;
    
    private Binary pan;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public Binary getAad() {
		return aad;
	}

	public void setAad(Binary aad) {
		this.aad = aad;
	}

	public Binary getPan() {
		return pan;
	}

	public void setPan(Binary pan) {
		this.pan = pan;
	}
    

	
    
	

}
