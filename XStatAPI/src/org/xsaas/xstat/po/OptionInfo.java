package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * ѡ����Ϣ
 */
public class OptionInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8051249576746234744L;
	/**
	 * ѡ����
	 */
	private Long optionID = null;
	/**
	 * ����
	 * 1����ʾ��Ϣ
	 * 2��ѡ��ֵ
	 */
	private Integer type = null;
	/**
	 * ����ѡ��
	 */
	private String chinaOption = null;
	/**
	 * Ӣ��ѡ��
	 */
	private String englishOption = null;
	/**
	 * ״̬
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
