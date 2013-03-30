package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IPartRecordInfoService;
import org.xsaas.xstat.dao.IPartRecordInfoDao;
import org.xsaas.xstat.po.PartRecordInfo;


public class PartRecordInfoService implements IPartRecordInfoService {
	private IPartRecordInfoDao partRecordInfoDao = null;

	public void setPartRecordInfoDao(IPartRecordInfoDao partRecordInfoDao) {
		this.partRecordInfoDao = partRecordInfoDao;
	}

	@Override
	public void deletePartRecordInfo(PartRecordInfo data) {
		
		partRecordInfoDao.delete(data);		
	}

	@Override
	public List<PartRecordInfo> findPartRecordInfoByPage(int firstResult,int maxResult) {
		
		return partRecordInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public PartRecordInfo getPartRecordInfo(Long ihID) {
		
		return partRecordInfoDao.getInfo(ihID);
	}

	@Override
	public List<PartRecordInfo> getPartRecordInfoList() {
		
		return partRecordInfoDao.getList();
	}

	@Override
	public int getPartRecordInfoTotal() {
		
		return partRecordInfoDao.getTotal();
	}

	@Override
	public void savePartRecordInfo(PartRecordInfo data) {
		
		partRecordInfoDao.save(data);
	}

	@Override
	public void updatePartRecordInfo(PartRecordInfo data) {
		
		partRecordInfoDao.update(data);
	}

	@Override
	public List<PartRecordInfo> findByPlan(Long planID) {	
		return this.partRecordInfoDao.findByPlan(planID);
	}

}
