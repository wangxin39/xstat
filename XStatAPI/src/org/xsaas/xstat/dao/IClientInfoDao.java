package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.ClientInfo;


public interface IClientInfoDao {
	/**
	 * ������ͻ���Ϣ
	 * @param data ���ͻ���Ϣ
	 */
	public void saveClientInfo(ClientInfo data);
	/**
	 * ���¼��ͻ���Ϣ
	 * @param data ���ͻ���Ϣ
	 */
	public void updateClientInfo(ClientInfo data);
	/**
	 * ɾ�����ͻ���Ϣ
	 * @param data ���ͻ���Ϣ
	 */
	public void deleteClientInfo(ClientInfo data);	
	/**
	 * ��ȡ���ͻ���Ϣ
	 * @param clientID �ʾ���
	 * @return ���ͻ���Ϣ
	 */
	public ClientInfo getClientInfo(Long clientID);
	/**
	 * ��ȡ���ͻ���Ϣ�б�
	 * @return ���ͻ���Ϣ�б�
	 */
	public List<ClientInfo> getClientInfoList();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getClientInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<ClientInfo> findClientInfoByPage(final int firstResult, final int maxResult);

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
	public List<ClientInfo> findPageByDelStatus(final int firstResult, final int maxResult);

}
