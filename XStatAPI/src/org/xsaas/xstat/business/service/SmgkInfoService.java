package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.ISmgkInfoService;
import org.xsaas.xstat.dao.ISmgkInfoDao;
import org.xsaas.xstat.po.SmgkInfo;


public class SmgkInfoService implements ISmgkInfoService {

	private ISmgkInfoDao smgkInfoDao = null;

	public void setSmgkInfoDao(ISmgkInfoDao smgkInfoDao) {
		this.smgkInfoDao = smgkInfoDao;
	}

	@Override
	public void deleteSmgkInfo(SmgkInfo data) {
		
		smgkInfoDao.deleteSmgkInfo(data);
	}

	@Override
	public List<SmgkInfo> findSmgkInfoByPage(int firstResult, int maxResult) {
		
		return smgkInfoDao.findSmgkInfoByPage(firstResult, maxResult);
	}

	@Override
	public SmgkInfo getSmgkInfo(Long smgkID) {
		
		return smgkInfoDao.getSmgkInfo(smgkID);
	}

	@Override
	public List<SmgkInfo> getSmgkInfoList() {
		
		return smgkInfoDao.getSmgkInfoList();
	}

	@Override
	public int getSmgkInfoTotal() {
		
		return smgkInfoDao.getSmgkInfoTotal();
	}

	@Override
	public void saveSmgkInfo(SmgkInfo data) {
		
		smgkInfoDao.saveSmgkInfo(data);
	}

	@Override
	public void updateSmgkInfo(SmgkInfo data) {
		
		smgkInfoDao.updateSmgkInfo(data);
	}

	@Override
	public SmgkInfo isLogin(String username, String password) {
		return smgkInfoDao.isLogin(username, password);
	}

	@Override
	public boolean isRegister(String userName) {
		
		return smgkInfoDao.isRegister(userName);
	}

	@Override
	public List<SmgkInfo> findSmgkInfoByPage(Integer status, int firstResult,
			int maxResult) {
		
		return smgkInfoDao.findSmgkInfoByPage(status, firstResult, maxResult);
	}

	@Override
	public int getSmgkInfoTotal(Integer status) {
		
		return smgkInfoDao.getSmgkInfoTotal(status);
	}

	@Override
	public List<SmgkInfo> findPageByDelStatus(int firstResult, int maxResult) {
		
		return smgkInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
		
		return smgkInfoDao.getTotalByDelStatus();
	}

}
