package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.QuestionInfo;


public interface IQuestionInfoService {

	/**
	 * �����ʾ�������Ϣ
	 * @param data �ʾ�������Ϣ
	 */
	public void save(QuestionInfo data);
	/**
	 * ɾ���ʾ�������Ϣ
	 * @param data �ʾ�������Ϣ
	 */
	public void delete(QuestionInfo data);
	/***
	 * �����ʾ�������Ϣ
	 * @param data �ʾ�������Ϣ
	 */
	public void update(QuestionInfo data);
	/**
	 * ��ȡ�ʾ�������Ϣ
	 * @param questionID �ʾ�������
	 * @return �ʾ�������Ϣ
	 */
	public QuestionInfo getQuestionInfo(long questionID);
	/**
	 * ��ȡ�ʾ�������Ϣ�б�
	 * @return �ʾ�������Ϣ
	 */
	public List<QuestionInfo> getQuestionInfoList();
	
	public int getQuestionInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<QuestionInfo> findByPage(final int firstResult, final int maxResult);
	/**
	 * ��ȡָ���������͵������б�
	 * @param questionType
	 * @param firstResult
	 * @param maxResult
	 * @return List<QuestionInfo>
	 */
	public List<QuestionInfo> findByPage(final int questionType, final int firstResult,final int maxResult);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getTotal(int questionType);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getTotal(int questionType,String keyword);	
	public List<QuestionInfo> findByPage(final int questionType,final String keyword,final int firstResult,final int maxResult);
	
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
	public List<QuestionInfo> findPageByDelStatus(final int firstResult, final int maxResult);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<QuestionInfo> findByPage(final String keyword,final int firstResult, final int maxResult);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getTotal(String keyword);
	
}
