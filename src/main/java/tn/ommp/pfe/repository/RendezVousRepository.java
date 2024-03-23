package tn.ommp.pfe.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import tn.ommp.pfe.models.Agent;
import tn.ommp.pfe.models.Medecin;
import tn.ommp.pfe.models.Relation;
import tn.ommp.pfe.models.RendezVous;




@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous, Long>, JpaSpecificationExecutor<RendezVous> {
	List<RendezVous> findByAgent(Agent agent);
 List<RendezVous> findByMedecin(Medecin medecin);
	List<RendezVous> findByRelation(Relation relation);
}
