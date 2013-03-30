package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IInquisitionInfoService;
import org.xsaas.xstat.dao.IInquisitionInfoDao;
import org.xsaas.xstat.po.InquisitionInfo;


public class InquisitionInfoService implements IInquisitionInfoService {
	private IInquisitionInfoDao inquisitionInfoDao = null;

	public void setInquisitionInfoDao(IInquisitionInfoDao inquisitionInfoDao) {
		this.inquisitionInfoDao = inquisitionInfoDao;
	}

	@Override
	public void deleteInquisitionInfo(InquisitionInfo data) {
		
		inquisitionInfoDao.delete(data);		
	}

	@Override
	public List<InquisitionInfo> findInquisitionInfoByPage(int firstResult,
			int maxResult) {
		
		return inquisitionInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public InquisitionInfo getInquisitionInfo(Long multiLangID) {
		
		return inquisitionInfoDao.getInquisitionInfo(multiLangID);
	}

	@Override
	public List<InquisitionInfo> getInquisitionInfoList() {
		
		return inquisitionInfoDao.getInquisitionInfoList();
	}

	@Override
	public int getInquisitionInfoTotal() {
		
		return inquisitionInfoDao.getTotal();
	}

	@Override
	public void saveInquisitionInfo(InquisitionInfo data) {
		
		inquisitionInfoDao.save(data);
	}

	@Override
	public void updateInquisitionInfo(InquisitionInfo data) {
		
		inquisitionInfoDao.update(data);
	}

	@Override
	public List<InquisitionInfo> findByPage(int status,	int firstResult, int maxResult) {		
		return inquisitionInfoDao.findByPage(status,firstResult, maxResult);
	}

	@Override
	public int getTotal(int status) {
		return inquisitionInfoDao.getTotal(status);
	}

	@Override
	public List<InquisitionInfo> getInquisitionInfoList(Long clientID) {
		
		return inquisitionInfoDao.getList(clientID);
	}

	@Override
	public List<InquisitionInfo> findPageByDelStatus(int firstResult,
			int maxResult) {
		
		return inquisitionInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
		
		return inquisitionInfoDao.getTotalByDelStatus();
	}

}
