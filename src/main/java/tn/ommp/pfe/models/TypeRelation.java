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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;


import lombok.Data;
@SuppressWarnings("serial")
@Entity
@Data
public class TypeRelation implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "typeRelation_sequence")
	@SequenceGenerator(name = "typeRelation_sequence", sequenceName = "typeRelation_sequence", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	private Long id;
	
	@Column(length = 100)
	private String libelle;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "typeRelation")
	
	private Set<Relation> relations = new HashSet<Relation>();

	public TypeRelation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeRelation(Long id, String libelle, Set<Relation> relations) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.relations = relations;
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

	public Set<Relation> getRelations() {
		return relations;
	}

	public void setRelations(Set<Relation> relations) {
		this.relations = relations;
	}
}
	