package tn.ommp.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import tn.ommp.pfe.models.Agent;
import tn.ommp.pfe.models.Prescription;
import tn.ommp.pfe.repository.PrescriptionRepository;

@Service
public class PrescriptionManagerImpl implements PrescriptionManager {

	@Autowired
	PrescriptionRepository prescriptionRepository;
	//@Autowired
	//MouchardManager mouchardManager;
	
	
	@Override
	public Prescription getPrescriptionById(Long id) {
		
		return prescriptionRepository.findById(id).get();
	}

	@Override
	public Prescription savePrescription(Prescription prescription) {
		//Prescription oldPrescription = prescription.getId() != null ? prescriptionRepository.findById(prescription.getId()).get() : null ;
		Prescription newPrescription = prescriptionRepository.save(prescription);
	//	mouchardManager.actionSave(oldPrescription, newPrescription, connectedUser);
		return newPrescription;
	}

	@Override
	public List<Prescription> getAllPrescriptions() {
		return (List<Prescription>) prescriptionRepository.findAll();
	}



	@Override
	public void deletePrescription(Long id) {
		Prescription prescription=getPrescriptionById(id);
		prescriptionRepository.deleteById(id);
		//mouchardManager.actionDelete(id, prescription, connectedUser);
		
	}
	

}
