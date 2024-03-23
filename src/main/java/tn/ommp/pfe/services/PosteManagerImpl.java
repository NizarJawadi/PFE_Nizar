package tn.ommp.pfe.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.ommp.pfe.models.Poste;
import tn.ommp.pfe.repository.PosteRepository;

@Service
public class PosteManagerImpl implements PosteManager {

	@Autowired
	PosteRepository posteRepository;
	
	//@Autowired
//	MouchardManager mouchardManager;

	@Override
	public List<Poste> getAllPostes() {
		return (List<Poste>) posteRepository.findAll();
	}

	@Override
	public Poste getPosteById(Long id) {
		return posteRepository.findById(id).get();
	}

	@Override
	public Poste savePoste(Poste poste) {
		//Poste oldPoste = poste.getId() != null ? posteRepository.findById(poste.getId()).get() : null;
		Poste newPoste = posteRepository.save(poste);
		//mouchardManager.actionSave(oldPoste, newPoste, connectedUser);
		return newPoste;
	}

	@Override
	public void deletePoste(Long id) {
		Poste poste = getPosteById(id);
		posteRepository.deleteById(id);
		//mouchardManager.actionDelete(id, poste, connectedUser);
	}

	@Override
	public List<Poste> getPosteBySuperior(Poste superior) {
		return posteRepository.findBySuperior(superior);
	}
	
	public List<Poste> getAllPostesFromParent(Poste parent, List<Poste> listIn){
		List<Poste> listOut = listIn != null ? listIn : new ArrayList<>();
			listOut.add(parent);
		for(Poste i: parent.getChildren()) {
			getAllPostesFromParent(i, listOut);
		}
		return listOut;
	}

	@Override
	public Poste getTopPoste(Poste poste) {
		if (poste.getSuperior()==null){
			return poste;
		}else{
			return getTopPoste(poste.getSuperior());
		}
	}

}
