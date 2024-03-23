package tn.ommp.pfe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.ommp.pfe.models.VisiteMedicale;
import tn.ommp.pfe.services.VisiteMedicaleManager;

@RestController 
@RequestMapping("/ommp/visitemedicale")
public class VisiteMedicaleController {

	
	@Autowired 
	VisiteMedicaleManager visiteMedicaleManager ;
	
	
	 @PostMapping("/add")
	 	public void addConvention(@RequestBody VisiteMedicale visiteMedicale ) {
		 visiteMedicaleManager.saveVisiteMedicale(visiteMedicale);
	    }
	 

	 @GetMapping("/all")
	    public List<VisiteMedicale> getAllConventions() {
	        return visiteMedicaleManager.getAllVisiteMedicale();
	    } 
}
