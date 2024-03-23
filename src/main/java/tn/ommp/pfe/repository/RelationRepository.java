package tn.ommp.pfe.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import tn.ommp.pfe.models.Agent;
import tn.ommp.pfe.models.Relation;
import tn.ommp.pfe.models.TypeRelation;





@Repository
public interface RelationRepository extends JpaRepository<Relation, Long> , JpaSpecificationExecutor<Relation>{
	Relation findByAgentAndTypeRelation(Agent agent, TypeRelation typeRelation);
	List<Relation> findByAgent(Agent connectedAgent);
}
