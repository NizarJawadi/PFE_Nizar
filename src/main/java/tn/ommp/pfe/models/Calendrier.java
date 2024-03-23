package tn.ommp.pfe.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;


import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Data
public class Calendrier implements java.io.Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "calendrier_sequence")
	@SequenceGenerator(name = "calendrier_sequence", sequenceName = "calendrier_sequence", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	private Long id;
	
	@Column
	private String jour ;
	
	@Column
	private String heureDeb ;
	
	@Column
	private double dureeSeance;
	
	@Column
	private int nmbreSeances;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="medecin_id")
	private Medecin medecin;

	public Calendrier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Calendrier(Long id, String jour, String heureDeb, double dureeSeance, int nmbreSeances, Medecin medecin) {
		super();
		this.id = id;
		this.jour = jour;
		this.heureDeb = heureDeb;
		this.dureeSeance = dureeSeance;
		this.nmbreSeances = nmbreSeances;
		this.medecin = medecin;
	}
	

}
