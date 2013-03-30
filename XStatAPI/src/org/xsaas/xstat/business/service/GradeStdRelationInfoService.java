package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IGradeStdRelationInfoService;
import org.xsaas.xstat.dao.IGradeStdRelationInfoDao;
import org.xsaas.xstat.po.GradeStdRelationInfo;


public class GradeStdRelationInfoService implements
		IGradeStdRelationInfoService {
	private IGradeStdRelationInfoDao gradeStdRelationInfoDao = null;

	public void setGradeStdRelationInfoDao(
			IGradeStdRelationInfoDao gradeStdRelationInfoDao) {
		this.gradeStdRelationInfoDao = gradeStdRelationInfoDao;
	}

	@Override
	public void delete(GradeStdRelationInfo data) {
		this.gradeStdRelationInfoDao.delete(data);		
	}

	@Override
	public List<GradeStdRelationInfo> findByPage(int firstResult, int maxResult) {
		return this.gradeStdRelationInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public GradeStdRelationInfo getGradeStdRelationInfo(Long stdRelationID) {		
		return this.gradeStdRelationInfoDao.getGradeStdRelationInfo(stdRelationID);
	}

	@Override
	public int getTotal() {
		return this.gradeStdRelationInfoDao.getTotal();
	}

	@Override
	public void save(GradeStdRelationInfo data) {
		this.gradeStdRelationInfoDao.save(data);		
	}

	@Override
	public void update(GradeStdRelationInfo data) {
		this.gradeStdRelationInfoDao.update(data);		
	}

	@Override
	public List<GradeStdRelationInfo> findByGradeStd(Long gradeStdID) {
		return this.gradeStdRelationInfoDao.findByGradeStd(gradeStdID);
	}
	
}
