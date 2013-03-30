package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.PlanInfo;


public interface IPlanInfoDao {
	/**
	 * �������ع˿Ͳ�����Ϣ
	 * @param data ���ع˿Ͳ�����Ϣ
	 */
	public void save(PlanInfo data);
	/**
	 * �������ع˿Ͳ�����Ϣ
	 * @param data ���ع˿Ͳ�����Ϣ
	 */
	public void update(PlanInfo data);
	/**
	 * ɾ�����ع˿Ͳ�����Ϣ
	 * @param data ���ع˿Ͳ�����Ϣ
	 */
	public void delete(PlanInfo data);	
	/**
	 * ��ȡ���ع˿Ͳ�����Ϣ
	 * @param planID ���ع˿Ͳ�����Ϣ���
	 * @return ���ع˿Ͳ�����Ϣ
	 */
	public PlanInfo getPlanInfo(Long planID);
	/**
	 * ��ȡ���ع˿Ͳ�����Ϣ�б�
	 * @return ���ع˿Ͳ�����Ϣ�б�
	 */
	public List<PlanInfo> getPlanInfoList();
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
	public List<PlanInfo> findByPage(final int firstResult, final int maxResult);

	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getTotal(long smgkID, int type);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<PlanInfo> findByPage(long smgkID, int type,final int firstResult, final int maxResult);	
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getClientTotal(long clientID, int type);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getTotal(long clientID,long smgkID,long inquisitionID);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<PlanInfo> findByClientPage(long clientID, int type,final int firstResult, final int maxResult);	
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<PlanInfo> findByPage(long clientID,long smgkID,long inquisitionID,final int firstResult, final int maxResult);	
	
	public List<PlanInfo> findBySmgk(Long smgkID);
	public List<PlanInfo> findByAccount(Long accountID);
	public List<PlanInfo> findByClient(Long clientID);	

	public List<PlanInfo> findBySmgk(Long smgkID,int inquisitionType);
	
	public List<PlanInfo> findByIssue(Long issueID);
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
	public List<PlanInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
