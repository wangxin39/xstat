package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.InquisitionInfo;


public interface IInquisitionInfoDao {
	/**
	 * ��������ʾ���Ϣ
	 * @param data �����ʾ���Ϣ
	 */
	public void save(InquisitionInfo data);
	/**
	 * ���µ����ʾ���Ϣ
	 * @param data �����ʾ���Ϣ
	 */
	public void update(InquisitionInfo data);
	/**
	 * ɾ�������ʾ���Ϣ
	 * @param data �����ʾ���Ϣ
	 */
	public void delete(InquisitionInfo data);	
	/**
	 * ��ȡ�����ʾ���Ϣ
	 * @param inquisitionID �����ʾ���Ϣ���
	 * @return �����ʾ���Ϣ
	 */
	public InquisitionInfo getInquisitionInfo(Long inquisitionID);
	/**
	 * ��ȡ�����ʾ���Ϣ�б�
	 * @return �����ʾ���Ϣ�б�
	 */
	public List<InquisitionInfo> getInquisitionInfoList();
	/**
	 * ��ȡ�����ʾ���Ϣ�б�
	 * @return �����ʾ���Ϣ�б�
	 */
	public List<InquisitionInfo> getList(Long clientID);
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
	public List<InquisitionInfo> findByPage(final int firstResult, final int maxResult);

	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getTotal(int status);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<InquisitionInfo> findByPage(final int status,final int firstResult, final int maxResult);
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
	public List<InquisitionInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
