package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IClientPopedomInfoService;
import org.xsaas.xstat.dao.IClientPopedomInfoDao;
import org.xsaas.xstat.po.ClientPopedomInfo;


public class ClientPopedomInfoService implements IClientPopedomInfoService {

	private IClientPopedomInfoDao clientPopedomInfoDao = null;

	public void setClientPopedomInfoDao(
			IClientPopedomInfoDao clientPopedomInfoDao) {
		this.clientPopedomInfoDao = clientPopedomInfoDao;
	}

	@Override
	public void deleteClientPopedomInfo(ClientPopedomInfo data) {
		
		clientPopedomInfoDao.deleteClientPopedomInfo(data);
	}

	@Override
	public List<ClientPopedomInfo> findClientPopedomInfoByPage(
			int firstResult, int maxResult) {
		
		return clientPopedomInfoDao.findClientPopedomInfoByPage(firstResult, maxResult);
	}

	@Override
	public ClientPopedomInfo getClientPopedomInfo(Long clientPopedomID) {
		
		return clientPopedomInfoDao.getClientPopedomInfo(clientPopedomID);
	}

	@Override
	public List<ClientPopedomInfo> getClientPopedomInfoList() {
		
		return clientPopedomInfoDao.getClientPopedomInfoList();
	}

	@Override
	public int getClientPopedomInfoTotal() {
		
		return clientPopedomInfoDao.getClientPopedomInfoTotal();
	}

	@Override
	public void saveClientPopedomInfo(ClientPopedomInfo data) {
		
		clientPopedomInfoDao.saveClientPopedomInfo(data);
	}

	@Override
	public void updateClientPopedomInfo(ClientPopedomInfo data) {
		
		clientPopedomInfoDao.updateClientPopedomInfo(data);
	}

	@Override
	public List<ClientPopedomInfo> findPageByDelStatus(int firstResult,
			int maxResult) {
		
		return clientPopedomInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
		
		return clientPopedomInfoDao.getTotalByDelStatus();
	}

}
