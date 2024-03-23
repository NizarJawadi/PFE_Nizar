package tn.ommp.pfe.models;


import java.util.ArrayList; 
import java.util.HashSet;
import java.util.List;
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
public class CentreMedical implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "centre_medical_sequence")
	@SequenceGenerator(name = "centre_medical_sequence", sequenceName = "centre_medical_sequence", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	private Long id;
	@Column(length = 50)
	private String nom;
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "centreMedical")
	private Set<Medecin> medecins=new HashSet<Medecin>();
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "centreMedical")
	private Set<Port> ports=new HashSet<Port>();
	
	
	public CentreMedical() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CentreMedical(Long id, String nom, Set<Medecin> medecins, Set<Port> ports) {
		super();
		this.id = id;
		this.nom = nom;
		this.medecins = medecins;
		this.ports = ports;
	}

	
	
	

}
