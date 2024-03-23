package tn.ommp.pfe.models;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



import lombok.Data;
import lombok.Getter;
@Data
@SuppressWarnings("serial")
@Entity


public class VisiteMedicale implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "visiteMedical_sequence")
	@SequenceGenerator(name = "visiteMedical_sequence", sequenceName = "visiteMedical_sequence", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	private Long id;
	
	
	private String observation;
	
	private String diagnostique;

	private String traitement;
	
	private String eploration;
	
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="rendez_vous_id")
	private RendezVous rendezVous;



	public VisiteMedicale() {
		super();
		// TODO Auto-generated constructor stub
	}



	public VisiteMedicale(Long id, String observation, String diagnostique, String traitement, String eploration,
			RendezVous rendezVous) {
		super();
		this.id = id;
		this.observation = observation;
		this.diagnostique = diagnostique;
		this.traitement = traitement;
		this.eploration = eploration;
		this.rendezVous = rendezVous;
	}

}