package tn.ommp.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.ommp.pfe.models.TypeRelation;
import tn.ommp.pfe.models.VisiteMedicale;
import tn.ommp.pfe.repository.VisiteMedicaleRepository;


@Service
public class VisiteMedicaleManagerImpl implements VisiteMedicaleManager {

	@Autowired
	VisiteMedicaleRepository visiteMedicaleRepository;
	
	@Override
	public VisiteMedicale saveVisiteMedicale(VisiteMedicale visiteMedicale) {
		VisiteMedicale newVisiteMedicale = visiteMedicaleRepository.save(visiteMedicale);
		return newVisiteMedicale;
	}

	@Override
	public List<VisiteMedicale> getAllVisiteMedicale() {
		return (List<VisiteMedicale>) visiteMedicaleRepository.findAll();

	}

}
