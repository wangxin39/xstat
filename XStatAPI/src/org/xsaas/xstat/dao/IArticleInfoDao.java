package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.ArticleInfo;


public interface IArticleInfoDao {
	/**
	 * ����������Ϣ
	 * @param data ������Ϣ
	 */
	public void saveArticleInfo(ArticleInfo data);
	/**
	 * ����������Ϣ
	 * @param data ������Ϣ
	 */
	public void updateArticleInfo(ArticleInfo data);
	/**
	 * ɾ��������Ϣ
	 * @param data ������Ϣ
	 */
	public void deleteArticleInfo(ArticleInfo data);	
	/**
	 * ��ȡ������Ϣ
	 * @param articleID �ʾ���
	 * @return ������Ϣ
	 */
	public ArticleInfo getArticleInfo(Long articleID);
	/**
	 * ��ȡ������Ϣ�б�
	 * @return ������Ϣ�б�
	 */
	public List<ArticleInfo> getArticleInfoList();

	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getArticleInfoTotal(String title);
	public int getArticleInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<ArticleInfo> findArticleInfoByPage(String title,final int firstResult, final int maxResult);

	public List<ArticleInfo> findArticleInfoByPage(final int firstResult, final int maxResult);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getTotalByDelStatus();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<ArticleInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
