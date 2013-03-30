package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IHeaderRecordInfoService;
import org.xsaas.xstat.dao.IHeaderRecordInfoDao;
import org.xsaas.xstat.po.HeaderRecordInfo;


public class HeaderRecordInfoService implements IHeaderRecordInfoService {
	private IHeaderRecordInfoDao headerRecordInfoDao = null;

	public void setHeaderRecordInfoDao(IHeaderRecordInfoDao headerRecordInfoDao) {
		this.headerRecordInfoDao = headerRecordInfoDao;
	}

	@Override
	public void deleteHeaderRecordInfo(HeaderRecordInfo data) {
		
		headerRecordInfoDao.delete(data);		
	}

	@Override
	public List<HeaderRecordInfo> findHeaderRecordInfoByPage(int firstResult,int maxResult) {
		
		return headerRecordInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public HeaderRecordInfo getHeaderRecordInfo(Long ihID) {
		
		return headerRecordInfoDao.getInfo(ihID);
	}

	@Override
	public List<HeaderRecordInfo> getHeaderRecordInfoList() {
		
		return headerRecordInfoDao.getList();
	}

	@Override
	public int getHeaderRecordInfoTotal() {
		
		return headerRecordInfoDao.getTotal();
	}

	@Override
	public void saveHeaderRecordInfo(HeaderRecordInfo data) {
		
		headerRecordInfoDao.save(data);
	}

	@Override
	public void updateHeaderRecordInfo(HeaderRecordInfo data) {
		
		headerRecordInfoDao.update(data);
	}

}
