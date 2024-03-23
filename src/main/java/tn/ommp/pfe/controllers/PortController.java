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

import tn.ommp.pfe.models.Port;
import tn.ommp.pfe.services.PortManager;

@RestController
@RequestMapping("/ommp/port")
public class PortController {


	@Autowired
	PortManager portManager;
	
	  
	 @PostMapping("/add")
	 	public void addPort(@RequestBody Port port) {
		 portManager.savePort(port);
	    }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Object> deletePort(@PathVariable Long id) {
		 portManager.deletePort(id);
	     return ResponseEntity.noContent().build();
	 }
	 
	 @GetMapping("/all")
	    public List<Port> getAllPorts() {
	        return portManager.getAllPorts();
	    }
}
