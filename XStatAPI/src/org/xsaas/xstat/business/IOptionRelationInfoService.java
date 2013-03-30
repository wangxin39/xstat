package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.OptionRelationInfo;


public interface IOptionRelationInfoService {
	/**
	 * 保存
	 * @param data
	 */
	public void save(OptionRelationInfo data);
	/**
	 * 删除
	 * @param data
	 */
	public void delete(OptionRelationInfo data);
	/**
	 * 更新
	 * @param data
	 */
	public void update(OptionRelationInfo data);
	/**
	 * 获取指定信息
	 * @param optionRelationID
	 * @return 指定信息
	 */
	public OptionRelationInfo getOptionRelationInfo(Long optionRelationID);
	/**
	 * 获取记录数
	 * @return 记录数
	 */
	public int getTotal();
	/**
	 * 获取指定开始和结束范围记录集合
	 * @param firstResult
	 * @param maxResult
	 * @return 选项关系列表
	 */
	public List<OptionRelationInfo> getList(final int firstResult, final int maxResult);
	/**
	 * 获取指定选项模板选项关系列表
	 * @param optionTemplateID
	 * @return 选项关系列表
	 */
	public List<OptionRelationInfo> getList(Long optionTemplateID);	
}
