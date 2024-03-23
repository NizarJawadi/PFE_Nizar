package tn.ommp.pfe.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import tn.ommp.pfe.models.Conge;
import tn.ommp.pfe.models.Medecin;





@Repository
public interface CongeRepository extends JpaRepository<Conge, Long>, JpaSpecificationExecutor<Conge> {

	List<Conge> findByMedecin(Medecin medecin);
	

}
