package org.xsaas.xstat.web.inquestion;

import java.io.Serializable;
import java.util.List;

public class PartTemplateInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2743080142591200043L;
	/**
	 * 计划编号
	 */
	private Long planID = null;
	/**
	 * 部分编号
	 */	
	private long partID = 0;
	/**
	 * 问卷编号
	 */	
	private long inquestionID = 0;
	/**
	 * 显示编号
	 */	
	private String showNum = null;
	/**
	 * 显示顺序
	 */
	private int showOrder = 0;
	/**
	 * 部分名称
	 */
	private String name = null;
	/**
	 * 部分问题列表
	 */	
	private List<QuestionTemplateInfo> questionList = null;
	public PartTemplateInfo(long inquestionID, String name, long partID,
			Long planID, List<QuestionTemplateInfo> questionList,
			String showNum, int showOrder) {
		super();
		this.inquestionID = inquestionID;
		this.name = name;
		this.partID = partID;
		this.planID = planID;
		this.questionList = questionList;
		this.showNum = showNum;
		this.showOrder = showOrder;
	}
	public PartTemplateInfo() {
		super();
	}
	public long getPartID() {
		return partID;
	}
	public void setPartID(long partID) {
		this.partID = partID;
	}
	public long getInquestionID() {
		return inquestionID;
	}
	public void setInquestionID(long inquestionID) {
		this.inquestionID = inquestionID;
	}
	public String getShowNum() {
		return showNum;
	}
	public void setShowNum(String showNum) {
		this.showNum = showNum;
	}
	public int getShowOrder() {
		return showOrder;
	}
	public void setShowOrder(int showOrder) {
		this.showOrder = showOrder;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<QuestionTemplateInfo> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<QuestionTemplateInfo> questionList) {
		this.questionList = questionList;
	}
	public Long getPlanID() {
		return planID;
	}
	public void setPlanID(Long planID) {
		this.planID = planID;
	}
	
	
	
}
