package tn.ommp.pfe.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import tn.ommp.pfe.models.Pathologie;


@Repository
public interface PathologieRepository extends JpaRepository<Pathologie, Long>, JpaSpecificationExecutor<Pathologie> {

}
