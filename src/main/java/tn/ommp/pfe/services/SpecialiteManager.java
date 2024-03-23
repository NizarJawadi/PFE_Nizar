package tn.ommp.pfe.services;

import java.util.List;
import java.util.Optional;

import tn.ommp.pfe.models.Specialite;

public interface SpecialiteManager {
	public Specialite getSpecialiteById(Long id);
	public Specialite saveSpecialite(Specialite specialite/*,Agent connectedUser*/);
	public List<Specialite> getAllSpecialites();
	public void deleteSpecialite(Long id /*,Agent connectedUser*/);
	//public List<Specialite> findByLibelle(String libelle); 
	//public Specialite getSpecialiteByLibelle(String libelle);

}
