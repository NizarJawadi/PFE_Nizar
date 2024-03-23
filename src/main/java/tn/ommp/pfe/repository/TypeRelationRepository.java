package tn.ommp.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import tn.ommp.pfe.models.TypeRelation;

@Repository
public interface TypeRelationRepository extends JpaRepository<TypeRelation, Long>, JpaSpecificationExecutor<TypeRelation> {
}
