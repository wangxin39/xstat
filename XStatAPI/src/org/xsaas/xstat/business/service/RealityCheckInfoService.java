package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IRealityCheckInfoService;
import org.xsaas.xstat.dao.IRealityCheckInfoDao;
import org.xsaas.xstat.po.RealityCheckInfo;


public class RealityCheckInfoService implements	IRealityCheckInfoService {

	private IRealityCheckInfoDao realityCheckInfoDao = null;


	public void setRealityCheckInfo(IRealityCheckInfoDao realityCheckInfoDao) {
		this.realityCheckInfoDao = realityCheckInfoDao;
	}

	@Override
	public void deleteRealityCheckInfo(RealityCheckInfo data) {
		
		realityCheckInfoDao.deleteRealityCheckInfo(data);
	}

	@Override
	public List<RealityCheckInfo> findRealityCheckInfoByPage(int firstResult,
			int maxResult) {
		
		return realityCheckInfoDao.findRealityCheckInfoByPage(firstResult, maxResult);
	}

	@Override
	public RealityCheckInfo getRealityCheckInfo(Long clientID) {
		
		return realityCheckInfoDao.getRealityCheckInfo(clientID);
	}

	@Override
	public List<RealityCheckInfo> getRealityCheckInfoList() {
		
		return realityCheckInfoDao.getRealityCheckInfoList();
	}

	@Override
	public int getRealityCheckInfoTotal() {
		
		return realityCheckInfoDao.getRealityCheckInfoTotal();
	}

	@Override
	public void saveRealityCheckInfo(RealityCheckInfo data) {
		
		realityCheckInfoDao.saveRealityCheckInfo(data);
	}

	@Override
	public void updateRealityCheckInfo(RealityCheckInfo data) {
		
		realityCheckInfoDao.updateRealityCheckInfo(data);
	}

	@Override
	public List<RealityCheckInfo> findRealityCheckInfoByPage(Long issueID,Long inquisitionID, int firstResult, int maxResult) {
		
		return realityCheckInfoDao.findByPage(issueID, inquisitionID, firstResult, maxResult);
	}

	@Override
	public int getRealityCheckInfoTotal(Long issueID,Long inquisitionID) {
		
		return realityCheckInfoDao.getTotal(issueID, inquisitionID);
	}

	@Override
	public List<RealityCheckInfo> findPageByDelStatus(int firstResult,
			int maxResult) {
		
		return realityCheckInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
		
		return realityCheckInfoDao.getTotalByDelStatus();
	}

	public void setRealityCheckInfoDao(IRealityCheckInfoDao realityCheckInfoDao) {
		this.realityCheckInfoDao = realityCheckInfoDao;
	}

	@Override
	public List<RealityCheckInfo> findRealityCheckInfoByPage(Long clientID,
			int firstResult, int maxResult) {
		
		return realityCheckInfoDao.findRealityCheckInfoByPage(clientID, firstResult, maxResult);
	}

	@Override
	public int getRealityCheckInfoTotal(Long clientID) {
		
		return realityCheckInfoDao.getRealityCheckInfoTotal(clientID);
	}

}
