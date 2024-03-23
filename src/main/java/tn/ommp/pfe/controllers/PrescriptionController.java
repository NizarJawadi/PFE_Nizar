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
import tn.ommp.pfe.models.Prescription;
import tn.ommp.pfe.services.PrescriptionManager;

@RestController
@RequestMapping("/ommp/prescription")

public class PrescriptionController {
	
	@Autowired
	PrescriptionManager   prescriptionManager ;

	
	 @PostMapping("/add")
	 	public void addPrescription(@RequestBody Prescription prescription) {
		 prescriptionManager.savePrescription(prescription);
	    }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Object> deletePrescription(@PathVariable Long id) {
		 prescriptionManager.deletePrescription(id);
	     return ResponseEntity.noContent().build();
	 }
	 
	 @GetMapping("/all")
	    public List<Prescription> getAllPorts() {
	        return prescriptionManager.getAllPrescriptions();
	    }

}
