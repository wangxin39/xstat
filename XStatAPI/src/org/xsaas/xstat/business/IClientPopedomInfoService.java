
package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.ClientPopedomInfo;


public interface IClientPopedomInfoService {
	/**
	 * ������ͻ�Ȩ����Ϣ
	 * @param data ���ͻ�Ȩ����Ϣ
	 */
	public void saveClientPopedomInfo(ClientPopedomInfo data);
	/**
	 * ���¼��ͻ�Ȩ����Ϣ
	 * @param data ���ͻ�Ȩ����Ϣ
	 */
	public void updateClientPopedomInfo(ClientPopedomInfo data);
	/**
	 * ɾ�����ͻ�Ȩ����Ϣ
	 * @param data ���ͻ�Ȩ����Ϣ
	 */
	public void deleteClientPopedomInfo(ClientPopedomInfo data);	
	/**
	 * ��ȡ���ͻ�Ȩ����Ϣ
	 * @param clientPopedomID ���ͻ�Ȩ�ޱ��
	 * @return ���ͻ�Ȩ����Ϣ
	 */
	public ClientPopedomInfo getClientPopedomInfo(Long clientPopedomID);
	/**
	 * ��ȡ���ͻ�Ȩ����Ϣ�б�
	 * @return ���ͻ�Ȩ����Ϣ�б�
	 */
	public List<ClientPopedomInfo> getClientPopedomInfoList();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getClientPopedomInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<ClientPopedomInfo> findClientPopedomInfoByPage(final int firstResult, final int maxResult);

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
	public List<ClientPopedomInfo> findPageByDelStatus(final int firstResult, final int maxResult);

}
