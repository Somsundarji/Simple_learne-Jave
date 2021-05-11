package com.example.springdemo.curd_demo.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdemo.curd_demo.Entety.Employee;
import com.example.springdemo.curd_demo.Repositerey.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	   private EmployeeRepository employeeRepository;
	
	
	@Override
	public List<Employee> getAllEmployees() {	
		
		  List<Employee> employeeList = null;		  
		   employeeList = employeeRepository.findAll();		   
		    if(employeeList.size() > 0) {		    	
		 List<Employee> presentdata = employeeList.stream()
				 .filter(p->p.getDeletes()!=0)
				 .collect(Collectors.toList());  
	            return presentdata;
	        } 	else{	        	
	        	return null;
	     	}
	   }	  
	

	@Override
	
	public List<Employee>  findAllById(int employee_id) {
		
		List<Employee> employeeList = null;			
		 employeeList = employeeRepository.findAll();	
		   if(employeeList.size() > 0) {		    	
				 List<Employee> presentdata = employeeList.stream()						 
						 .filter(p->p.getDeletes()!=0)
						 .filter(p->p.getEmployee_id()== employee_id)
						 .collect(Collectors.toList());  
			            return presentdata;
			        } 	else{	        	
			        	return null;
			     	}
	       
			       		        			        
	}

	@Override
	public void deleteEmployee(int employee_id) {
		     employeeRepository.findById(employee_id).map(employee -> {employee.setDeletes(0);          
	            return employeeRepository.save(employee);
	        });
		
	}



}
