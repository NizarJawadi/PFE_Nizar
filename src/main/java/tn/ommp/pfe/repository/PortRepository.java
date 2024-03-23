package tn.ommp.pfe.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import tn.ommp.pfe.models.CentreMedical;
import tn.ommp.pfe.models.Port;





@Repository
public interface PortRepository extends JpaRepository<Port, Long>, JpaSpecificationExecutor<Port>
{

	List<Port> findByCentreMedical(CentreMedical centreMedical);


}