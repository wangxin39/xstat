package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IStatChartInfoService;
import org.xsaas.xstat.dao.IStatChartInfoDao;
import org.xsaas.xstat.po.StatChartInfo;


public class StatChartInfoService implements IStatChartInfoService {

	private IStatChartInfoDao statChartInfoDao =null;


	@Override
	public void deleteStatChartInfo(StatChartInfo data) {
		
		statChartInfoDao.delete(data);
	}


	@Override
	public StatChartInfo getStatChartInfo(Long qpID) {
		
		return statChartInfoDao.getStatChartInfo(qpID);
	}

	@Override
	public List<StatChartInfo> getStatChartInfoList() {
		
		return statChartInfoDao.getStatChartInfoList();
	}

	@Override
	public void updateStatChartInfo(StatChartInfo data) {
		
		statChartInfoDao.update(data);
	}

	@Override
	public List<StatChartInfo> findByPageStatChartInfo(int firstResult, int maxResult) {
		
		return statChartInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public int getTotalStatChartInfo() {
		
		return statChartInfoDao.getTotal();
	}

	public void setStatChartInfoDao(IStatChartInfoDao statChartInfoDao) {
		this.statChartInfoDao = statChartInfoDao;
	}


	@Override
	public void saveStatChartInfo(StatChartInfo data) {
		this.statChartInfoDao.save(data);
	}

	
}
