package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IIssueInfoService;
import org.xsaas.xstat.dao.IIssueInfoDao;
import org.xsaas.xstat.po.IssueInfo;


public class IssueInfoService implements	IIssueInfoService {

	private IIssueInfoDao issueInfoDao = null;

	public void setIssueInfoDao(IIssueInfoDao issueInfoDao) {
		this.issueInfoDao = issueInfoDao;
	}

	@Override
	public void deleteIssueInfo(IssueInfo data) {
		
		issueInfoDao.delete(data);
	}

	@Override
	public List<IssueInfo> findIssueInfoByPage(int firstResult,
			int maxResult) {
		
		return issueInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public IssueInfo getIssueInfo(Long ptID) {
		
		return issueInfoDao.getIssueInfo(ptID);
	}

	@Override
	public List<IssueInfo> getIssueInfoList() {
		
		return issueInfoDao.getIssueInfoList();
	}

	@Override
	public int getIssueInfoTotal() {
		
		return issueInfoDao.getTotal();
	}

	@Override
	public void saveIssueInfo(IssueInfo data) {
		
		issueInfoDao.save(data);
	}

	@Override
	public void updateIssueInfo(IssueInfo data) {
		
		issueInfoDao.update(data);
	}

	@Override
	public List<IssueInfo> findByPage(long smgkID, int status,
			int firstResult, int maxResult) {
		
		return issueInfoDao.findByPage(smgkID, status, firstResult, maxResult);
	}

	@Override
	public IssueInfo getIssueInfoSmgk(long smgkID) {
	
		return issueInfoDao.getIssueInfoSmgk(smgkID);
	}

	@Override
	public int getTotal(long smgkID, int status) {
		
		return issueInfoDao.getTotal(smgkID, status);
	}

	@Override
	public boolean isRegister(String issue) {
		return issueInfoDao.isRegister(issue);
	}

	@Override
	public List<IssueInfo> findByPage(Long clientID, int firstResult,
			int maxResult) {
		
		return issueInfoDao.findByPage(clientID, firstResult, maxResult);
	}

	@Override
	public int getTotal(Long clientID) {
		
		return issueInfoDao.getTotal(clientID);
	}

	@Override
	public List<IssueInfo> findIssueInfoByPage(Long clientID, int firstResult,
			int maxResult) {
		
		return issueInfoDao.findIssueInfoByPage(clientID, firstResult, maxResult);
	}

	@Override
	public int getIssueInfoTotal(Long clientID) {
		
		return issueInfoDao.getIssueInfoTotal(clientID);
	}

	@Override
	public List<IssueInfo> findByPage(Long clientID, Long issueID,
			int firstResult, int maxResult) {
		
		return issueInfoDao.findByPage(clientID, issueID, firstResult, maxResult);
	}

	@Override
	public int getTotal(Long clientID, Long issueID) {
	
		return issueInfoDao.getTotal(clientID, issueID);
	}

	@Override
	public List<IssueInfo> getIssueInfoList(Long inquisitionID) {
		
		return issueInfoDao.getList(inquisitionID);
	}

	@Override
	public List<IssueInfo> findPageByDelStatus(int firstResult, int maxResult) {
		
		return issueInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
		
		return issueInfoDao.getTotalByDelStatus();
	}

	@Override
	public List<IssueInfo> findIssueInfoByPage(Long clientID, Long issueID,
			int firstResult, int maxResult) {
		
		return issueInfoDao.findIssueInfoByPage(clientID, issueID, firstResult, maxResult);
	}

	@Override
	public int getIssueInfoTotal(Long clientID, Long issueID) {
		
		return issueInfoDao.getIssueInfoTotal(clientID, issueID);
	}

	@Override
	public List<IssueInfo> getList(Long inquisitionID, Long projectID) {
		
		return issueInfoDao.getList(inquisitionID, projectID);
	}

	@Override
	public List<IssueInfo> findIssueInfoListByReportStatus() {		
		return this.issueInfoDao.findIssueInfoListByReportStatus();
	}

	@Override
	public IssueInfo getLastIssueID(Long clientID, Long projectID,String issue) {		
		return this.issueInfoDao.getLastIssueID(clientID,projectID,issue);
	}
	
}
