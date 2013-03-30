package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.SelectWeightInfo;


public interface ISelectWeightInfoService {
	/**
	 * �����ʾ���
	 * @param data �ʾ���
	 */
	public void save(SelectWeightInfo data);
	/**
	 * �����ʾ���
	 * @param data �ʾ���
	 */
	public void update(SelectWeightInfo data);
	/**
	 * ɾ���ʾ���
	 * @param data �ʾ���
	 */
	public void delete(SelectWeightInfo data);	
	/**
	 * ��ȡȨ����Ϣ
	 * @param qpID Ȩ�ر��
	 * @return Ȩ���趨��Ϣ
	 */
	public SelectWeightInfo getSelectWeightInfo(Long qpID);
	
	/**
	 * ��ȡָ��ѡ��Ȩ���趨��Ϣ
	 * @param inquisitionID �����ʾ���
	 * @param partQuestionID ����������
	 * @param selectID ѡ����
	 * @return Ȩ���趨��Ϣ
	 */
	public SelectWeightInfo getSelectWeightInfo(Long inquisitionID, Long partQuestionID, Long selectID);
	public int getTotal();	
	public int getTotal(Long inquisitionID, Long partID);
	public int getTotal(Long inquisitionID);
	public int getCountWeight(Long inquisitionID,Long partID);
	public int getTotalByDelStatus();
	
	public List<SelectWeightInfo> findByPage(final int firstResult,final int maxResult);
	public List<SelectWeightInfo> findByPage(Long inquisitionID, Long partID,final int firstResult,final int maxResult);
	public List<SelectWeightInfo> findByPage(final Long inquisitionID, final int firstResult,final int maxResult);
	
	public List<SelectWeightInfo> findByPart(Long inquisitionID, Long partID);
	public List<SelectWeightInfo> findByPartQuestion(Long inquisitionID,Long partQuestionID);
	public List<SelectWeightInfo> findByDelStatus(final int firstResult, final int maxResult);
	public int getSumWeightByQuestion(Long inquisitionID,Long partQuestionID);
}
