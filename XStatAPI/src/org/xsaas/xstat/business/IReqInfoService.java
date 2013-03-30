package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.ReqInfo;


public interface IReqInfoService {
	/**
	 * ������������Ϣ
	 * @param data ���������Ϣ
	 */
	public void saveReqInfo(ReqInfo data);
	/**
	 * ���¼��������Ϣ
	 * @param data ���������Ϣ
	 */
	public void updateReqInfo(ReqInfo data);
	/**
	 * ɾ�����������Ϣ
	 * @param data ���������Ϣ
	 */
	public void deleteReqInfo(ReqInfo data);	
	/**
	 * ��ȡ���������Ϣ
	 * @param reqID �ʾ���
	 * @return ���������Ϣ
	 */
	public ReqInfo getReqInfo(Long reqID);
	/**
	 * ��ȡ���������Ϣ�б�
	 * @return ���������Ϣ�б�
	 */
	public List<ReqInfo> getReqInfoList();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getReqInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<ReqInfo> findReqInfoByPage(final int firstResult, final int maxResult);
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
	public List<ReqInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
