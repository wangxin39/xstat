package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IPartInfoService;
import org.xsaas.xstat.dao.IPartInfoDao;
import org.xsaas.xstat.po.PartInfo;


public class PartInfoService implements	IPartInfoService {

	private IPartInfoDao partInfoDao =null;


	@Override
	public void deletePartInfo(PartInfo data) {
		
		partInfoDao.delete(data);
	}


	@Override
	public PartInfo getPartInfo(Long qpID) {
		
		return partInfoDao.getPartInfo(qpID);
	}

	@Override
	public List<PartInfo> getPartInfoList() {
		
		return partInfoDao.getPartInfoList();
	}

	
	@Override
	public void updatePartInfo(PartInfo data) {
		
		partInfoDao.update(data);
	}

	@Override
	public List<PartInfo> findByPagePartInfo(long inquisitionID,int firstResult, int maxResult) {
		
		return partInfoDao.findByPage(inquisitionID,firstResult, maxResult);
	}

	@Override
	public int getTotalPartInfo(long inquisitionID) {
		
		return partInfoDao.getTotal(inquisitionID);
	}

	public void setPartInfoDao(IPartInfoDao partInfoDao) {
		this.partInfoDao = partInfoDao;
	}


	@Override
	public void savePartInfo(PartInfo data) {
		partInfoDao.save(data);
	}


	@Override
	public List<PartInfo> getPartInfoList(Long inquisitionID) {
	
		return partInfoDao.getPartInfoList(inquisitionID);
	}


	@Override
	public List<PartInfo> findByPage(int firstResult, int maxResult) {		
		return partInfoDao.findByPage(firstResult, maxResult);
	}


	@Override
	public int getTotal() {
		return partInfoDao.getTotal();
	}


	@Override
	public List<PartInfo> findPageByDelStatus(int firstResult, int maxResult) {
		
		return partInfoDao.findPageByDelStatus(firstResult, maxResult);
	}


	@Override
	public int getTotalByDelStatus() {
		
		return partInfoDao.getTotalByDelStatus();
	}

	
}
