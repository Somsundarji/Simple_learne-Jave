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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "sport")
public class Sport implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sport_id ;	
	@Column 
	private String sport_name;
	@Column 
	private String sport_type;
	
	@Column(name = "deletes")
	private int deletes;
	

	@ManyToOne() 
	@JoinColumn(name = "employee_id ")   
	private Employee employee; 

	   
		public Sport(){
		
		}

	public Sport(int sport_id, String sport_name, String sport_type, int deletes, Employee employee) {
	super();
	this.sport_id = sport_id;
	this.sport_name = sport_name;
	this.sport_type = sport_type;
	this.deletes = deletes;
	this.employee = employee;
}

	@JsonBackReference
	  public Employee getEmployee() {
		return employee;
		}

	 public void setEmployee(Employee employee) {
	 this.employee = employee;
		}

	public int getDeletes() {
		return deletes;
	}

	public void setDeletes(int deletes) {
		this.deletes = deletes;
	}

	public int getSport_id() {
		return sport_id;
	}

	public void setSport_id(int sport_id) {
		this.sport_id = sport_id;
	}

	public String getSport_name() {
		return sport_name;
	}
	public void setSport_name(String sport_name) {
		this.sport_name = sport_name;
	}
	public String getSport_type() {
		return sport_type;
	}
	public void setSport_type(String sport_type) {
		this.sport_type = sport_type;
	}

	@Override
	public String toString() {
		return "Sport [sport_id=" + sport_id + ", sport_name=" + sport_name + ", sport_type=" + sport_type
				+"]";
	}



	
}
