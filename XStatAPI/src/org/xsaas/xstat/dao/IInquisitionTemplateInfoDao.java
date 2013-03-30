package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.InquisitionTemplateInfo;


public interface IInquisitionTemplateInfoDao {
	/**
	 * ��������ʾ�ģ����Ϣ
	 * @param data �����ʾ�ģ����Ϣ
	 */
	public void save(InquisitionTemplateInfo data);
	/**
	 * ���µ����ʾ�ģ����Ϣ
	 * @param data �����ʾ�ģ����Ϣ
	 */
	public void update(InquisitionTemplateInfo data);
	/**
	 * ɾ�������ʾ�ģ����Ϣ
	 * @param data �����ʾ�ģ����Ϣ
	 */
	public void delete(InquisitionTemplateInfo data);	
	/**
	 * ��ȡ�����ʾ�ģ����Ϣ
	 * @param tempID �����ʾ�ģ����Ϣ���
	 * @return �����ʾ�ģ����Ϣ
	 */
	public InquisitionTemplateInfo getInquisitionTemplateInfo(Long tempID);
	/**
	 * ��ȡ�����ʾ�ģ����Ϣ�б�
	 * @return �����ʾ�ģ����Ϣ�б�
	 */
	public List<InquisitionTemplateInfo> getInquisitionTemplateInfoList();
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
	public List<InquisitionTemplateInfo> findByPage(final int firstResult, final int maxResult);
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
	public List<InquisitionTemplateInfo> findPageByDelStatus(final int firstResult, final int maxResult);

	
}
