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


import lombok.Data;
@Data
@SuppressWarnings("serial")
@Entity
public class Statut implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "statut_sequence")
	@SequenceGenerator(name = "statut_sequence", sequenceName = "statut_sequence", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	private Long id;
	
	@Column(length = 100)
	private String libelle;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "statut")
	
	private Set<Agent> agents = new HashSet<Agent>();

	public Statut(Long id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}

	public Statut() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	

}
