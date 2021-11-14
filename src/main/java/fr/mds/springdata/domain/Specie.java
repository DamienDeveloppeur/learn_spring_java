package fr.mds.springdata.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Specie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id = 0L;
	
	@Column(name = "common_name")
	private String commonName;
	
	@Column(name = "latinName")
	private String latinName;

	public Specie() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getLatinName() {
		return latinName;
	}

	public void setLatinName(String latinName) {
		this.latinName = latinName;
	}

	public Specie(Long id, String commonName, String latinName) {
		super();
		this.id = id;
		this.commonName = commonName;
		this.latinName = latinName;
	}

	public Specie(String commonName, String latinName) {
		super();
		this.commonName = commonName;
		this.latinName = latinName;
	}

	@Override
	public String toString() {
		return "Specie [id=" + id + ", commonName=" + commonName + ", latinName=" + latinName + "]";
	}
}
