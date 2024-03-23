package tn.ommp.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.ommp.pfe.models.CentreMedical;
import tn.ommp.pfe.models.Port;
import tn.ommp.pfe.repository.PortRepository;

@Service
	public class PortManagerImpl implements PortManager {

		@Autowired
		PortRepository portRepository;
		
		//@Autowired
		//MouchardManager mouchardManager;

		@Override
		public List<Port> getAllPorts() {
			return (List<Port>) portRepository.findAll();
		}

		@Override
		public Port getPortById(Long id) {
			return portRepository.findById(id).get();
		}

		@Override
		public Port savePort(Port port) {
			//Port oldPort = port.getId() != null ? portRepository.findById(port.getId()).get() : null;
			Port newPort = portRepository.save(port);
			//mouchardManager.actionSave(oldPort, newPort, connectedUser);
			return newPort;
		}

	

	
		@Override
		public void deletePort(Long id) {
			Port port = getPortById(id);
			portRepository.deleteById(id);
			//mouchardManager.actionDelete(id, port, connectedUser);
		}

		@Override
		public List<Port> getPortByCentre(CentreMedical centreMedical) {
			
			return portRepository.findByCentreMedical(centreMedical);
		}


}
