package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IClientInfoService;
import org.xsaas.xstat.dao.IClientInfoDao;
import org.xsaas.xstat.po.ClientInfo;


public class ClientInfoService implements	IClientInfoService {

	private IClientInfoDao clientInfoDao = null;

	public void setClientInfoDao(IClientInfoDao clientInfoDao) {
		this.clientInfoDao = clientInfoDao;
	}

	@Override
	public void deleteClientInfo(ClientInfo data) {
		
		clientInfoDao.deleteClientInfo(data);
	}

	@Override
	public List<ClientInfo> findClientInfoByPage(int firstResult,
			int maxResult) {
		
		return clientInfoDao.findClientInfoByPage(firstResult, maxResult);
	}

	@Override
	public ClientInfo getClientInfo(Long clientID) {
		
		return clientInfoDao.getClientInfo(clientID);
	}

	@Override
	public List<ClientInfo> getClientInfoList() {
		
		return clientInfoDao.getClientInfoList();
	}

	@Override
	public int getClientInfoTotal() {
		
		return clientInfoDao.getClientInfoTotal();
	}

	@Override
	public void saveClientInfo(ClientInfo data) {
		
		clientInfoDao.saveClientInfo(data);
	}

	@Override
	public void updateClientInfo(ClientInfo data) {
		
		clientInfoDao.updateClientInfo(data);
	}

	@Override
	public List<ClientInfo> findPageByDelStatus(int firstResult, int maxResult) {
		
		return clientInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
		
		return clientInfoDao.getTotalByDelStatus();
	}

}
