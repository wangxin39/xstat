package org.xsaas.xstat.po;

import java.io.Serializable;

public class OptionTemplateInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4649623988157159006L;
	
	private Long optionTemplateID = null;
	private String title = null;
	private String description = null;
	private Integer status = null;
	public Long getOptionTemplateID() {
		return optionTemplateID;
	}
	public void setOptionTemplateID(Long optionTemplateID) {
		this.optionTemplateID = optionTemplateID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public OptionTemplateInfo(String description, Long optionTemplateID,
			Integer status, String title) {
		super();
		this.description = description;
		this.optionTemplateID = optionTemplateID;
		this.status = status;
		this.title = title;
	}
	public OptionTemplateInfo() {
		super();
	}	
}
