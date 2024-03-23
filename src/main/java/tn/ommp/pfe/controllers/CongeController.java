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

import tn.ommp.pfe.models.CentreMedical;
import tn.ommp.pfe.models.Conge;
import tn.ommp.pfe.services.CongeManager;

@RestController
@RequestMapping("/ommp/conge")
public class CongeController {
		
	
	@Autowired
	CongeManager congeManager ;
	
	
	  
		 @PostMapping("/add")
		 	public void addConge(@RequestBody Conge conge) {
			 congeManager.saveConge(conge);
		    }
		 
		 @DeleteMapping("/{id}")
		 public ResponseEntity<Object> deleteConge(@PathVariable Long id) {
			 congeManager.deleteConge(id);
		     return ResponseEntity.noContent().build();
		 }
		 
		 @GetMapping("/all")
		    public List<Conge> getAllConges() {
		        return congeManager.getAllConges();
		    } 
		 
	}
