package tn.ommp.pfe.services;

import java.util.List;



import tn.ommp.pfe.models.Conge;
import tn.ommp.pfe.models.Medecin;

public interface CongeManager {
	
	public Conge getCongeById(Long id);
	public Conge saveConge(Conge conge /*, Agent connectedUser*/);
	public List<Conge> getAllConges();
	//public DataTablesOutput<Conge> findAllForDataTable(DataTablesInput input);
	//public DataTablesOutput<Conge> findForDataTableWithSpec(DataTablesInput input, Specification<Conge> spec);
	public void deleteConge(Long id /*, Agent connectedUser*/);
	List<Conge> getCongeByMedecin (Medecin medecin);

}
