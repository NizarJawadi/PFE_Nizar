package tn.ommp.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import tn.ommp.pfe.models.Agent;
import tn.ommp.pfe.models.Fonction;
import tn.ommp.pfe.models.Medecin;
import tn.ommp.pfe.models.Relation;
import tn.ommp.pfe.models.RendezVous;
import tn.ommp.pfe.repository.MedecinRepository;
import tn.ommp.pfe.repository.RendezVousRepository;

@Service
public class RendezVousManagerImpl implements RendezVousManager {

	
	
	@Autowired
	RendezVousRepository rendezVousRepository;
	
	@Autowired
	MedecinRepository medecinRepository ;
	//@Autowired
	//MouchardManager mouchardManager;
	

	@Override
	public RendezVous getRendezVousById(Long id) {
		return rendezVousRepository.findById(id).get();
		
	}

	@Override
	public RendezVous saveRendezVous(RendezVous rendezVous) {
		//RendezVous oldRendezVous = rendezVous.getId() != null ? rendezVousRepository.findById(rendezVous.getId()).get() : null;
		RendezVous newRendezVous = rendezVousRepository.save(rendezVous);
		//mouchardManager.actionSave(oldRendezVous, newRendezVous, connectedUser);
	      return newRendezVous;
	      
		 
	}

	@Override
	public List<RendezVous> getAllRendezVous() {
		return (List<RendezVous>) rendezVousRepository.findAll();
		}


	@Override
	public void deleteRendezVous(Long id/*,Agent connectedUser*/) {
		RendezVous rendezVous = getRendezVousById(id);
		rendezVousRepository.deleteById(id);
		//mouchardManager.actionDelete(id, rendezVous, connectedUser);
		}

	@Override
	public List<RendezVous> getRendezVousByMedecin(Long id) {
		//Optional<Medecin> medecin = medecinRepository.findById(id);
		
	return rendezVousRepository.findByMedecin(medecinRepository.findById(id).get());
		
	}

	@Override
	public List<RendezVous> getRendezVousByAgent(Agent agent) {
		
		return rendezVousRepository.findByAgent(agent);
	}

	@Override
	public List<RendezVous> getRendezVousByRelation(Relation relation) {
		
		return rendezVousRepository.findByRelation(relation);
	}



}
