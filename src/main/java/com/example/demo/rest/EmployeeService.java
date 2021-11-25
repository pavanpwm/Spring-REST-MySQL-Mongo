package com.example.demo.rest;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository eRepo;
	
	@Autowired
	EmployeeFilesRepository fRepo;
	
	public Long addEmp(String name,String eid,String dep,String des) {
		Employee e = new Employee(name, eid, dep, des);
		return eRepo.save(e).getId();
	}
	
	public Employee getEmp(String eid) {
		return eRepo.findByEid(eid);
	}
	
	public String addFiles(String eid, MultipartFile aad, MultipartFile pan) throws Exception { 
        EmployeeFiles files = new EmployeeFiles();
        files.setAad(new Binary(BsonBinarySubType.BINARY, aad.getBytes()));
        files.setPan(new Binary(BsonBinarySubType.BINARY, pan.getBytes()));
        files.setEid(eid);
        files = fRepo.insert(files);
        return files.getId(); 
    }

    public ResponseEntity<ByteArrayResource> getFiles(String eid, boolean aad, boolean pan) { 
    	 
    	EmployeeFiles files = fRepo.findByEid(eid);
    	if (aad) {
    		ByteArrayResource resource = new ByteArrayResource(files.getAad().getData());
    		HttpHeaders headers = new HttpHeaders();
            headers.add("Content-disposition", "attachment;filename=aadhar.jpg");
       	 	return ResponseEntity.ok()
       	            .headers(headers)
       	            .contentLength(files.getAad().length())
       	            .contentType(MediaType.APPLICATION_OCTET_STREAM)
       	            .body(resource);
		}else {
			ByteArrayResource resource = new ByteArrayResource(files.getPan().getData());
			HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-disposition", "attachment;filename=pancard.pdf");
       	 	return ResponseEntity.ok()
       	            .headers(headers)
       	            .contentLength(files.getPan().length())
       	            .contentType(MediaType.APPLICATION_OCTET_STREAM)
       	            .body(resource);
		}
    }
    
    
    public void deleteAll() {
    	eRepo.deleteAll();
    	fRepo.deleteAll();
    }
    
    

}
