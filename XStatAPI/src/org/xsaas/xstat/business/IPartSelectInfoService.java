package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.PartSelectInfo;


public interface IPartSelectInfoService {
	/**
	 * ��������ѡ����Ϣ
	 * @param data ����ѡ����Ϣ
	 */
	public void savePartSelectInfo(PartSelectInfo data);
	/**
	 * ��������ѡ����Ϣ
	 * @param data ����ѡ����Ϣ
	 */
	public void updatePartSelectInfo(PartSelectInfo data);
	/**
	 * ɾ������ѡ����Ϣ
	 * @param data ����ѡ����Ϣ
	 */
	public void deletePartSelectInfo(PartSelectInfo data);	
	/**
	 * ��ȡ����ѡ����Ϣ
	 * @param partQuestionSelectID ���ⲿ��ѡ����
	 * @return ����ѡ����Ϣ
	 */
	public PartSelectInfo getPartSelectInfo(Long partQuestionSelectID);
	/**
	 * ��ȡ����ѡ����Ϣ�б�
	 * @return ����ѡ����Ϣ�б�
	 */
	public List<PartSelectInfo> getPartSelectInfoList();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getPartSelectInfoTotal(long inquisitionID);
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
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<PartSelectInfo> findPartSelectInfoByPage(long inquisitionID,final int firstResult, final int maxResult);
	/**
	 * ��ȡָ�������ѡ��
	 * @param inquestionID
	 * @param partQuestionID
	 * @return List<PartSelectInfo> ѡ���б�
	 */
	public List<PartSelectInfo> findByQuestion(Long inquisitionID,Long partQuestionID);
	/**
	 * ��ȡָ�������ѡ��
	 * @param inquestionID
	 * @param partQuestionID
	 * @return List<PartSelectInfo> ѡ���б�
	 */
	public List<PartSelectInfo> findByQuestion(Long partQuestionID);
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
