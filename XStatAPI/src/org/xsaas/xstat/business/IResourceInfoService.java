package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.ResourceInfo;


public interface IResourceInfoService {
	/**
	 * ������Դ��Ϣ
	 * @param data ��Դ��Ϣ
	 */
	public void save(ResourceInfo data);
	/**
	 * ������Դ��Ϣ
	 * @param data ��Դ��Ϣ
	 */
	public void update(ResourceInfo data);
	/**
	 * ɾ����Դ��Ϣ
	 * @param data ������Դ��Ϣ
	 */
	public void delete(ResourceInfo data);	
	/**
	 * ��ȡ��Դ��Ϣ
	 * @param resourceID ��Դ���
	 * @return ��Դ��Ϣ
	 */
	public ResourceInfo getResourceInfo(Long resourceID);
	/**
	 * ��ȡ��Դ��Ϣ�б�
	 * @return ��Դ��Ϣ�б�
	 */
	public List<ResourceInfo> getList();
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
	public List<ResourceInfo> findByPage(final int firstResult, final int maxResult);
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
	public List<ResourceInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
