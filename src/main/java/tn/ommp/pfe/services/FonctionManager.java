package tn.ommp.pfe.services;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import tn.ommp.pfe.models.Agent;
import tn.ommp.pfe.models.Fonction;

public interface FonctionManager {
	public Fonction getFonctionById(Long id);
	public Fonction saveFonction(Fonction fonction/*, Agent connectedUser*/);
	public List<Fonction> getAllFonctions();
	//public DataTablesOutput<Fonction> findAllForDataTable(DataTablesInput input);
	//public DataTablesOutput<Fonction> findForDataTableWithSpec(DataTablesInput input, Specification<Fonction> spec);
	public void deleteFonction(Long id/*, Agent */);
}
