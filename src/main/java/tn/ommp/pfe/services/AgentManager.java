package tn.ommp.pfe.services;

import java.util.List;

import tn.ommp.pfe.models.Agent;
import tn.ommp.pfe.models.Port;
import tn.ommp.pfe.models.Poste;

public interface AgentManager {
	public Agent getAgentById(Long id);
	public void saveAgent(Agent agent);
	public List<Agent> getAllAgents();
	
	public void deleteAgent(Long id);
	//public Agent authentication(String username,String password);
	public List<Agent> findByMatriculeOrNom(String term);
	public List<Agent> getAgentsByPoste(Poste poste);
	public List<Agent> getAllSuperiors(List<Poste> postes);
	public List<Agent> findByPosteIn(List<Poste> postes);
	public List<Agent> getAgentByPort(Port port);
	public List<Agent> findByMatriculeAndPort(String term,Port port);
}
