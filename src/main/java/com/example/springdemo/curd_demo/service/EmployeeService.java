package com.example.springdemo.curd_demo.service;

import java.util.List;
import java.util.Optional;

import com.example.springdemo.curd_demo.Entety.Employee;


public interface EmployeeService {
	
	 public List<Employee> getAllEmployees() ;
	 
	 public  List<Employee> findAllById(int employee_id);
	 
	 public void deleteEmployee(int employee_id);
	 
	 

}
