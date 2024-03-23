package tn.ommp.pfe.models;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;



import lombok.Data;
@Data
@SuppressWarnings("serial")
@Entity
public class FileUpload implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "fileUpload_sequence")
	@SequenceGenerator(name = "fileUpload_sequence", sequenceName = "fileUpload_sequence", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	private Long id;

	@Column(length = 100)
	private String fileName;

	@Transient
	private MultipartFile file;

	@Transient
	private String filePath;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fichier")
	private Set<Convention> conventions = new HashSet<Convention>();

	public Set<Convention> getConventions() {
		return conventions;
	}

	public void setConventions(Set<Convention> conventions) {
		this.conventions = conventions;
	}

	public FileUpload() {
		//filePath = "C:/Users/hajerbo/Documents/storage/";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
