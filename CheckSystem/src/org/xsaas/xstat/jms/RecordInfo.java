package org.xsaas.xstat.jms;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;

public class RecordInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2564625533855929812L;

	private Long planID = null;
	private Long inquisitionID = null;
	private Timestamp sendTime = null;
	@SuppressWarnings("unchecked")
	private Map parameters = null;
	public RecordInfo() {
		super();

	}
	@SuppressWarnings("unchecked")
	public RecordInfo(Long inquisitionID, Map parameters,
			Long planID, Timestamp sendTime) {
		super();
		this.inquisitionID = inquisitionID;
		this.parameters = parameters;
		this.planID = planID;
		this.sendTime = sendTime;
	}
	public Long getPlanID() {
		return planID;
	}
	public void setPlanID(Long planID) {
		this.planID = planID;
	}
	public Long getInquisitionID() {
		return inquisitionID;
	}
	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}
	public Timestamp getSendTime() {
		return sendTime;
	}
	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}
	@SuppressWarnings("unchecked")
	public Map getParameters() {
		return parameters;
	}
	@SuppressWarnings("unchecked")
	public void setParameters(Map parameters) {
		this.parameters = parameters;
	}
	
	
}
