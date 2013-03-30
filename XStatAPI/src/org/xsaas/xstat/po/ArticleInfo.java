package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * ������Ϣ
 * @author wangxin
 *
 */
public class ArticleInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -319808821938133791L;
	/**
	 * ���±��
	 */
	private Long articleID = null;
	/**
	 * ���±���
	 */
	private String title = null;
	/**
	 * ����
	 */
	private String author = null; 
	/**
	 * ��Ϣ��Դ
	 */
	private String source = null;
	/**
	 * ��������
	 */
	private String content = null;
	/**
	 * ����״̬
	 */
	private Integer status = null;
	/**
	 * ���ʱ��
	 */
	private Timestamp addTime = null;
	
	public ArticleInfo(Long articleID, String title, String author,
			String source, String content, Integer status, Timestamp addTime) {
		super();
		this.articleID = articleID;
		this.title = title;
		this.author = author;
		this.source = source;
		this.content = content;
		this.status = status;
		this.addTime = addTime;
	}
	/**
	 * 
	 */

	public ArticleInfo() {
		super();
	}
	/**
	 * ��ȡ���±��
	 * @return ArticleID
	 */
	public Long getArticleID() {
		return articleID;
	}
	/**
	 * �������±��
	 * @param articleID
	 */
	public void setArticleID(Long articleID) {
		this.articleID = articleID;
	}
	/**
	 * ��ȡ����
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * ���ñ���
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * ��ȡ����
	 * @return Content
	 */
	public String getContent() {
		return content;
	}
	/***
	 * ��������
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * ��ȡ״̬
	 * @return status 
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * ����״̬
	 * @param status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * ��ȡʱ��
	 * @return addTime
	 */
	public Timestamp getAddTime() {
		return addTime;
	}
	/***
	 * ����ʱ��
	 * @param addTime
	 */
	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}
	/**
	 * ��ȡ����
	 * @return Author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * ��������
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * ��ȡ��Ϣ��Դ
	 * @return Source
	 */
	public String getSource() {
		return source;
	}
	/***
	 * ������Ϣ��Դ
	 * @param source
	 */
	public void setSource(String source) {
		this.source = source;
	}

}
