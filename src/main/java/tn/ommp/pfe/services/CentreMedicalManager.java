package tn.ommp.pfe.services;

import java.util.List;



import tn.ommp.pfe.models.CentreMedical;


public interface CentreMedicalManager {
	
	public CentreMedical getCentreMedicalById(Long id);
	public CentreMedical saveCentreMedical(CentreMedical centreMedical/*,Agent connectedUser */ );
	public List<CentreMedical> getAllCentreMedicals();
	//public DataTablesOutput<CentreMedical> findAllForDataTable(DataTablesInput input);
	//public DataTablesOutput<CentreMedical> findForDataTableWithSpec(DataTablesInput input, Specification<CentreMedical> spec);
	public void deleteCentreMedical(Long id /*,Agent connectedUser*/ );
}