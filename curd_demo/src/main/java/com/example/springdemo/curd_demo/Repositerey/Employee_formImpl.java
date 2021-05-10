package com.example.springdemo.curd_demo.Repositerey;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springdemo.curd_demo.Entety.Employee;
import com.example.springdemo.curd_demo.Entety.Employee_form;

@Component 
public class Employee_formImpl implements Employee_formDao{
	

	@Autowired
	SessionFactory sessionFactory;
	Session session = null;
	Transaction tx = null;	
	Employee employee = new Employee();



	@SuppressWarnings("rawtypes")
	@Override
	public void deleteEmployee(int employee_id ) {			
		employee.setEmployee_id(employee_id);
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		org.hibernate.query.Query q = session.createQuery("UPDATE Employee set deletes = :zero "  + "WHERE employee_id = :employee_id");
		//org.hibernate.query.Query q = session.createQuery("update employee set deletes=:zero where employee_id=:employee_id");
		q.setParameter("employee_id", employee.getEmployee_id());
		q.setParameter("zero", 0);
		q.executeUpdate();
		tx.commit();
		session.close();		
	}

	@Override
	public boolean addEmployee(Employee_form Employee_form) {			
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.saveOrUpdate(Employee_form);
		tx.commit();
		session.close();
    	return false;
	}

	@Override
	public boolean updateEmployee(Employee_form Employee_form) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.saveOrUpdate(Employee_form);
		tx.commit();
		session.close();
    	return false;
	}


	@SuppressWarnings("deprecation")
	@Override
	public List<Employee_form> getEmployeeById(int employee_form_Id) {
		//employee.setEmployee_id(employee_id);	
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee_form.class)
				.add(Restrictions.eq("employee_form_Id", employee_form_Id))
				.add(Restrictions.eq("deletes", 1));
		List<Employee_form> employee_form = criteria.list();
		tx.commit();
		session.close();
		return employee_form;
	}

	@Override
	public List<Employee_form> getEmployee_List() {
		
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee_form.class)				
				.add(Restrictions.eq("deletes", 1));
		List<Employee_form> employee_form = criteria.list();
		tx.commit();
		session.close();
		return employee_form;
	}

	@Override
	public void SoftdeleteEmployee(int employee_form_Id) {
		Employee_form employee_form = new Employee_form();
		employee_form.setEmployee_form_Id(employee_form_Id);;
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		org.hibernate.query.Query q = session.createQuery("UPDATE Employee_form set deletes = :zero "  + "WHERE employee_form_Id = :employee_form_Id");
		//org.hibernate.query.Query q = session.createQuery("update employee set deletes=:zero where employee_id=:employee_id");
		q.setParameter("employee_form_Id", employee_form.getEmployee_form_Id());
		q.setParameter("zero", 0);
		q.executeUpdate();
		tx.commit();
		session.close();
		
	}


}
