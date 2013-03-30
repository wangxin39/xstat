package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.InquisitionTemplateInfo;


public interface IInquisitionTemplateInfoService {
	/**
	 * 保存调查问卷模板信息
	 * @param data 调查问卷模板信息
	 */
	public void saveInquisitionTemplateInfo(InquisitionTemplateInfo data);
	/**
	 * 更新调查问卷模板信息
	 * @param data 调查问卷模板信息
	 */
	public void updateInquisitionTemplateInfo(InquisitionTemplateInfo data);
	/**
	 * 删除调查问卷模板信息
	 * @param data 调查问卷模板信息
	 */
	public void deleteInquisitionTemplateInfo(InquisitionTemplateInfo data);	
	/**
	 * 获取调查问卷模板信息
	 * @param tempID 问卷问题编号
	 * @return 调查问卷模板信息
	 */
	public InquisitionTemplateInfo getInquisitionTemplateInfo(Long tempID);
	/**
	 * 获取调查问卷模板信息列表
	 * @return 调查问卷模板信息列表
	 */
	public List<InquisitionTemplateInfo> getInquisitionTemplateInfoList();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getInquisitionTemplateInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<InquisitionTemplateInfo> findInquisitionTemplateInfoByPage(final int firstResult, final int maxResult);

	/**
	 * 删除状态总数
	 * @return int
	 */
	public int getTotalByDelStatus();
	/**
	 * 删除状态分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<InquisitionTemplateInfo> findPageByDelStatus(final int firstResult, final int maxResult);

}
