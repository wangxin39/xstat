package org.xsaas.xstat.po;

import java.io.Serializable;

public class OptionRelationInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4066418258704491428L;

	private Long optionRelationID = null;
	private Long optionTemplateID = null;
	private String showNum = null;
	private String optionName = null;
	private Long alterID = null;
	private Long optionID = null;
	private Integer status = null;
	public Long getOptionRelationID() {
		return optionRelationID;
	}
	public void setOptionRelationID(Long optionRelationID) {
		this.optionRelationID = optionRelationID;
	}
	public Long getOptionTemplateID() {
		return optionTemplateID;
	}
	public void setOptionTemplateID(Long optionTemplateID) {
		this.optionTemplateID = optionTemplateID;
	}
	public String getShowNum() {
		return showNum;
	}
	public void setShowNum(String showNum) {
		this.showNum = showNum;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public Long getAlterID() {
		return alterID;
	}
	public void setAlterID(Long alterID) {
		this.alterID = alterID;
	}
	public Long getOptionID() {
		return optionID;
	}
	public void setOptionID(Long optionID) {
		this.optionID = optionID;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public OptionRelationInfo(Long alterID, Long optionID, String optionName,
			Long optionRelationID, Long optionTemplateID, String showNum,
			Integer status) {
		super();
		this.alterID = alterID;
		this.optionID = optionID;
		this.optionName = optionName;
		this.optionRelationID = optionRelationID;
		this.optionTemplateID = optionTemplateID;
		this.showNum = showNum;
		this.status = status;
	}
	public OptionRelationInfo() {
		super();
	}
	
}
