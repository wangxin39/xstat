package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IAddressCatalogInfoService;
import org.xsaas.xstat.po.AddressCatalogInfo;


public class AddressCatalogInfoService implements IAddressCatalogInfoService {
	private org.xsaas.xstat.dao.IAddressCatalogInfoDao addressCatalogInfoDao = null;

	public void setAddressCatalogInfoDao(
			org.xsaas.xstat.dao.IAddressCatalogInfoDao addressCatalogInfoDao) {
		this.addressCatalogInfoDao = addressCatalogInfoDao;
	}

	@Override
	public void deleteAddressCatalogInfo(AddressCatalogInfo data) {
		addressCatalogInfoDao.deleteAddressCatalogInfo(data);
	}

	@Override
	public List<AddressCatalogInfo> findAddressCatalogInfoByPage(
			int firstResult, int maxResult) {
		return addressCatalogInfoDao.findAddressCatalogInfoByPage(firstResult, maxResult);
	}

	@Override
	public AddressCatalogInfo getAddressCatalogInfo(Long acID) {
		return addressCatalogInfoDao.getAddressCatalogInfo(acID);
	}

	@Override
	public List<AddressCatalogInfo> getAddressCatalogInfoList() {
		return addressCatalogInfoDao.getAddressCatalogInfoList();
	}

	@Override
	public int getAddressCatalogInfoTotal() {
		
		return addressCatalogInfoDao.getAddressCatalogInfoTotal();
	}

	@Override
	public void saveAddressCatalogInfo(AddressCatalogInfo data) {
		
		addressCatalogInfoDao.saveAddressCatalogInfo(data);
	}

	@Override
	public void updateAddressCatalogInfo(AddressCatalogInfo data) {
		
		addressCatalogInfoDao.updateAddressCatalogInfo(data);
	}

	@Override
	public List<AddressCatalogInfo> findPageByDelStatus(int firstResult,
			int maxResult) {
		
		return addressCatalogInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
		
		return addressCatalogInfoDao.getTotalByDelStatus();
	}
	
}
