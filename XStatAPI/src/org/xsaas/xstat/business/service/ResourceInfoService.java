package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IResourceInfoService;
import org.xsaas.xstat.dao.IResourceInfoDao;
import org.xsaas.xstat.po.ResourceInfo;


public class ResourceInfoService implements IResourceInfoService {
	private IResourceInfoDao resourceInfoDao = null;

	public void setResouceInfoDao(IResourceInfoDao resourceInfoDao) {
		this.resourceInfoDao = resourceInfoDao;
	}

	@Override
	public void delete(ResourceInfo data) {		
		resourceInfoDao.delete(data);
	}

	@Override
	public List<ResourceInfo> findByPage(int firstResult,
			int maxResult) {		
		return resourceInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public ResourceInfo getResourceInfo(Long resourceID) {		
		return resourceInfoDao.getResourceInfo(resourceID);
	}

	@Override
	public List<ResourceInfo> getList() {		
		return resourceInfoDao.getList();
	}

	@Override
	public int getTotal() {		
		return resourceInfoDao.getTotal();
	}

	@Override
	public void save(ResourceInfo data) {		
		resourceInfoDao.save(data);
	}

	@Override
	public void update(ResourceInfo data) {		
		resourceInfoDao.update(data);
	}

	@Override
	public List<ResourceInfo> findPageByDelStatus(int firstResult,
			int maxResult) {	
		return resourceInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {	
		return resourceInfoDao.getTotalByDelStatus();
	}
	
}
