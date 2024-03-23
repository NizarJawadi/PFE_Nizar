package tn.ommp.pfe.services;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import tn.ommp.pfe.models.Agent;
import tn.ommp.pfe.models.TypeRelation;



public interface TypeRelationManager {
	
	public TypeRelation getTypeRelationById(Long id);
	public TypeRelation saveTypeRelation(TypeRelation typeRelation);
	public List<TypeRelation> getAllTypeRelations();
//	public DataTablesOutput<TypeRelation> findAllForDataTable(DataTablesInput input);
//	public DataTablesOutput<TypeRelation> findForDataTableWithSpec(DataTablesInput input, Specification<TypeRelation> spec);
	public void deleteTypeRelation(Long id);
}


