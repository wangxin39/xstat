package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.PartQuestionInfo;


public interface IPartQuestionInfoService {
	/**
	 * �����ʾ���
	 * @param data �ʾ���
	 */
	public void savePartQuestionInfo(PartQuestionInfo data);
	/**
	 * �����ʾ���
	 * @param data �ʾ���
	 */
	public void updatePartQuestionInfo(PartQuestionInfo data);
	/**
	 * ɾ���ʾ���
	 * @param data �ʾ���
	 */
	public void deletePartQuestionInfo(PartQuestionInfo data);	
	/**
	 * ��ȡ�ʾ���
	 * @param partQuestionID �������ͱ��
	 * @return �ʾ���
	 */
	public PartQuestionInfo getPartQuestionInfo(Long inquisitionID);
	/**
	 * ��ȡ�ʾ����б�
	 * @return �ʾ����б�
	 */
	public List<PartQuestionInfo> getPartQuestionInfoList();
	public List<PartQuestionInfo> getPartQuestionInfoList(Long partID,Long questionID, Long inquisitionID);
	public List<PartQuestionInfo> getPartQuestionInfoList(Long inquisitionID,Long partID);
	public List<PartQuestionInfo> getPartQuestionInfoList(Long partID);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getPartQuestionInfoTotal(Long partID, Long questionID,Long inquisitionID);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getPartQuestionInfoTotal(Long partID,Long inquisitionID);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<PartQuestionInfo> findPartQuestionInfoByPage(final Long inquisitionID,final Long partID,final int firstResult, final int maxResult);
	
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<PartQuestionInfo> findPartQuestionInfoByPage(final Long questionID,final Long inquisitionID,final Long partID,final int firstResult, final int maxResult);
	
	public int getQuestionTotal(Long inquisitionID);
	public List<PartQuestionInfo> getFatherPqInfo(Long fatherPqID);
	
	public int getPartQuestionTotal(Long partID);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<PartQuestionInfo> findPartQuestionInfoByPage(final Long partID,final int firstResult, final int maxResult);
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
	public List<PartQuestionInfo> findPageByDelStatus(final int firstResult, final int maxResult);
	/**
	 * ��ȡ�ܼ�¼��
	 * @return �ܼ�¼��
	 */	
	public int getTotal();
	/**
	 * ��ȡ��ҳ����
	 * @param firstResult
	 * @param maxResult
	 * @return ��ҳ����
	 */
	public List<PartQuestionInfo> findByPage(final int firstResult, final int maxResult);
	/**
	 * ��ȡ��ǰ����������ʾ���
	 * @param inquisitionID
	 * @return ������ʾ���
	 */
	public int getLastShowNum(Long inquisitionID);	
	/**
	 * ���������ϼ���������Ĳ��������б�
	 * @param partQuestionID
	 * @return ���������б�
	 */
	public List<PartQuestionInfo> findByFather(Long partQuestionID);	
}
