package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.InquisitionHeaderInfo;


public interface IInquisitionHeaderInfoService {
	/**
	 * ��������ʾ�ͷ����Ϣ
	 * @param data �����ʾ�ͷ����Ϣ
	 */
	public void saveInquisitionHeaderInfo(InquisitionHeaderInfo data);
	/**
	 * ���µ����ʾ�ͷ����Ϣ
	 * @param data �����ʾ�ͷ����Ϣ
	 */
	public void updateInquisitionHeaderInfo(InquisitionHeaderInfo data);
	/**
	 * ɾ�������ʾ�ͷ����Ϣ
	 * @param data �����ʾ�ͷ����Ϣ
	 */
	public void deleteInquisitionHeaderInfo(InquisitionHeaderInfo data);	
	
	/**
	 * ��ȡ�����ʾ�ͷ����Ϣ
	 * @param ihID �ʾ�ͷ�����
	 * @return �����ʾ�ͷ����Ϣ
	 */
	public InquisitionHeaderInfo getInquisitionHeaderInfo(Long ihID);
	/**
	 * ��ȡ�����ʾ�ͷ����Ϣ�б�
	 * @return �����ʾ�ͷ����Ϣ�б�
	 */
	public List<InquisitionHeaderInfo> getInquisitionHeaderInfoList();
	public List<InquisitionHeaderInfo> getInquisitionHeaderInfoList(Long inquisitionID);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getInquisitionHeaderInfoTotal();
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
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<InquisitionHeaderInfo> findInquisitionHeaderInfoByPage(final int firstResult, final int maxResult);

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
