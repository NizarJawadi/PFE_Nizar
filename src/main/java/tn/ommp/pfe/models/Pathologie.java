package tn.ommp.pfe.models;


import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;



import lombok.Data;

@Data
@SuppressWarnings("serial")
@Entity
public class Pathologie implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "pathologie_sequence")
	@SequenceGenerator(name = "pathologie_sequence", sequenceName = "pathologie_sequence", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	private Long id;
	
	private String libelle;

	public Pathologie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pathologie(String libelle) {
		super();
		this.libelle = libelle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	

}
