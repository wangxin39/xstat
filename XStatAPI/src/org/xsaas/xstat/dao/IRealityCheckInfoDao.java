package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.RealityCheckInfo;


public interface IRealityCheckInfoDao {
	/**
	 * ������ͻ���Ϣ
	 * @param data ���ͻ���Ϣ
	 */
	public void saveRealityCheckInfo(RealityCheckInfo data);
	/**
	 * ���¼��ͻ���Ϣ
	 * @param data ���ͻ���Ϣ
	 */
	public void updateRealityCheckInfo(RealityCheckInfo data);
	/**
	 * ɾ�����ͻ���Ϣ
	 * @param data ���ͻ���Ϣ
	 */
	public void deleteRealityCheckInfo(RealityCheckInfo data);	
	/**
	 * ��ȡ���ͻ���Ϣ
	 * @param clientID �ʾ���
	 * @return ���ͻ���Ϣ
	 */
	public RealityCheckInfo getRealityCheckInfo(Long clientID);
	/**
	 * ��ȡ���ͻ���Ϣ�б�
	 * @return ���ͻ���Ϣ�б�
	 */
	public List<RealityCheckInfo> getRealityCheckInfoList();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getRealityCheckInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<RealityCheckInfo> findRealityCheckInfoByPage(final int firstResult, final int maxResult);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getTotal(Long issueID,Long inquisitionID);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<RealityCheckInfo> findByPage(Long issueID,Long inquisitionID,final int firstResult, final int maxResult);
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
	public List<RealityCheckInfo> findPageByDelStatus(final int firstResult, final int maxResult);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getRealityCheckInfoTotal(Long clientID);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<RealityCheckInfo> findRealityCheckInfoByPage(Long clientID,final int firstResult, final int maxResult);


}
