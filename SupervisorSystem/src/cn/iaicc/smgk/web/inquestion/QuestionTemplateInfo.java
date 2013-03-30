package cn.iaicc.smgk.web.inquestion;

import java.io.Serializable;
import java.util.List;

public class QuestionTemplateInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5731419747502058480L;
	/**
	 * 问题编号
	 */
	private long questionID = 0;
	/**
	 * 问题
	 */
	private String question = null;
	/**
	 * 英语问题
	 */
	private String englishQuestion = null;
	/**
	 * 字段名称
	 */
	private String fieldName = null;	
	/**
	 * 显示编号
	 */
	private int showNum = 0;
	/**
	 * 问题类型
	 */
	private int questionType = 0;
	/**
	 * 中文解释说明
	 */
	private String zhExplain = null;
	/**
	 * 英文解释说明
	 */
	private String englishExplain = null;
	/**
	 * 评语
	 */
	private String appraise = null;
	/**
	 * 英文评语
	 */
	private String englishAppraise = null;
	private int isLogic = 0;
	/**
	 * 选项列表
	 */
	private List<SelectTemplateInfo> selectList = null;

	public QuestionTemplateInfo() {
		super();
	}
	public long getQuestionID() {
		return questionID;
	}
	public void setQuestionID(long questionID) {
		this.questionID = questionID;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getEnglishQuestion() {
		return englishQuestion;
	}
	public void setEnglishQuestion(String englishQuestion) {
		this.englishQuestion = englishQuestion;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public int getShowNum() {
		return showNum;
	}
	public void setShowNum(int showNum) {
		this.showNum = showNum;
	}
	public int getQuestionType() {
		return questionType;
	}
	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}
	public String getZhExplain() {
		return zhExplain;
	}
	public void setZhExplain(String zhExplain) {
		this.zhExplain = zhExplain;
	}
	public String getEnglishExplain() {
		return englishExplain;
	}
	public void setEnglishExplain(String englishExplain) {
		this.englishExplain = englishExplain;
	}
	public String getAppraise() {
		return appraise;
	}
	public void setAppraise(String appraise) {
		this.appraise = appraise;
	}
	public String getEnglishAppraise() {
		return englishAppraise;
	}
	public void setEnglishAppraise(String englishAppraise) {
		this.englishAppraise = englishAppraise;
	}
	public List<SelectTemplateInfo> getSelectList() {
		return selectList;
	}
	public void setSelectList(List<SelectTemplateInfo> selectList) {
		this.selectList = selectList;
	}
	public int getIsLogic() {
		return isLogic;
	}
	public void setIsLogic(int isLogic) {
		this.isLogic = isLogic;
	}
	public QuestionTemplateInfo(String appraise, String englishAppraise,
			String englishExplain, String englishQuestion, String fieldName,
			int isLogic, String question, long questionID, int questionType,
			List<SelectTemplateInfo> selectList, int showNum, String zhExplain) {
		super();
		this.appraise = appraise;
		this.englishAppraise = englishAppraise;
		this.englishExplain = englishExplain;
		this.englishQuestion = englishQuestion;
		this.fieldName = fieldName;
		this.isLogic = isLogic;
		this.question = question;
		this.questionID = questionID;
		this.questionType = questionType;
		this.selectList = selectList;
		this.showNum = showNum;
		this.zhExplain = zhExplain;
	}	
}
