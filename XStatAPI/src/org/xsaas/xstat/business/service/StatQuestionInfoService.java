package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IStatQuestionInfoService;
import org.xsaas.xstat.dao.IStatQuestionInfoDao;
import org.xsaas.xstat.po.StatQuestionInfo;


public class StatQuestionInfoService implements	IStatQuestionInfoService {

	private IStatQuestionInfoDao statQuestionInfoDao =null;


	@Override
	public void deleteStatQuestionInfo(StatQuestionInfo data) {
		
		statQuestionInfoDao.delete(data);
	}


	@Override
	public StatQuestionInfo getStatQuestionInfo(Long qpID) {
		
		return statQuestionInfoDao.getStatQuestionInfo(qpID);
	}

	@Override
	public List<StatQuestionInfo> getStatQuestionInfoList() {
		
		return statQuestionInfoDao.getStatQuestionInfoList();
	}

	@Override
	public void updateStatQuestionInfo(StatQuestionInfo data) {
		
		statQuestionInfoDao.update(data);
	}

	@Override
	public List<StatQuestionInfo> findByPageStatQuestionInfo(int firstResult, int maxResult) {
		
		return statQuestionInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public int getTotalStatQuestionInfo() {
		
		return statQuestionInfoDao.getTotal();
	}

	public void setStatQuestionInfoDao(IStatQuestionInfoDao statQuestionInfoDao) {
		this.statQuestionInfoDao = statQuestionInfoDao;
	}


	@Override
	public void saveStatQuestionInfo(StatQuestionInfo data) {
		this.statQuestionInfoDao.save(data);
	}


	@Override
	public boolean isSave(Long planID, Long partID, Long partQuestionID,
			Long partSelectID) {
		return this.statQuestionInfoDao.isSave(planID, partID, partQuestionID, partSelectID);
	}


	@Override
	public int getCountMarks(Long planID, Long partID) {		
		return this.statQuestionInfoDao.getCountMarks(planID, partID);
	}

	@Override
	public int getCountMarks(Long planID) {
		return this.statQuestionInfoDao.getCountMarks(planID);
	}


	@Override
	public StatQuestionInfo findByPlan(Long issueID, Long planID, Long partID) {		
		return this.statQuestionInfoDao.findByPlan(issueID, planID, partID);
	}


	@Override
	public StatQuestionInfo findByIssue(Long issueID, Long partID, Long partQuestionID, Integer round) {
		return this.statQuestionInfoDao.findByIssue(issueID, partID, partQuestionID, round);
	}


	@Override
	public int getCountWeights(Long planID, Long partID) {		
		return this.statQuestionInfoDao.getCountWeights(planID, partID);
	}


	@Override
	public int getCountWeights(Long planID) {
		return this.statQuestionInfoDao.getCountWeights(planID);
	}

	
}
