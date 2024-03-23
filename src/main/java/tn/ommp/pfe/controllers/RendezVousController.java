package tn.ommp.pfe.controllers;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.ommp.pfe.models.Medecin;
import tn.ommp.pfe.models.RendezVous;
import tn.ommp.pfe.models.Specialite;
import tn.ommp.pfe.services.RendezVousManager;

@RestController
@RequestMapping("/ommp/rendez-vous")
public class RendezVousController {
	@Autowired
	RendezVousManager rendezVousManager ;
	
	
	 @PostMapping("/add")
	 	public void addRendezVous(@RequestBody RendezVous rendezVous) {
		
		 RendezVous r = rendezVous ;
		 
        	  r.setDateDebutRendezVous(r.getDateDebutRendezVous());
        	  r.setDateCreation(r.getDateCreation());
        	  r.setDateFinRendezVous(r.getDateFinRendezVous());
        	 
        	  //ZonedDateTime zonedDateTime = ZonedDateTime.parse(r.getDateDebutRendezVous().plusHours(+1).toString(), formatter);
	
		 rendezVousManager.saveRendezVous(rendezVous);
	    }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Object> deleteRendezVous(@PathVariable Long id) {
		 rendezVousManager.deleteRendezVous(id);
	     return ResponseEntity.noContent().build();
	 }
	 
	 @GetMapping("/all")
	    public List<RendezVous> getAllRendezVous() {
	        return rendezVousManager.getAllRendezVous();
	    }
	 
	 

	 @GetMapping("/rendezvousMedecin/{id}")
		public ResponseEntity<List<RendezVous>> getRendezVousParMedecin(@PathVariable(name="id") String idMedecin   ) {
		  
			Long id ;
			try {
		        id = Long.parseLong(idMedecin);
		    } catch (NumberFormatException ex) {
		        return ResponseEntity.badRequest().build();
		    }
			
			//Optional<Specialite> specialite = specialiteRepository.findById(id);
		    
		    //if (specialite != null ) {
		        List<RendezVous> rendezVous = rendezVousManager.getRendezVousByMedecin(id);
		        List <RendezVous> listeRendezVous =new  ArrayList<RendezVous>();
		        for (RendezVous r : rendezVous ) {
		        	 ZonedDateTime dateDebut = r.getDateDebutRendezVous().plusHours(1);
		        	 ZonedDateTime dateCre = r.getDateCreation().plusHours(1);
		        	 ZonedDateTime dateFin = r.getDateFinRendezVous().plusHours(1);
		        	 
		        	 RendezVous Rvous = new RendezVous(r.getId(),dateDebut,dateFin,dateCre);
		        	 listeRendezVous.add(Rvous) ;
		        }
		       
		        
		        return ResponseEntity.ok(listeRendezVous);
		    
		}
	
	

}
