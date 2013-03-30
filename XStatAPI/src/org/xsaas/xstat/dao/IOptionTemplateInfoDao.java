package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.OptionTemplateInfo;


public interface IOptionTemplateInfoDao {
	/**
	 * 增加
	 * @param data
	 */
	public void save(OptionTemplateInfo data);
	/**
	 * 删除
	 * @param data
	 */
	public void delete(OptionTemplateInfo data);
	/**
	 * 更新
	 * @param data
	 */
	public void update(OptionTemplateInfo data);
	/**
	 * 获取指定信息
	 * @param optionTemplateID
	 * @return 指定信息
	 */
	public OptionTemplateInfo getOptionTemplateInfo(Long optionTemplateID);
	/**
	 * 获取记录数
	 * @return
	 */
	public int getTotal();
	/**
	 * 获取指定集合记录
	 * @param firstResult
	 * @param maxResult
	 * @return 指定开始和结束范围内的选项模板列表
	 */
	public List<OptionTemplateInfo> getList(final int firstResult,final int maxResult);	
}
