package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.AddressCatalogInfo;


public interface IAddressCatalogInfoService {
	/**
	 * 保存通讯录分类信息
	 * @param data 通讯录分类信息
	 */
	public void saveAddressCatalogInfo(AddressCatalogInfo data);
	/**
	 * 更新通讯录分类信息
	 * @param data 通讯录分类信息
	 */
	public void updateAddressCatalogInfo(AddressCatalogInfo data);
	/**
	 * 删除通讯录分类信息
	 * @param data 通讯录分类信息
	 */
	public void deleteAddressCatalogInfo(AddressCatalogInfo data);	
	/**
	 * 获取通讯录分类信息
	 * @param acID 问卷编号
	 * @return 通讯录分类信息
	 */
	public AddressCatalogInfo getAddressCatalogInfo(Long acID);
	/**
	 * 获取通讯录分类信息列表
	 * @return 通讯录分类信息列表
	 */
	public List<AddressCatalogInfo> getAddressCatalogInfoList();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getAddressCatalogInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<AddressCatalogInfo> findAddressCatalogInfoByPage(final int firstResult, final int maxResult);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getTotalByDelStatus();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<AddressCatalogInfo> findPageByDelStatus(final int firstResult, final int maxResult);

}
