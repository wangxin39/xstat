package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.SmgkPopedomInfo;


public interface ISmgkPopedomInfoService {
	/**
	 * �������ع˿�Ȩ����Ϣ
	 * @param data ���ع˿�Ȩ����Ϣ
	 */
	public void saveSmgkPopedomInfo(SmgkPopedomInfo data);
	/**
	 * �������ع˿�Ȩ����Ϣ
	 * @param data ���ع˿�Ȩ����Ϣ
	 */
	public void updateSmgkPopedomInfo(SmgkPopedomInfo data);
	/**
	 * ɾ�����ع˿�Ȩ����Ϣ
	 * @param data ���ع˿�Ȩ����Ϣ
	 */
	public void deleteSmgkPopedomInfo(SmgkPopedomInfo data);	
	/**
	 * ��ȡ���ع˿�Ȩ����Ϣ
	 * @param smgkPopedomID ���ع˿�Ȩ����Ϣ���
	 * @return ���ع˿�Ȩ����Ϣ
	 */
	public SmgkPopedomInfo getSmgkPopedomInfo(Long smgkPopedomID);
	/**
	 * ��ȡ���ع˿�Ȩ����Ϣ�б�
	 * @return ���ع˿�Ȩ����Ϣ�б�
	 */
	public List<SmgkPopedomInfo> getSmgkPopedomInfoList();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getSmgkPopedomInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<SmgkPopedomInfo> findSmgkPopedomInfoByPage(final int firstResult, final int maxResult);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getSmgkPopedomInfoTotal(long employeeID);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<SmgkPopedomInfo> findSmgkPopedomInfoByPage(long employeeID,final int firstResult, final int maxResult);

}
