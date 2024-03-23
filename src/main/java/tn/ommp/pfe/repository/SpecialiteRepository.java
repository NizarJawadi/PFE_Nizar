package tn.ommp.pfe.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.ommp.pfe.models.Medecin;
import tn.ommp.pfe.models.Specialite;

@Repository
public interface SpecialiteRepository extends JpaRepository<Specialite, Long>,  CrudRepository<Specialite , Long  > {
	
 //Optional <Specialite> findByLibelle(String libelle);
	@Override
		Optional<Specialite> findById(Long id);

}
