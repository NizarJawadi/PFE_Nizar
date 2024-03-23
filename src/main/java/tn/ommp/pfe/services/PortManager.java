package tn.ommp.pfe.services;

import java.util.List;

import tn.ommp.pfe.models.Agent;
import tn.ommp.pfe.models.CentreMedical;
import tn.ommp.pfe.models.Port;

public interface PortManager {

	public Port getPortById(Long id);

	public Port savePort(Port port /*, Agent connectedUser */ );

	public List<Port> getAllPorts();

	// public DataTablesOutput<Port> findAllForDataTable(DataTablesInput input);
	// public DataTablesOutput<Port> findForDataTableWithSpec(DataTablesInput input,
	// Specification<Port> spec);
	public void deletePort(Long id /*, Agent connectedUser*/ );

	public List<Port> getPortByCentre(CentreMedical centreMedical);

}
