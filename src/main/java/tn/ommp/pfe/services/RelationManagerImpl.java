package tn.ommp.pfe.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import tn.ommp.pfe.models.Agent;
import tn.ommp.pfe.models.Fonction;
import tn.ommp.pfe.models.Relation;
import tn.ommp.pfe.models.Specialite;
import tn.ommp.pfe.models.TypeRelation;
import tn.ommp.pfe.repository.RelationRepository;

@Service
public class RelationManagerImpl implements RelationManager{
	
	@Autowired
	RelationRepository relationRepository ;
	
//	@Autowired
//	MouchardManager mouchardManager;

	@Override
	public Relation getRelationById(Long id) {
       
		return relationRepository.findById(id).get(); 
	}

	@Override
	public Relation saveRelation(Relation relation) {
		Relation oldRelation = relation.getId() != null ? relationRepository.findById(relation.getId()).get() : null;
		Relation newRelation = relationRepository.save(relation);
		//mouchardManager.actionSave(oldRelation, newRelation, connectedUser);
		return newRelation;
	}

	@Override
	public List<Relation> getAllRelations() {
		return (List<Relation>) relationRepository.findAll();
	}

	
	@Override
	public void deleteRelation(Long id ) {
		Relation relation = getRelationById(id);
		relationRepository.deleteById(id);
		//mouchardManager.actionDelete(id, relation, connectedUser);
		
		
	}

	@Override
	public List<Relation> getRelationByAgent(Agent connectedAgent) {
		
		return relationRepository.findByAgent(connectedAgent);
	}
	@Override
    public Relation getRelationByAgentAndTypeRelation(Agent agent, TypeRelation typeRelation) {

        return relationRepository.findByAgentAndTypeRelation(agent, typeRelation);
    }
	
	
}

