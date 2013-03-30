package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.SmgkInfo;


public interface ISmgkInfoDao {
	/**
	 * �������ع˿���Ϣ
	 * @param data ���ع˿���Ϣ
	 */
	public void saveSmgkInfo(SmgkInfo data);
	/**
	 * �������ع˿���Ϣ
	 * @param data ���ع˿���Ϣ
	 */
	public void updateSmgkInfo(SmgkInfo data);
	/**
	 * ɾ�����ع˿���Ϣ
	 * @param data ���ع˿���Ϣ
	 */
	public void deleteSmgkInfo(SmgkInfo data);	
	/**
	 * ��ȡ���ع˿���Ϣ
	 * @param smgkID ���ع˿ͱ��
	 * @return ���ع˿���Ϣ
	 */
	public SmgkInfo getSmgkInfo(Long smgkID);
	/**
	 * ��ȡ���ع˿���Ϣ�б�
	 * @return ���ع˿���Ϣ�б�
	 */
	public List<SmgkInfo> getSmgkInfoList();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getSmgkInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<SmgkInfo> findSmgkInfoByPage(final int firstResult, final int maxResult);
	/**
	 * ��½ϵͳ
	 * @param username �û�����
	 * @param password �û�����
	 * @return SmgkInfo
	 */
	public SmgkInfo isLogin(String username,String password);
	public boolean isRegister(String userName);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getSmgkInfoTotal(Integer status);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<SmgkInfo> findSmgkInfoByPage(Integer status,final int firstResult, final int maxResult);
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
	public List<SmgkInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
