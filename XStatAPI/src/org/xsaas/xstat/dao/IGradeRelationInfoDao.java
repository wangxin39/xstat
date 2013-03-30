package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.GradeRelationInfo;


public interface IGradeRelationInfoDao {
	public void save(GradeRelationInfo data);
	public void update(GradeRelationInfo data);
	public void delete(GradeRelationInfo data);
	
	public GradeRelationInfo getGradeRelationInfo(Long gradeRelationID);
	
	public int getTotal();
	public List<GradeRelationInfo> findByPage(int firstResult, int maxResult);
	/**
	 * ��ȡָ����������ڴ��ڴ��е����ֹ�ϵ
	 * @param issueID
	 * @param informantID
	 * @return ���ֹ�ϵ
	 */
	public GradeRelationInfo findByIssue(Long issueID, Long informantID);
	/**
	 * ��ȡ���ֹ�ϵ�б�
	 * @param issueID
	 * @return ���ֹ�ϵ�б�
	 */
	public List<GradeRelationInfo> findByIssue(Long issueID);
	/**
	 * ͳ�Ƶ�ǰ�ڴ����ֹ�ϵ����
	 * @param issueID
	 * @return �趨�����ֹ�ϵ��
	 */
	public int getTotal(Long issueID);
	/**
	 * ͳ�Ƶ�ǰ�ڴ����ֹ�ϵ����
	 * @param issueID
	 * @param informantID
	 * @return �趨�����ֹ�ϵ��
	 */
	public int getTotal(Long issueID,Long informantID);	
}
