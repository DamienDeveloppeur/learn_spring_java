package fr.mds.springdata.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "color")
	private String color;

	@Column(name = "SEX")
	private String sex;

	@ManyToOne
	@JoinColumn(name = "id_specie")
	private Specie specie;

	public Animal(Long id, String name, String color, String sex, Specie specie) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.sex = sex;
		this.specie = specie;
	}

	public Animal() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Specie getSpecie() {
		return specie;
	}

	public void setSpecie(Specie specie) {
		this.specie = specie;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + ", color=" + color + ", sex=" + sex + ", specie=" + specie + "]";
	}

}
