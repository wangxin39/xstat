package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IInformantEvaluationInfoService;
import org.xsaas.xstat.dao.IInformantEvaluationInfoDao;
import org.xsaas.xstat.po.InformantEvaluationInfo;


public class InformantEvaluationInfoService implements IInformantEvaluationInfoService {
	private IInformantEvaluationInfoDao informantEvaluationInfoDao = null;

	@Override
	public void delete(InformantEvaluationInfo data) {		
		informantEvaluationInfoDao.delete(data);		
	}

	@Override
	public List<InformantEvaluationInfo> findByPage(int firstResult,int maxResult) {		
		return informantEvaluationInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public InformantEvaluationInfo getInformantEvaluationInfo(Long multiLangID) {		
		return informantEvaluationInfoDao.getInformantEvaluationInfo(multiLangID);
	}

	@Override
	public List<InformantEvaluationInfo> getInformantEvaluationInfoList() {		
		return informantEvaluationInfoDao.getInformantEvaluationInfoList();
	}

	@Override
	public int getTotal() {		
		return informantEvaluationInfoDao.getTotal();
	}

	@Override
	public void save(InformantEvaluationInfo data) {		
		informantEvaluationInfoDao.save(data);
	}

	@Override
	public void update(InformantEvaluationInfo data) {		
		informantEvaluationInfoDao.update(data);
	}

	public void setInformantEvaluationInfoDao(
			IInformantEvaluationInfoDao informantEvaluationInfoDao) {
		this.informantEvaluationInfoDao = informantEvaluationInfoDao;
	}

	@Override
	public List<InformantEvaluationInfo> findByInformant(Long issueID, Long informantID) {
		return this.informantEvaluationInfoDao.findByInformant(issueID, informantID);
	}

}
