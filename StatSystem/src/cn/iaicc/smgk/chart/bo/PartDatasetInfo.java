package cn.iaicc.smgk.chart.bo;

import java.io.Serializable;

public class PartDatasetInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3980725758431430738L;

	private Double score = null;
	private String name = null;
	private String part = null;
	public PartDatasetInfo() {
		super();
	}
	public PartDatasetInfo(Double score, String name, String part) {
		super();
		this.score = score;
		this.name = name;
		this.part = part;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	
	
}
