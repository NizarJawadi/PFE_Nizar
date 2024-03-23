package tn.ommp.pfe.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import tn.ommp.pfe.models.Calendrier;
import tn.ommp.pfe.models.Medecin;

@Repository
public interface CalendrierRepository extends JpaRepository<Calendrier,Long>,JpaSpecificationExecutor<Calendrier>{
	
List<Calendrier> findByMedecin(Medecin medecin);

}
