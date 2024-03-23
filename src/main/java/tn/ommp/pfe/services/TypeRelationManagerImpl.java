package tn.ommp.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.ommp.pfe.models.TypeRelation;
import tn.ommp.pfe.repository.TypeRelationRepository;

@Service
public class TypeRelationManagerImpl implements TypeRelationManager {

	@Autowired
	TypeRelationRepository typeRelationRepository;

	@Override
	public TypeRelation getTypeRelationById(Long id) {
		return typeRelationRepository.findById(id).get();

	}

	@Override
	public TypeRelation saveTypeRelation(TypeRelation typeRelation) {
		TypeRelation newTypeRelation = typeRelationRepository.save(typeRelation);
		return newTypeRelation;
	}

	@Override
	public List<TypeRelation> getAllTypeRelations() {
		return (List<TypeRelation>) typeRelationRepository.findAll();
	}

	@Override
	public void deleteTypeRelation(Long id) {
		typeRelationRepository.deleteById(id);
	}

}