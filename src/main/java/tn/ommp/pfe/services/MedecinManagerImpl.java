package tn.ommp.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tn.ommp.pfe.models.Agent;
import tn.ommp.pfe.models.CentreMedical;
import tn.ommp.pfe.models.Medecin;
import tn.ommp.pfe.models.Specialite;
import tn.ommp.pfe.repository.AgentRepository;
import tn.ommp.pfe.repository.MedecinRepository;
@Service
public class MedecinManagerImpl implements MedecinManager {


	private final PasswordEncoder passwordEncoder;

	@Autowired
	MedecinRepository medecinRepository;
	
	//@Autowired
	//MouchardManager mouchardManager;
	
	@Autowired
    public MedecinManagerImpl(MedecinRepository medecinRepository, PasswordEncoder passwordEncoder ) {
        this.medecinRepository = medecinRepository;
        this.passwordEncoder = passwordEncoder; // And this
    }

	@Override
	public Medecin getMedecinById(Long id) {
		return medecinRepository.findById(id).get();
	}

	@Override
	public Medecin saveMedecin(Medecin medecin) {
		//Medecin oldMedecin = medecin.getId() != null ? medecinRepository.findById(medecin.getId()).get() : null;
		medecin.setPassword(passwordEncoder.encode(medecin.getPassword()));
		Medecin newMedecin = medecinRepository.save(medecin);
		//mouchardManager.actionSave(oldMedecin, newMedecin, connectedUser);
		return newMedecin;
	}

	
	@Override
	public List<Medecin> getAllMedecins() {
		return (List<Medecin>) medecinRepository.findAll();
	}

	


	@Override
	public void deleteMedecin(Long id ) {
		medecinRepository.deleteById(id);
		
	}

	/*@Override
	public List<Medecin> getMedecinsBySpecialiteAndCentre(Specialite specialite,CentreMedical centreMedical) {
		return medecinRepository.getMedecinsBySpecialiteAndCentreMedical(specialite,centreMedical);
		
	}*/

	@Override
	public List<Medecin> findBySpecialiteIn(List<Specialite> specialites) {
		return medecinRepository.findBySpecialiteIn(specialites);
	}

	@Override
	public List<Medecin> getMedecinByCentre(CentreMedical centreMedical) {
		return medecinRepository.findByCentreMedical(centreMedical);
	}

	@Override
	public Medecin authentication(String matricule, String password) {
		List<Medecin> medecins = medecinRepository.findByMatriculeAndPassword(matricule, password);
		if (medecins == null || medecins.size() == 0) {
			return null;
		} else {
			return medecins.get(0);
		}
	}

	@Override
	public List<Medecin> getMedecinsBySpecialite(Specialite specialite) {
		return medecinRepository.findBySpecialite(specialite);
	}

	@Override
	public List<Medecin> getBySpecAndCentre(Long idSpecialite, CentreMedical centreMedical) {
        return medecinRepository.findBySpecialiteAndCentreMedical(idSpecialite, centreMedical);

	}


	
	

}
