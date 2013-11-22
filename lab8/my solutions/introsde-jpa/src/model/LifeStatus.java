package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "LifeStatus" database table.
 * 
 */
@Entity
@Table(name="\"LifeStatus\"")
@NamedQuery(name="LifeStatus.findAll", query="SELECT l FROM LifeStatus l")
public class LifeStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"idMeasure\"")
	private int idMeasure;

	@Column(name="\"idMeasureDef\"")
	private int idMeasureDef;

	@Column(name="\"idPerson\"")
	private int idPerson;

	@Column(name="\"value\"")
	private String value;
	
	@ManyToOne(targetEntity=Person.class)
	private Person person;
	
	public LifeStatus() {
	}

	public int getIdMeasure() {
		return this.idMeasure;
	}

	public void setIdMeasure(int idMeasure) {
		this.idMeasure = idMeasure;
	}

	public int getIdMeasureDef() {
		return this.idMeasureDef;
	}

	public void setIdMeasureDef(int idMeasureDef) {
		this.idMeasureDef = idMeasureDef;
	}

	public int getIdPerson() {
		return this.idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}