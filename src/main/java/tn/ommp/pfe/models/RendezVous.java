package tn.ommp.pfe.models;



import java.time.ZonedDateTime;
//import java.sql.Time;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import tn.ommp.pfe.utils.ZonedDateTimeConverter;


@SuppressWarnings("serial")
@Entity
@Data
public class RendezVous implements java.io.Serializable {
	
	
	 

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "rendez_vous_sequence")
	@SequenceGenerator(name = "rendez_vous_sequence", sequenceName = "rendez_vous_sequence", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="agent_id")
	private Agent agent;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="relation_id")
	private Relation relation;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="medecin_id")
	private Medecin medecin;
	
	@OneToOne(fetch = FetchType.EAGER)
	private VisiteMedicale visiteMedicale;
	
    //@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC", locale = "US")
    //@DateTimeFormat(pattern = "DY Mon DD YYYY HH24:MI:SS'Z'")
    //@Column(name = "DATE_Debut_Rendez_Vous")
    @Column(name = "DATE_Debut_Rendez_Vous", columnDefinition = "TIMESTAMP")
   // @Convert(converter = ZonedDateTimeConverter.class)
    private ZonedDateTime dateDebutRendezVous ;
    
    //@Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC", locale = "US")
    //@DateTimeFormat(pattern = "DY Mon DD YYYY HH24:MI:SS'Z'")
    //@Column(name = "DATE_Fin_Rendez_Vous")
    @Column(name = "DATE_Fin_Rendez_Vous", columnDefinition = "TIMESTAMP")
   // @Convert(converter = ZonedDateTimeConverter.class)
    private ZonedDateTime dateFinRendezVous;
   
    private String horraire;
    
    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_creation", columnDefinition = "TIMESTAMP")
   // @Convert(converter = ZonedDateTimeConverter.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC", locale = "US")
    //@DateTimeFormat(pattern = "DY Mon DD YYYY HH24:MI:SS'Z'")
    //@Column(name = "DATE_CREATION")
    private ZonedDateTime dateCreation;
    
    private String etat;
    
    
    
    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(nullable=true)
    private boolean confirmation;

	public RendezVous() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RendezVous(Long id, Agent agent, Relation relation, Medecin medecin, VisiteMedicale visiteMedicale,
			ZonedDateTime dateDebutRendezVous,ZonedDateTime dateFinRendezVous , String horraire, ZonedDateTime dateCreation, String etat, boolean confirmation) {
		super();
		this.id = id;
		this.agent = agent;
		this.relation = relation;
		this.medecin = medecin;
		this.visiteMedicale = visiteMedicale;
		this.dateFinRendezVous = dateFinRendezVous;
		this.dateDebutRendezVous = dateDebutRendezVous;
		this.horraire = horraire;
		this.dateCreation = dateCreation;
		this.etat = etat;
		this.confirmation = confirmation;
	}

	public RendezVous(Long id ,ZonedDateTime dateDebutRendezVous, ZonedDateTime dateFinRendezVous, ZonedDateTime dateCreation) {
		super();
		this.id = id;
		this.dateDebutRendezVous = dateDebutRendezVous;
		this.dateFinRendezVous = dateFinRendezVous;
		this.dateCreation = dateCreation;
	} 
	

}

