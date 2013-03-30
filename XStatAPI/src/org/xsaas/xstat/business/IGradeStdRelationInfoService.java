package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.GradeStdRelationInfo;


public interface IGradeStdRelationInfoService {
	public void save(GradeStdRelationInfo data);
	public void update(GradeStdRelationInfo data);
	public void delete(GradeStdRelationInfo data);
	
	public GradeStdRelationInfo getGradeStdRelationInfo(Long stdRelationID);
	
	public int getTotal();
	public List<GradeStdRelationInfo> findByPage(int firstResult, int maxResult);
	/**
	 * ��ȡ���ֱ�׼��Ӧ��Ȩ���б�	
	 * @param gradeStdID
	 * @return Ȩ���б�
	 */
	public List<GradeStdRelationInfo> findByGradeStd(Long gradeStdID);
}
