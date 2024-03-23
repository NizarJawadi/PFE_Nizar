package tn.ommp.pfe.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.ommp.pfe.models.Convention;
import tn.ommp.pfe.models.Fonction;
import tn.ommp.pfe.services.ConventionManager;
import tn.ommp.pfe.services.FonctionManager;


@RestController
@RequestMapping("/ommp/fonction")
public class FonctionController {

	
	@Autowired
	 FonctionManager  fonctionManager ;
	
	 @PostMapping("/add")
	 	public void addFonction(@RequestBody Fonction fonction , HttpServletRequest request) {
		 fonctionManager.saveFonction(fonction);
		 HttpSession session = request.getSession();
		 String sessionId = request.getSession().getId();
		    String matricule = (String)session.getAttribute("matricule");
		    String password = (String)session.getAttribute("password");
		    String role = (String) session.getAttribute("role") ;
		    System.out.println(sessionId);
		    System.out.println(matricule);
		    System.out.println(password);
		    System.out.println(role);
		 
	    }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Object> deleteFonction(@PathVariable Long id) {
		 fonctionManager.deleteFonction(id);
	     return ResponseEntity.noContent().build();
	 }
	 
	 @GetMapping("/all")
	    public List<Fonction> getAllFonction() {
	        return fonctionManager.getAllFonctions();
	    } 
}
