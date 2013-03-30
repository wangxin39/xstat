package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.ArticleInfo;


public interface IArticleInfoDao {
	/**
	 * 保存文章信息
	 * @param data 文章信息
	 */
	public void saveArticleInfo(ArticleInfo data);
	/**
	 * 更新文章信息
	 * @param data 文章信息
	 */
	public void updateArticleInfo(ArticleInfo data);
	/**
	 * 删除文章信息
	 * @param data 文章信息
	 */
	public void deleteArticleInfo(ArticleInfo data);	
	/**
	 * 获取文章信息
	 * @param articleID 问卷编号
	 * @return 文章信息
	 */
	public ArticleInfo getArticleInfo(Long articleID);
	/**
	 * 获取文章信息列表
	 * @return 文章信息列表
	 */
	public List<ArticleInfo> getArticleInfoList();

	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getArticleInfoTotal(String title);
	public int getArticleInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<ArticleInfo> findArticleInfoByPage(String title,final int firstResult, final int maxResult);

	public List<ArticleInfo> findArticleInfoByPage(final int firstResult, final int maxResult);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getTotalByDelStatus();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<ArticleInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
