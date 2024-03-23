package tn.ommp.pfe.models;




import java.io.File;
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

import org.hibernate.annotations.Type;


import lombok.Data;
@Data
@SuppressWarnings("serial")
@Entity
public class Resiliation implements java.io.Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "resiliation_sequence")
	@SequenceGenerator(name = "resiliation_sequence", sequenceName = "resiliation_sequence", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	private Long id;
	
	
    @Temporal(TemporalType.DATE)
    @Column(name = "date_resiliation", length = 7)
    private Date dateResiliation ;
    
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="convention_id")
	private Convention convention;
    
    @Column
    private String objet;
    
    
    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column
    private boolean valide;
    
    
    @Column
    private File fichier;


	public Resiliation() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Resiliation(Date date_resiliation, Convention convention, String objet, boolean valide, File fichier) {
		super();
		this.dateResiliation = date_resiliation;
		this.convention = convention;
		this.objet = objet;
		this.valide = valide;
		this.fichier = fichier;
	}




	}