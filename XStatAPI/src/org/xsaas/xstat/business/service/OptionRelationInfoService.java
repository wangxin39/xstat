package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IOptionRelationInfoService;
import org.xsaas.xstat.dao.IOptionRelationInfoDao;
import org.xsaas.xstat.po.OptionRelationInfo;


public class OptionRelationInfoService implements IOptionRelationInfoService {
	private IOptionRelationInfoDao optionRelationInfoDao = null;

	public void setOptionRelationInfoDao(
			IOptionRelationInfoDao optionRelationInfoDao) {
		this.optionRelationInfoDao = optionRelationInfoDao;
	}

	@Override
	public void delete(OptionRelationInfo data) {
		optionRelationInfoDao.delete(data);	
	}

	@Override
	public List<OptionRelationInfo> getList(int firstResult, int maxResult) {
		return optionRelationInfoDao.getList(firstResult, maxResult);
	}

	@Override
	public OptionRelationInfo getOptionRelationInfo(Long optionRelationID) {
		return optionRelationInfoDao.getOptionRelationInfo(optionRelationID);
	}

	@Override
	public int getTotal() {
		return optionRelationInfoDao.getTotal();
	}

	@Override
	public void save(OptionRelationInfo data) {
		optionRelationInfoDao.save(data);		
	}

	@Override
	public void update(OptionRelationInfo data) {
		optionRelationInfoDao.update(data);		
	}

	@Override
	public List<OptionRelationInfo> getList(Long optionTemplateID) {		
		return this.optionRelationInfoDao.getList(optionTemplateID);
	}
}
