package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * 选项信息
 */
public class OptionInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8051249576746234744L;
	/**
	 * 选项编号
	 */
	private Long optionID = null;
	/**
	 * 类型
	 * 1：提示信息
	 * 2：选项值
	 */
	private Integer type = null;
	/**
	 * 中文选项
	 */
	private String chinaOption = null;
	/**
	 * 英文选项
	 */
	private String englishOption = null;
	/**
	 * 状态
	 */
	private Integer status = null;
	
	public OptionInfo() {
		super();

	}

	public Long getOptionID() {
		return optionID;
	}

	public void setOptionID(Long optionID) {
		this.optionID = optionID;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getEnglishOption() {
		return englishOption;
	}

	public void setEnglishOption(String englishOption) {
		this.englishOption = englishOption;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getChinaOption() {
		return chinaOption;
	}

	public void setChinaOption(String chinaOption) {
		this.chinaOption = chinaOption;
	}

	public OptionInfo(String chinaOption, String englishOption, Long optionID,
			Integer status, Integer type) {
		super();
		this.chinaOption = chinaOption;
		this.englishOption = englishOption;
		this.optionID = optionID;
		this.status = status;
		this.type = type;
	}

}
