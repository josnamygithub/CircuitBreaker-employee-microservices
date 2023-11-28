package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
	public class EmployeeController {

	@Autowired
	private NameService nameServices;
		
		@GetMapping
		@RequestMapping("/api/employees")
		public Employee getEmployee() {
			
			Employee emp= new Employee(); 
			// calling microservices here 
			String name =nameServices.callNameService();
			
			emp.setName(name);
			emp.setSalary(100);
			return emp;
		}
		

}
