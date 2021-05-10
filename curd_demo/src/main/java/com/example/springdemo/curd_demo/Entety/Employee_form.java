package com.example.springdemo.curd_demo.Entety;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "employee_form")
public class Employee_form {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employee_form_Id ;
	
  
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "employee_id")    
	private Employee employee; 
   
   
   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "sport_id")
   private Sport sport;
   
	@Column(name = "deletes")
	private int deletes;
	
	
	public Employee_form() {
		// TODO Auto-generated constructor stub
	}

	
	public Employee_form(int employee_form_Id, Employee employee, Sport sport, int deletes) {
		super();
		this.employee_form_Id = employee_form_Id;
		this.employee = employee;
		this.sport = sport;
		this.deletes = deletes;
	}

	
	public int getEmployee_form_Id() {
		return employee_form_Id;
	}

	public void setEmployee_form_Id(int employee_form_Id) {
		this.employee_form_Id = employee_form_Id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public int getDeletes() {
		return deletes;
	}

	public void setDeletes(int deletes) {
		this.deletes = deletes;
	}

	
}
