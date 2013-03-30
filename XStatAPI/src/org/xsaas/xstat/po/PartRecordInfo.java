package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * ���ּ�¼���𰸣���Ϣʵ��
 */
public class PartRecordInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1374712212981326834L;
	
	/**
	 * ���ּ�¼���
	 */
	private Long partRecordID = null;
	
	/**
	 * �ƻ����
	 */
	private Long planID = null;
	/**
	 * �ڴα��
	 */
	private Long issueID = null;
	
	/**
	 * �ͻ����
	 */
	private Long clientID = null;
	/**
	 * ���������
	 */
	private Long informantID = null;
	
	/**
	 * ���ع˿ͱ��
	 */
	private Long smgkID = null;
	/**
	 * �����ʾ���
	 */
	private Long inquisitionID = null;	
	/**
	 * ���ֱ��
	 */
	private Long partID = null;
	/**
	 * ����������
	 */
	private Long partQuestionID = null;
	/**
	 * ����ѡ����
	 */
	private Long partSelectID = null;
	/**
	 * ѡ���ϵ���
	 */
	private Long optionRelationID = null;

	/**
	 * Ȩ��
	 */
	private Integer weighted = null;
	/**
	 * ��������
	 */	
	private Integer questionType = null;
	
	/**
	 * �ֶ�����
	 */
	private String fieldName = null;
	/**
	 * ���Ĵ�
	 */
	private String answer = null;
	/**
	 * Ӣ�Ĵ�
	 */		
	private String enAnswer = null;
	/**
	 * ����ʱ��
	 */	
	private Timestamp addTime = null;
	/**
	 * �ִ�
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
