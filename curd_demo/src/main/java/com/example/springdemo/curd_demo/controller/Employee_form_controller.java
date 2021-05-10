package com.example.springdemo.curd_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.springdemo.curd_demo.Entety.Employee_form;
import com.example.springdemo.curd_demo.Entety.Status;
import com.example.springdemo.curd_demo.service.Employee_form_Services;

@RestController
public class Employee_form_controller {

	@Autowired
	Employee_form_Services employee_form_Services ;
	
	
	
	   @GetMapping(value = "/employeesform")
	   public List<Employee_form>getAllEmployees() {		   
		   List<Employee_form> employeeList = null;
		   employeeList = employee_form_Services.getEmployee_List();
		   return employeeList ;
	   }
	   
	   @GetMapping(value = "/employeesbyid/{employee_id}")
	   public List<Employee_form>getEmployees(@PathVariable int employee_id) {		   
		   List<Employee_form> employeeList = null;
		   employeeList = employee_form_Services.getEmployeeById(employee_id);
		   return employeeList ;
	   }	 
			  
      @PostMapping("/addemployees")
	    Status createOrSaveEmployee(@RequestBody Employee_form employee_form) { 	
    		try {
	    		  employee_form_Services.addEmployee(employee_form);
	    		  return new Status( "Employee added Successfully !");
			} catch (Exception e) {
				return new Status( "Employee Not Added");
			  }    
    		}
	
      @PutMapping("/updateemployees")
      Status updateOrSaveEmployee(@RequestBody Employee_form employee_form) { 	
  		try {
    		  employee_form_Services.updateEmployee(employee_form);
	    		 return new Status( "Employee updated Successfully !");
			} catch (Exception e) {
				return new Status( "Employee Not updated");
			  }    
  		}
			
      @DeleteMapping("/Deleteemployees/{employee_id}")
	    public Status deleteEmployee(@PathVariable int employee_id) {
    	  try {
    		  employee_form_Services.deleteEmployee(employee_id);
    		  return new Status( "Employee delete Successfully !");
		} catch (Exception e) {
			System.out.println (""+e);
			return new Status( "Employee Not delete or already delete");
		}
      }
      
      @DeleteMapping("/softDelete/{employee_id}")
      public Status softdeleteEmployee(@PathVariable int employee_id) {
    	  try {
    		  employee_form_Services.SoftdeleteEmployee(employee_id);;
    		  return new Status( "Employee delete Successfully !");
		} catch (Exception e) {
			System.out.println (""+e);
			return new Status( "Employee Not delete or already delete");
		}
      }
      
      
      
      
}
