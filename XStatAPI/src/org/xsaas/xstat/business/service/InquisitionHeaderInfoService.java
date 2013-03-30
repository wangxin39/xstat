package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IInquisitionHeaderInfoService;
import org.xsaas.xstat.dao.IInquisitionHeaderInfoDao;
import org.xsaas.xstat.po.InquisitionHeaderInfo;


public class InquisitionHeaderInfoService implements IInquisitionHeaderInfoService {
	private IInquisitionHeaderInfoDao inquisitionHeaderInfoDao = null;

	public void setInquisitionHeaderInfoDao(IInquisitionHeaderInfoDao inquisitionHeaderInfoDao) {
		this.inquisitionHeaderInfoDao = inquisitionHeaderInfoDao;
	}

	@Override
	public void deleteInquisitionHeaderInfo(InquisitionHeaderInfo data) {
		
		inquisitionHeaderInfoDao.delete(data);		
	}

	@Override
	public InquisitionHeaderInfo getInquisitionHeaderInfo(Long ihID) {
		
		return inquisitionHeaderInfoDao.getInquisitionHeaderInfo(ihID);
	}

	@Override
	public List<InquisitionHeaderInfo> getInquisitionHeaderInfoList() {
		
		return inquisitionHeaderInfoDao.getInquisitionHeaderInfoList();
	}

	@Override
	public int getInquisitionHeaderInfoTotal() {
		
		return inquisitionHeaderInfoDao.getTotal();
	}

	@Override
	public void saveInquisitionHeaderInfo(InquisitionHeaderInfo data) {
		
		inquisitionHeaderInfoDao.save(data);
	}

	@Override
	public void updateInquisitionHeaderInfo(InquisitionHeaderInfo data) {
		
		inquisitionHeaderInfoDao.update(data);
	}

	@Override
	public List<InquisitionHeaderInfo> getInquisitionHeaderInfoList(Long inquisitionID) {
		
		return inquisitionHeaderInfoDao.getInquisitionHeaderInfoList(inquisitionID);
	}

	@Override
	public int getInquisitionHeaderInfoTotal(long inquisitionID) {
		
		return inquisitionHeaderInfoDao.getInquisitionHeaderInfoTotal(inquisitionID);
	}

	@Override
	public List<InquisitionHeaderInfo> findInquisitionHeaderInfoByPage(
			long inquisitionID, int firstResult, int maxResult) {
		
		return inquisitionHeaderInfoDao.findInquisitionHeaderInfoByPage(inquisitionID, firstResult, maxResult);
	}

	@Override
	public List<InquisitionHeaderInfo> findInquisitionHeaderInfoByPage(int firstResult, int maxResult) {
		return inquisitionHeaderInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public List<InquisitionHeaderInfo> findPageByDelStatus(int firstResult,
			int maxResult) {
		
		return inquisitionHeaderInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
		
		return inquisitionHeaderInfoDao.getTotalByDelStatus();
	}

	@Override
	public int getNewShowOrder(Long inquisitionID) {		
		return inquisitionHeaderInfoDao.getNewShowOrder(inquisitionID);
	}

}
