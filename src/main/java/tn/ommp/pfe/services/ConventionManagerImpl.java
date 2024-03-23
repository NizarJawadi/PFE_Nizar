package tn.ommp.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import tn.ommp.pfe.models.Agent;
import tn.ommp.pfe.models.Convention;
import tn.ommp.pfe.repository.ConventionRepository;

@Service
public class ConventionManagerImpl implements ConventionManager {
	
	@Autowired
	ConventionRepository conventionRepository;
	//@Autowired
	//MouchardManager mouchardManager;
	

	@Override
	public Convention getConventionById(Long id) {
		return conventionRepository.findById(id).get();
		
	}

	@Override
	public Convention saveConvention(Convention convention) {
		//Convention oldConvention=convention.getId()!= null ? conventionRepository.findById(convention.getId()).get() : null ;
		Convention newConvention = conventionRepository.save(convention);
		//mouchardManager.actionSave(oldConvention, newConvention, connectedUser);
		return newConvention;
	}

	@Override
	public List<Convention> getAllConventions() {
		return (List<Convention>) conventionRepository.findAll();
		}


	@Override
	public void deleteConvention(Long id) {
		Convention convention=getConventionById(id);
		conventionRepository.deleteById(id);
		//mouchardManager.actionDelete(id, convention, connectedUser);
		}

}
