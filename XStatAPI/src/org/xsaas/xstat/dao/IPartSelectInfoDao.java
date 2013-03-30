package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.PartSelectInfo;


public interface IPartSelectInfoDao {
	/**
	 * �����ʾ���ѡ��
	 * @param data �ʾ���ѡ��
	 */
	public void save(PartSelectInfo data);
	/**
	 * �����ʾ���ѡ��
	 * @param data �ʾ���ѡ��
	 */
	public void update(PartSelectInfo data);
	/**
	 * ɾ���ʾ���ѡ��
	 * @param data �ʾ���ѡ��
	 */
	public void delete(PartSelectInfo data);	
	/**
	 * ��ȡ�ʾ���ѡ��
	 * @param partQuestionSelectID ���ⲿ��ѡ����
	 * @return �ʾ���ѡ��
	 */
	public PartSelectInfo getPartSelectInfo(Long partQuestionSelectID);
	/**
	 * ��ȡ�ʾ���ѡ���б�
	 * @return �ʾ���ѡ���б�
	 */
	public List<PartSelectInfo> getPartSelectInfoList();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getTotal(long questionID);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<PartSelectInfo> findByPage(long questionID,final int firstResult, final int maxResult);

	/**
	 * ��ȡָ�������ѡ��
	 * @param inquestionID
	 * @param partQuestionID
	 * @param questionID
	 * @return List<PartSelectInfo> ѡ���б�
	 */
	public List<PartSelectInfo> findByQuestion(Long inquisitionID,Long partQuestionID);

	/**
	 * ��ȡָ�������ѡ��
	 * @param inquestionID
	 * @param partQuestionID
	 * @param questionID
	 * @return List<PartSelectInfo> ѡ���б�
	 */
	public List<PartSelectInfo> findByQuestion(Long partQuestionID);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getPartSelectInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<PartSelectInfo> findPartSelectInfoByPage(final int firstResult, final int maxResult);
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
	public List<PartSelectInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
