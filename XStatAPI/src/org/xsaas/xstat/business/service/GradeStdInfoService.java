package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IGradeStdInfoService;
import org.xsaas.xstat.dao.IGradeStdInfoDao;
import org.xsaas.xstat.po.GradeStdInfo;


public class GradeStdInfoService implements IGradeStdInfoService {
	private IGradeStdInfoDao gradeStdInfoDao = null;

	public void setGradeStdInfoDao(IGradeStdInfoDao gradeStdInfoDao) {
		this.gradeStdInfoDao = gradeStdInfoDao;
	}

	@Override
	public void delete(GradeStdInfo data) {
		this.gradeStdInfoDao.delete(data);		
	}

	@Override
	public List<GradeStdInfo> findByPage(int firstResult, int maxResult) {
		return this.gradeStdInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public GradeStdInfo getGradeStdInfo(Long gradeStdID) {
		return this.gradeStdInfoDao.getGradeStdInfo(gradeStdID);
	}

	@Override
	public int getTotal() {
		return this.gradeStdInfoDao.getTotal();
	}

	@Override
	public void save(GradeStdInfo data) {
		this.gradeStdInfoDao.save(data);
	}

	@Override
	public void update(GradeStdInfo data) {
		this.gradeStdInfoDao.update(data);		
	}
}
