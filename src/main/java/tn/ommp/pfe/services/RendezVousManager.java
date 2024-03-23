package tn.ommp.pfe.services;

import java.util.List;


import tn.ommp.pfe.models.Agent;
import tn.ommp.pfe.models.Medecin;
import tn.ommp.pfe.models.Relation;
import tn.ommp.pfe.models.RendezVous;

public interface RendezVousManager {
	
	public RendezVous getRendezVousById(Long id);
	public RendezVous saveRendezVous(RendezVous rendezVous /*, Agent connectedUser*/);
	public List<RendezVous> getAllRendezVous();
	//public DataTablesOutput<RendezVous> findAllForDataTable(DataTablesInput input);
	//public DataTablesOutput<RendezVous> findForDataTableWithSpec(DataTablesInput input, Specification<RendezVous> spec);
	public void deleteRendezVous(Long id/*, Agent connectedUser*/);
	List<RendezVous> getRendezVousByAgent (Agent agent);
	public List<RendezVous> getRendezVousByMedecin(Long id);
	List<RendezVous> getRendezVousByRelation (Relation relation);
}
