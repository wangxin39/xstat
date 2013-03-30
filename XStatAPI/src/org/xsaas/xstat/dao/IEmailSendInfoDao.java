package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.EmailSendInfo;


public interface IEmailSendInfoDao {
	/**
	 * ���淢������Ϣ
	 * @param data ��������Ϣ
	 */
	public void saveEmailSendInfo(EmailSendInfo data);
	/**
	 * ���·�������Ϣ
	 * @param data ��������Ϣ
	 */
	public void updateEmailSendInfo(EmailSendInfo data);
	/**
	 * ɾ����������Ϣ
	 * @param data ��������Ϣ
	 */
	public void deleteEmailSendInfo(EmailSendInfo data);	
	/**
	 * ��ȡ��������Ϣ
	 * @param sendID �ʼ����
	 * @return ��������Ϣ
	 */
	public EmailSendInfo getEmailSendInfo(Long sendID);
	/**
	 * ��ȡ��������Ϣ�б�
	 * @return ��������Ϣ�б�
	 */
	public List<EmailSendInfo> getEmailSendInfoList();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getEmailSendInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<EmailSendInfo> findEmailSendInfoByPage(final int firstResult, final int maxResult);
	/**
	 * ɾ��״̬����
	 * @return int
	 */
	public int getTotalByDelStatus();
	/**
	 * ɾ��״̬��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<EmailSendInfo> findPageByDelStatus(final int firstResult, final int maxResult);

}
