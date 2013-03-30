package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IClientAccountInfoService;
import org.xsaas.xstat.dao.IClientAccountInfoDao;
import org.xsaas.xstat.po.ClientAccountInfo;


public class ClientAccountInfoService implements IClientAccountInfoService {

	private IClientAccountInfoDao clientAccountInfoDao = null;

	public void setClientAccountInfoDao(IClientAccountInfoDao clientAccountInfoDao) {
		this.clientAccountInfoDao = clientAccountInfoDao;
	}

	@Override
	public void deleteClientAccountInfo(ClientAccountInfo data) {
		
		clientAccountInfoDao.deleteClientAccountInfo(data);
	}

	@Override
	public List<ClientAccountInfo> findClientAccountInfoByPage(int firstResult,
			int maxResult) {
		
		return clientAccountInfoDao.findClientAccountInfoByPage(firstResult, maxResult);
	}

	@Override
	public ClientAccountInfo getClientAccountInfo(Long clientID) {
		
		return clientAccountInfoDao.getClientAccountInfo(clientID);
	}

	@Override
	public List<ClientAccountInfo> getClientAccountInfoList() {
		
		return clientAccountInfoDao.getClientAccountInfoList();
	}

	@Override
	public int getClientAccountInfoTotal() {
		
		return clientAccountInfoDao.getClientAccountInfoTotal();
	}

	@Override
	public void saveClientAccountInfo(ClientAccountInfo data) {
		
		clientAccountInfoDao.saveClientAccountInfo(data);
	}

	@Override
	public void updateClientAccountInfo(ClientAccountInfo data) {
		
		clientAccountInfoDao.updateClientAccountInfo(data);
	}

	@Override
	public List<ClientAccountInfo> findClientAccountInfoByPage(int account,
			int firstResult, int maxResult) {		
		return clientAccountInfoDao.findClientAccountInfoByPage(account, firstResult, maxResult);
	}

	@Override
	public int getClientAccountInfoTotal(int account) {
		return clientAccountInfoDao.getClientAccountInfoTotal(account);
	}

	@Override
	public List<ClientAccountInfo> getClientAccountInfoList(Long clientID,
			Long informantID) {
		return clientAccountInfoDao.getClientAccountInfoList(clientID, informantID);
	}

	@Override
	public List<ClientAccountInfo> findClientAccountInfoByPage(Long clientID,
			int firstResult, int maxResult) {
		
		return clientAccountInfoDao.findClientAccountInfoByPage(clientID, firstResult, maxResult);
	}

	@Override
	public int getClientAccountInfoTotal(Long clientID) {
		
		return clientAccountInfoDao.getClientAccountInfoTotal(clientID);
	}

	@Override
	public ClientAccountInfo isLogin(String loginname, String password) {
		
		return clientAccountInfoDao.isLogin(loginname, password);
	}

	@Override
	public boolean isRegister(String loginname, String password) {
		
		return clientAccountInfoDao.isRegister(loginname, password);
	}

	@Override
	public List<ClientAccountInfo> findPageByDelStatus(int firstResult,
			int maxResult) {
		
		return clientAccountInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
		
		return clientAccountInfoDao.getTotalByDelStatus();
	}

}
