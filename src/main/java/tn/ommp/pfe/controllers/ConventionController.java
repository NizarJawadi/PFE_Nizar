package tn.ommp.pfe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.ommp.pfe.models.Convention;
import tn.ommp.pfe.services.ConventionManager;


@RestController
@RequestMapping("/ommp/convention")
public class ConventionController {
	
	
	@Autowired
	ConventionManager  conventionManger ;
	
	 @PostMapping("/add")
	 	public void addConvention(@RequestBody Convention convention) {
		 conventionManger.saveConvention(convention);
	    }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Object> deleteConvention(@PathVariable Long id) {
		 conventionManger.deleteConvention(id);
	     return ResponseEntity.noContent().build();
	 }
	 
	 @GetMapping("/all")
	    public List<Convention> getAllConventions() {
	        return conventionManger.getAllConventions();
	    } 
	 
}


