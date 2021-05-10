package com.example.springdemo.curd_demo.Repositerey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springdemo.curd_demo.Entety.Sport;


@Repository
public interface SportRepository extends JpaRepository<Sport, Integer>{

}
