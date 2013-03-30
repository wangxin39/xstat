package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.ICityInfoService;
import org.xsaas.xstat.dao.ICityInfoDao;
import org.xsaas.xstat.po.CityInfo;


public class CityInfoService implements ICityInfoService {
	private ICityInfoDao cityInfoDao = null;

	public void setCityInfoDao(ICityInfoDao cityInfoDao) {
		this.cityInfoDao = cityInfoDao;
	}

	@Override
	public void deleteCityInfo(CityInfo data) {
		
		cityInfoDao.deleteCityInfo(data);
	}

	@Override
	public List<CityInfo> findCityInfoByPage(int firstResult, int maxResult) {
		
		return cityInfoDao.findCityInfoByPage(firstResult, maxResult);
	}

	@Override
	public CityInfo getCityInfo(Long cityID) {
		
		return cityInfoDao.getCityInfo(cityID);
	}

	@Override
	public List<CityInfo> getCityInfoList() {
		
		return cityInfoDao.getCityInfoList();
	}

	@Override
	public int getCityInfoTotal() {
		
		return cityInfoDao.getCityInfoTotal();
	}

	@Override
	public void saveCityInfo(CityInfo data) {
		
		cityInfoDao.saveCityInfo(data);
	}

	@Override
	public void updateCityInfo(CityInfo data) {
		
		cityInfoDao.updateCityInfo(data);
	}

	@Override
	public List<CityInfo> findCityInfoByPage(int province, int firstResult,
			int maxResult) {		
		return this.cityInfoDao.findCityInfoByPage(province, firstResult, maxResult);
	}

	@Override
	public int getCityInfoTotal(int province) {
		return this.cityInfoDao.getCityInfoTotal(province);
	}

	@Override
	public List<CityInfo> getCityInfoList(int province) {
		
		return cityInfoDao.getCityInfoList(province);
	}

	@Override
	public List<CityInfo> findPageByDelStatus(int firstResult, int maxResult) {
		
		return cityInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
		
		return cityInfoDao.getTotalByDelStatus();
	}

}
