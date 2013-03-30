package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.EmailDraftInfo;


public interface IEmailDraftInfoDao {
	/**
	 * ����ݸ�����Ϣ
	 * @param data �ݸ�����Ϣ
	 */
	public void saveEmailDraftInfo(EmailDraftInfo data);
	/**
	 * ���²ݸ�����Ϣ
	 * @param data �ݸ�����Ϣ
	 */
	public void updateEmailDraftInfo(EmailDraftInfo data);
	/**
	 * ɾ���ݸ�����Ϣ
	 * @param data �ݸ�����Ϣ
	 */
	public void deleteEmailDraftInfo(EmailDraftInfo data);	
	/**
	 * ��ȡ�ݸ�����Ϣ
	 * @param draftID �ݸ���
	 * @return �ݸ�����Ϣ
	 */
	public EmailDraftInfo getEmailDraftInfo(Long draftID);
	/**
	 * ��ȡ�ݸ�����Ϣ�б�
	 * @return �ݸ�����Ϣ�б�
	 */
	public List<EmailDraftInfo> getEmailDraftInfoList();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getEmailDraftInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<EmailDraftInfo> findEmailDraftInfoByPage(final int firstResult, final int maxResult);
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
	public List<EmailDraftInfo> findPageByDelStatus(final int firstResult, final int maxResult);

}
