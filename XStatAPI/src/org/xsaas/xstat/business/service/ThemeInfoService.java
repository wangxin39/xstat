package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IThemeInfoService;
import org.xsaas.xstat.dao.IThemeInfoDao;
import org.xsaas.xstat.po.ThemeInfo;


public class ThemeInfoService implements IThemeInfoService {

	private IThemeInfoDao themeInfoDao = null;
	public void setThemeInfoDao(IThemeInfoDao themeInfoDao) {
		this.themeInfoDao = themeInfoDao;
	}

	@Override
	public void deleteThemeInfo(ThemeInfo data) {
		
		themeInfoDao.delete(data);
	}

	@Override
	public List<ThemeInfo> findThemeInfoByPage(int firstResult, int maxResult) {
		
		return themeInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public ThemeInfo getThemeInfo(Long translateID) {
		
		return themeInfoDao.getThemeInfo(translateID);
	}

	@Override
	public List<ThemeInfo> getThemeInfoList() {
		
		return themeInfoDao.getThemeInfoList();
	}

	@Override
	public int getThemeInfoTotal() {
		
		return themeInfoDao.getTotal();
	}

	@Override
	public void saveThemeInfo(ThemeInfo data) {
		
		themeInfoDao.save(data);	
	}

	@Override
	public void updateThemeInfo(ThemeInfo data) {
		
		themeInfoDao.update(data);
	}

	@Override
	public List<ThemeInfo> findPageByDelStatus(int firstResult, int maxResult) {
		
		return themeInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
		
		return themeInfoDao.getTotalByDelStatus();
	}

}
