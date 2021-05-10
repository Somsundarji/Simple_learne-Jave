package com.example.springdemo.curd_demo.Repositerey;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springdemo.curd_demo.Entety.Employee_form;




//extends JpaRepository<Employee_form, Integer>
public interface Employee_formDao {
	
	public List<Employee_form> getEmployee_List();
	
	public boolean addEmployee(Employee_form Employee_form );
	
	public boolean updateEmployee(Employee_form Employee_form );

	public void deleteEmployee(int Employee_id);
	
	public void SoftdeleteEmployee(int Employee_id);
	
	public List<Employee_form> getEmployeeById(int employee_id);

}
