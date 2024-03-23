package tn.ommp.pfe.services;

import java.util.List;


import tn.ommp.pfe.models.Prescription;

public interface PrescriptionManager {
	
	public Prescription getPrescriptionById(Long id);
	public Prescription savePrescription(Prescription prescription /*,Agent connectedUser*/);
	public List<Prescription> getAllPrescriptions();
	// DataTablesOutput<Prescription> findAllForDataTable(DataTablesInput input);
	//public DataTablesOutput<Prescription> findForDataTableWithSpec(DataTablesInput input, Specification<Prescription> spec);
	public void deletePrescription(Long id/*,Agent connectedUser*/);

}
