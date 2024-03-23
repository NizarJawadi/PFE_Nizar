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

import tn.ommp.pfe.models.Port;
import tn.ommp.pfe.models.Specialite;
import tn.ommp.pfe.services.PortManager;
import tn.ommp.pfe.services.SpecialiteManager;


@RestController
@RequestMapping("/ommp/specialite")
public class SpecialiteController {


	@Autowired
	SpecialiteManager specialiteManager;
	
	  
	 @PostMapping("/add")
	 	public void addSpecialite(@RequestBody Specialite specialite) {
		 specialiteManager.saveSpecialite(specialite);
	    }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Object> deleteSpecialite(@PathVariable Long id) {
		 specialiteManager.deleteSpecialite(id);
	     return ResponseEntity.noContent().build();
	 }
	 
	 @GetMapping("/all")
	    public List<Specialite> getAllSpecialites() {
	        return specialiteManager.getAllSpecialites();
	    }
	 
	 
}
