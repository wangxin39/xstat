package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.InquisitionTemplateInfo;


public interface IInquisitionTemplateInfoService {
	/**
	 * ��������ʾ�ģ����Ϣ
	 * @param data �����ʾ�ģ����Ϣ
	 */
	public void saveInquisitionTemplateInfo(InquisitionTemplateInfo data);
	/**
	 * ���µ����ʾ�ģ����Ϣ
	 * @param data �����ʾ�ģ����Ϣ
	 */
	public void updateInquisitionTemplateInfo(InquisitionTemplateInfo data);
	/**
	 * ɾ�������ʾ�ģ����Ϣ
	 * @param data �����ʾ�ģ����Ϣ
	 */
	public void deleteInquisitionTemplateInfo(InquisitionTemplateInfo data);	
	/**
	 * ��ȡ�����ʾ�ģ����Ϣ
	 * @param tempID �ʾ�������
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
	public int getInquisitionTemplateInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<InquisitionTemplateInfo> findInquisitionTemplateInfoByPage(final int firstResult, final int maxResult);

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
