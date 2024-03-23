package tn.ommp.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import tn.ommp.pfe.models.Agent;
import tn.ommp.pfe.models.Conge;
import tn.ommp.pfe.models.Fonction;
import tn.ommp.pfe.models.Medecin;
import tn.ommp.pfe.repository.CongeRepository;
@Service
public class CongeManagerImpl implements CongeManager {

	@Autowired
	CongeRepository congeRepository;
	

	//@Autowired
	//MouchardManager mouchardManager;
	
	@Override
	public Conge getCongeById(Long id) {
		return congeRepository.findById(id).get();
		
	}

	@Override
	public Conge saveConge(Conge conge) {
		//Conge oldConge = conge.getId() != null ? congeRepository.findById(conge.getId()).get() : null;
		Conge newConge = congeRepository.save(conge);
		//mouchardManager.actionSave(oldConge,  newConge, connectedUser);
		return newConge;
	}

	@Override
	public List<Conge> getAllConges() {
		return (List<Conge>) congeRepository.findAll();
		}

	@Override
	public void deleteConge(Long id) {
		Conge conge = getCongeById(id);
		congeRepository.deleteById(id);
		//mouchardManager.actionDelete(id, conge, connectedUser);
		}

	@Override
	public List<Conge> getCongeByMedecin(Medecin medecin) {
		
		return congeRepository.findByMedecin(medecin);
	}
		
	}