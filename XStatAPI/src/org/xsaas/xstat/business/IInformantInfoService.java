package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.InformantInfo;


public interface IInformantInfoService {
	/**
	 * ���汻��������Ϣ
	 * @param data ����������Ϣ
	 */
	public void saveInformantInfo(InformantInfo data);
	/**
	 * ���±���������Ϣ
	 * @param data ����������Ϣ
	 */
	public void updateInformantInfo(InformantInfo data);
	/**
	 * ɾ������������Ϣ
	 * @param data ����������Ϣ
	 */
	public void deleteInformantInfo(InformantInfo data);	
	/**
	 * ��ȡ����������Ϣ
	 * @param informantID ��������
	 * @return ����������Ϣ
	 */
	public InformantInfo getInformantInfo(Long informantID);
	/**
	 * ��ȡ����������Ϣ�б�
	 * @return ����������Ϣ�б�
	 */
	public List<InformantInfo> getInformantInfoList();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getInformantInfoTotal();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getInformantInfoTotal(long clientID);
	public int getInformantInfoTotal(long informantID,long clientID);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<InformantInfo> findInformantInfoByPage(final long clientID,final int firstResult, final int maxResult);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<InformantInfo> findInformantInfoByPage(final int firstResult, final int maxResult);
	public List<InformantInfo> getInformantInfoList(Long clientID);
	

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
	public List<InformantInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
