package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "MeasureDefaultRange" database table.
 * 
 */
@Entity
@Table(name="\"MeasureDefaultRange\"")
@NamedQuery(name="MeasureDefaultRange.findAll", query="SELECT m FROM MeasureDefaultRange m")
public class MeasureDefaultRange implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="\"alarmLevel\"")
	private int alarmLevel;

	@Column(name="\"endValue\"")
	private String endValue;

	@Column(name="\"idMeasureDef\"")
	private int idMeasureDef;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"idRange\"")
	private int idRange;

	@Column(name="\"rangeName\"")
	private String rangeName;

	@Column(name="\"startValue\"")
	private String startValue;

	public MeasureDefaultRange() {
	}

	public int getAlarmLevel() {
		return this.alarmLevel;
	}

	public void setAlarmLevel(int alarmLevel) {
		this.alarmLevel = alarmLevel;
	}

	public String getEndValue() {
		return this.endValue;
	}

	public void setEndValue(String endValue) {
		this.endValue = endValue;
	}

	public int getIdMeasureDef() {
		return this.idMeasureDef;
	}

	public void setIdMeasureDef(int idMeasureDef) {
		this.idMeasureDef = idMeasureDef;
	}

	public int getIdRange() {
		return this.idRange;
	}

	public void setIdRange(int idRange) {
		this.idRange = idRange;
	}

	public String getRangeName() {
		return this.rangeName;
	}

	public void setRangeName(String rangeName) {
		this.rangeName = rangeName;
	}

	public String getStartValue() {
		return this.startValue;
	}

	public void setStartValue(String startValue) {
		this.startValue = startValue;
	}

}