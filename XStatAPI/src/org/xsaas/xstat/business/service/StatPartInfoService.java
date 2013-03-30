package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IStatPartInfoService;
import org.xsaas.xstat.dao.IStatPartInfoDao;
import org.xsaas.xstat.po.StatPartInfo;


public class StatPartInfoService implements	IStatPartInfoService {

	private IStatPartInfoDao statPartInfoDao =null;


	@Override
	public void deleteStatPartInfo(StatPartInfo data) {
		
		statPartInfoDao.delete(data);
	}


	@Override
	public StatPartInfo getStatPartInfo(Long qpID) {
		
		return statPartInfoDao.getStatPartInfo(qpID);
	}

	@Override
	public List<StatPartInfo> getStatPartInfoList() {
		
		return statPartInfoDao.getStatPartInfoList();
	}

	@Override
	public void updateStatPartInfo(StatPartInfo data) {
		
		statPartInfoDao.update(data);
	}

	@Override
	public List<StatPartInfo> findByPageStatPartInfo(int firstResult, int maxResult) {
		
		return statPartInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public int getTotalStatPartInfo() {
		
		return statPartInfoDao.getTotal();
	}

	public void setStatPartInfoDao(IStatPartInfoDao statPartInfoDao) {
		this.statPartInfoDao = statPartInfoDao;
	}


	@Override
	public void saveStatPartInfo(StatPartInfo data) {
		this.statPartInfoDao.save(data);
	}


	@Override
	public boolean isSave(Long planID, Long partID) {
		return this.statPartInfoDao.isSave(planID, partID);
	}


	@Override
	public int getActualTotal(Long planID) {
		return this.statPartInfoDao.getActualTotal(planID);
	}


	@Override
	public int getPartTotal(Long planID) {
		return this.statPartInfoDao.getPartTotal(planID);
	}


	@Override
	public int getWeightedTotal(Long planID) {
		return this.statPartInfoDao.getWeightedTotal(planID);
	}


	@Override
	public List<StatPartInfo> findByPlan(Long planID) {
		return this.statPartInfoDao.findByPlan(planID);
	}


	@Override
	public int getActualTotal(Long informantID, Long issueID, Long partID) {		
		return this.statPartInfoDao.getActualTotal(informantID, issueID, partID);
	}


	@Override
	public int getActualTotal(Long issueID, Long partID) {		
		return this.statPartInfoDao.getActualTotal(issueID, partID);
	}


	@Override
	public int getSmgkTotal(Long informantID, Long issueID) {		
		return this.statPartInfoDao.getSmgkTotal(informantID, issueID);
	}


	@Override
	public int getSmgkTotal(Long issueID) {		
		return this.statPartInfoDao.getSmgkTotal(issueID);
	}


	@Override
	public int getWeightedTotal(Long informantID, Long issueID, Long partID) {		
		return this.statPartInfoDao.getWeightedTotal(informantID, issueID, partID);
	}


	@Override
	public int getWeightedTotal(Long issueID, Long partID) {		
		return this.statPartInfoDao.getWeightedTotal(issueID, partID);
	}


	@Override
	public StatPartInfo findByIssue(Long issueID, Long partID, Integer round) {
		return this.statPartInfoDao.findByIssue(issueID, partID, round);
	}


	@Override
	public int findActualByYear(Integer year, Long clientID, Long projectID,
			Long informantID) {
		return this.statPartInfoDao.findActualByYear(year, clientID, projectID, informantID);
	}


	@Override
	public int findActualByYear(Integer year, Long clientID, Long projectID) {
		return this.statPartInfoDao.findActualByYear(year, clientID, projectID);
	}


	@Override
	public int findWeightedByYear(Integer year, Long clientID, Long projectID,
			Long informantID) {
		return this.statPartInfoDao.findWeightedByYear(year, clientID, projectID, informantID);
	}


	@Override
	public int findWeightedByYear(Integer year, Long clientID, Long projectID) {
		return this.statPartInfoDao.findWeightedByYear(year, clientID, projectID);
	}


	@Override
	public StatPartInfo findByIssue(Long issueID, Long informantID,
			Long partID, Integer round) {
		return this.statPartInfoDao.findByIssue(issueID, informantID, partID, round);
	}

	
}
