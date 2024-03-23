package tn.ommp.pfe.services;

import java.util.List;


import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import tn.ommp.pfe.models.Agent;
import tn.ommp.pfe.models.Pathologie;

@Service
public interface PathologieManager {
	public Pathologie getPathologieById(Long id);
	public Pathologie savePathologie(Pathologie Pathologie /*,Agent connectedUser*/);
	public List<Pathologie> getAllPathologies();
	//public DataTablesOutput<Pathologie> findAllForDataTable(DataTablesInput input);
	//public DataTablesOutput<Pathologie> findForDataTableWithSpec(DataTablesInput input, Specification<Pathologie> spec);
	public void deletePathologie(Long id /*,Agent connectedUser*/);

}
