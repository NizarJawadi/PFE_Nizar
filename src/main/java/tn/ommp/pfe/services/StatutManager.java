package tn.ommp.pfe.services;

import java.util.List;


import org.springframework.data.jpa.domain.Specification;

import tn.ommp.pfe.models.Agent;
import tn.ommp.pfe.models.Statut;

public interface StatutManager {
	public Statut getStatutById(Long id);
	public Statut saveStatut(Statut statut /* ,Agent connectedAgent */ );
	public List<Statut> getAllStatuts();
	//public DataTablesOutput<Statut> findAllForDataTable(DataTablesInput input);
	//public DataTablesOutput<Statut> findForDataTableWithSpec(DataTablesInput input, Specification<Statut> spec);
	public void deleteStatut(Long id /*,Agent connectedAgent */ );

}
