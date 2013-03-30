package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.ReqResultInfo;


public interface IReqResultInfoDao {
	/**
	 * ����˿���֤��Ϣ
	 * @param data �˿���֤��Ϣ
	 */
	public void saveReqResultInfo(ReqResultInfo data);
	/**
	 * ���¹˿���֤��Ϣ
	 * @param data �˿���֤��Ϣ
	 */
	public void updateReqResultInfo(ReqResultInfo data);
	/**
	 * ɾ���˿���֤��Ϣ
	 * @param data �˿���֤��Ϣ
	 */
	public void deleteReqResultInfo(ReqResultInfo data);	
	/**
	 * ��ȡ�˿���֤��Ϣ
	 * @param authID �ʾ���
	 * @return �˿���֤��Ϣ
	 */
	public ReqResultInfo getReqResultInfo(Long authID);
	/**
	 * ��ȡ�˿���֤��Ϣ�б�
	 * @return �˿���֤��Ϣ�б�
	 */
	public List<ReqResultInfo> getReqResultInfoList();
	public ReqResultInfo findReqResultInfoBySmgk(long smgkID);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getReqResultInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<ReqResultInfo> findReqResultInfoByPage(final int firstResult, final int maxResult);
	/**
	 * ��ȡ�˿���֤��Ϣ�б�
	 * @return �˿���֤��Ϣ�б�
	 */
	public List<ReqResultInfo> findReqResultInfoByReq(Long reqID);
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
	public List<ReqResultInfo> findPageByDelStatus(final int firstResult, final int maxResult);

}
