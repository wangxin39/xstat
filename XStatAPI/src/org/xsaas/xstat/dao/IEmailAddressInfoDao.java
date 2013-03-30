package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.EmailAddressInfo;


public interface IEmailAddressInfoDao {
	/**
	 * 保存通讯录信息
	 * @param data 通讯录信息
	 */
	public void saveEmailAddressInfo(EmailAddressInfo data);
	/**
	 * 更新通讯录信息
	 * @param data 通讯录信息
	 */
	public void updateEmailAddressInfo(EmailAddressInfo data);
	/**
	 * 删除通讯录信息
	 * @param data 通讯录信息
	 */
	public void deleteEmailAddressInfo(EmailAddressInfo data);	
	/**
	 * 获取通讯录信息
	 * @param addressID 问卷编号
	 * @return 通讯录信息
	 */
	public EmailAddressInfo getEmailAddressInfo(Long addressID);
	/**
	 * 获取通讯录信息列表
	 * @return 通讯录信息列表
	 */
	public List<EmailAddressInfo> getEmailAddressInfoList();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getEmailAddressInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<EmailAddressInfo> findEmailAddressInfoByPage(final int firstResult, final int maxResult);
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
	public List<EmailAddressInfo> findPageByDelStatus(final int firstResult, final int maxResult);

}
