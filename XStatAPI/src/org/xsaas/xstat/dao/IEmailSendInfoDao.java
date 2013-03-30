package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.EmailSendInfo;


public interface IEmailSendInfoDao {
	/**
	 * 保存发件箱信息
	 * @param data 发件箱信息
	 */
	public void saveEmailSendInfo(EmailSendInfo data);
	/**
	 * 更新发件箱信息
	 * @param data 发件箱信息
	 */
	public void updateEmailSendInfo(EmailSendInfo data);
	/**
	 * 删除发件箱信息
	 * @param data 发件箱信息
	 */
	public void deleteEmailSendInfo(EmailSendInfo data);	
	/**
	 * 获取发件箱信息
	 * @param sendID 邮件编号
	 * @return 发件箱信息
	 */
	public EmailSendInfo getEmailSendInfo(Long sendID);
	/**
	 * 获取发件箱信息列表
	 * @return 发件箱信息列表
	 */
	public List<EmailSendInfo> getEmailSendInfoList();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getEmailSendInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<EmailSendInfo> findEmailSendInfoByPage(final int firstResult, final int maxResult);
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
	public List<EmailSendInfo> findPageByDelStatus(final int firstResult, final int maxResult);

}
