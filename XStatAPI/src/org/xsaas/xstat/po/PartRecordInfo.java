package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 部分记录（答案）信息实体
 */
public class PartRecordInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1374712212981326834L;
	
	/**
	 * 部分记录编号
	 */
	private Long partRecordID = null;
	
	/**
	 * 计划编号
	 */
	private Long planID = null;
	/**
	 * 期次编号
	 */
	private Long issueID = null;
	
	/**
	 * 客户编号
	 */
	private Long clientID = null;
	/**
	 * 调查对象编号
	 */
	private Long informantID = null;
	
	/**
	 * 神秘顾客编号
	 */
	private Long smgkID = null;
	/**
	 * 调查问卷编号
	 */
	private Long inquisitionID = null;	
	/**
	 * 部分编号
	 */
	private Long partID = null;
	/**
	 * 部分问题编号
	 */
	private Long partQuestionID = null;
	/**
	 * 部分选项编号
	 */
	private Long partSelectID = null;
	/**
	 * 选项关系编号
	 */
	private Long optionRelationID = null;

	/**
	 * 权重
	 */
	private Integer weighted = null;
	/**
	 * 问题类型
	 */	
	private Integer questionType = null;
	
	/**
	 * 字段名称
	 */
	private String fieldName = null;
	/**
	 * 中文答案
	 */
	private String answer = null;
	/**
	 * 英文答案
	 */		
	private String enAnswer = null;
	/**
	 * 增加时间
	 */	
	private Timestamp addTime = null;
	/**
	 * 轮次
	 */	
	private Integer round = null;
	
	public PartRecordInfo() {
		super();
		
	}

	public Long getPartRecordID() {
		return partRecordID;
	}

	public void setPartRecordID(Long partRecordID) {
		this.partRecordID = partRecordID;
	}

	public Long getPlanID() {
		return planID;
	}

	public void setPlanID(Long planID) {
		this.planID = planID;
	}

	public Long getIssueID() {
		return issueID;
	}

	public void setIssueID(Long issueID) {
		this.issueID = issueID;
	}

	public Long getClientID() {
		return clientID;
	}

	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}

	public Long getInformantID() {
		return informantID;
	}

	public void setInformantID(Long informantID) {
		this.informantID = informantID;
	}

	public Long getSmgkID() {
		return smgkID;
	}

	public void setSmgkID(Long smgkID) {
		this.smgkID = smgkID;
	}

	public Long getInquisitionID() {
		return inquisitionID;
	}

	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}

	public Long getPartID() {
		return partID;
	}

	public void setPartID(Long partID) {
		this.partID = partID;
	}

	public Long getPartQuestionID() {
		return partQuestionID;
	}

	public void setPartQuestionID(Long partQuestionID) {
		this.partQuestionID = partQuestionID;
	}

	public Long getPartSelectID() {
		return partSelectID;
	}

	public void setPartSelectID(Long partSelectID) {
		this.partSelectID = partSelectID;
	}

	public Integer getWeighted() {
		return weighted;
	}

	public void setWeighted(Integer weighted) {
		this.weighted = weighted;
	}

	public Integer getQuestionType() {
		return questionType;
	}

	public void setQuestionType(Integer questionType) {
		this.questionType = questionType;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getEnAnswer() {
		return enAnswer;
	}

	public void setEnAnswer(String enAnswer) {
		this.enAnswer = enAnswer;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Integer getRound() {
		return round;
	}

	public void setRound(Integer round) {
		this.round = round;
	}

	public Long getOptionRelationID() {
		return optionRelationID;
	}

	public void setOptionRelationID(Long optionRelationID) {
		this.optionRelationID = optionRelationID;
	}

	public PartRecordInfo(Timestamp addTime, String answer, Long clientID,
			String enAnswer, String fieldName, Long informantID,
			Long inquisitionID, Long issueID, Long optionRelationID,
			Long partID, Long partQuestionID, Long partRecordID,
			Long partSelectID, Long planID, Integer questionType,
			Integer round, Long smgkID, Integer weighted) {
		super();
		this.addTime = addTime;
		this.answer = answer;
		this.clientID = clientID;
		this.enAnswer = enAnswer;
		this.fieldName = fieldName;
		this.informantID = informantID;
		this.inquisitionID = inquisitionID;
		this.issueID = issueID;
		this.optionRelationID = optionRelationID;
		this.partID = partID;
		this.partQuestionID = partQuestionID;
		this.partRecordID = partRecordID;
		this.partSelectID = partSelectID;
		this.planID = planID;
		this.questionType = questionType;
		this.round = round;
		this.smgkID = smgkID;
		this.weighted = weighted;
	}	

}
