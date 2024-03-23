package tn.ommp.pfe.services;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import tn.ommp.pfe.models.Agent;
import tn.ommp.pfe.models.Resiliation;


public interface ResiliationManager {
	public Resiliation getResiliationById(Long id);
	public Resiliation saveResiliation(Resiliation resiliation/*,Agent connectedUser*/);
	public List<Resiliation> getAllResiliations();
	//public DataTablesOutput<Resiliation> findAllForDataTable(DataTablesInput input);
	//public DataTablesOutput<Resiliation> findForDataTableWithSpec(DataTablesInput input, Specification<Resiliation> spec);
	public void deleteResiliation(Long id/*,Agent connectedUser*/);
}
