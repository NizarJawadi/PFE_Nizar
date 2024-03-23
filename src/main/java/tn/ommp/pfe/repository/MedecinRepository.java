package tn.ommp.pfe.repository;




import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import tn.ommp.pfe.models.CentreMedical;
import tn.ommp.pfe.models.Medecin;
import tn.ommp.pfe.models.Specialite;



public interface MedecinRepository extends JpaRepository<Medecin, Long>{

	
    List<Medecin> findBySpecialiteIn(List<Specialite> specialites);
    List<Medecin> findBySpecialite(Specialite specialite);
    List<Medecin> findByCentreMedical(CentreMedical centreMedical);
	List<Medecin> getMedecinsBySpecialiteAndCentreMedical(Specialite specialite, CentreMedical centreMedical);
    List<Medecin> findBySpecialiteAndCentreMedical(Long specialite, CentreMedical centreMedical);

	List<Medecin> findByMatriculeAndPassword(String matricule, String password);
	Optional<Medecin> findByMatricule(String matricule);
	
	
	

	
	

}
