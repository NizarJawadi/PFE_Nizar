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

import tn.ommp.pfe.models.Resiliation;
import tn.ommp.pfe.services.ResiliationManager;

@RestController
@RequestMapping("/ommp/resiliation")
public class ResiliationController {
	
	@Autowired
	ResiliationManager	resiliationManager ;
	

	
	 @PostMapping("/add")
	 	public void addResiliation(@RequestBody Resiliation resiliation) {
		 resiliationManager.saveResiliation(resiliation);
	    }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Object> deleteResiliation(@PathVariable Long id) {
		 resiliationManager.deleteResiliation(id);
	     return ResponseEntity.noContent().build();
	 }
	 
	 @GetMapping("/all")
	    public List<Resiliation> getAllResiliations() {
	        return resiliationManager.getAllResiliations();
	    }

}
