package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.PublishInfo;


public interface IPublishInfoService {

	/**
	 * ��������ʾ���Ϣ
	 * @param data �����ʾ���Ϣ
	 */
	public void savePublishInfo(PublishInfo data);
	/**
	 * ���µ����ʾ���Ϣ
	 * @param data �����ʾ���Ϣ
	 */
	public void updatePublishInfo(PublishInfo data);
	/**
	 * ɾ�������ʾ���Ϣ
	 * @param data �����ʾ���Ϣ
	 */
	public void deletePublishInfo(PublishInfo data);	
	/**
	 * ��ȡ�����ʾ���Ϣ
	 * @param partID ���ⲿ�ֱ��
	 * @return �����ʾ���Ϣ
	 */
	public PublishInfo getPublishInfo(Long partID);
	/**
	 * ��ȡ�����ʾ���Ϣ�б�
	 * @return �����ʾ���Ϣ�б�
	 */
	public List<PublishInfo> getPublishInfoList();
	/**
	 * ͨ��ָ������ʼ���ͽ������õ�һ������
	 * @param firstResult 
	 * @param maxResult 
	 * @return �����ʾ���Ϣ
	 */
	public List<PublishInfo> findByPagePublishInfo(final int firstResult,final int maxResult);
	/**
	 * ͨ��ָ������ʼ����ȡ�ܼ���
	 * @return ����
	 */
	public int getTotalPublishInfo();
	
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
