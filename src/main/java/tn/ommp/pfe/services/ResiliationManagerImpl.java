package tn.ommp.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.ommp.pfe.models.Resiliation;
import tn.ommp.pfe.repository.ResiliationRepository;



@Service
public class ResiliationManagerImpl implements ResiliationManager {
	
	@Autowired
	ResiliationRepository resiliationRepository;
	//@Autowired
	// mouchardManager;

	@Override
	public Resiliation getResiliationById(Long id) {
		return resiliationRepository.findById(id).get();
	}

	@Override
	public Resiliation saveResiliation(Resiliation resiliation) {
		// Resiliation oldResiliation= resiliation.getId() != null ? resiliationRepository.findById(resiliation.getId()).get() : null;
		Resiliation newResiliation = resiliationRepository.save(resiliation);
		//mouchardManager.actionSave(oldResiliation, newResiliation, connectedUser);
		return newResiliation;
	}

	@Override
	public List<Resiliation> getAllResiliations() {
		return (List<Resiliation>) resiliationRepository.findAll();
		}

	

	@Override
	public void deleteResiliation(Long id) {
		Resiliation resiliation=getResiliationById(id);
		resiliationRepository.deleteById(id);
		//mouchardManager.actionDelete(id, resiliation, connectedUser);
		}


}
