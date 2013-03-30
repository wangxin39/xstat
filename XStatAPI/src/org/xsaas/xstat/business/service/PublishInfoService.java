package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IPublishInfoService;
import org.xsaas.xstat.dao.IPublishInfoDao;
import org.xsaas.xstat.po.PublishInfo;


public class PublishInfoService implements	IPublishInfoService {

	private IPublishInfoDao publishInfoDao =null;


	@Override
	public void deletePublishInfo(PublishInfo data) {
		
		publishInfoDao.delete(data);
	}


	@Override
	public PublishInfo getPublishInfo(Long qpID) {
		
		return publishInfoDao.getPublishInfo(qpID);
	}

	@Override
	public List<PublishInfo> getPublishInfoList() {
		
		return publishInfoDao.getPublishInfoList();
	}

	@Override
	public void updatePublishInfo(PublishInfo data) {
		
		publishInfoDao.update(data);
	}

	@Override
	public List<PublishInfo> findByPagePublishInfo(int firstResult, int maxResult) {
		
		return publishInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public int getTotalPublishInfo() {
		
		return publishInfoDao.getTotal();
	}

	public void setPublishInfoDao(IPublishInfoDao publishInfoDao) {
		this.publishInfoDao = publishInfoDao;
	}


	@Override
	public void savePublishInfo(PublishInfo data) {
		this.publishInfoDao.save(data);
	}


	@Override
	public List<PublishInfo> findByPage(int type, int firstResult, int maxResult) {
		
		return publishInfoDao.findByPage(type, firstResult, maxResult);
	}


	@Override
	public List<PublishInfo> findByPage(int type, Long smgkID, int firstResult,
			int maxResult) {
		
		return publishInfoDao.findByPage(type, smgkID, firstResult, maxResult);
	}


	@Override
	public int getTotal(int type) {
		
		return publishInfoDao.getTotal(type);
	}


	@Override
	public int getTotal(int type, Long smgkID) {
		
		return publishInfoDao.getTotal(type, smgkID);
	}


	@Override
	public List<PublishInfo> findPageByDelStatus(int firstResult, int maxResult) {
		
		return publishInfoDao.findPageByDelStatus(firstResult, maxResult);
	}


	@Override
	public int getTotalByDelStatus() {
		
		return publishInfoDao.getTotalByDelStatus();
	}

	
}
