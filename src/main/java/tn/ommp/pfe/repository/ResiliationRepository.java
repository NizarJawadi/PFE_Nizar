package tn.ommp.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import tn.ommp.pfe.models.Resiliation;


public interface ResiliationRepository extends JpaRepository<Resiliation, Long>,JpaSpecificationExecutor<Resiliation> {

}
