package tn.ommp.pfe;


import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@SpringBootApplication
public class PfeProjectApplication   {
	/*PortRepository portRepository ;
	CentreMedicalRepository centreMedicalRepository ;
	UserRepository userRepository ;
	AgentRepository agentRepository ;
	public PfeProjectApplication(PortRepository portRepository, CentreMedicalRepository centreMedicalRepository,
			UserRepository userRepository , AgentRepository agentRepository) {
		super();
		this.portRepository = portRepository;
		this.centreMedicalRepository = centreMedicalRepository;
		this.userRepository = userRepository;
		this.agentRepository =agentRepository ;
	}

*/
	
	

	

	public static void main(String[] args) {
		SpringApplication.run(PfeProjectApplication.class, args);
		
	}
	

	
	 @Bean
	  public WebMvcConfigurer crosConfigurer() {
		 return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// TODO Auto-generated method stub
				 registry.addMapping("/**")
			      .allowedOrigins("http://localhost:4200/")
			      .allowedMethods("GET", "POST", "PUT", "DELETE")
			      .allowedHeaders("*")
			      .allowCredentials(true)
			      .maxAge(3600);
			}
		 };
	 }
	 
	 
	
/*
		@Override
		public void run(String... args) throws Exception {
		
			/*Medecin med = new Medecin();
			Port p = new Port();
			p.setCode("1");
			p.setDesignation("DG");
			
			
			med.setId((long) 1);
			med.setNomPrenom("ala");
			med.setMatricule("1919");
			med.setPassword("1212");
			med.setCentreMedical(null);
			med.setSpecialite(spec);
			Specialite spec = new Specialite(null,med,"radiologie");
			CentreMedical c1 = new CentreMedical(,"DG", med, p);
					
		Agent a1 = new Agent();			
		a1.setCin("14500470");
		a1.setRole(Role.ADMIN);
		a1.setEmail("jawadinizar2@gmail.com");
		a1.setMatricule("12345678");
		a1.setNomPrenom("hamza jawadi");
		a1.setPassword("12345678");
		a1.setResponsable(true);
		
				
		Agent a2 = new Agent();			
		a2.setCin("14500470");
		a2.setRole(Role.MEDECIN);
		a2.setEmail("jawadinizar2@gmail.com");
		a2.setMatricule("12345678");
		a2.setNomPrenom("hamza jawadi");
		a2.setPassword("12345678");
		a2.setResponsable(true);
		
		
		Medecin a3 = new Medecin();			
		a3.setCin("14500470");
		a3.setRole(Role.ADMIN);
		//a3.setEmail("jawadinizar2@gmail.com");
		a3.setMatricule("12345678");
		a3.setNomPrenom("hamza jawadi");
		a3.setPassword("22222222");
		
		
		//a1.setPort(portRepository.findByCentreMedical(cen));
		userRepository.save(a1);
		agentRepository.save(a1);
		userRepository.save(a2);
		userRepository.save(a3);

		
		//userRepository.findAll().forEach(p->System.out.println(p.toString()));
		
	
		}

/*
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//tutorialRepository.save(new Tutorial(1,"nizar","jawadi",true));
		List<Agent> tuto= agentRepository.findByMatriculeAndPassword("1919","1919");
		Agent a = new Agent(tuto.get(0).getId(),tuto.get(0).getMatricule(),tuto.get(0).getPassword());
		System.out.println(a);
		System.out.println("***********************");
		

		agentRepository.findByMatriculeAndPassword("1919","1919").forEach(p->System.out.println(p.toString()));
	}
	*/



}
