package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.PartRecordInfo;


public interface IPartRecordInfoDao {
	/**
	 * ��������ʾ�ͷ����Ϣ
	 * @param data �����ʾ�ͷ����Ϣ
	 */
	public void save(PartRecordInfo data);
	/**
	 * ���µ����ʾ�ͷ����Ϣ
	 * @param data �����ʾ�ͷ����Ϣ
	 */
	public void update(PartRecordInfo data);
	/**
	 * ɾ�������ʾ�ͷ����Ϣ
	 * @param data �����ʾ�ͷ����Ϣ
	 */
	public void delete(PartRecordInfo data);	
	/**
	 * ��ȡ�����ʾ�ͷ����Ϣ
	 * @param answerID �����ʾ�ͷ����Ϣ���
	 * @return �����ʾ�ͷ����Ϣ
	 */
	public PartRecordInfo getInfo(Long answerID);
	/**
	 * ��ȡ�����ʾ�ͷ����Ϣ�б�
	 * @return �����ʾ�ͷ����Ϣ�б�
	 */
	public List<PartRecordInfo> getList();
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
	public List<PartRecordInfo> findByPage(final int firstResult, final int maxResult);
	/**
	 * ��ȡ��ǰ�ƻ�����
	 * @param planID
	 * @return �����Ϣ
	 */
	public List<PartRecordInfo> findByPlan(Long planID);
	
}
