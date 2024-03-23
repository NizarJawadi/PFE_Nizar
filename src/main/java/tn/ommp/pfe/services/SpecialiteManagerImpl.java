package tn.ommp.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.ommp.pfe.models.Specialite;
import tn.ommp.pfe.repository.SpecialiteRepository;
@Service
public class SpecialiteManagerImpl implements SpecialiteManager {
	
	@Autowired
	SpecialiteRepository specialiteRepository;
	
	//@Autowired
	//MouchardManager mouchardManager;
	

	@Override
	public Specialite getSpecialiteById(Long id) {
		return specialiteRepository.findById(id).get();
		
	}

	@Override
	public Specialite saveSpecialite(Specialite specialite) {
		//Specialite oldSpecialite = specialite.getId() != null ? specialiteRepository.findById(specialite.getId()).get() : null;
		Specialite newSpecialite = specialiteRepository.save(specialite);
		//mouchardManager.actionSave(oldSpecialite, newSpecialite, connectedUser);
		return newSpecialite;
	}

	@Override
	public List<Specialite> getAllSpecialites() {
		return (List<Specialite>) specialiteRepository.findAll();
		}

	

	@Override
	public void deleteSpecialite(Long id) {
		specialiteRepository.deleteById(id);
		}

	
	

}
