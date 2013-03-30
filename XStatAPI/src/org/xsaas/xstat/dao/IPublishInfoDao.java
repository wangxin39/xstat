package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.PublishInfo;



public interface IPublishInfoDao {
	/**
	 * �����ʾ���
	 * @param data �ʾ���
	 */
	public void save(PublishInfo data);
	/**
	 * �����ʾ���
	 * @param data �ʾ���
	 */
	public void update(PublishInfo data);
	/**
	 * ɾ���ʾ���
	 * @param data �ʾ���
	 */
	public void delete(PublishInfo data);	
	/**
	 * ��ȡ�ʾ���
	 * @param qpID �������ͱ��
	 * @return �ʾ���
	 */
	public PublishInfo getPublishInfo(Long qpID);
	/**
	 * ��ȡ�ʾ����б�
	 * @return �ʾ����б�
	 */
	public List<PublishInfo> getPublishInfoList();
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
	public List<PublishInfo> findByPage(final int firstResult, final int maxResult);

	public int getTotal(int type);
	public int getTotal(int type,Long smgkID);
	public List<PublishInfo> findByPage(final int type,final int firstResult, final int maxResult);
	public List<PublishInfo> findByPage(final int type,final Long smgkID,final int firstResult, final int maxResult);
	
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
	public List<PublishInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
