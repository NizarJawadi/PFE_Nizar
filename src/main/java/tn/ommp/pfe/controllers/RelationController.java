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

import tn.ommp.pfe.models.Relation;
import tn.ommp.pfe.services.RelationManager;
@RestController
@RequestMapping("/ommp/relation")
public class RelationController {
	
	@Autowired
	RelationManager relationManager ;

	
	 @PostMapping("/add")
	 	public void addRelation(@RequestBody Relation relation) {
		 relationManager.saveRelation(relation);
	    }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Object> deleteRelation(@PathVariable Long id) {
		 relationManager.deleteRelation(id);
	     return ResponseEntity.noContent().build();
	 }
	 
	 @GetMapping("/all")
	    public List<Relation> getAllRelations() {
	        return relationManager.getAllRelations();
	    }

}
