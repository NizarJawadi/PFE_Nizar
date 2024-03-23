package tn.ommp.pfe.services;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import tn.ommp.pfe.models.Agent;
import tn.ommp.pfe.models.Poste;

public interface PosteManager {
	public Poste getPosteById(Long id);
	public Poste savePoste(Poste poste /*, Agent connectedUser*/);
	public List<Poste> getAllPostes();
	//public DataTablesOutput<Poste> findAllForDataTable(DataTablesInput input);
	//public DataTablesOutput<Poste> findForDataTableWithSpec(DataTablesInput input, Specification<Poste> spec);
	public void deletePoste(Long id /*, Agent connectedUser*/);
	public List<Poste> getPosteBySuperior(Poste superior);
	public List<Poste> getAllPostesFromParent(Poste parent, List<Poste> listIn);
	public Poste getTopPoste(Poste poste);
}
