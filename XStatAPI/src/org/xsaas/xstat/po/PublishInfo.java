package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * ������Ϣ
 * @author wangxin
 *
 */
public class PublishInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -319808821938133791L;
	/**
	 * ���±��
	 */
	private Long publishID = null;
	/**
	 * ���±��
	 */
	private Long articleID = null;
	/**
	 * ���±���
	 */
	private Long smgkID = null;
	/**
	 * ����
	 */
	private Integer type = null; 

	/**
	 * ����״̬
	 */
	private Integer status = null;
	/**
	 * ���ʱ��
	 */
	private Timestamp publishTime = null;
	

	public PublishInfo() {
		super();
	}
	
	public PublishInfo(Long publishID, Long articleID, Long smgkID,
			Integer type, Integer status, Timestamp publishTime) {
		super();
		this.publishID = publishID;
		this.articleID = articleID;
		this.smgkID = smgkID;
		this.type = type;
		this.status = status;
		this.publishTime = publishTime;
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

	public Long getPublishID() {
		return publishID;
	}

	public void setPublishID(Long publishID) {
		this.publishID = publishID;
	}

	public Long getSmgkID() {
		return smgkID;
	}

	public void setSmgkID(Long smgkID) {
		this.smgkID = smgkID;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Timestamp getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}
	
}
