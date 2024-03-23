package tn.ommp.pfe.services;


import java.util.List;

import tn.ommp.pfe.models.VisiteMedicale;

public interface VisiteMedicaleManager {

	public VisiteMedicale saveVisiteMedicale(VisiteMedicale visiteMedicale);
	
	public List<VisiteMedicale> getAllVisiteMedicale () ;

 }
