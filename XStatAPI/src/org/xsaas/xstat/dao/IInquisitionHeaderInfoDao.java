package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.InquisitionHeaderInfo;


public interface IInquisitionHeaderInfoDao {
	/**
	 * ��������ʾ�ͷ����Ϣ
	 * @param data �����ʾ�ͷ����Ϣ
	 */
	public void save(InquisitionHeaderInfo data);
	/**
	 * ���µ����ʾ�ͷ����Ϣ
	 * @param data �����ʾ�ͷ����Ϣ
	 */
	public void update(InquisitionHeaderInfo data);
	/**
	 * ɾ�������ʾ�ͷ����Ϣ
	 * @param data �����ʾ�ͷ����Ϣ
	 */
	public void delete(InquisitionHeaderInfo data);	
	/**
	 * ��ȡ�����ʾ�ͷ����Ϣ
	 * @param IhID �����ʾ�ͷ����Ϣ���
	 * @return �����ʾ�ͷ����Ϣ
	 */
	public InquisitionHeaderInfo getInquisitionHeaderInfo(Long IhID);
	public List<InquisitionHeaderInfo>  getInquisitionHeaderInfoList(Long inquisitionID);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getInquisitionHeaderInfoTotal(long inquisitionID);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<InquisitionHeaderInfo> findInquisitionHeaderInfoByPage(long inquisitionID,final int firstResult, final int maxResult);

	/**
	 * ��ȡ�����ʾ�ͷ����Ϣ�б�
	 * @return �����ʾ�ͷ����Ϣ�б�
	 */
	public List<InquisitionHeaderInfo> getInquisitionHeaderInfoList();
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
	public List<InquisitionHeaderInfo> findByPage(final int firstResult, final int maxResult);
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
	public List<InquisitionHeaderInfo> findPageByDelStatus(final int firstResult, final int maxResult);
	/**
	 * ��ȡ����ʾ˳��
	 * @param inquisitionID
	 * @return ��ʾ˳��
	 */
	public int getNewShowOrder(Long inquisitionID);
	

	
}
