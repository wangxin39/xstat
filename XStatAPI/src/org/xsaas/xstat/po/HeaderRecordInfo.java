package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * �����ʾ�����¼
 */
public class HeaderRecordInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1374712212981326834L;
	
	/**
	 * ������
	 */
	private Long headerRecordID = null;
	
	/**
	 * ���ع˿ͱ��
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
	 * ��ͷ���
	 */
	private Long headerID = null;
	private Integer questionType = null;
	/**
	 * ѡ���ϵ���
	 */
	private Long optionRelationID = null;

	/**
	 * ��ͷѡ����
	 */
	private Long headerSelectID = null;	
	/**
	 * ���ֶ���
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
	
	public HeaderRecordInfo() {
		super();
		
	}	
	/**
	 * ��ȡ�ֶ�����
	 * @return fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}
	/**
	 * �����ֶ�����
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
	 * ��ȡ��
	 */
	public String getAnswer() {
		return answer;
	}
	/**
	 * ���ô�
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
