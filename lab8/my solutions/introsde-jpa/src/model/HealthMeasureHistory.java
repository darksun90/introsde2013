package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "HealthMeasureHistory" database table.
 * 
 */
@Entity
@Table(name="\"HealthMeasureHistory\"")
@NamedQuery(name="HealthMeasureHistory.findAll", query="SELECT h FROM HealthMeasureHistory h")
public class HealthMeasureHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="\"idMeasureDefinition\"")
	private int idMeasureDefinition;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"idMeasureHistory\"")
	private int idMeasureHistory;

	@Column(name="\"idPerson\"")
	private int idPerson;

	@Temporal(TemporalType.DATE)
	@Column(name="\"timestamp\"")
	private Date timestamp;

	@Column(name="\"value\"")
	private String value;

	public HealthMeasureHistory() {
	}

	public int getIdMeasureDefinition() {
		return this.idMeasureDefinition;
	}

	public void setIdMeasureDefinition(int idMeasureDefinition) {
		this.idMeasureDefinition = idMeasureDefinition;
	}

	public int getIdMeasureHistory() {
		return this.idMeasureHistory;
	}

	public void setIdMeasureHistory(int idMeasureHistory) {
		this.idMeasureHistory = idMeasureHistory;
	}

	public int getIdPerson() {
		return this.idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}