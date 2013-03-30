package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IReqInfoService;
import org.xsaas.xstat.dao.IReqInfoDao;
import org.xsaas.xstat.po.ReqInfo;


public class ReqInfoService implements	IReqInfoService {

	private IReqInfoDao reqInfoDao = null;

	public void setReqInfoDao(IReqInfoDao reqInfoDao) {
		this.reqInfoDao = reqInfoDao;
	}

	@Override
	public void deleteReqInfo(ReqInfo data) {
		
		reqInfoDao.deleteReqInfo(data);
	}

	@Override
	public List<ReqInfo> findReqInfoByPage(int firstResult,
			int maxResult) {
		
		return reqInfoDao.findReqInfoByPage(firstResult, maxResult);
	}

	@Override
	public ReqInfo getReqInfo(Long reqID) {
		
		return reqInfoDao.getReqInfo(reqID);
	}

	@Override
	public List<ReqInfo> getReqInfoList() {
		
		return reqInfoDao.getReqInfoList();
	}

	@Override
	public int getReqInfoTotal() {
		
		return reqInfoDao.getReqInfoTotal();
	}

	@Override
	public void saveReqInfo(ReqInfo data) {
		
		reqInfoDao.saveReqInfo(data);
	}

	@Override
	public void updateReqInfo(ReqInfo data) {
		
		reqInfoDao.updateReqInfo(data);
	}

	@Override
	public List<ReqInfo> findPageByDelStatus(int firstResult, int maxResult) {
		
		return reqInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
		
		return reqInfoDao.getTotalByDelStatus();
	}

}
