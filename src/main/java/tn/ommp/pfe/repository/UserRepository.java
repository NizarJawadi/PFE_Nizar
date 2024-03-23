package tn.ommp.pfe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;

import tn.ommp.pfe.models.Agent;
import tn.ommp.pfe.models.CentreMedical;
import tn.ommp.pfe.models.Medecin;
import tn.ommp.pfe.models.Port;
import tn.ommp.pfe.models.Poste;
import tn.ommp.pfe.models.Specialite;
import tn.ommp.pfe.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
   Optional<User> findByMatricule(String matricule);
  
   Optional<User> findById(Long id) ;  
   
   
	List<Agent> findByMatriculeAndPassword(String matricule, String password);
	List<Agent> findByPort(Port port);
	List<Agent> findByMatriculeContainingOrNomPrenomIgnoreCaseContaining(String matricule, String nomPrenom);
	List<Agent> getAgentsByPoste(Poste poste);
	List<Agent> findByPosteAndResponsable(Poste poste, boolean b);
	List<Agent> findByPosteIn(List<Poste> postes);
	List<Agent> findByMatriculeContainingAndPort(String matricule, Port port);
	
	@Query(value="SELECT a FROM AGENT a WHERE a.matricule = :matricule", nativeQuery = true)
	 public Agent getUserByMatricule(@PageableDefault @Param("matricule") String matricule);
	
	@Query(value= "SELECT a FROM AGENT a WHERE a.password = :password",nativeQuery = true)
	 public Agent getUserByPassword(@PageableDefault @Param("password") String password);
		
	// Optional<Agent> findByMatricule(String matricule);

	 
	  List<Medecin> findBySpecialiteIn(List<Specialite> specialites);
	    
	  List<Medecin> findByCentreMedical(CentreMedical centreMedical);
      List<Medecin> getMedecinsBySpecialiteAndCentreMedical(Specialite specialite, CentreMedical centreMedical);

		//List<Medecin> findByMatriculeAndPassword(String matricule, String password);
		//Optional<Medecin> findByMatricule(String matricule);
		
		
  
}

