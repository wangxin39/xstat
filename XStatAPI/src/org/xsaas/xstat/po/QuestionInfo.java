package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * �����ʾ�����
 */
public class QuestionInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5641375473304417533L;
	/**
	 * ������
	 */
	private Long questionID = null;
	
	/**
	 * ������Ŀ
	 */
	private String question = null;
	/**
	 * Ӣ����Ŀ
	 */
	private String englishQuestion = null;
	/**
	 * ����˵��
	 */
	private String zhExplain = null;
	/**
	 * Ӣ��˵��
	 */
	private String englishExplain = null;
	/**
	 * �𰸸�ʽ
	 */
	private String format = null;
	/**
	 * 	�ֶ�Ĭ��ֵ
	 */
	private String fieldValue = null;
	/**
	 * �ֶ�����
	 */
	private Integer fieldType = null;
	/**
	 * ��������
	 */
	private Integer questionType = null;
	private Integer status = null;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 
	 */
	public QuestionInfo() {
		super();
	}

	public QuestionInfo(Long questionID, String question,
			String englishQuestion, String zhExplain, String englishExplain,
			String format, String fieldValue, Integer fieldType,
			Integer questionType, Integer status) {
		super();
		this.questionID = questionID;
		this.question = question;
		this.englishQuestion = englishQuestion;
		this.zhExplain = zhExplain;
		this.englishExplain = englishExplain;
		this.format = format;
		this.fieldValue = fieldValue;
		this.fieldType = fieldType;
		this.questionType = questionType;
		this.status = status;
	}
	/**
	 * ��ȡ������
	 */
	public Long getQuestionID() {
		return questionID;
	}
	/**
	 * ����������
	 */
	public void setQuestionID(Long questionID) {
		this.questionID = questionID;
	}
	/**
	 * ��ȡ������Ŀ
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * ����������Ŀ
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 * ��ȡӢ����Ŀ
	 */
	public String getEnglishQuestion() {
		return englishQuestion;
	}
	/**
	 * ����Ӣ����Ŀ
	 */
	public void setEnglishQuestion(String englishQuestion) {
		this.englishQuestion = englishQuestion;
	}
	/**
	 * ��ȡ����˵��
	 */
	public String getZhExplain() {
		return zhExplain;
	}
	/**
	 * ��������˵��
	 */
	public void setZhExplain(String zhExplain) {
		this.zhExplain = zhExplain;
	}
	/**
	 * ��ȡӢ��˵��
	 */
	public String getEnglishExplain() {
		return englishExplain;
	}
	/**
	 * ����Ӣ��˵��
	 */
	public void setEnglishExplain(String englishExplain) {
		this.englishExplain = englishExplain;
	}
	/**
	 * ��ȡ�ֶ�Ĭ��ֵ
	 * @return fieldValue
	 */
	public String getFieldValue() {
		return fieldValue;
	}
	/**
	 * �����ֶ�Ĭ��ֵ
	 * @param fieldValue
	 */
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	/**
	 * ��ȡ�𰸸�ʽ
	 */
	public String getFormat() {
		return format;
	}
	/**
	 * ���ô𰸸�ʽ
	 */
	public void setFormat(String format) {
		this.format = format;
	}
	/**
	 * ��ȡ�ֶ�����
	 */

	public Integer getFieldType() {
		return fieldType;
	}

	/**
	 * �����ֶ�����
	 */
	public void setFieldType(Integer fieldType) {
		this.fieldType = fieldType;
	}

	/**
	 * ��ȡ��������
	 */
	public Integer getQuestionType() {
		return questionType;
	}


	/**
	 * ������������
	 */
	public void setQuestionType(Integer questionType) {
		this.questionType = questionType;
	}
	
}
