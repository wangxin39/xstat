package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 调查问卷答题记录
 */
public class HeaderRecordInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1374712212981326834L;
	
	/**
	 * 答题编号
	 */
	private Long headerRecordID = null;
	
	/**
	 * 神秘顾客编号
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
	 * 表头编号
	 */
	private Long headerID = null;
	private Integer questionType = null;
	/**
	 * 选项关系编号
	 */
	private Long optionRelationID = null;

	/**
	 * 表头选项编号
	 */
	private Long headerSelectID = null;	
	/**
	 * 答案字段名
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
	
	public HeaderRecordInfo() {
		super();
		
	}	
	/**
	 * 获取字段名称
	 * @return fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}
	/**
	 * 设置字段名称
	 * @param fieldName
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
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

	public Long getHeaderID() {
		return headerID;
	}

	public void setHeaderID(Long headerID) {
		this.headerID = headerID;
	}


	public Integer getQuestionType() {
		return questionType;
	}

	public void setQuestionType(Integer questionType) {
		this.questionType = questionType;
	}

	/**
	 * 获取答案
	 */
	public String getAnswer() {
		return answer;
	}
	/**
	 * 设置答案
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Long getPlanID() {
		return planID;
	}

	public void setPlanID(Long planID) {
		this.planID = planID;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Long getHeaderRecordID() {
		return headerRecordID;
	}

	public void setHeaderRecordID(Long headerRecordID) {
		this.headerRecordID = headerRecordID;
	}

	public Integer getRound() {
		return round;
	}

	public void setRound(Integer round) {
		this.round = round;
	}

	public String getEnAnswer() {
		return enAnswer;
	}

	public void setEnAnswer(String enAnswer) {
		this.enAnswer = enAnswer;
	}
	public Long getHeaderSelectID() {
		return headerSelectID;
	}
	public void setHeaderSelectID(Long headerSelectID) {
		this.headerSelectID = headerSelectID;
	}

	public Long getOptionRelationID() {
		return optionRelationID;
	}
	public void setOptionRelationID(Long optionRelationID) {
		this.optionRelationID = optionRelationID;
	}
	public HeaderRecordInfo(Timestamp addTime, String answer, Long clientID,
			String enAnswer, String fieldName, Long headerID,
			Long headerRecordID, Long headerSelectID, Long informantID,
			Long inquisitionID, Long issueID, Long optionRelationID,
			Long planID, Integer questionType, Integer round, Long smgkID) {
		super();
		this.addTime = addTime;
		this.answer = answer;
		this.clientID = clientID;
		this.enAnswer = enAnswer;
		this.fieldName = fieldName;
		this.headerID = headerID;
		this.headerRecordID = headerRecordID;
		this.headerSelectID = headerSelectID;
		this.informantID = informantID;
		this.inquisitionID = inquisitionID;
		this.issueID = issueID;
		this.optionRelationID = optionRelationID;
		this.planID = planID;
		this.questionType = questionType;
		this.round = round;
		this.smgkID = smgkID;
	}
	

}
