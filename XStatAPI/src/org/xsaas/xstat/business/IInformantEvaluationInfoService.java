package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.InformantEvaluationInfo;


public interface IInformantEvaluationInfoService {
	/**
	 * 保存调查问卷信息
	 * @param data 调查问卷信息
	 */
	public void save(InformantEvaluationInfo data);
	/**
	 * 更新调查问卷信息
	 * @param data 调查问卷信息
	 */
	public void update(InformantEvaluationInfo data);
	/**
	 * 删除调查问卷信息
	 * @param data 调查问卷信息
	 */
	public void delete(InformantEvaluationInfo data);	
	/**
	 * 获取调查问卷信息
	 * @param inquisitionID 调查问卷编号
	 * @return 调查问卷信息
	 */
	public InformantEvaluationInfo getInformantEvaluationInfo(Long inquisitionID);
	/**
	 * 获取调查问卷信息列表
	 * @return 调查问卷信息列表
	 */
	public List<InformantEvaluationInfo> getInformantEvaluationInfoList();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<InformantEvaluationInfo> findByPage(final int firstResult, final int maxResult);
	/**
	 * 取得指定期次和调查对象所有评估信息
	 * @param issueID
	 * @param informantID
	 * @return 评估信息列表
	 */
	public List<InformantEvaluationInfo> findByInformant(Long issueID,Long informantID);
}
