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

import tn.ommp.pfe.models.Pathologie;
import tn.ommp.pfe.services.PathologieManager;

@RestController
@RequestMapping("/ommp/pathologie")
public class PathologieController {

	
	@Autowired 
	PathologieManager pathologieManager ;
	 @PostMapping("/add")
	 	public void addPathologie(@RequestBody Pathologie pathologie) {
		 pathologieManager.savePathologie(pathologie) ;
	    }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Object> deletePathologie(@PathVariable Long id) {
		 pathologieManager.deletePathologie(id);
	     return ResponseEntity.noContent().build();
	 }
	 
	 @GetMapping("/all")
	    public List<Pathologie> getAllPathologies() {
	        return pathologieManager.getAllPathologies();
	    }

}
