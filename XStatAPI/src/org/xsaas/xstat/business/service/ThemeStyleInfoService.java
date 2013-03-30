package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IThemeStyleInfoService;
import org.xsaas.xstat.dao.IThemeStyleInfoDao;
import org.xsaas.xstat.po.ThemeStyleInfo;


public class ThemeStyleInfoService implements	IThemeStyleInfoService {

	private IThemeStyleInfoDao themeStyleInfoDao =null;


	@Override
	public void deleteThemeStyleInfo(ThemeStyleInfo data) {
		
		themeStyleInfoDao.delete(data);
	}


	@Override
	public ThemeStyleInfo getThemeStyleInfo(Long qpID) {
		
		return themeStyleInfoDao.getThemeStyleInfo(qpID);
	}

	@Override
	public List<ThemeStyleInfo> getThemeStyleInfoList() {
		
		return themeStyleInfoDao.getThemeStyleInfoList();
	}

	@Override
	public void updateThemeStyleInfo(ThemeStyleInfo data) {
		
		themeStyleInfoDao.update(data);
	}

	@Override
	public List<ThemeStyleInfo> findThemeStyleInfoByPage(int firstResult, int maxResult) {
		
		return themeStyleInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public int getThemeStyleInfoTotal() {
		
		return themeStyleInfoDao.getTotal();
	}

	public void setThemeStyleInfoDao(IThemeStyleInfoDao themeStyleInfoDao) {
		this.themeStyleInfoDao = themeStyleInfoDao;
	}


	@Override
	public void saveThemeStyleInfo(ThemeStyleInfo data) {
		this.themeStyleInfoDao.save(data);
	}


	@Override
	public List<ThemeStyleInfo> findPageByDelStatus(int firstResult,
			int maxResult) {
		
		return themeStyleInfoDao.findPageByDelStatus(firstResult, maxResult);
	}


	@Override
	public int getTotalByDelStatus() {
		
		return themeStyleInfoDao.getTotalByDelStatus();
	}

}
