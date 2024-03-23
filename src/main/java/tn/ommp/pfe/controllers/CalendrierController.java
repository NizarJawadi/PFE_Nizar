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

import tn.ommp.pfe.models.Calendrier;
import tn.ommp.pfe.services.CalendrierManager;

@RestController
@RequestMapping("/ommp/calendrier")
public class CalendrierController {
	
	@Autowired
	 CalendrierManager calendrierManager;
	 @PostMapping("/add")
	 	public void addConvention(@RequestBody Calendrier calendrier) {
		 calendrierManager.saveCalendrier(calendrier);
	    }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Object> deleteCalendrier(@PathVariable Long id) {
		 calendrierManager.deleteCalendrier(id);
	     return ResponseEntity.noContent().build();
	 }
	 
	 @GetMapping("/all")
	    public List<Calendrier> getAllCalendriers() {
	        return calendrierManager.getAllCalendriers();
	    } 
	

}
