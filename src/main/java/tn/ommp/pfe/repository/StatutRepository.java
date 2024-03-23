package tn.ommp.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.ommp.pfe.models.Statut;

@Repository
public interface StatutRepository extends JpaRepository<Statut, Long> , CrudRepository<Statut, Long>{

}
