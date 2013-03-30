package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IReqResultInfoService;
import org.xsaas.xstat.dao.IReqResultInfoDao;
import org.xsaas.xstat.po.ReqResultInfo;


public class ReqResultInfoService implements	IReqResultInfoService {
	private IReqResultInfoDao reqResultInfoDao = null;

	public void setReqResultInfoDao(IReqResultInfoDao reqResultInfoDao) {
		this.reqResultInfoDao = reqResultInfoDao;
	}

	@Override
	public void deleteReqResultInfo(ReqResultInfo data) {
		
		reqResultInfoDao.deleteReqResultInfo(data);
	}

	@Override
	public List<ReqResultInfo> findReqResultInfoByPage(int firstResult, int maxResult) {
		
		return reqResultInfoDao.findReqResultInfoByPage(firstResult, maxResult);
	}

	@Override
	public ReqResultInfo getReqResultInfo(Long reqResultID) {
		
		return reqResultInfoDao.getReqResultInfo(reqResultID);
	}

	@Override
	public List<ReqResultInfo> getReqResultInfoList() {
		
		return reqResultInfoDao.getReqResultInfoList();
	}

	@Override
	public int getReqResultInfoTotal() {
		
		return reqResultInfoDao.getReqResultInfoTotal();
	}

	@Override
	public void saveReqResultInfo(ReqResultInfo data) {
		
		reqResultInfoDao.saveReqResultInfo(data);
	}

	@Override
	public void updateReqResultInfo(ReqResultInfo data) {
		
		reqResultInfoDao.updateReqResultInfo(data);
	}

	@Override
	public ReqResultInfo findReqResultInfoBySmgk(long smgkID) {
		
		return reqResultInfoDao.findReqResultInfoBySmgk(smgkID);
	}

	@Override
	public List<ReqResultInfo> findReqResultInfoByReq(Long reqID) {
	
		return reqResultInfoDao.findReqResultInfoByReq(reqID);
	}

	@Override
	public List<ReqResultInfo> findPageByDelStatus(int firstResult,
			int maxResult) {
		
		return reqResultInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
		
		return reqResultInfoDao.getTotalByDelStatus();
	}

}
