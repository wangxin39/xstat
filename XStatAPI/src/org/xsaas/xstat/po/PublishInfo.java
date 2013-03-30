package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 文章信息
 * @author wangxin
 *
 */
public class PublishInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -319808821938133791L;
	/**
	 * 文章编号
	 */
	private Long publishID = null;
	/**
	 * 文章编号
	 */
	private Long articleID = null;
	/**
	 * 文章标题
	 */
	private Long smgkID = null;
	/**
	 * 作者
	 */
	private Integer type = null; 

	/**
	 * 文章状态
	 */
	private Integer status = null;
	/**
	 * 添加时间
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
	 * 获取文章编号
	 * @return ArticleID
	 */
	public Long getArticleID() {
		return articleID;
	}
	/**
	 * 设置文章编号
	 * @param articleID
	 */
	public void setArticleID(Long articleID) {
		this.articleID = articleID;
	}
	
	/**
	 * 获取状态
	 * @return status 
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置状态
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
