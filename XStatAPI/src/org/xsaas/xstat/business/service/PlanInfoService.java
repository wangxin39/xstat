package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IPlanInfoService;
import org.xsaas.xstat.dao.IPlanInfoDao;
import org.xsaas.xstat.po.PlanInfo;


public class PlanInfoService implements IPlanInfoService {

	private IPlanInfoDao planInfoDao =null;

	public void setPlanInfoDao(IPlanInfoDao planInfoDao) {
		this.planInfoDao = planInfoDao;
	}

	@Override
	public void deletePlanInfo(PlanInfo data) {
		
		planInfoDao.delete(data);
	}

	@Override
	public List<PlanInfo> findPlanInfoByPage(int firstResult,
			int maxResult) {
		
		return planInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public PlanInfo getPlanInfo(Long planID) {
		
		return planInfoDao.getPlanInfo(planID);
	}

	@Override
	public List<PlanInfo> getPlanInfoList() {
		
		return planInfoDao.getPlanInfoList();
	}

	@Override
	public int getPlanInfoTotal() {
		
		return planInfoDao.getTotal();
	}

	@Override
	public void savePlanInfo(PlanInfo data) {
		
		planInfoDao.save(data);
	}

	@Override
	public void updatePlanInfo(PlanInfo data) {
		
		planInfoDao.update(data);
	}

	@Override
	public List<PlanInfo> findByClientPage(long clientID, int type,
			int firstResult, int maxResult) {		
		return planInfoDao.findByClientPage(clientID, type, firstResult, maxResult);
	}

	@Override
	public List<PlanInfo> findByPage(long smgkID, int type, int firstResult,
			int maxResult) {		
		return planInfoDao.findByPage(smgkID, type, firstResult, maxResult);
	}

	@Override
	public int getClientTotal(long clientID, int type) {
		return planInfoDao.getClientTotal(clientID, type);
	}

	@Override
	public int getTotal(long smgkID, int type) {	
		return planInfoDao.getTotal(smgkID, type);
	}

	@Override
	public List<PlanInfo> findPlanByPage(long clientID, long smgkID,
			long inquisitionID, int firstResult, int maxResult) {
		
		return planInfoDao.findByPage(clientID, smgkID, inquisitionID, firstResult, maxResult);
	}

	@Override
	public int getPlanTotal(long clientID, long smgkID, long inquisitionID) {
		
		return planInfoDao.getTotal(clientID, smgkID, inquisitionID);
	}

	@Override
	public List<PlanInfo> findByAccount(Long accountID) {		
		return planInfoDao.findByAccount(accountID);
	}

	@Override
	public List<PlanInfo> findByClient(Long clientID) {
		return planInfoDao.findByClient(clientID);
	}

	@Override
	public List<PlanInfo> findBySmgk(Long smgkID) {
		return planInfoDao.findBySmgk(smgkID);
	}

	@Override
	public List<PlanInfo> findBySmgk(Long smgkID, int inquisitionType) {
		return planInfoDao.findBySmgk(smgkID, inquisitionType);
	}

	@Override
	public List<PlanInfo> findByIssue(Long issueID) {		
		return planInfoDao.findByIssue(issueID);
	}

	@Override
	public List<PlanInfo> findPageByDelStatus(int firstResult, int maxResult) {
		
		return planInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
		
		return planInfoDao.getTotalByDelStatus();
	}

	
}
