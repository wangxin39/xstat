package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * 调查问卷问题
 */
public class QuestionInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5641375473304417533L;
	/**
	 * 问题编号
	 */
	private Long questionID = null;
	
	/**
	 * 中文题目
	 */
	private String question = null;
	/**
	 * 英文题目
	 */
	private String englishQuestion = null;
	/**
	 * 中文说明
	 */
	private String zhExplain = null;
	/**
	 * 英文说明
	 */
	private String englishExplain = null;
	/**
	 * 答案格式
	 */
	private String format = null;
	/**
	 * 	字段默认值
	 */
	private String fieldValue = null;
	/**
	 * 字段类型
	 */
	private Integer fieldType = null;
	/**
	 * 问题类型
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
	 * 获取问题编号
	 */
	public Long getQuestionID() {
		return questionID;
	}
	/**
	 * 设置问题编号
	 */
	public void setQuestionID(Long questionID) {
		this.questionID = questionID;
	}
	/**
	 * 获取中文题目
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * 设置中文题目
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 * 获取英文题目
	 */
	public String getEnglishQuestion() {
		return englishQuestion;
	}
	/**
	 * 设置英文题目
	 */
	public void setEnglishQuestion(String englishQuestion) {
		this.englishQuestion = englishQuestion;
	}
	/**
	 * 获取中文说明
	 */
	public String getZhExplain() {
		return zhExplain;
	}
	/**
	 * 设置中文说明
	 */
	public void setZhExplain(String zhExplain) {
		this.zhExplain = zhExplain;
	}
	/**
	 * 获取英文说明
	 */
	public String getEnglishExplain() {
		return englishExplain;
	}
	/**
	 * 设置英文说明
	 */
	public void setEnglishExplain(String englishExplain) {
		this.englishExplain = englishExplain;
	}
	/**
	 * 获取字段默认值
	 * @return fieldValue
	 */
	public String getFieldValue() {
		return fieldValue;
	}
	/**
	 * 设置字段默认值
	 * @param fieldValue
	 */
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	/**
	 * 获取答案格式
	 */
	public String getFormat() {
		return format;
	}
	/**
	 * 设置答案格式
	 */
	public void setFormat(String format) {
		this.format = format;
	}
	/**
	 * 获取字段类型
	 */

	public Integer getFieldType() {
		return fieldType;
	}

	/**
	 * 设置字段类型
	 */
	public void setFieldType(Integer fieldType) {
		this.fieldType = fieldType;
	}

	/**
	 * 获取问题类型
	 */
	public Integer getQuestionType() {
		return questionType;
	}


	/**
	 * 设置问题类型
	 */
	public void setQuestionType(Integer questionType) {
		this.questionType = questionType;
	}
	
}
