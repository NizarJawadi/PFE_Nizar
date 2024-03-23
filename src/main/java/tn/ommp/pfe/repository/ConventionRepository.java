package tn.ommp.pfe.repository;


 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import tn.ommp.pfe.models.Convention;



public interface ConventionRepository extends JpaRepository<Convention, Long>,JpaSpecificationExecutor<Convention> {

}
