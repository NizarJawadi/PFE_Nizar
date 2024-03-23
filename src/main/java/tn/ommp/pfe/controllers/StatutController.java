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

import tn.ommp.pfe.models.Statut;
import tn.ommp.pfe.services.StatutManager;


@RestController
@RequestMapping("/ommp/status")
public class StatutController {
	@Autowired
	StatutManager statutManager;
	
	  
	 @PostMapping("/add")
	 	public void addStatut(@RequestBody Statut statut) {
		 statutManager.saveStatut(statut);
	    }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Object> deleteStatut(@PathVariable Long id) {
		 statutManager.deleteStatut(id);
	     return ResponseEntity.noContent().build();
	 }
	 
	 @GetMapping("/all")
	    public List<Statut> getAllStatut() {
	        return statutManager.getAllStatuts();
	    }
}
