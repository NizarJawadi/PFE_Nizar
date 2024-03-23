package tn.ommp.pfe.models;


import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import lombok.Data;
@Data
@SuppressWarnings("serial")
@Entity
public class Prescription implements java.io.Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "prescription_sequence")
	@SequenceGenerator(name = "prescription_sequence", sequenceName = "prescription_sequence", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	private Long id;
	
	private String libelle;
	
	private String type;
	
	@Transient
	public static HashMap<String, String> typeList = new HashMap<String, String>() {
		{
			put("1", "Traitement");
			put("2", "Analyse");
			put("3", "Radio");
		}
	};

	public Prescription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Prescription(Long id, String libelle, String type) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static HashMap<String, String> getTypeList() {
		return typeList;
	}

	public static void setTypeList(HashMap<String, String> typeList) {
		Prescription.typeList = typeList;
	}
}
