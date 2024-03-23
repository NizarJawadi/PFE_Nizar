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
import tn.ommp.pfe.services.CentreMedicalManager;


@RestController
@RequestMapping("/ommp/centreMedical")
public class CentreMedicalController {

	

	@Autowired
	CentreMedicalManager centreMedicalManager;
	
	  
	 @PostMapping("/add")
	 	public void addCentreMedical(@RequestBody CentreMedical centreMedical) {
		 centreMedicalManager.saveCentreMedical(centreMedical);
	    }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Object> deleteCentreMedical(@PathVariable Long id) {
		 centreMedicalManager.deleteCentreMedical(id);
	     return ResponseEntity.noContent().build();
	 }
	 
	 @GetMapping("/all")
	    public List<CentreMedical> getAllCentreMedicals() {
	        return centreMedicalManager.getAllCentreMedicals();
	    } 
	 
}
