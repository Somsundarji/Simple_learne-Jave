package com.example.springdemo.curd_demo.Repositerey;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springdemo.curd_demo.Entety.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// public List<Employee> findAllById(int employee_id);

}
