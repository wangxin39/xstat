package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.ICheckDetailInfoService;
import org.xsaas.xstat.dao.ICheckDetailInfoDao;
import org.xsaas.xstat.po.CheckDetailInfo;


public class CheckDetailInfoService implements	ICheckDetailInfoService {

	private ICheckDetailInfoDao checkDetailInfoDao = null;


	@Override
	public void deleteCheckDetailInfo(CheckDetailInfo data) {
		
		checkDetailInfoDao.deleteCheckDetailInfo(data);
	}

	@Override
	public List<CheckDetailInfo> findCheckDetailInfoByPage(int firstResult,
			int maxResult) {
		
		return checkDetailInfoDao.findCheckDetailInfoByPage(firstResult, maxResult);
	}

	@Override
	public CheckDetailInfo getCheckDetailInfo(Long clientID) {
		
		return checkDetailInfoDao.getCheckDetailInfo(clientID);
	}

	@Override
	public List<CheckDetailInfo> getCheckDetailInfoList() {
		
		return checkDetailInfoDao.getCheckDetailInfoList();
	}

	@Override
	public int getCheckDetailInfoTotal() {
		
		return checkDetailInfoDao.getCheckDetailInfoTotal();
	}

	@Override
	public void saveCheckDetailInfo(CheckDetailInfo data) {
		
		checkDetailInfoDao.saveCheckDetailInfo(data);
	}

	@Override
	public void updateCheckDetailInfo(CheckDetailInfo data) {
		
		checkDetailInfoDao.updateCheckDetailInfo(data);
	}

	@Override
	public List<CheckDetailInfo> findCheckDetailInfoByPage(Long issueID,
			Long informantID, Long inquisitionID, int firstResult, int maxResult) {
		
		return checkDetailInfoDao.findByPage(issueID, informantID, inquisitionID, firstResult, maxResult);
	}

	@Override
	public int getCheckDetailInfoTotal(Long issueID, Long informantID,
			Long inquisitionID) {
		
		return checkDetailInfoDao.getTotal(issueID, informantID, inquisitionID);
	}

	@Override
	public List<CheckDetailInfo> findPageByDelStatus(int firstResult,
			int maxResult) {
		
		return checkDetailInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
		
		return checkDetailInfoDao.getTotalByDelStatus();
	}

	public void setCheckDetailInfoDao(ICheckDetailInfoDao checkDetailInfoDao) {
		this.checkDetailInfoDao = checkDetailInfoDao;
	}

	@Override
	public List<CheckDetailInfo> findCheckDetailInfoByPage(Long clientID,
			int firstResult, int maxResult) {
		
		return checkDetailInfoDao.findCheckDetailInfoByPage(clientID, firstResult, maxResult);
	}

	@Override
	public int getCheckDetailInfoTotal(Long clientID) {
		
		return checkDetailInfoDao.getCheckDetailInfoTotal(clientID);
	}

}
