package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.PartInfo;



public interface IPartInfoDao {
	/**
	 * �����ʾ���
	 * @param data �ʾ���
	 */
	public void save(PartInfo data);
	/**
	 * �����ʾ���
	 * @param data �ʾ���
	 */
	public void update(PartInfo data);
	/**
	 * ɾ���ʾ���
	 * @param data �ʾ���
	 */
	public void delete(PartInfo data);	
	/**
	 * ��ȡ�ʾ���
	 * @param qpID �������ͱ��
	 * @return �ʾ���
	 */
	public PartInfo getPartInfo(Long qpID);
	public List<PartInfo> getPartInfoList(Long inquisitionID);
	/**
	 * ��ȡ�ʾ����б�
	 * @return �ʾ����б�
	 */
	public List<PartInfo> getPartInfoList();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getTotal(long inquisitionID);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<PartInfo> findByPage(long inquisitionID,final int firstResult, final int maxResult);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getTotal();

	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<PartInfo> findByPage(final int firstResult, final int maxResult);
	
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
	public List<PartInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
