package tn.ommp.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import tn.ommp.pfe.models.Pathologie;
import tn.ommp.pfe.repository.PathologieRepository;

@Service
public class PathologieManagerImpl implements PathologieManager {
	@Autowired
	PathologieRepository pathologieRepository ;
	//@Autowired
	//MouchardManager mouchardManager;
	
	
	@Override
	public Pathologie getPathologieById(Long id) {
		return pathologieRepository.findById(id).get();
		
	}

	@Override
	public Pathologie savePathologie(Pathologie pathologie) {
		//Pathologie oldPathologie = pathologie.getId() != null ? pathologieRepository.findById(pathologie.getId()).get() : null ;
		Pathologie newPathologie = pathologieRepository.save(pathologie);
		//mouchardManager.actionSave(oldPathologie, newPathologie, connectedUser);
		
		return newPathologie;
	}

	@Override
	public List<Pathologie> getAllPathologies() {
		return (List<Pathologie>) pathologieRepository.findAll();
		}


	@Override
	public void deletePathologie(Long id) {
		Pathologie pathologie=getPathologieById(id);
		pathologieRepository.deleteById(id);
		//mouchardManager.actionDelete(id, pathologie, connectedUser);
		}

}

	
	
	