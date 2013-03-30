package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.ISmgkMenuInfoService;
import org.xsaas.xstat.dao.ISmgkMenuInfoDao;
import org.xsaas.xstat.po.SmgkMenuInfo;


public class SmgkMenuInfoService implements ISmgkMenuInfoService {
	private ISmgkMenuInfoDao smgkMenuInfoDao = null;

	public void setSmgkMenuInfoDao(ISmgkMenuInfoDao smgkMenuInfoDao) {
		this.smgkMenuInfoDao = smgkMenuInfoDao;
	}

	@Override
	public void deleteSmgkMenuInfo(SmgkMenuInfo data) {
		smgkMenuInfoDao.delete(data);		
	}

	@Override
	public SmgkMenuInfo getSmgkMenuInfo(Long menuID) {
		return smgkMenuInfoDao.getSmgkMenuInfo(menuID);
	}

	@Override
	public void saveSmgkMenuInfo(SmgkMenuInfo data) {
		smgkMenuInfoDao.save(data);	
	}

	@Override
	public void updateSmgkMenuInfo(SmgkMenuInfo data) {
		smgkMenuInfoDao.update(data);		
	}

	@Override
	public List<SmgkMenuInfo> findSmgkMenuInfoByPage(int firstResult, int maxResult) {
		
		return smgkMenuInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public int getSmgkMenuInfoTotal() {
		
		return smgkMenuInfoDao.getTotal();
	}

	@Override
	public List<SmgkMenuInfo> getSmgkMenuInfoList() {
		return smgkMenuInfoDao.getSmgkMenuInfoList();
	}
}
