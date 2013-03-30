package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.InquisitionHeaderSelectInfo;


public interface IInquisitionHeaderSelectInfoDao {
	/**
	 * ��������ʾ�ͷ����Ϣ
	 * @param data �����ʾ�ͷ����Ϣ
	 */
	public void save(InquisitionHeaderSelectInfo data);
	/**
	 * ���µ����ʾ�ͷ����Ϣ
	 * @param data �����ʾ�ͷ����Ϣ
	 */
	public void update(InquisitionHeaderSelectInfo data);
	/**
	 * ɾ�������ʾ�ͷ����Ϣ
	 * @param data �����ʾ�ͷ����Ϣ
	 */
	public void delete(InquisitionHeaderSelectInfo data);	
	/**
	 * ��ȡ�����ʾ�ͷ����Ϣ
	 * @param headerSelectID �����ʾ�ͷ����Ϣ���
	 * @return �����ʾ�ͷ����Ϣ
	 */
	public InquisitionHeaderSelectInfo getInquisitionHeaderSelectInfo(Long headerSelectID);
	/**
	 * ��ȡ�����ʾ�ͷ����Ϣ�б�
	 * @return �����ʾ�ͷ����Ϣ�б�
	 */
	public List<InquisitionHeaderSelectInfo> getList();
	/**
	 * ��ȡ�ʾ��ͷ����ѡ���б�
	 * @param inquisitionID
	 * @param headerID
	 * @return ��Ϣ�б�
	 */
	public List<InquisitionHeaderSelectInfo> getList(Long inquisitionID,Long headerID);

	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getTotal(Long headerID);
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
	public List<InquisitionHeaderSelectInfo> findByPage(Long headerID,final int firstResult, final int maxResult);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<InquisitionHeaderSelectInfo> findByPage(final int firstResult, final int maxResult);
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
	public List<InquisitionHeaderSelectInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
