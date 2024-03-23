package tn.ommp.pfe.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.ommp.pfe.models.Agent;
import tn.ommp.pfe.models.CentreMedical;
import tn.ommp.pfe.models.Medecin;
import tn.ommp.pfe.models.Specialite;
import tn.ommp.pfe.repository.CentreMedicalRepository;
import tn.ommp.pfe.repository.MedecinRepository;
import tn.ommp.pfe.repository.SpecialiteRepository;
import tn.ommp.pfe.services.MedecinManager;
import tn.ommp.pfe.services.SpecialiteManager;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("ommp/medecin")
public class MedecinController {
	
	
	@Autowired
	MedecinManager medecinManager ;

	@Autowired
	SpecialiteManager specialiteManager ;
	
	@Autowired
	private SpecialiteRepository specialiteRepository;
	
	@Autowired
	private MedecinRepository medecinRepository;
	
	@Autowired
	private CentreMedicalRepository centreRepository;
	
	@PostMapping("/add")
	public void addMedecin(@RequestBody Medecin medecin) {
		medecinManager.saveMedecin(medecin);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteMedecin(@PathVariable Long id) {
		medecinManager.deleteMedecin(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/all")
	public List<Medecin> getAllAgents() {
		return medecinManager.getAllMedecins();
	}
	
	@GetMapping("/medecinsSpec/{id}")
	public ResponseEntity<List<Medecin>> getMedecinsParSpecialite(@PathVariable(name="id") String idSpec  /*, @RequestParam String centreMedicale*/ ) {
	  
		Long id ;
		try {
	        id = Long.parseLong(idSpec);
	    } catch (NumberFormatException ex) {
	        return ResponseEntity.badRequest().build();
	    }
		
		Optional<Specialite> specialite = specialiteRepository.findById(id);
	    
	    if (specialite != null ) {
	        List<Medecin> medecins = medecinManager.getMedecinsBySpecialite(specialite.get());
	        
	        return ResponseEntity.ok(medecins);
	    } else {
	        return ResponseEntity.notFound().build();
	    } 
	}
	
	
	@GetMapping("/medecinsCentre/{id}")
	public ResponseEntity<List<Medecin>> getMedecinsParCentre(@PathVariable(name="id") String idCentre  /*, @RequestParam String centreMedicale*/ ) {
	  
		Long id ;
		try {
	        id = Long.parseLong(idCentre);
	    } catch (NumberFormatException ex) {
	        return ResponseEntity.badRequest().build();
	    }
		
		Optional<CentreMedical> centre = centreRepository.findById(id);
	    
	    if (centre != null ) {
	        List<Medecin> medecins = medecinManager.getMedecinByCentre(centre.get());
	        
	        return ResponseEntity.ok(medecins);
	    } else {
	        return ResponseEntity.notFound().build();
	    } 
	}
	
	
	 @GetMapping("/specialite/{specialite}/centre/{centreId}")
	    public ResponseEntity<List<Medecin>> getBySpecAndCentre(@PathVariable(name="specialite") Long idSpec, @PathVariable(name="centreId") Long centreId) {
		 /*Long id ;
			try {
		        id = Long.parseLong(centreId);
		    } catch (NumberFormatException ex) {
		        return ResponseEntity.badRequest().build();
		    }*/
			
			Optional<CentreMedical> centre = centreRepository.findById(centreId);
		    List<Medecin> medecinBySpecAndCentre = new ArrayList<>() ;
		    if (centre.isPresent() ) {
		        List<Medecin> medecins = medecinManager.getMedecinByCentre(centre.get());
		        
		       for(Medecin med : medecins) {
		    	   if (med.getCentreMedical().getId()== centre.get().getId()) {
		    		   medecinBySpecAndCentre.add(med);
		    	   }
		       }
		        
		        return ResponseEntity.ok(medecinBySpecAndCentre);
		    } else {
		        return ResponseEntity.notFound().build();
		    } 
	    }
	
}
