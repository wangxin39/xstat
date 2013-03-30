package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IOptionTemplateInfoService;
import org.xsaas.xstat.dao.IOptionTemplateInfoDao;
import org.xsaas.xstat.po.OptionTemplateInfo;


public class OptionTemplateInfoService implements IOptionTemplateInfoService {
	private IOptionTemplateInfoDao optionTemplateInfoDao = null;

	public void setOptionTemplateInfoDao(
			IOptionTemplateInfoDao optionTemplateInfoDao) {
		this.optionTemplateInfoDao = optionTemplateInfoDao;
	}

	@Override
	public void delete(OptionTemplateInfo data) {
		optionTemplateInfoDao.delete(data);		
	}

	@Override
	public List<OptionTemplateInfo> getList(int firstResult, int maxResult) {
		return optionTemplateInfoDao.getList(firstResult, maxResult);
	}

	@Override
	public OptionTemplateInfo getOptionTemplateInfo(Long optionTemplateID) {
		return optionTemplateInfoDao.getOptionTemplateInfo(optionTemplateID);
	}

	@Override
	public int getTotal() {
		return optionTemplateInfoDao.getTotal();
	}

	@Override
	public void save(OptionTemplateInfo data) {
		optionTemplateInfoDao.save(data);		
	}

	@Override
	public void update(OptionTemplateInfo data) {
		optionTemplateInfoDao.update(data);		
	}
}
