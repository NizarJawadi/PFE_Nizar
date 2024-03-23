package tn.ommp.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.ommp.pfe.models.Fonction;
import tn.ommp.pfe.repository.FonctionRepository;

@Service
public class FonctionManagerImpl implements FonctionManager {

	@Autowired
	FonctionRepository fonctionRepository;
	
	//@Autowired
	//MouchardManager mouchardManager;

	@Override
	public List<Fonction> getAllFonctions() {
		return (List<Fonction>) fonctionRepository.findAll();
	}

	@Override
	public Fonction getFonctionById(Long id) {
		return fonctionRepository.findById(id).get();
	}

	@Override
	public Fonction saveFonction(Fonction fonction) {
		//Fonction oldFonction = fonction.getId() != null ? fonctionRepository.findById(fonction.getId()).get() : null;
		Fonction newFonction = fonctionRepository.save(fonction);
		//mouchardManager.actionSave(oldFonction, newFonction, connectedUser);
		return newFonction;
	}


	@Override
	public void deleteFonction(Long id) {
		Fonction fonction = getFonctionById(id);
		fonctionRepository.deleteById(id);
	//	mouchardManager.actionDelete(id, fonction, connectedUser);
	}

}
