package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.ReqResultInfo;


public interface IReqResultInfoService {
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
	/**
	 * ��ȡ�˿���֤��Ϣ�б�
	 * @return �˿���֤��Ϣ�б�
	 */
	public List<ReqResultInfo> findReqResultInfoByReq(Long reqID);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getReqResultInfoTotal();
	public ReqResultInfo findReqResultInfoBySmgk(long smgkID);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<ReqResultInfo> findReqResultInfoByPage(final int firstResult, final int maxResult);
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
