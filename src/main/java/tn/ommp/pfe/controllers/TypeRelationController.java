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

import tn.ommp.pfe.models.TypeRelation;
import tn.ommp.pfe.services.TypeRelationManager;

@RestController
@RequestMapping("/ommp/typerelation")
public class TypeRelationController {
	
	@Autowired
	TypeRelationManager typeRelationManager ;
	

	
	 @PostMapping("/add")
	 	public void addRendezVous(@RequestBody TypeRelation typeRelation) {
		 typeRelationManager.saveTypeRelation(typeRelation);
	    }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Object> deleteRendezVous(@PathVariable Long id) {
		 typeRelationManager.deleteTypeRelation(id);
	     return ResponseEntity.noContent().build();
	 }
	 
	 @GetMapping("/all")
	    public List<TypeRelation> getAllRendezVous() {
	        return typeRelationManager.getAllTypeRelations();
	    }

}
