package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.ISmgkPopedomInfoService;
import org.xsaas.xstat.dao.ISmgkPopedomInfoDao;
import org.xsaas.xstat.po.SmgkPopedomInfo;


public class SmgkPopedomInfoService implements ISmgkPopedomInfoService {

	private ISmgkPopedomInfoDao smgkPopedomInfoDao = null;

	
	public void setSmgkPopedomInfoDao(ISmgkPopedomInfoDao smgkPopedomInfoDao) {
		this.smgkPopedomInfoDao = smgkPopedomInfoDao;
	}


	@Override
	public List<SmgkPopedomInfo> findSmgkPopedomInfoByPage(int firstResult,
			int maxResult) {
		
		return smgkPopedomInfoDao.findSmgkPopedomInfoByPage(firstResult, maxResult);
	}

	@Override
	public SmgkPopedomInfo getSmgkPopedomInfo(Long smgkPopedomID) {
		
		return smgkPopedomInfoDao.getSmgkPopedomInfo(smgkPopedomID);
	}

	@Override
	public List<SmgkPopedomInfo> getSmgkPopedomInfoList() {
		
		return smgkPopedomInfoDao.getSmgkPopedomInfoList();
	}

	@Override
	public int getSmgkPopedomInfoTotal() {
		
		return smgkPopedomInfoDao.getSmgkPopedomInfoTotal();
	}

	@Override
	public void saveSmgkPopedomInfo(SmgkPopedomInfo data) {
		
		smgkPopedomInfoDao.saveSmgkPopedomInfo(data);
	}

	@Override
	public void updateSmgkPopedomInfo(SmgkPopedomInfo data) {
		
		smgkPopedomInfoDao.updateSmgkPopedomInfo(data);
	}


	@Override
	public void deleteSmgkPopedomInfo(SmgkPopedomInfo data) {
		smgkPopedomInfoDao.deleteSmgkPopedomInfo(data);
	}


	@Override
	public List<SmgkPopedomInfo> findSmgkPopedomInfoByPage(long employeeID,
			int firstResult, int maxResult) {
		
		return smgkPopedomInfoDao.findSmgkPopedomInfoByPage(employeeID, firstResult, maxResult);
	}


	@Override
	public int getSmgkPopedomInfoTotal(long employeeID) {
	
		return smgkPopedomInfoDao.getSmgkPopedomInfoTotal(employeeID);
	}

	
}
