package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IArticleInfoService;
import org.xsaas.xstat.dao.IArticleInfoDao;
import org.xsaas.xstat.po.ArticleInfo;


public class ArticleInfoService implements
		IArticleInfoService {

	private IArticleInfoDao articleInfoDao = null;

	public void setArticleInfoDao(IArticleInfoDao articleInfoDao) {
		this.articleInfoDao = articleInfoDao;
	}

	@Override
	public void deleteArticleInfo(ArticleInfo data) {
		
		articleInfoDao.deleteArticleInfo(data);
	}

	@Override
	public List<ArticleInfo> findArticleInfoByPage(String keyword,int firstResult,
			int maxResult) {
		
		return articleInfoDao.findArticleInfoByPage(keyword,firstResult, maxResult);
	}

	@Override
	public ArticleInfo getArticleInfo(Long articleID) {
		
		return articleInfoDao.getArticleInfo(articleID);
	}

	@Override
	public List<ArticleInfo> getArticleInfoList() {
		
		return articleInfoDao.getArticleInfoList();
	}

	@Override
	public int getArticleInfoTotal(String keyword) {
		
		return articleInfoDao.getArticleInfoTotal(keyword);
	}

	@Override
	public void saveArticleInfo(ArticleInfo data) {
		
		articleInfoDao.saveArticleInfo(data);
	}

	@Override
	public void updateArticleInfo(ArticleInfo data) {
		
		articleInfoDao.updateArticleInfo(data);
	}

	@Override
	public List<ArticleInfo> findArticleInfoByPage(int firstResult,
			int maxResult) {
	
		return articleInfoDao.findArticleInfoByPage(firstResult, maxResult);
	}

	@Override
	public int getArticleInfoTotal() {
		
		return articleInfoDao.getArticleInfoTotal();
	}

	@Override
	public List<ArticleInfo> findPageByDelStatus(int firstResult, int maxResult) {
		
		return articleInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
		
		return articleInfoDao.getTotalByDelStatus();
	}
}
