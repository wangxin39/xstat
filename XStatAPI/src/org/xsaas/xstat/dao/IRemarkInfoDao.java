package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.RemarkInfo;


public interface IRemarkInfoDao {
	/**
	 * ��������ʾ��˹�������Ϣ
	 * @param data �����ʾ��˹�������Ϣ
	 */
	public void save(RemarkInfo data);
	/**
	 * ���µ����ʾ��˹�������Ϣ
	 * @param data �����ʾ��˹�������Ϣ
	 */
	public void update(RemarkInfo data);
	/**
	 * ɾ�������ʾ��˹�������Ϣ
	 * @param data �����ʾ��˹�������Ϣ
	 */
	public void delete(RemarkInfo data);	
	/**
	 * ��ȡ�����ʾ��˹�������Ϣ
	 * @param remarkID �˹�������
	 * @return �����ʾ��˹�������Ϣ
	 */
	public RemarkInfo getRemarkInfo(Long remarkID);
	/**
	 * ��ȡ�����ʾ��˹�������Ϣ�б�
	 * @return �����ʾ��˹�������Ϣ�б�
	 */
	public List<RemarkInfo> getRemarkInfoList();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getTotal(long inquisitionID);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<RemarkInfo> findByPage(long inquisitionID,final int firstResult, final int maxResult);
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
	public List<RemarkInfo> findByPage(final int firstResult, final int maxResult);
	
	/**
	 * ��ȡ������Ϣ
	 * @param issueID
	 * @param informantID
	 * @param inquisitionID
	 * @return ������Ϣ�б�
	 */
	public List<RemarkInfo> findByInformant(Long issueID, Long informantID, Long inquisitionID);
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
	public List<RemarkInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
