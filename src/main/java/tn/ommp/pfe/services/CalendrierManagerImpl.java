package tn.ommp.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.ommp.pfe.models.Calendrier;
import tn.ommp.pfe.models.Medecin;
import tn.ommp.pfe.repository.CalendrierRepository;

@Service
public class CalendrierManagerImpl implements CalendrierManager{

	@Autowired
	CalendrierRepository calendrierRepository;
	//@Autowired
	//MouchardManager mouchardManager;
	

	@Override
	public Calendrier getCalendrierById(Long id) {
		return calendrierRepository.findById(id).get();
		
	}

	@Override
	public Calendrier saveCalendrier(Calendrier calendrier) {
		//Calendrier oldCalendrier = calendrier.getId() != null ? calendrierRepository.findById(calendrier.getId()).get() : null;
		Calendrier newCalendrier = calendrierRepository.save(calendrier);
		//mouchardManager.actionSave(oldCalendrier, newCalendrier, connectedUser);
		return newCalendrier;
	}

	@Override
	public List<Calendrier> getAllCalendriers() {
		return (List<Calendrier>) calendrierRepository.findAll();
		}

	
	@Override
	public void deleteCalendrier(Long id) {
		Calendrier calendrier=getCalendrierById(id);
		calendrierRepository.deleteById(id);
		//mouchardManager.actionDelete(id, calendrier, connectedUser);
		
		}

	@Override
	public List<Calendrier> getCalenrierByMedecin(Medecin medecin) {
		
		return calendrierRepository.findByMedecin(medecin);
	}
		

}
