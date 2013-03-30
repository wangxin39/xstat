package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IInquisitionTemplateInfoService;
import org.xsaas.xstat.dao.IInquisitionTemplateInfoDao;
import org.xsaas.xstat.po.InquisitionTemplateInfo;


public class InquisitionTemplateInfoService implements IInquisitionTemplateInfoService {
	private IInquisitionTemplateInfoDao inquisitionTemplateInfoDao = null;

	public void setInquisitionTemplateInfoDao(IInquisitionTemplateInfoDao inquisitionTemplateInfoDao) {
		this.inquisitionTemplateInfoDao = inquisitionTemplateInfoDao;
	}

	@Override
	public void deleteInquisitionTemplateInfo(InquisitionTemplateInfo data) {
		
		inquisitionTemplateInfoDao.delete(data);		
	}

	@Override
	public List<InquisitionTemplateInfo> findInquisitionTemplateInfoByPage(int firstResult,
			int maxResult) {
		
		return inquisitionTemplateInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public InquisitionTemplateInfo getInquisitionTemplateInfo(Long multiLangID) {
		
		return inquisitionTemplateInfoDao.getInquisitionTemplateInfo(multiLangID);
	}

	@Override
	public List<InquisitionTemplateInfo> getInquisitionTemplateInfoList() {
		
		return inquisitionTemplateInfoDao.getInquisitionTemplateInfoList();
	}

	@Override
	public int getInquisitionTemplateInfoTotal() {
		
		return inquisitionTemplateInfoDao.getTotal();
	}

	@Override
	public void saveInquisitionTemplateInfo(InquisitionTemplateInfo data) {
		
		inquisitionTemplateInfoDao.save(data);
	}

	@Override
	public void updateInquisitionTemplateInfo(InquisitionTemplateInfo data) {
		
		inquisitionTemplateInfoDao.update(data);
	}

	@Override
	public List<InquisitionTemplateInfo> findPageByDelStatus(int firstResult,
			int maxResult) {
		
		return inquisitionTemplateInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
		
		return inquisitionTemplateInfoDao.getTotalByDelStatus();
	}

}
