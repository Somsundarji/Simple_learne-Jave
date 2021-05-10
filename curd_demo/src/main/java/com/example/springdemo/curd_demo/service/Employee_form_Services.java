package com.example.springdemo.curd_demo.service;

import java.util.List;

import com.example.springdemo.curd_demo.Entety.Employee_form;

public interface Employee_form_Services {
	
	
	public List<Employee_form> getEmployee_List();
	
	public boolean addEmployee(Employee_form Employee_form );
	
	public boolean updateEmployee(Employee_form Employee_form );

	public void deleteEmployee(int Employee_id);
	
	public List<Employee_form> getEmployeeById(int Employee_id);
	
	public void SoftdeleteEmployee(int Employee_id);

}
