package com.example.demo.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*")
@RestController
public class EmployeeController {
	


	@Autowired
	EmployeeService eService;
	

	
	@PostMapping("/add")
	public String add(@RequestPart("name") String name,
					  @RequestPart("eid") String eid,
					  @RequestPart("dep") String dep,
					  @RequestPart("des") String des,
					  @RequestPart("aad") MultipartFile aad,
					  @RequestPart("pan") MultipartFile pan) throws Exception {
		
		return " " + eService.addEmp(name, eid, dep, des) + eService.addFiles(eid, aad, pan);
	}
	
	
	@GetMapping("/getEmp/{eid}")
	public Employee getEmpDetails(@PathVariable("eid") String eid)  {
		return eService.getEmp(eid);
	}
	
	@GetMapping("/getAad/{eid}")
	public ResponseEntity<ByteArrayResource> getEmpAad(@PathVariable("eid") String eid)  {
		return eService.getFiles(eid, true, false);
	}
	
	@GetMapping("/getPan/{eid}")
	public ResponseEntity<ByteArrayResource> getEmpPan(@PathVariable("eid") String eid)  {
		return eService.getFiles(eid, false, true);
	}
	
	
	@GetMapping("/delAll")
	public String delAll() {
		eService.deleteAll();
		return "";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	
//	
//	@CrossOrigin(origins = "*")
//	@PostMapping("/add")
//	public String add(@RequestPart("cust") String cust, @RequestPart("file") List<MultipartFile> file) {
//		System.out.println(cust + "   " );
//		Customer c = getJson(cust, file);
//		repo.save(c);
//		return c.getId().toString();
//	}
//	public Customer getJson(String cust, List<MultipartFile> file) {
//		Customer c = new Customer();
//		try {
//			ObjectMapper om = new ObjectMapper();
//			c= om.readValue(cust, Customer.class);
//			c.setFile(getBlobData(file.get(0)));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return c;
//	}
//	
//	
	

	
}
