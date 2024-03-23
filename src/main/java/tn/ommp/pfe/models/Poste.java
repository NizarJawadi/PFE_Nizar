package tn.ommp.pfe.models;


import java.util.HashSet; 
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@SuppressWarnings("serial")
@Entity
public class Poste implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "poste_sequence")
	@SequenceGenerator(name = "poste_sequence", sequenceName = "poste_sequence", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	private Long id;
	
	@Column(length = 200)
	private String designation;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "superior")
	private Poste superior;
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "poste")
	private Set<Agent> users = new HashSet<Agent>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "superior")
	private Set<Poste> children = new HashSet<Poste>();

	public Poste() {
	}

	public Poste(Long id) {
		super();
		this.id = id;
	}

	public Poste(String designation, Poste superior) {
		super();
		this.designation = designation;
		this.superior = superior;
	}

	public Poste(Long id, String designation, Poste superior,
			Set<Agent> users, Set<Poste> children) {
		super();
		this.id = id;
		this.designation = designation;
		this.superior = superior;
		this.users = users;
		this.children = children;
	}



}
