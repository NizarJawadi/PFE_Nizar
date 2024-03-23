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

import tn.ommp.pfe.models.Poste;
import tn.ommp.pfe.services.PosteManager;

@RestController
@RequestMapping("/ommp/poste")
public class PosteController {



		@Autowired
		PosteManager  posteManager ; 
		
		  
		 @PostMapping("/add")
		 	public void addPort(@RequestBody Poste poste) {
			 posteManager.savePoste(poste);
		    }
		 
		 @DeleteMapping("/{id}")
		 public ResponseEntity<Object> deletePort(@PathVariable Long id) {
			 posteManager.deletePoste(id);
		     return ResponseEntity.noContent().build();
		 }
		 
		 @GetMapping("/all")
		    public List<Poste> getAllPorts() {
		        return posteManager.getAllPostes();
		    }
	
		
}
