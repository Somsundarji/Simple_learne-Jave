package com.example.springdemo.curd_demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.curd_demo.Entety.Employee;
import com.example.springdemo.curd_demo.Entety.Status;
import com.example.springdemo.curd_demo.Repositerey.EmployeeRepository;





@RestController
public class Employeecontroller {
	
	 
	@Autowired
	   private EmployeeRepository employeeRepository;
	
	   @GetMapping(path="/demo")
	   public String Demotest() {   
		   System.out.println("Application is running");
		   return "Application is running";
	   }
	   
	   @GetMapping(value = "/employees")
	      public List<Employee> getAllEmployees() {   
		   List<Employee> employeeList = null;
		   
		   employeeList = employeeRepository.findAll();
		    if(employeeList.size() > 0) {
	            return employeeList;
	        } 		  
	        	return employeeList;			    				    	 
	        }				    
		      
	   
	    @PostMapping("/add_employees")
	    Employee createOrSaveEmployee(@RequestBody Employee newEmployee) {    		    	
	        return employeeRepository.save(newEmployee);
	    }
	 
	    
	    @GetMapping("/employees/{employee_id}")
	    Employee getEmployeeById(@PathVariable int employee_id) {
	    	
	    	Optional<Employee> employeelist=null;	
	    	
	    	try {
	    		employeelist = employeeRepository.findById(employee_id);	          
		          if(employeelist.isPresent()) {	        	  
		              return employeelist.get();
		          }else{
			    		 System.out.println("No Data Avalibel");
			    	 }
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    	 return employeelist.orElse(null);
	         
	      }
	    
	
	    @PutMapping("/update_employees/{employee_id}")
	    Employee updateEmployee(@RequestBody Employee newEmployee, @PathVariable int employee_id) {
	 
	        return employeeRepository.findById(employee_id).map(employee -> {
	        	employee.setEmployee_name(newEmployee.getEmployee_name());
	            employee.setEmployee_project(newEmployee.getEmployee_project()); 
	           // employee.setSport(newEmployee.getSport());
	            return employeeRepository.save(employee);
	        }).orElseGet(() -> {
	        	
	            newEmployee.setEmployee_id(employee_id);
	           return employeeRepository.save(newEmployee);
	        });
	    }
	 
	    @DeleteMapping("/Delete_employees/{employee_id}")
	    public Status deleteEmployee(@PathVariable int employee_id) {
	    	
	    	 Optional<Employee>  deleteEmployee= null ;
	    	 try {
	    		 deleteEmployee = employeeRepository.findById(employee_id);	    	
		    	 if(deleteEmployee.isPresent()) {		    
		    		 employeeRepository.deleteById(employee_id);
		    		 return new Status(" Deleted Successfully !");
		    	 }
		    	
			} catch (Exception e) {
				e.printStackTrace();
			}
	          return new Status("No data Avalibel already Deleted !");
	    	        	     		     	
	          }
	    	
	    	
	    

}
