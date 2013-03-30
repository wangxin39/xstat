package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IInquisitionMarkInfoService;
import org.xsaas.xstat.dao.IInquisitionMarkInfoDao;
import org.xsaas.xstat.po.InquisitionMarkInfo;


public class InquisitionMarkInfoService implements	IInquisitionMarkInfoService {

	private IInquisitionMarkInfoDao inquisitionMarkInfoDao =null;


	@Override
	public void deleteInquisitionMarkInfo(InquisitionMarkInfo data) {		
		inquisitionMarkInfoDao.delete(data);
	}


	@Override
	public InquisitionMarkInfo getInquisitionMarkInfo(Long qpID) {
		
		return inquisitionMarkInfoDao.getInquisitionMarkInfo(qpID);
	}

	@Override
	public List<InquisitionMarkInfo> getInquisitionMarkInfoList() {
		
		return inquisitionMarkInfoDao.getInquisitionMarkInfoList();
	}

	@Override
	public void updateInquisitionMarkInfo(InquisitionMarkInfo data) {
		
		inquisitionMarkInfoDao.update(data);
	}

	@Override
	public List<InquisitionMarkInfo> findByPageInquisitionMarkInfo(int firstResult, int maxResult) {
		
		return inquisitionMarkInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public int getTotalInquisitionMarkInfo() {
		
		return inquisitionMarkInfoDao.getTotal();
	}

	public void setInquisitionMarkInfoDao(IInquisitionMarkInfoDao inquisitionMarkInfoDao) {
		this.inquisitionMarkInfoDao = inquisitionMarkInfoDao;
	}


	@Override
	public void saveInquisitionMarkInfo(InquisitionMarkInfo data) {
		this.inquisitionMarkInfoDao.save(data);
	}


	@Override
	public InquisitionMarkInfo findByISI(Long issueID, Long smgkID,
			Long informantID) {
		return this.inquisitionMarkInfoDao.findByISI(issueID, smgkID, informantID);
	}

	@Override
	public boolean isSave(Long issueID, Long smgkID, Long informantID) {
		return this.inquisitionMarkInfoDao.isSave(issueID, smgkID, informantID);
	}


	@Override
	public List<InquisitionMarkInfo> findByClient(Long clientID, Long projectID) {
		return this.inquisitionMarkInfoDao.findByClient(clientID, projectID);
	}


	@Override
	public List<InquisitionMarkInfo> findByInformant(Long informantID,Long projectID) {
		return this.inquisitionMarkInfoDao.findByInformant(informantID, projectID);
	}


	@Override
	public int getActualRound1Total(Long informantID, Long issueID) {
		return this.inquisitionMarkInfoDao.getActualRound1Total(informantID, issueID);
	}


	@Override
	public int getActualRound1Total(Long issueID) {
		return this.inquisitionMarkInfoDao.getActualRound1Total(issueID);
	}


	@Override
	public int getActualRound2Total(Long informantID, Long issueID) {
		return this.inquisitionMarkInfoDao.getActualRound2Total(informantID, issueID);
	}


	@Override
	public int getActualRound2Total(Long issueID) {
		return this.inquisitionMarkInfoDao.getActualRound2Total(issueID);
	}


	@Override
	public double getAverageTotal(Long issueID, Integer year, Integer month) {
		return this.inquisitionMarkInfoDao.getAverageTotal(issueID, year, month);
	}


	@Override
	public double getAverageTotal(Long issueID, Integer year) {
		return this.inquisitionMarkInfoDao.getAverageTotal(issueID, year);
	}


	@Override
	public double getAverageTotal(Long informantID, Long issueID, Integer year,	Integer month) {
		return this.inquisitionMarkInfoDao.getAverageTotal(informantID, issueID, year,month);
	}


	@Override
	public double getAverageTotal(Long informantID, Long issueID, Integer year) {
		return this.inquisitionMarkInfoDao.getAverageTotal(informantID, issueID, year);
	}


	@Override
	public double getAverageTotal(Long informantID, Long issueID) {
		return this.inquisitionMarkInfoDao.getAverageTotal(informantID, issueID);
	}


	@Override
	public double getAverageTotal(Long issueID) {		
		return this.inquisitionMarkInfoDao.getAverageTotal(issueID);
	}


	@Override
	public List<Integer> getCountQuarter(Long clientID, Long projectID,
			Long informantID) {
		return this.inquisitionMarkInfoDao.getCountQuarter(clientID, projectID,informantID);
	}


	@Override
	public List<Integer> getCountQuarter(Long clientID, Long projectID) {
		return this.inquisitionMarkInfoDao.getCountQuarter(clientID, projectID);
	}


	@Override
	public List<Integer> getCountWeek(Long clientID, Long projectID,Integer year, Integer month) {
		return this.inquisitionMarkInfoDao.getCountWeek(clientID, projectID, year, month);
	}


	@Override
	public List<Integer> getCountWeek(Long clientID, Long projectID,
			Long informantID, Integer year, Integer month) {
		return this.inquisitionMarkInfoDao.getCountWeek(clientID, projectID, informantID, year, month);
	}


	@Override
	public List<Integer> getCountYear(Long clientID, Long projectID, Long informantID) {
		return this.inquisitionMarkInfoDao.getCountYear(clientID, projectID, informantID);
	}


	@Override
	public List<Integer> getCountYear(Long clientID, Long projectID) {
		return this.inquisitionMarkInfoDao.getCountYear(clientID, projectID);
	}


	@Override
	public int getSmgkTotal(Long issueID, Integer year, Integer month) {
		return this.inquisitionMarkInfoDao.getSmgkTotal(issueID, year, month);
	}

	@Override
	public int getSmgkTotal(Long issueID, Integer year) {
		return this.inquisitionMarkInfoDao.getSmgkTotal(issueID, year);
	}


	@Override
	public int getSmgkTotal(Long informantID, Long issueID) {
		return this.inquisitionMarkInfoDao.getSmgkTotal(informantID, issueID);
	}


	@Override
	public int getSmgkTotal(Long issueID) {
		return this.inquisitionMarkInfoDao.getSmgkTotal(issueID);
	}


	@Override
	public int getWeightedRound1Total(Long informantID, Long issueID) {
		return this.inquisitionMarkInfoDao.getWeightedRound1Total(informantID, issueID);
	}


	@Override
	public int getWeightedRound1Total(Long issueID) {
		return this.inquisitionMarkInfoDao.getWeightedRound1Total(issueID);
	}


	@Override
	public int getWeightedRound2Total(Long informantID, Long issueID) {
		return this.inquisitionMarkInfoDao.getActualRound2Total(informantID, issueID);
	}

	@Override
	public int getWeightedRound2Total(Long issueID) {
		return this.inquisitionMarkInfoDao.getWeightedRound2Total(issueID);
	}


	@Override
	public double getAverageTotal(Integer year, Integer month, Long informantID) {		
		return this.inquisitionMarkInfoDao.getAverageTotal(year, month, informantID);
	}


	@Override
	public double getAverageTotal(Integer year, Integer month) {
		return this.inquisitionMarkInfoDao.getAverageTotal(year, month);
	}


	@Override
	public double getAverageTotal(Integer year, Long informantID) {
		return this.inquisitionMarkInfoDao.getAverageTotal(year, informantID);
	}


	@Override
	public double getAverageTotal(Integer year) {
		return this.inquisitionMarkInfoDao.getAverageTotal(year);
	}


	@Override
	public int getSmgkTotal(Integer year, Integer month, Long informantID) {		
		return this.inquisitionMarkInfoDao.getSmgkTotal(year, month, informantID);
	}


	@Override
	public int getSmgkTotal(Integer year, Integer month) {
		return this.inquisitionMarkInfoDao.getSmgkTotal(year, month);
	}


	@Override
	public Long getLastIssue(Long informantID, Integer year) {		
		return this.inquisitionMarkInfoDao.getLastIssue(informantID, year);
	}


	@Override
	public Long getLastIssue(Integer year) {
		return this.inquisitionMarkInfoDao.getLastIssue(year);
	}


	@Override
	public double getAverage(Long issueID) {
		return this.inquisitionMarkInfoDao.getAverage(issueID);
	}

	
}
