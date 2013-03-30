package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.OptionInfo;


public interface IOptionInfoDao {
	/**
	 * 保存调查问卷选项信息
	 * @param data 调查问卷选项信息
	 */
	public void save(OptionInfo data);
	/**
	 * 更新调查问卷选项信息
	 * @param data 调查问卷选项信息
	 */
	public void update(OptionInfo data);
	/**
	 * 删除调查问卷选项信息
	 * @param data 调查问卷选项信息
	 */
	public void delete(OptionInfo data);	
	/**
	 * 获取调查问卷选项信息
	 * @param optionID 试题选项编号
	 * @return 调查问卷选项信息
	 */
	public OptionInfo getOptionInfo(Long optionID);
	/**
	 * 获取调查问卷选项信息列表
	 * @type 类型 1：提示 2：选项值
	 * @return 调查问卷选项信息列表
	 */
	public List<OptionInfo> getList(Integer type);
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
	public List<OptionInfo> findByPage(final int firstResult, final int maxResult);
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
	public List<OptionInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
