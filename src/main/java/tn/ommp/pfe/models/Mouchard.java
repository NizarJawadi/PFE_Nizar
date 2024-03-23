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


import lombok.Data;
@Data
@SuppressWarnings("serial")
@Entity
public class Mouchard implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "mouchard_sequence")
	@SequenceGenerator(name = "mouchard_sequence", sequenceName = "mouchard_sequence", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	private Long id;

	@Column(nullable = true, length = 20)
	private String type;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "agent_id")
	private Agent agent;
	
	@Column(nullable = true, length = 100)
	private String tables;
	
	@Column(nullable = true, length = 4000)
	private String champ;
	
	@Column(nullable = true, length = 4000)
	private String ancVal;
	
	@Column(nullable = true, length = 4000)
	private String nouVal;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = true)
	private Date dateTime;
	
	@Column(nullable = true, length = 20)
	private String cle;
	
	public Mouchard() {
	}

	public Mouchard(String type, Agent agent, String tables, Date dateTime, String cle) {
		super();
		this.type = type;
		this.agent = agent;
		this.tables = tables;
		this.dateTime = dateTime;
		this.cle = cle;
	}
	
	public Mouchard(String ancVal, String type, Agent agent, String tables, Date dateTime, String cle) {
		super();
		this.type = type;
		this.agent = agent;
		this.tables = tables;
		this.dateTime = dateTime;
		this.cle = cle;
		this.ancVal = ancVal;
	}

	public Mouchard(String type, Agent agent, String tables, Date dateTime, String cle, String nouVal) {
		super();
		this.type = type;
		this.agent = agent;
		this.tables = tables;
		this.dateTime = dateTime;
		this.cle = cle;
		this.nouVal = nouVal;
	}

	public Mouchard(String ancVal, String type, Agent agent, String tables, Date dateTime, String cle,
			String nouVal) {
		super();
		this.type = type;
		this.agent = agent;
		this.tables = tables;
		this.dateTime = dateTime;
		this.cle = cle;
		this.nouVal = nouVal;
		this.ancVal = ancVal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public String getTables() {
		return tables;
	}

	public void setTables(String tables) {
		this.tables = tables;
	}

	public String getChamp() {
		return champ;
	}

	public void setChamp(String champ) {
		this.champ = champ;
	}

	public String getAncVal() {
		return ancVal;
	}

	public void setAncVal(String ancVal) {
		this.ancVal = ancVal;
	}

	public String getNouVal() {
		return nouVal;
	}

	public void setNouVal(String nouVal) {
		this.nouVal = nouVal;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getCle() {
		return cle;
	}

	public void setCle(String cle) {
		this.cle = cle;
	}

}
