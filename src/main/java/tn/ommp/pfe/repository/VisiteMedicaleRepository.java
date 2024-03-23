package tn.ommp.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import tn.ommp.pfe.models.VisiteMedicale;

@Repository
public interface VisiteMedicaleRepository extends JpaRepository<VisiteMedicale, Long>, JpaSpecificationExecutor<VisiteMedicale> {

	
}
