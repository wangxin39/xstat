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
	 * 获取指定调查对象在此期次中的评分关系
	 * @param issueID
	 * @param informantID
	 * @return 评分关系
	 */
	public GradeRelationInfo findByIssue(Long issueID, Long informantID);
	/**
	 * 获取评分关系列表
	 * @param issueID
	 * @return 评分关系列表
	 */
	public List<GradeRelationInfo> findByIssue(Long issueID);
	/**
	 * 统计当前期次评分关系数量
	 * @param issueID
	 * @return 设定的评分关系数
	 */
	public int getTotal(Long issueID);
	/**
	 * 统计当前期次评分关系数量
	 * @param issueID
	 * @param informantID
	 * @return 设定的评分关系数
	 */
	public int getTotal(Long issueID,Long informantID);	
}
