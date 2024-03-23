package tn.ommp.pfe.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.ommp.pfe.models.CentreMedical;
import tn.ommp.pfe.models.Medecin;
import tn.ommp.pfe.models.Specialite;

@Service
public interface MedecinManager {
	public Medecin getMedecinById(Long id);
	public Medecin saveMedecin(Medecin medecin /*,Agent connectedUser*/);
	//public DataTablesOutput<Medecin> findAllForDataTable(DataTablesInput input);
	//public DataTablesOutput<Medecin> findForDataTableWithSpec(DataTablesInput input, Specification<Medecin> spec);
	public void deleteMedecin(Long id /* ,Agent connectedUser*/);
	public List<Medecin> getMedecinsBySpecialite(Specialite specialite);
	public List<Medecin> findBySpecialiteIn(List<Specialite> specialites);
	List<Medecin> getAllMedecins();
	public List<Medecin> getMedecinByCentre(CentreMedical centreMedical);
	public Medecin authentication(String username,String password);
	
	List<Medecin> getBySpecAndCentre(Long specialite, CentreMedical centreMedical);
}
