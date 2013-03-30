package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.ISitePopedomInfoService;
import org.xsaas.xstat.dao.ISitePopedomInfoDao;
import org.xsaas.xstat.po.SitePopedomInfo;


public class SitePopedomInfoService implements ISitePopedomInfoService {

	private ISitePopedomInfoDao sitePopedomInfoDao = null;

	public void setSitePopedomInfoDao(ISitePopedomInfoDao sitePopedomInfoDao) {
		this.sitePopedomInfoDao = sitePopedomInfoDao;
	}

	@Override
	public void deleteSitePopedomInfo(SitePopedomInfo data) {
		
		sitePopedomInfoDao.delete(data);
	}

	@Override
	public List<SitePopedomInfo> findSitePopedomInfoByPage(int firstResult,
			int maxResult) {
		
		return sitePopedomInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public SitePopedomInfo getSitePopedomInfo(Long sitePopedomID) {
		
		return sitePopedomInfoDao.getSitePopedomInfo(sitePopedomID);
	}

	@Override
	public List<SitePopedomInfo> getSitePopedomInfoList() {
		
		return sitePopedomInfoDao.getSitePopedomInfoList();
	}

	@Override
	public int getSitePopedomInfoTotal() {
		
		return sitePopedomInfoDao.getTotal();
	}

	@Override
	public void saveSitePopedomInfo(SitePopedomInfo data) {
		sitePopedomInfoDao.save(data);
		
	}

	@Override
	public void updateSitePopedomInfo(SitePopedomInfo data) {
		sitePopedomInfoDao.update(data);
		
	}

	@Override
	public List<SitePopedomInfo> findSitePopedomInfoByPage(long employeeID,
			int firstResult, int maxResult) {
		
		return sitePopedomInfoDao.findSitePopedomInfoByPage(employeeID, firstResult, maxResult);
	}

	@Override
	public int getSitePopedomInfoTotal(long employeeID) {
	
		return sitePopedomInfoDao.getSitePopedomInfoTotal(employeeID);
	}

	@Override
	public List<SitePopedomInfo> findPageByDelStatus(int firstResult,
			int maxResult) {
		
		return sitePopedomInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
		
		return sitePopedomInfoDao.getTotalByDelStatus();
	}

	@Override
	public List<SitePopedomInfo> getSitePopedomInfoList(Long employeeID) {
	
		return sitePopedomInfoDao.getSitePopedomInfoList(employeeID);
	}
}
