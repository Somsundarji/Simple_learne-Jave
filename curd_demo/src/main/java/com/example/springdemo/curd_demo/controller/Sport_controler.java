package com.example.springdemo.curd_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.curd_demo.Entety.Sport;
import com.example.springdemo.curd_demo.Repositerey.SportRepository;



@RestController
public class Sport_controler {

	@Autowired
	   private SportRepository sportrepository;	  
	  
	@GetMapping(value = "/sport")
    public List<Sport> getAllsport() {
  	System.out.println("Running");
	    return (List<Sport>) sportrepository.findAll();
	    
	    }
	     
  @PostMapping("/add_sport")
  Sport createOrSaveEmployee(@RequestBody Sport sport) {
      return sportrepository.save(sport);
  }

  @GetMapping("/sport_ById/{sport_id}")
  Sport getSportById(@PathVariable int sport_id) {
      return sportrepository.findById(sport_id).get();
  }

  @DeleteMapping("/delete_sport/{sport_id}")
  void deletesport(@PathVariable int sport_id) {
	  sportrepository.deleteById(sport_id);
}
	  
}
