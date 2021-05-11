package com.example.springdemo.curd_demo.Entety;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity  
@Table(name = "employee")
public class Employee implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employee_id; 
	@Column  
	private String employee_name;
	@Column  
	private String employee_project;
	
	@Column(name = "deletes")
	private int deletes;
	
	 @OneToMany(mappedBy = "employee")	 
	 public List<Sport> sport ;		
	

	public Employee(){ 
		
	 }  	

	public Employee(int employee_id, String employee_name, String employee_project, int deletes, List<Sport> sport) {
	super();
	this.employee_id = employee_id;
	this.employee_name = employee_name;
	this.employee_project = employee_project;
	this.deletes = deletes;
	this.sport = sport;
}

	
	public List<Sport> getSport() {
		return sport;
	}

	public void setSport(List<Sport> sport) {
		this.sport = sport;
	}

	public int getDeletes() {
		return deletes;
	}

	public void setDeletes(int deletes) {
		this.deletes = deletes;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}	

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmployee_project() {
		return employee_project;
	}

	public void setEmployee_project(String employee_project) {
		this.employee_project = employee_project;
	}

	


	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", employee_name=" + employee_name + ", employee_project="
				+ employee_project + "]";
	}


	
	
	
}
