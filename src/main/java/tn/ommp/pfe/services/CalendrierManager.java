package tn.ommp.pfe.services;

import java.util.List;


import org.springframework.data.jpa.domain.Specification;

import tn.ommp.pfe.models.Agent;
import tn.ommp.pfe.models.Calendrier;
import tn.ommp.pfe.models.Medecin;

public interface CalendrierManager {
	public Calendrier getCalendrierById(Long id);
	public Calendrier saveCalendrier(Calendrier calendrier /* ,Agent connectedUser*/);
	public List<Calendrier> getAllCalendriers();
	//public DataTablesOutput<Calendrier> findAllForDataTable(DataTablesInput input);
	//public DataTablesOutput<Calendrier> findForDataTableWithSpec(DataTablesInput input, Specification<Calendrier> spec);
	public void deleteCalendrier(Long id /* ,Agent connectedUser*/);
	public List<Calendrier> getCalenrierByMedecin(Medecin medecin);
	
}
