package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IInformantInfoService;
import org.xsaas.xstat.dao.IInformantInfoDao;
import org.xsaas.xstat.po.InformantInfo;


public class InformantInfoService implements IInformantInfoService {

	private IInformantInfoDao informantInfoDao = null;

	public void setInformantInfoDao(IInformantInfoDao informantInfoDao) {
		this.informantInfoDao = informantInfoDao;
	}

	@Override
	public void deleteInformantInfo(InformantInfo data) {
		
		informantInfoDao.deleteInformantInfo(data);
	}

	@Override
	public List<InformantInfo> findInformantInfoByPage(int firstResult,
			int maxResult) {
		
		return informantInfoDao.findInformantInfoByPage(firstResult, maxResult);
	}

	@Override
	public InformantInfo getInformantInfo(Long informantID) {
		
		return informantInfoDao.getInformantInfo(informantID);
	}

	@Override
	public List<InformantInfo> getInformantInfoList() {
		
		return informantInfoDao.getInformantInfoList();
	}

	@Override
	public int getInformantInfoTotal() {
		
		return informantInfoDao.getInformantInfoTotal();
	}

	@Override
	public void saveInformantInfo(InformantInfo data) {
		
		informantInfoDao.saveInformantInfo(data);
	}

	@Override
	public void updateInformantInfo(InformantInfo data) {
		
		informantInfoDao.updateInformantInfo(data);
	}


	@Override
	public List<InformantInfo> findInformantInfoByPage(
			long clientID, int firstResult, int maxResult) {
		return informantInfoDao.findInformantInfoByPage(clientID, firstResult, maxResult);
	}

	@Override
	public int getInformantInfoTotal(long informantID, long clientID) {
		
		return informantInfoDao.getInformantInfoTotal(informantID, clientID);
	}

	@Override
	public int getInformantInfoTotal(long clientID) {
		
		return informantInfoDao.getInformantInfoTotal(clientID);
	}

	@Override
	public List<InformantInfo> getInformantInfoList(Long clientID) {		
		return informantInfoDao.getInformantInfoList(clientID);
	}

	@Override
	public List<InformantInfo> findPageByDelStatus(int firstResult,
			int maxResult) {
		
		return informantInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
		
		return informantInfoDao.getTotalByDelStatus();
	}
}
