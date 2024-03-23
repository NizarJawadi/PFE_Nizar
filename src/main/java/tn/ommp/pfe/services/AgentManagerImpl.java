package tn.ommp.pfe.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.var;
import tn.ommp.pfe.auth.AuthenticationService;
import tn.ommp.pfe.models.Agent;
import tn.ommp.pfe.models.Port;
import tn.ommp.pfe.models.Poste;
import tn.ommp.pfe.models.Role;
import tn.ommp.pfe.models.User;
import tn.ommp.pfe.repository.AgentRepository;

@Service
@RequiredArgsConstructor
public class AgentManagerImpl implements AgentManager {
	private  final PasswordEncoder passwordEncoder;

	@Autowired
	AgentRepository agentRepository;

	
	@Autowired
    public AgentManagerImpl(AgentRepository agentRepository, PasswordEncoder passwordEncoder ) {
        this.agentRepository = agentRepository;
        this.passwordEncoder = passwordEncoder; // And this
    }
	@Override
	public void saveAgent(Agent agent /* , Agent connectedUser */) {
		
		agent.setMatricule(String.format("%04d", Integer.parseInt(agent.getMatricule())));
		agent.setPassword(passwordEncoder.encode(agent.getPassword()));
		agent.setCin(String.format("%08d", Integer.parseInt(agent.getCin())));
		
		//Agent oldAgent = agent.getMatricule() != null ? agentRepository.findByMatricule(agent.getMatricule()).get() : null;
		//Agent oldAgent = agentRepository.findByMatricule(agent.getMatricule()).get()  ;
		
		if (agent.getRole().toString().toUpperCase() != "MEDECIN") {
			agentRepository.save(agent);
		}
		
		//Agent newAgent = agentRepository.save(agent);
		// mouchardManager.actionSave(oldAgent, newAgent, connectedUser);
		//return newAgent;
	}

	@Override
	public List<Agent> getAllAgents() {
		return (List<Agent>) agentRepository.findAll();
	}

	@Override
	public void deleteAgent(Long id) {
		Agent agent = getAgentById(id);
		agentRepository.deleteById(id);
		// mouchardManager.actionDelete(id, agent, connectedUser);
	}

	/*
	 * @Override public Agent authentication(String username, String password) { //
	 * TODO Auto-generated method stub return null; }
	 */
	@Override
	public List<Agent> findByMatriculeOrNom(String term) {
		return agentRepository.findByMatriculeContainingOrNomPrenomIgnoreCaseContaining(term, term);
	}

	@Override
	public List<Agent> getAgentsByPoste(Poste poste) {
		return agentRepository.getAgentsByPoste(poste);
	}

	@Override
	public List<Agent> getAllSuperiors(List<Poste> postes) {
		List<Agent> agents = new ArrayList<>();
		for (Poste poste : postes) {
			agents.addAll(agentRepository.findByPosteAndResponsable(poste, true));
		}
		return agents;
	}

	@Override
	public List<Agent> findByPosteIn(List<Poste> postes) {
		return agentRepository.findByPosteIn(postes);
	}

	@Override
	public List<Agent> getAgentByPort(Port port) {
		return agentRepository.findByPort(port);
	}

	@Override
	public List<Agent> findByMatriculeAndPort(String term, Port port) {
		return agentRepository.findByMatriculeContainingAndPort(term, port);
	}

	@Override
	public Agent getAgentById(Long id) {
		return agentRepository.findById(id).get();

	}

}
