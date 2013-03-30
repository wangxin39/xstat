package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.HeaderRecordInfo;


public interface IHeaderRecordInfoDao {
	/**
	 * ��������ʾ�ͷ����Ϣ
	 * @param data �����ʾ�ͷ����Ϣ
	 */
	public void save(HeaderRecordInfo data);
	/**
	 * ���µ����ʾ�ͷ����Ϣ
	 * @param data �����ʾ�ͷ����Ϣ
	 */
	public void update(HeaderRecordInfo data);
	/**
	 * ɾ�������ʾ�ͷ����Ϣ
	 * @param data �����ʾ�ͷ����Ϣ
	 */
	public void delete(HeaderRecordInfo data);	
	/**
	 * ��ȡ�����ʾ�ͷ����Ϣ
	 * @param answerID �����ʾ�ͷ����Ϣ���
	 * @return �����ʾ�ͷ����Ϣ
	 */
	public HeaderRecordInfo getInfo(Long answerID);
	/**
	 * ��ȡ�����ʾ�ͷ����Ϣ�б�
	 * @return �����ʾ�ͷ����Ϣ�б�
	 */
	public List<HeaderRecordInfo> getList();
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
	public List<HeaderRecordInfo> findByPage(final int firstResult, final int maxResult);

	
}
