package tn.ommp.pfe.models;


import java.io.File;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Data
@SuppressWarnings("serial")
@Entity
public class Convention implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "convention_sequence")
	@SequenceGenerator(name = "convention_sequence", sequenceName = "convention_sequence", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	private Long id;

	@Column(nullable = false, length = 10)
	private String jour;
	@JsonFormat(pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_Debut", length = 7)
	private Date dateDebut;
	@JsonFormat(pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_fin", length = 7)
	private Date dateFin;
	@JsonFormat(pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "Date_Signature", length = 7)
	private Date dateSignature;

	@Column
	private double dureeEte;

	@Column
	private int nmbreSeancesEte;

	@Column
	private double dureeHiver;

	@Column
	private int nmbreSeancesHiver;

	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean valide;

	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean reconductible;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fichier_id")
	private FileUpload fichier;
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "convention")
	private Set<Resiliation> resiliations = new HashSet<Resiliation>();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "medecin_id")
	private Medecin medecin;

	@Transient
	private MultipartFile file;
	

	public Convention() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Convention(Long id, String jour, Date dateDebut, Date dateFin, Date dateSignature, double dureeEte,
			int nmbreSeancesEte, double dureeHiver, int nmbreSeancesHiver, boolean valide, boolean reconductible,
			FileUpload fichier, Set<Resiliation> resiliations, Medecin medecin) {
		super();
		this.id = id;
		this.jour = jour;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.dateSignature = dateSignature;
		this.dureeEte = dureeEte;
		this.nmbreSeancesEte = nmbreSeancesEte;
		this.dureeHiver = dureeHiver;
		this.nmbreSeancesHiver = nmbreSeancesHiver;
		this.valide = valide;
		this.reconductible = reconductible;
		this.fichier = fichier;
		this.resiliations = resiliations;
		this.medecin = medecin;
	}


}