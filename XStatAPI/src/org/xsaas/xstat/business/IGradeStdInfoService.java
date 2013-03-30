package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.GradeStdInfo;


public interface IGradeStdInfoService {
	public void save(GradeStdInfo data);
	public void update(GradeStdInfo data);
	public void delete(GradeStdInfo data);
	
	public GradeStdInfo getGradeStdInfo(Long gradeStdID);
	
	public int getTotal();
	public List<GradeStdInfo> findByPage(int firstResult, int maxResult);
}
