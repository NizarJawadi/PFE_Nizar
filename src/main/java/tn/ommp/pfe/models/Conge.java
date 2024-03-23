package tn.ommp.pfe.models;


import java.util.Date; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
@SuppressWarnings("serial")
@Entity
public class Conge implements java.io.Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "conge_sequence")
	@SequenceGenerator(name = "conge_sequence", sequenceName = "conge_sequence", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="medecin_id")
	private Medecin medecin;
	@JsonFormat(pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_Debut", length = 7)
	private Date dateDebut;
	@JsonFormat(pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_Fin", length = 7)
	private Date dateFin;
	
	public Conge() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Conge(Long id, Medecin medecin, Date dateDebut, Date dateFin, int nbr_jours_rest) {
		super();
		this.id = id;
		this.medecin = medecin;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	
	}

	
    
}
