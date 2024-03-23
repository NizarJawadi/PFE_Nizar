package tn.ommp.pfe.models;


import java.util.Date; 
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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "userId") 
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")

public class Agent extends User  implements java.io.Serializable {
	
	/*public static final String ROLE_ADMIN = "ADMIN";
	public static final String ROLE_SUPER_ADMIN = "SUPER_ADMIN";
	public static final String ROLE_USER = "USER";
*/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "agent_sequence")
	@SequenceGenerator(name = "agent_sequence", sequenceName = "agent_sequence", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	private Long id;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="Poste_id")
	private Poste poste;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="Port_id")
	private Port port;

	

	@Column(length = 100)
	private String nomPrenom;

	@Column(nullable = true, length = 100)
	private String email;

	/*@Column(length = 50)
	private String role;
*/

	
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean responsable;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_Recrutement", length = 7)
	private Date dateRecrutement;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_Fonction", length = 7)
	private Date dateFonction;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_Naissance", length = 7)
	private Date dateNaissance;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_Retraite", length = 7)
	private Date dateRetraite;
	
	@Column(length = 8)
	private String cin;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="Fonction_id")
	private Fonction fonction;
	
	@Column(length = 1000)
	private String grade;
	
	@Column(length = 1000)
	private String emploiEffectif;
	
	@Column(length = 10)
	private String college;
	
	@Column(length = 20)
	private String tel;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "agent")
	@JsonIgnore
	private Set<Mouchard> mouchards = new HashSet<Mouchard>();
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="Statut_id")
	private Statut statut;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "agent")
	@JsonIgnore
	private Set<Relation> relations= new HashSet<Relation>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "agent")
	@JsonIgnore
	private Set<RendezVous> rendezVous= new HashSet<RendezVous>();
	





	


	
}