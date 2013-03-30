package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.IssueInfo;


public interface IIssueInfoDao {
	/**
	 * ������Ŀ��ѵ��Ϣ
	 * @param data ��Ŀ��ѵ��Ϣ
	 */
	public void save(IssueInfo data);
	/**
	 * ɾ����Ŀ��ѵ��Ϣ
	 * @param data ��Ŀ��ѵ��Ϣ
	 */
	public void delete(IssueInfo data);
	/**
	 * �޸���Ŀ��ѵ��Ϣ
	 * @param data ��Ŀ��ѵ��Ϣ
	 */
	public void update(IssueInfo data);
	/**
	 * ��ȡ��Ŀ��ѵ��Ϣ
	 * @param ptID ��Ŀ��ѵ��Ŀ��ѵ���
	 * @return ��Ŀ��ѵ��Ϣ
	 */
	public IssueInfo getIssueInfo(Long ptID);
	/**
	 * ��ȡ��Ŀ��ѵ��Ϣ
	 * @param ptID ��Ŀ��ѵ��Ŀ��ѵ���
	 * @return ��Ŀ��ѵ��Ϣ
	 */
	public IssueInfo getIssueInfoSmgk(long smgkID);
	/**
	 * ��ȡ��Ŀ��ѵ��Ϣ�б�
	 * @return List<IssueInfo>��Ŀ��ѵ��Ϣ
	 */
	public List<IssueInfo> getIssueInfoList();
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
	public List<IssueInfo> findByPage(final int firstResult, final int maxResult);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getTotal(long smgkID,int status);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<IssueInfo> findByPage(long smgkID,int status,final int firstResult, final int maxResult);
	/**
	 * �ж��Ƿ��Ѵ���
	 * @param issue
	 * @return true �Ѵ��ڣ� false ������
	 */
	public boolean isRegister(String issue);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getTotal(Long clientID);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<IssueInfo> findByPage(Long clientID,final int firstResult, final int maxResult);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getIssueInfoTotal(Long clientID);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<IssueInfo> findIssueInfoByPage(Long clientID,final int firstResult, final int maxResult);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getTotal(Long clientID,Long issueID);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<IssueInfo> findByPage(Long clientID,Long issueID,final int firstResult, final int maxResult);
	/**
	 * ��ȡ��Ŀ��ѵ��Ϣ�б�
	 * @return ��Ŀ��ѵ��Ϣ�б�
	 */
	public List<IssueInfo> getList(Long inquisitionID);
	/**
	 * ��ȡ��Ŀ��ѵ��Ϣ�б�
	 * @return ��Ŀ��ѵ��Ϣ�б�
	 */
	public List<IssueInfo> getList(Long projectID,Long inquisitionID);
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
	public List<IssueInfo> findPageByDelStatus(final int firstResult, final int maxResult);
	
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getIssueInfoTotal(Long clientID,Long issueID);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<IssueInfo> findIssueInfoByPage(Long clientID,Long issueID,final int firstResult, final int maxResult);
	/**
	 * ��ȡ������Ч�ڴΣ����ں�̨ͳ��
	 * @return ��Ч�ڴ�
	 */
	public List<IssueInfo> findIssueInfoListByReportStatus();
	/**
	 * ���ݵ�ǰ�ڴΣ���ȡ��һ�ڴα��
	 * @param clientID �ͻ����
	 * @param projectID ��Ŀ���
	 * @param issue ��ǰ�ڴ�
	 * @return ������Ϣ
	 */
	public IssueInfo getLastIssueID(Long clientID,Long projectID,String issue);
}
