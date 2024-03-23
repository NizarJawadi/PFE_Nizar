package tn.ommp.pfe.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import tn.ommp.pfe.models.Prescription;


@Repository
public interface PrescriptionRepository  extends JpaRepository<Prescription, Long>, JpaSpecificationExecutor<Prescription> {

}
