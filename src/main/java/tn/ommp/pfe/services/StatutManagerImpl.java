package tn.ommp.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import tn.ommp.pfe.models.Statut;
import tn.ommp.pfe.repository.StatutRepository;


@Service
public class StatutManagerImpl implements StatutManager {

	@Autowired
	StatutRepository statutRepository;
	
	//@Autowired
	//MouchardManager mouchardManager;
	

	@Override
	public Statut getStatutById(Long id) {
		return statutRepository.findById(id).get();
		
	}

	@Override
	public Statut saveStatut(Statut statut) {
		//Statut oldStatut = statut.getId() != null ? statutRepository.findById(statut.getId()).get() : null;
		Statut newStatut = statutRepository.save(statut);
		//mouchardManager.actionSave(oldStatut, newStatut, connectedUser);
		return newStatut;
	}
	

	@Override
	public List<Statut> getAllStatuts() {
		return (List<Statut>) statutRepository.findAll();
		}

	

	@Override
	public void deleteStatut(Long id) {
		statutRepository.deleteById(id);
		}

	
		
	}


