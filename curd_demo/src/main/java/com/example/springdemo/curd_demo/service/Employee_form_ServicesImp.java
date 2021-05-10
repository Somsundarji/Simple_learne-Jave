package com.example.springdemo.curd_demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdemo.curd_demo.Entety.Employee_form;
import com.example.springdemo.curd_demo.Repositerey.Employee_formDao;

@Service
public class Employee_form_ServicesImp implements  Employee_form_Services{
	
	@Autowired
	Employee_formDao employee_formDao ;

	@Override
	public boolean addEmployee(Employee_form Employee_form) {

		return employee_formDao.addEmployee(Employee_form);
	}

	@Override
	public boolean updateEmployee(Employee_form Employee_form) {
		
		return employee_formDao.updateEmployee(Employee_form);
	}

	@Override
	public void deleteEmployee(int Employee_id) {
		employee_formDao.deleteEmployee(Employee_id);
		
	}

	@Override
	public List<Employee_form> getEmployeeById(int employee_id) {
		// TODO Auto-generated method stub
		return employee_formDao.getEmployeeById(employee_id);
	}

	@Override
	public List<Employee_form> getEmployee_List() {
		// TODO Auto-generated method stub
		return employee_formDao.getEmployee_List();
	}

	@Override
	public void SoftdeleteEmployee(int Employee_id) {
		// TODO Auto-generated method stub
		employee_formDao.SoftdeleteEmployee(Employee_id);
	}

}
