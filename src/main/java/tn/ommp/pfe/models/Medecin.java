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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

 
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@SuppressWarnings("serial")
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@PrimaryKeyJoinColumn (name ="userId")
public class Medecin  extends User implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "medecin_sequence")
	@SequenceGenerator(name = "medecin_sequence", sequenceName = "medecin_sequence", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	private Long id;
	

	@Column(length = 8)
	private String cin;

	@Column(length = 100)
	private String nomPrenom;

	/*@Column(nullable = true, length = 100)
	private String matricule;

	private String password;
	
	*/
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medecin")
	private Set<Absence> absences = new HashSet<Absence>();
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medecin")
	private Set<Conge> conges = new HashSet<Conge>();
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medecin")
	private Set<Calendrier> calendriers = new HashSet<Calendrier>();
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medecin")
	private Set<Convention> conventions = new HashSet<Convention>();
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medecin")
	private Set<RendezVous> rendezVous = new HashSet<RendezVous>();

	@ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name="centre_id")
	 private CentreMedical centreMedical;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "specialite_id")
	private Specialite specialite;
}
