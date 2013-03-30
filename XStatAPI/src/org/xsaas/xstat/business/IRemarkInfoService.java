package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.RemarkInfo;


public interface IRemarkInfoService {
	/**
	 * �����ʾ��˹�������Ϣ
	 * @param data �ʾ��˹�������Ϣ
	 */
	public void saveRemarkInfo(RemarkInfo data);
	/**
	 * �����ʾ��˹�������Ϣ
	 * @param data �ʾ��˹�������Ϣ
	 */
	public void updateRemarkInfo(RemarkInfo data);
	/**
	 * ɾ���ʾ��˹�������Ϣ
	 * @param data �ʾ��˹�������Ϣ
	 */
	public void deleteRemarkInfo(RemarkInfo data);	
	/**
	 * ��ȡ�ʾ��˹�������Ϣ
	 * @param remarkID �ʾ��˹����ֱ��
	 * @return �ʾ��˹�������Ϣ
	 */
	public RemarkInfo getRemarkInfo(Long remarkID);
	/**
	 * ��ȡ�ʾ��˹�������Ϣ�б�
	 * @return �ʾ��˹�������Ϣ�б�
	 */
	public List<RemarkInfo> getRemarkInfoList();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getRemarkInfoTotal(long inquisitionID);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<RemarkInfo> findRemarkInfoByPage(long inquisitionID,final int firstResult, final int maxResult);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getRemarkInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<RemarkInfo> findRemarkInfoByPage(final int firstResult, final int maxResult);
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
