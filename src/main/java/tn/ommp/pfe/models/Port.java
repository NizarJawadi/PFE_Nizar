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
import javax.persistence.SequenceGenerator;



import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Data
public class Port implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "port_sequence")
	@SequenceGenerator(name = "port_sequence", sequenceName = "port_sequence", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	private Long id;
	
	@Column(nullable = true, length = 1000)
	private String designation;
	
	@Column(length = 20)
	private String code;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "port")
	
	private Set<Agent> agents = new HashSet<Agent>();
	
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name="centre_id")
	 private CentreMedical centreMedical;

	public Port() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Port(Long id, String designation, String code, Set<Agent> agents, CentreMedical centreMedical) {
		super();
		this.id = id;
		this.designation = designation;
		this.code = code;
		this.agents = agents;
		this.centreMedical = centreMedical;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Set<Agent> getAgents() {
		return agents;
	}

	public void setAgents(Set<Agent> agents) {
		this.agents = agents;
	}

	public CentreMedical getCentreMedical() {
		return centreMedical;
	}

	public void setCentreMedical(CentreMedical centreMedical) {
		this.centreMedical = centreMedical;
	}

	
}
