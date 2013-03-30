package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.GradeStdRelationInfo;


public interface IGradeStdRelationInfoDao {
	public void save(GradeStdRelationInfo data);
	public void update(GradeStdRelationInfo data);
	public void delete(GradeStdRelationInfo data);
	
	public GradeStdRelationInfo getGradeStdRelationInfo(Long stdRelationID);
	
	public int getTotal();
	public List<GradeStdRelationInfo> findByPage(int firstResult, int maxResult);
	/**
	 * 获取评分标准对应的权重列表	
	 * @param gradeStdID
	 * @return 权重列表
	 */
	public List<GradeStdRelationInfo> findByGradeStd(Long gradeStdID);
}
