package tn.ommp.pfe.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import tn.ommp.pfe.models.Poste; 


public interface PosteRepository extends JpaRepository<Poste, Long>, JpaSpecificationExecutor<Poste>
{

	List<Poste> findBySuperior(Poste superior);

}