package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.EmailDraftInfo;


public interface IEmailDraftInfoDao {
	/**
	 * 保存草稿箱信息
	 * @param data 草稿箱信息
	 */
	public void saveEmailDraftInfo(EmailDraftInfo data);
	/**
	 * 更新草稿箱信息
	 * @param data 草稿箱信息
	 */
	public void updateEmailDraftInfo(EmailDraftInfo data);
	/**
	 * 删除草稿箱信息
	 * @param data 草稿箱信息
	 */
	public void deleteEmailDraftInfo(EmailDraftInfo data);	
	/**
	 * 获取草稿箱信息
	 * @param draftID 草稿编号
	 * @return 草稿箱信息
	 */
	public EmailDraftInfo getEmailDraftInfo(Long draftID);
	/**
	 * 获取草稿箱信息列表
	 * @return 草稿箱信息列表
	 */
	public List<EmailDraftInfo> getEmailDraftInfoList();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getEmailDraftInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<EmailDraftInfo> findEmailDraftInfoByPage(final int firstResult, final int maxResult);
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
	public List<EmailDraftInfo> findPageByDelStatus(final int firstResult, final int maxResult);

}
