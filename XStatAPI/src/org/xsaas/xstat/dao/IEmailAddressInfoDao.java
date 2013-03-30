package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.EmailAddressInfo;


public interface IEmailAddressInfoDao {
	/**
	 * ����ͨѶ¼��Ϣ
	 * @param data ͨѶ¼��Ϣ
	 */
	public void saveEmailAddressInfo(EmailAddressInfo data);
	/**
	 * ����ͨѶ¼��Ϣ
	 * @param data ͨѶ¼��Ϣ
	 */
	public void updateEmailAddressInfo(EmailAddressInfo data);
	/**
	 * ɾ��ͨѶ¼��Ϣ
	 * @param data ͨѶ¼��Ϣ
	 */
	public void deleteEmailAddressInfo(EmailAddressInfo data);	
	/**
	 * ��ȡͨѶ¼��Ϣ
	 * @param addressID �ʾ���
	 * @return ͨѶ¼��Ϣ
	 */
	public EmailAddressInfo getEmailAddressInfo(Long addressID);
	/**
	 * ��ȡͨѶ¼��Ϣ�б�
	 * @return ͨѶ¼��Ϣ�б�
	 */
	public List<EmailAddressInfo> getEmailAddressInfoList();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getEmailAddressInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<EmailAddressInfo> findEmailAddressInfoByPage(final int firstResult, final int maxResult);
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
	public List<EmailAddressInfo> findPageByDelStatus(final int firstResult, final int maxResult);

}
