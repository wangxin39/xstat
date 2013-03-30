package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.PartRecordInfo;


public interface IPartRecordInfoService {
	/**
	 * ��������ʾ�ͷ����Ϣ
	 * @param data �����ʾ�ͷ����Ϣ
	 */
	public void savePartRecordInfo(PartRecordInfo data);
	/**
	 * ���µ����ʾ�ͷ����Ϣ
	 * @param data �����ʾ�ͷ����Ϣ
	 */
	public void updatePartRecordInfo(PartRecordInfo data);
	/**
	 * ɾ�������ʾ�ͷ����Ϣ
	 * @param data �����ʾ�ͷ����Ϣ
	 */
	public void deletePartRecordInfo(PartRecordInfo data);	
	/**
	 * ��ȡ�����ʾ�ͷ����Ϣ
	 * @param answerID �ʾ�ͷ�����
	 * @return �����ʾ�ͷ����Ϣ
	 */
	public PartRecordInfo getPartRecordInfo(Long answerID);
	/**
	 * ��ȡ�����ʾ�ͷ����Ϣ�б�
	 * @return �����ʾ�ͷ����Ϣ�б�
	 */
	public List<PartRecordInfo> getPartRecordInfoList();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getPartRecordInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<PartRecordInfo> findPartRecordInfoByPage(final int firstResult, final int maxResult);
	/**
	 * ��ȡ��ǰ�ƻ�����
	 * @param planID
	 * @return �����Ϣ
	 */
	public List<PartRecordInfo> findByPlan(Long planID);
}
