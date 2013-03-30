package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.CheckDetailInfo;


public interface ICheckDetailInfoDao {
	/**
	 * ������ͻ���Ϣ
	 * @param data ���ͻ���Ϣ
	 */
	public void saveCheckDetailInfo(CheckDetailInfo data);
	/**
	 * ���¼��ͻ���Ϣ
	 * @param data ���ͻ���Ϣ
	 */
	public void updateCheckDetailInfo(CheckDetailInfo data);
	/**
	 * ɾ�����ͻ���Ϣ
	 * @param data ���ͻ���Ϣ
	 */
	public void deleteCheckDetailInfo(CheckDetailInfo data);	
	/**
	 * ��ȡ���ͻ���Ϣ
	 * @param clientID �ʾ���
	 * @return ���ͻ���Ϣ
	 */
	public CheckDetailInfo getCheckDetailInfo(Long clientID);
	/**
	 * ��ȡ���ͻ���Ϣ�б�
	 * @return ���ͻ���Ϣ�б�
	 */
	public List<CheckDetailInfo> getCheckDetailInfoList();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getCheckDetailInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<CheckDetailInfo> findCheckDetailInfoByPage(final int firstResult, final int maxResult);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getTotal(Long issueID,Long informantID,Long inquisitionID);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<CheckDetailInfo> findByPage(Long issueID,Long informantID,Long inquisitionID,final int firstResult, final int maxResult);
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
	public List<CheckDetailInfo> findPageByDelStatus(final int firstResult, final int maxResult);

	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getCheckDetailInfoTotal(Long clientID);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<CheckDetailInfo> findCheckDetailInfoByPage(Long clientID,final int firstResult, final int maxResult);


}
