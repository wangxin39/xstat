package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IRemarkInfoService;
import org.xsaas.xstat.dao.IRemarkInfoDao;
import org.xsaas.xstat.po.RemarkInfo;


public class RemarkInfoService implements IRemarkInfoService {

	private IRemarkInfoDao remarkInfoDao = null;

	public void setRemarkInfoDao(
			IRemarkInfoDao remarkInfoDao) {
		this.remarkInfoDao = remarkInfoDao;
	}

	@Override
	public void deleteRemarkInfo(RemarkInfo data) {
		
		remarkInfoDao.delete(data);
	}

	@Override
	public List<RemarkInfo> findRemarkInfoByPage(long questionID,
			int firstResult, int maxResult) {
		
		return remarkInfoDao.findByPage(questionID,firstResult, maxResult);
	}

	@Override
	public RemarkInfo getRemarkInfo(Long remarkID) {
		
		return remarkInfoDao.getRemarkInfo(remarkID);
	}

	@Override
	public List<RemarkInfo> getRemarkInfoList() {
		
		return remarkInfoDao.getRemarkInfoList();
	}

	@Override
	public int getRemarkInfoTotal(long questionID) {
		
		return remarkInfoDao.getTotal(questionID);
	}

	@Override
	public void saveRemarkInfo(RemarkInfo data) {
		
		remarkInfoDao.save(data);
	}

	@Override
	public void updateRemarkInfo(RemarkInfo data) {
		
		remarkInfoDao.update(data);
	}

	@Override
	public List<RemarkInfo> findRemarkInfoByPage(int firstResult, int maxResult) {
		
		return remarkInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public int getRemarkInfoTotal() {
		
		return remarkInfoDao.getTotal();
	}

	@Override
	public List<RemarkInfo> findByInformant(Long issueID, Long informantID,
			Long inquisitionID) {		
		return this.remarkInfoDao.findByInformant(issueID, informantID, inquisitionID);
	}

	@Override
	public List<RemarkInfo> findPageByDelStatus(int firstResult, int maxResult) {
		
		return remarkInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
		
		return remarkInfoDao.getTotalByDelStatus();
	}
}
