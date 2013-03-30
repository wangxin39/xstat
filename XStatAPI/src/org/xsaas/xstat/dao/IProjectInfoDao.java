package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.ProjectInfo;


public interface IProjectInfoDao {
	/**
	 * ����˿ͼ����Ϣ
	 * @param data �˿ͼ����Ϣ
	 */
	public void saveProjectInfo(ProjectInfo data);
	/**
	 * ���¹˿ͼ����Ϣ
	 * @param data �˿ͼ����Ϣ
	 */
	public void updateProjectInfo(ProjectInfo data);
	/**
	 * ɾ���˿ͼ����Ϣ
	 * @param data �˿ͼ����Ϣ
	 */
	public void deleteProjectInfo(ProjectInfo data);	
	/**
	 * ��ȡ�˿ͼ����Ϣ
	 * @param projectID �ʾ���
	 * @return �˿ͼ����Ϣ
	 */
	public ProjectInfo getProjectInfo(Long projectID);
	public ProjectInfo getProjectInfoClient(long clientID);
	/**
	 * ��ȡ�˿ͼ����Ϣ�б�
	 * @return �˿ͼ����Ϣ�б�
	 */
	public List<ProjectInfo> getProjectInfoList();
	/**
	 * ��ȡ�˿ͼ����Ϣ�б�
	 * @return �˿ͼ����Ϣ�б�
	 */
	public List<ProjectInfo> getProjectInfoList(Long clientID);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getProjectInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<ProjectInfo> findProjectInfoByPage(final int firstResult, final int maxResult);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getProjectInfoTotal(long clientID,int status);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<ProjectInfo> findProjectInfoByPage(long clientID,int status,final int firstResult, final int maxResult);
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
	public List<ProjectInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
