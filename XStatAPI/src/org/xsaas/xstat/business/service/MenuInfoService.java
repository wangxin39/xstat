package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IMenuInfoService;
import org.xsaas.xstat.dao.IMenuInfoDao;
import org.xsaas.xstat.po.MenuInfo;


public class MenuInfoService implements IMenuInfoService {
	private IMenuInfoDao menuInfoDao = null;

	public void setMenuInfoDao(IMenuInfoDao menuInfoDao) {
		this.menuInfoDao = menuInfoDao;
	}

	@Override
	public void deleteMenuInfo(MenuInfo data) {
		menuInfoDao.delete(data);		
	}

	@Override
	public MenuInfo getMenuInfo(Long menuID) {
		return menuInfoDao.getMenuInfo(menuID);
	}

	@Override
	public List<MenuInfo> getMenuInfoList(Long parentID, int type) {
		return menuInfoDao.getMenuInfoList(parentID, type);
	}

	@Override
	public void saveMenuInfo(MenuInfo data) {
		menuInfoDao.save(data);	
	}

	@Override
	public void updateMenuInfo(MenuInfo data) {
		menuInfoDao.update(data);		
	}

	@Override
	public List<MenuInfo> findMenuInfoByPage(int firstResult, int maxResult) {
		
		return menuInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public int getMenuInfoTotal() {
		
		return menuInfoDao.getTotal();
	}

	@Override
	public List<MenuInfo> findPageByDelStatus(int firstResult, int maxResult) {
		
		return menuInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
		
		return menuInfoDao.getTotalByDelStatus();
	}
}
