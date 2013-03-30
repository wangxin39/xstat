package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IQuestionInfoService;
import org.xsaas.xstat.dao.IQuestionInfoDao;
import org.xsaas.xstat.po.QuestionInfo;


public class QuestionInfoService implements IQuestionInfoService {
	private IQuestionInfoDao questionInfoDao = null;

	public void setQuestionInfoDao(IQuestionInfoDao questionInfoDao) {
		this.questionInfoDao = questionInfoDao;
	}

	/**
	 * ɾ���ʾ���Ϣ
	 */
	public void delete(QuestionInfo data) {
		questionInfoDao.delete(data);
		
	}

	/**
	 * ��ȡ�ʾ���Ϣ
	 */
	public QuestionInfo getQuestionInfo(long questionID) {
		
		return questionInfoDao.getQuestionInfo(questionID);
	}

	/**
	 * ��ȡ�ʾ���Ϣ�б�
	 */
	public List<QuestionInfo> getQuestionInfoList() {
		
		return questionInfoDao.getQuestionInfoList();
	}

	/**
	 * �����ʾ���Ϣ
	 */
	public void save(QuestionInfo data) {
		
		questionInfoDao.save(data);
	}
	/**
	 * �����ʾ���Ϣ
	 */
	
	public void update(QuestionInfo data) {
		
		questionInfoDao.update(data);
	}
	@Override
	public List<QuestionInfo> findByPage(int questionType,String keyword,int firstResult, int maxResult) {
		
		return questionInfoDao.findByPage(questionType, keyword, firstResult, maxResult);
	}

	@Override
	public int getQuestionInfoTotal() {
	
		return questionInfoDao.getTotal();
	}

	@Override
	public List<QuestionInfo> findByPage(int firstResult, int maxResult) {
		
		return questionInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public List<QuestionInfo> findByPage(int questionType, int firstResult,
			int maxResult) {
		return questionInfoDao.findByPage(questionType, firstResult, maxResult);
	}

	@Override
	public int getTotal(int questionType, String keyword) {
		return questionInfoDao.getTotal(questionType, keyword);
	}

	@Override
	public int getTotal(int questionType) {
		return questionInfoDao.getTotal(questionType);
	}

	@Override
	public List<QuestionInfo> findPageByDelStatus(int firstResult, int maxResult) {
	
		return questionInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
	
		return questionInfoDao.getTotalByDelStatus();
	}

	@Override
	public List<QuestionInfo> findByPage(String keyword, int firstResult,
			int maxResult) {		
		return this.questionInfoDao.findByPage(keyword, firstResult, maxResult);
	}

	@Override
	public int getTotal(String keyword) {
		return this.questionInfoDao.getTotal(keyword);
	}
	
}
