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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;


import lombok.Data;


@Data
@SuppressWarnings("serial")
@Entity
public class Relation implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "relation_sequence")
	@SequenceGenerator(name = "relation_sequence", sequenceName = "relation_sequence", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	private Long id;
	
	@Column(length = 50, name = "nom_prenom")
	private String nomPrenom;
	
	private String email;
	
	
	private String tel;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="Agent_id")
	private Agent agent;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "typeRelation_id")
	private TypeRelation typeRelation;


	
//	@OneToMany(fetch=FetchType.LAZY, mappedBy ="relation")
//	@JsonIgnore
//	private Set<Rendez_Vous> rendez_vous =new HashSet<Rendez_Vous>();

	
	

	

	


	


//	public Set<Rendez_Vous> getRendez_vous() {
//		return rendez_vous;
//	}
//
//	public void setRendez_vous(Set<Rendez_Vous> rendez_vous) {
//		this.rendez_vous = rendez_vous;
//	}
	public Relation() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Relation(Long id, String nomPrenom, String email, String tel, Agent agent, TypeRelation typeRelation) {
		super();
		this.id = id;
		this.nomPrenom = nomPrenom;
		this.email = email;
		this.tel = tel;
		this.agent = agent;
		this.typeRelation = typeRelation;
	}


	


	public Relation(String nomPrenom, String email, String tel, Agent agent, TypeRelation typeRelation) {
		super();
		this.nomPrenom = nomPrenom;
		this.email = email;
		this.tel = tel;
		this.agent = agent;
		this.typeRelation = typeRelation;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomPrenom() {
		return nomPrenom;
	}


	public void setNomPrenom(String nomPrenom) {
		this.nomPrenom = nomPrenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public Agent getAgent() {
		return agent;
	}


	public void setAgent(Agent agent) {
		this.agent = agent;
	}


	public TypeRelation getTypeRelation() {
		return typeRelation;
	}


	public void setTypeRelation(TypeRelation typeRelation) {
		this.typeRelation = typeRelation;
	}

	
}
