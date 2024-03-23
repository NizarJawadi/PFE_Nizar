package tn.ommp.pfe.services;

import java.util.List;


import org.springframework.data.jpa.domain.Specification;

import tn.ommp.pfe.models.Agent;
import tn.ommp.pfe.models.Convention;

public interface ConventionManager {
	public Convention getConventionById(Long id);
	public Convention saveConvention(Convention convention /*,Agent connectedUser*/);
	public List<Convention> getAllConventions();
	//public DataTablesOutput<Convention> findAllForDataTable(DataTablesInput input);
	//public DataTablesOutput<Convention> findForDataTableWithSpec(DataTablesInput input, Specification<Convention> spec);
	public void deleteConvention(Long id/*,Agent connectedUser*/);


}
