package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.HeaderRecordInfo;


public interface IHeaderRecordInfoService {
	/**
	 * ��������ʾ�ͷ����Ϣ
	 * @param data �����ʾ�ͷ����Ϣ
	 */
	public void saveHeaderRecordInfo(HeaderRecordInfo data);
	/**
	 * ���µ����ʾ�ͷ����Ϣ
	 * @param data �����ʾ�ͷ����Ϣ
	 */
	public void updateHeaderRecordInfo(HeaderRecordInfo data);
	/**
	 * ɾ�������ʾ�ͷ����Ϣ
	 * @param data �����ʾ�ͷ����Ϣ
	 */
	public void deleteHeaderRecordInfo(HeaderRecordInfo data);	
	/**
	 * ��ȡ�����ʾ�ͷ����Ϣ
	 * @param answerID �ʾ�ͷ�����
	 * @return �����ʾ�ͷ����Ϣ
	 */
	public HeaderRecordInfo getHeaderRecordInfo(Long answerID);
	/**
	 * ��ȡ�����ʾ�ͷ����Ϣ�б�
	 * @return �����ʾ�ͷ����Ϣ�б�
	 */
	public List<HeaderRecordInfo> getHeaderRecordInfoList();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getHeaderRecordInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<HeaderRecordInfo> findHeaderRecordInfoByPage(final int firstResult, final int maxResult);

}
