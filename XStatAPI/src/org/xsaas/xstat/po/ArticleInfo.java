package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 文章信息
 * @author wangxin
 *
 */
public class ArticleInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -319808821938133791L;
	/**
	 * 文章编号
	 */
	private Long articleID = null;
	/**
	 * 文章标题
	 */
	private String title = null;
	/**
	 * 作者
	 */
	private String author = null; 
	/**
	 * 信息来源
	 */
	private String source = null;
	/**
	 * 文章内容
	 */
	private String content = null;
	/**
	 * 文章状态
	 */
	private Integer status = null;
	/**
	 * 添加时间
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
	 * 获取标题
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置标题
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取内容
	 * @return Content
	 */
	public String getContent() {
		return content;
	}
	/***
	 * 设置内容
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
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
	/**
	 * 获取时间
	 * @return addTime
	 */
	public Timestamp getAddTime() {
		return addTime;
	}
	/***
	 * 设置时间
	 * @param addTime
	 */
	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}
	/**
	 * 获取作者
	 * @return Author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * 设置作者
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * 获取信息来源
	 * @return Source
	 */
	public String getSource() {
		return source;
	}
	/***
	 * 设置信息来源
	 * @param source
	 */
	public void setSource(String source) {
		this.source = source;
	}

}
