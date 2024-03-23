package tn.ommp.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import tn.ommp.pfe.models.Agent;
import tn.ommp.pfe.models.CentreMedical;
import tn.ommp.pfe.models.Convention;
import tn.ommp.pfe.repository.CentreMedicalRepository;

@Service
public class CentreMedicalManagerImpl implements CentreMedicalManager {

	@Autowired
	CentreMedicalRepository centreMedicalRepository;
	//@Autowired
	//MouchardManager mouchardManager;

	@Override
	public CentreMedical getCentreMedicalById(Long id) {
		return centreMedicalRepository.findById(id).get();
		
	}

	@Override
	public CentreMedical saveCentreMedical(CentreMedical centreMedical) {
		//CentreMedical oldCentreMedical=centreMedical.getId()!= null ? centreMedicalRepository.findById(centreMedical.getId()).get() : null ;
		CentreMedical newCentreMedical = centreMedicalRepository.save(centreMedical);
		//mouchardManager.actionSave(oldCentreMedical, newCentreMedical, connectedUser);
		return newCentreMedical;
	}

	@Override
	public List<CentreMedical> getAllCentreMedicals() {
		return (List<CentreMedical>) centreMedicalRepository.findAll();
		}


	@Override
	public void deleteCentreMedical(Long id){
		CentreMedical centreMedical=getCentreMedicalById(id);
		centreMedicalRepository.deleteById(id);
		//mouchardManager.actionDelete(id, centreMedical, connectedUser);
		}

}
