package tn.ommp.pfe.auth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.server.reactive.HttpHeadResponseDecorator;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

import lombok.RequiredArgsConstructor;
import tn.ommp.pfe.jwt.config.LogoutService;
import tn.ommp.pfe.models.User;
import tn.ommp.pfe.repository.UserRepository;
@RestController
@RequestMapping("/ommp")
@RequiredArgsConstructor
public class AuthenticationController {

	@Autowired
	UserRepository repository;

	@Autowired
	LogoutService logoutservice;

	private final AuthenticationService service;

	private final LogoutService logoutService;

	@PostMapping("/register")
	public HttpStatus register(@RequestBody RegisterRequest request) {
		if (repository.findByMatricule(request.getMatricule()).isPresent() != false) {
			AuthenticationResponse response = new AuthenticationResponse();
			HttpStatus status = HttpStatus.UNAUTHORIZED;
			return status;
		}
		else {
			ResponseEntity.ok(service.register(request));
			HttpStatus status = HttpStatus.ACCEPTED;
			return status;
		}

	}

	@PostMapping("/authenticate")
	  public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request , HttpSession reqSession ) {
		  if (repository.findByMatricule(request.getMatricule()).isPresent()!=false) 
		 {
			  AuthenticationResponse auth = service.authenticate(request, reqSession) ;
			  return  ResponseEntity.ok(auth);
			  /* HttpSession session = reqSession.getSession(true); 
		        User user = repository.findByMatricule(request.getMatricule()).get();
		        session.setAttribute("user",user);
		        session.setAttribute("password",user.getPassword());
		        session.setAttribute("matricule",user.getMatricule());
		        session.setAttribute("role",user.getRole().name());
		        session.setAttribute("token",service.authenticate(request).getToken());
				HttpStatus status = HttpStatus.ACCEPTED;	*/
				  
		 }	
		  
		  return ResponseEntity.ok().body(new AuthenticationResponse ()) ;
	  }

	/*
	 * @RequestMapping("/logout") public ResponseEntity<String> logout(){
	 * logoutService.logout(HttpServletRequest, HttpServletResponse , Authentication
	 * authentication); return new ResponseEntity<String>("Logout Successfully!",
	 * HttpStatus.OK); }
	 */
	/*@GetMapping("/logout")
	public String logout (HttpServletRequest request, HttpServletResponse response) {
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  if (auth != null){
	    new SecurityContextLogoutHandler().logout(request, response, auth);
	    HttpSession session = request.getSession(false);
	    session.invalidate() ;
	    String sessionId = request.getSession().getId();
	    String matricule = (String)session.getAttribute("matricule");
	    String password = (String)session.getAttribute("password");
	    String role = (String) session.getAttribute("role") ;
	    
	    System.out.println(sessionId);
	    System.out.println(matricule);
	    System.out.println(password);
	    System.out.println(role);
	  }
	  return "USER_LOGOUT_SUCCESSFUL";
	}*/

	@GetMapping("/logout")
	  public void logout(HttpServletRequest request, HttpServletResponse response ) throws ServletException {
	    request.getSession().invalidate();
	    logoutService.logout(request, response, null);
	    response.setStatus(HttpStatus.OK.value());
	    //HttpSession session = request.getSession();
	    //session.invalidate();
	    // session = request.getSession(false);
	     
	     String sessionId = request.getSession().getId();
	   // HttpHeaders headers = new HttpHeaders();
	   // headers.add("Set-Cookie", "JSESSIONID=" + null + "; HttpOnly");
	   
		    String matricule = (String)request.getSession().getAttribute("matricule");
		    String password = (String)request.getSession().getAttribute("password");
		    String role = (String) request.getSession().getAttribute("role") ;
		    
		    System.out.println(sessionId);
		    System.out.println(matricule);
		    System.out.println(password);
		    System.out.println(role);
	  }
	  

	@GetMapping("/session")
	public ResponseEntity<Map<String, Object>> getSession(HttpServletRequest request) {
	    Map<String, Object> data = new HashMap<>();
	    

	    HttpSession session = request.getSession();
	    String sessionId = request.getSession().getId();
	    Long id =  (Long)session.getAttribute("ID") ;
	    String matricule = (String)session.getAttribute("matricule");
	    String password = (String)session.getAttribute("password");
	    String role = (String) session.getAttribute("role") ;
	    data.put("id",id);
	    data.put("sessionId", sessionId);
	    data.put("matricule", matricule);
	    data.put("password", password);
	    data.put("role", role);
	    System.out.println(id);
	    System.out.println(sessionId);
	    System.out.println(matricule);
	    System.out.println(password);
	    System.out.println(role);
	   // HttpHeaders headers = new HttpHeaders();
	    //headers.add("Set-Cookie", "JSESSIONID=" + sessionId + "; HttpOnly");

	    return ResponseEntity.ok()
	            //.headers(headers)
	            .body(data);
	}
}


 /*
 @PostMapping("/logout")
  public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException {
    request.getSession().invalidate();
    logoutService.logout(request, response, null);
    response.setStatus(HttpStatus.OK.value());
    HttpSession session = request.getSession();
    session.invalidate();
     session = request.getSession(false);
  }
  

*/
