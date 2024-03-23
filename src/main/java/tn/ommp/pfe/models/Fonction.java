package tn.ommp.pfe.models;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@SuppressWarnings("serial")
@Entity
public class Fonction implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "fonction_sequence")
	@SequenceGenerator(name = "fonction_sequence", sequenceName = "fonction_sequence", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	private Long id;
	
	@Column(nullable = true, length = 1000)
	private String libelle;
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fonction")
	private Set<Agent> agents = new HashSet<Agent>();

	public Fonction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fonction(Long id) {
		super();
		this.id = id;
	}

	public Fonction(Long id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Agent> getAgents() {
		return agents;
	}

	public void setAgents(Set<Agent> agents) {
		this.agents = agents;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
