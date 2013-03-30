package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.IssueInfo;


public interface IIssueInfoService {
	/**
	 * ������Ŀ��ѵ��Ϣ
	 * @param data ��Ŀ��ѵ��Ϣ
	 */
	public void saveIssueInfo(IssueInfo data);
	/**
	 * ������Ŀ��ѵ��Ϣ
	 * @param data ��Ŀ��ѵ��Ϣ
	 */
	public void updateIssueInfo(IssueInfo data);
	/**
	 * ɾ����Ŀ��ѵ��Ϣ
	 * @param data ��Ŀ��ѵ��Ϣ
	 */
	public void deleteIssueInfo(IssueInfo data);	
	/**
	 * ��ȡ��Ŀ��ѵ��Ϣ
	 * @param ptID ��ѵ���
	 * @return ��Ŀ��ѵ��Ϣ
	 */
	public IssueInfo getIssueInfo(Long ptID);
	public IssueInfo getIssueInfoSmgk(long smgkID);
	/**
	 * ��ȡ��Ŀ��ѵ��Ϣ�б�
	 * @return ��Ŀ��ѵ��Ϣ�б�
	 */
	public List<IssueInfo> getIssueInfoList();
	/**
	 * ��ȡ��Ŀ��ѵ��Ϣ�б�
	 * @return ��Ŀ��ѵ��Ϣ�б�
	 */
	public List<IssueInfo> getIssueInfoList(Long inquisitionID);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getIssueInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<IssueInfo> findIssueInfoByPage(final int firstResult, final int maxResult);
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
	 * ��ȡ��Ŀ��ѵ��Ϣ�б�
	 * @return ��Ŀ��ѵ��Ϣ�б�
	 */
	public List<IssueInfo> getList(Long inquisitionID,Long projectID);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<IssueInfo> findByPage(Long clientID,Long issueID,final int firstResult, final int maxResult);

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
