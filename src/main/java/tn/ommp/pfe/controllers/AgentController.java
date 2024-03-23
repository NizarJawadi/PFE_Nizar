 package tn.ommp.pfe.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.ommp.pfe.models.Agent;
import tn.ommp.pfe.services.AgentManager;

@RestController
@RequestMapping("/ommp/agent")
public class AgentController {

	

	@Autowired
	AgentManager agentManager;
	
	  
	 @PostMapping("/add")
	 	public void addAgent(@RequestBody Agent agent, HttpSession session) {
		 agentManager.saveAgent(agent);
	    }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Object> deleteAgent(@PathVariable Long id) {
		 agentManager.deleteAgent(id);
	     return ResponseEntity.noContent().build();
	 }
	 
	 @GetMapping("/all")
	    public List<Agent> getAllAgents() {
	        return agentManager.getAllAgents();
	    }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<Object> getAgent(@PathVariable Long id) {
		 agentManager.deleteAgent(id);
	     return ResponseEntity.noContent().build();
	 }
	 
	 /*@GetMapping("session")
		public ResponseEntity<Map<String, Object>> getSession(HttpServletRequest request) {
		    Map<String, Object> data = new HashMap<>();
		   
		    HttpSession session = request.getSession(true);
		    String sessionId = session.getId();
		    String matricule = (String)session.getAttribute("matricule");
		    String password = (String)session.getAttribute("password");
		    String role = (String) session.getAttribute("role") ;
		    data.put("sessionId", sessionId);
		    data.put("matricule", matricule);
		    data.put("password", password);
		    data.put("role", role);
		    
		    HttpHeaders headers = new HttpHeaders();
		    headers.add("Set-Cookie", "JSESSIONID=" + sessionId + "; HttpOnly");

		    return ResponseEntity.ok()
		            .headers(headers)
		            .body(data);
		}
	*/
		 
	    
}
