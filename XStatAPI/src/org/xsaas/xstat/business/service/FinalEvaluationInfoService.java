package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IFinalEvaluationInfoService;
import org.xsaas.xstat.dao.IFinalEvaluationInfoDao;
import org.xsaas.xstat.po.FinalEvaluationInfo;


public class FinalEvaluationInfoService implements IFinalEvaluationInfoService {

	private IFinalEvaluationInfoDao finalEvaluationInfoDao =null;

	public void setFinalEvaluationInfoDao(
			IFinalEvaluationInfoDao finalEvaluationInfoDao) {
		this.finalEvaluationInfoDao = finalEvaluationInfoDao;
	}

	@Override
	public void deleteFinalEvaluationInfo(FinalEvaluationInfo data) {
	
		finalEvaluationInfoDao.delete(data);
	}

	@Override
	public List<FinalEvaluationInfo> findFinalEvaluationInfoByPage(
			int firstResult, int maxResult) {
	
		return finalEvaluationInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public FinalEvaluationInfo getFinalEvaluationInfo(Long gradeID) {
	
		return finalEvaluationInfoDao.getFinalEvaluationInfo(gradeID);
	}

	@Override
	public List<FinalEvaluationInfo> getFinalEvaluationInfoList() {
	
		return finalEvaluationInfoDao.getFinalEvaluationInfoList();
	}

	@Override
	public int getFinalEvaluationInfoTotal() {
	
		return finalEvaluationInfoDao.getTotal();
	}

	@Override
	public void saveFinalEvaluationInfo(FinalEvaluationInfo data) {
	
		finalEvaluationInfoDao.save(data);
	}

	@Override
	public void updateFinalEvaluationInfo(FinalEvaluationInfo data) {
	
		finalEvaluationInfoDao.update(data);
	}
}
