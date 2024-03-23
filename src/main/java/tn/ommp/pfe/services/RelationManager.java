package tn.ommp.pfe.services;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import tn.ommp.pfe.models.Agent;
import tn.ommp.pfe.models.Relation;
import tn.ommp.pfe.models.TypeRelation;

public interface RelationManager {
	public Relation getRelationById(Long id);
	public Relation saveRelation(Relation relation /*, Agent connectedUser*/);
	public List<Relation> getAllRelations();
	//public DataTablesOutput<Relation> findAllForDataTable(DataTablesInput input);
//	public DataTablesOutput<Relation> findForDataTableWithSpec(DataTablesInput input, Specification<Relation> spec);
	public void deleteRelation(Long id /*,Agent connectedUser*/);
	public List<Relation> getRelationByAgent(Agent connectedAgent);
	public Relation getRelationByAgentAndTypeRelation(Agent agent ,TypeRelation typeRelation);
	

}
