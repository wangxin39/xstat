package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.SelectWeightInfo;


public interface ISelectWeightInfoService {
	/**
	 * 保存问卷部分
	 * @param data 问卷部分
	 */
	public void save(SelectWeightInfo data);
	/**
	 * 更新问卷部分
	 * @param data 问卷部分
	 */
	public void update(SelectWeightInfo data);
	/**
	 * 删除问卷部分
	 * @param data 问卷部分
	 */
	public void delete(SelectWeightInfo data);	
	/**
	 * 获取权重信息
	 * @param qpID 权重编号
	 * @return 权重设定信息
	 */
	public SelectWeightInfo getSelectWeightInfo(Long qpID);
	
	/**
	 * 获取指定选项权重设定信息
	 * @param inquisitionID 调查问卷编号
	 * @param partQuestionID 部分问题编号
	 * @param selectID 选项编号
	 * @return 权重设定信息
	 */
	public SelectWeightInfo getSelectWeightInfo(Long inquisitionID, Long partQuestionID, Long selectID);
	public int getTotal();	
	public int getTotal(Long inquisitionID, Long partID);
	public int getTotal(Long inquisitionID);
	public int getCountWeight(Long inquisitionID,Long partID);
	public int getTotalByDelStatus();
	
	public List<SelectWeightInfo> findByPage(final int firstResult,final int maxResult);
	public List<SelectWeightInfo> findByPage(Long inquisitionID, Long partID,final int firstResult,final int maxResult);
	public List<SelectWeightInfo> findByPage(final Long inquisitionID, final int firstResult,final int maxResult);
	
	public List<SelectWeightInfo> findByPart(Long inquisitionID, Long partID);
	public List<SelectWeightInfo> findByPartQuestion(Long inquisitionID,Long partQuestionID);
	public List<SelectWeightInfo> findByDelStatus(final int firstResult, final int maxResult);
	public int getSumWeightByQuestion(Long inquisitionID,Long partQuestionID);
}
