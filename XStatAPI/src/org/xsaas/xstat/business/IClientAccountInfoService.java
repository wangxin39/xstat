package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.ClientAccountInfo;


public interface IClientAccountInfoService {
	/**
	 * ������ͻ���Ϣ
	 * @param data ���ͻ���Ϣ
	 */
	public void saveClientAccountInfo(ClientAccountInfo data);
	/**
	 * ���¼��ͻ���Ϣ
	 * @param data ���ͻ���Ϣ
	 */
	public void updateClientAccountInfo(ClientAccountInfo data);
	/**
	 * ɾ�����ͻ���Ϣ
	 * @param data ���ͻ���Ϣ
	 */
	public void deleteClientAccountInfo(ClientAccountInfo data);	
	/**
	 * ��ȡ���ͻ���Ϣ
	 * @param checkClientID �ʾ���
	 * @return ���ͻ���Ϣ
	 */
	public ClientAccountInfo getClientAccountInfo(Long checkClientID);
	/**
	 * ��ȡ���ͻ���Ϣ�б�
	 * @return ���ͻ���Ϣ�б�
	 */
	public List<ClientAccountInfo> getClientAccountInfoList();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getClientAccountInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<ClientAccountInfo> findClientAccountInfoByPage(final int firstResult, final int maxResult);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getClientAccountInfoTotal(int account);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<ClientAccountInfo> findClientAccountInfoByPage(final int account,final int firstResult, final int maxResult);	
	public List<ClientAccountInfo> getClientAccountInfoList(Long clientID,Long informantID);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getClientAccountInfoTotal(Long clientID);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<ClientAccountInfo> findClientAccountInfoByPage(final Long clientID,final int firstResult, final int maxResult);	
	/**
	 * ��½ϵͳ
	 * @param username �û�����
	 * @param password �û�����
	 * @return SmgkInfo
	 */
	public ClientAccountInfo isLogin(String loginname,String password);
	public boolean isRegister(String loginname,String password);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getTotalByDelStatus();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<ClientAccountInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
