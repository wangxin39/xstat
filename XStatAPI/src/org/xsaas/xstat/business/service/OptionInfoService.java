package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IOptionInfoService;
import org.xsaas.xstat.dao.IOptionInfoDao;
import org.xsaas.xstat.po.OptionInfo;


public class OptionInfoService implements IOptionInfoService {

	private IOptionInfoDao optionInfoDao = null;

	public void setOptionInfoDao(IOptionInfoDao optionInfoDao) {
		this.optionInfoDao = optionInfoDao;
	}

	@Override
	public void delete(OptionInfo data) {	
		optionInfoDao.delete(data);
	}

	@Override
	public List<OptionInfo> findByPage(int firstResult, int maxResult) {		
		return optionInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public OptionInfo getOptionInfo(Long optionID) {	
		return optionInfoDao.getOptionInfo(optionID);
	}

	@Override
	public List<OptionInfo> getList(Integer type) {	
		return optionInfoDao.getList(type);
	}

	@Override
	public int getTotal() {	
		return optionInfoDao.getTotal();
	}

	@Override
	public void save(OptionInfo data) {	
		optionInfoDao.save(data);
	}

	@Override
	public void update(OptionInfo data) {	
		optionInfoDao.update(data);
	}
	@Override
	public List<OptionInfo> findPageByDelStatus(int firstResult,
			int maxResult) {	
		return optionInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {	
		return optionInfoDao.getTotalByDelStatus();
	}
}
