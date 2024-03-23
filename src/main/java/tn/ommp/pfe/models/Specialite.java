package tn.ommp.pfe.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@SuppressWarnings("serial")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Specialite implements java.io.Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "specialite_sequence")
	@SequenceGenerator(name = "specialite_sequence", sequenceName = "specialite_sequence", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	private Long id;
	
	//@OneToOne(fetch = FetchType.EAGER)	
	//private Medecin medecin;
	@Column(name = "libelle")
	private String libelle;

	

	

}
