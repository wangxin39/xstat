package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IGradeRelationInfoService;
import org.xsaas.xstat.dao.IGradeRelationInfoDao;
import org.xsaas.xstat.po.GradeRelationInfo;


public class GradeRelationInfoService implements IGradeRelationInfoService {
	private IGradeRelationInfoDao gradeRelationInfoDao = null;

	public void setGradeRelationInfoDao(IGradeRelationInfoDao gradeRelationInfoDao) {
		this.gradeRelationInfoDao = gradeRelationInfoDao;
	}

	@Override
	public void delete(GradeRelationInfo data) {
		this.gradeRelationInfoDao.delete(data);
	}

	@Override
	public List<GradeRelationInfo> findByPage(int firstResult, int maxResult) {
		return this.gradeRelationInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public GradeRelationInfo getGradeRelationInfo(Long gradeRelationID) {
		return this.gradeRelationInfoDao.getGradeRelationInfo(gradeRelationID);
	}

	@Override
	public int getTotal() {
		return this.gradeRelationInfoDao.getTotal();
	}

	@Override
	public void save(GradeRelationInfo data) {
		this.gradeRelationInfoDao.save(data);		
	}

	@Override
	public void update(GradeRelationInfo data) {
		this.gradeRelationInfoDao.update(data);		
	}

	@Override
	public GradeRelationInfo findByIssue(Long issueID, Long informantID) {		
		return this.gradeRelationInfoDao.findByIssue(issueID, informantID);
	}

	@Override
	public List<GradeRelationInfo> findByIssue(Long issueID) {		
		return this.gradeRelationInfoDao.findByIssue(issueID);
	}

	@Override
	public int getTotal(Long issueID, Long informantID) {
		return this.gradeRelationInfoDao.getTotal(issueID, informantID);
	}

	@Override
	public int getTotal(Long issueID) {
		return this.gradeRelationInfoDao.getTotal(issueID);
	}
	

}
