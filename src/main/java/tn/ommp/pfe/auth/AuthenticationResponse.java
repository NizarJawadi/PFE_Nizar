package tn.ommp.pfe.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.ommp.pfe.models.Agent;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

	private String NOT_FOUND ="NOT_FOUND" ;
	
	  private String token;
	  
	  private String role ;
	  
	  private String password ;
	  
	  private String matricule ;
	  
	  private String sessionID ;
	  
	  private Long ID ;
}