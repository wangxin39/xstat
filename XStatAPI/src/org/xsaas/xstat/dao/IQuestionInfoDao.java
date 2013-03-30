package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.QuestionInfo;


public interface IQuestionInfoDao {
	/**
	 * �����ʾ���Ϣ
	 * @param data �ʾ���Ϣ
	 */
	public void save(QuestionInfo data);
	/**
	 * ɾ���ʾ���Ϣ
	 * @param data �ʾ���Ϣ
	 */
	public void delete(QuestionInfo data);
	/**
	 * �޸��ʾ���Ϣ
	 * @param data �ʾ���Ϣ
	 */
	public void update(QuestionInfo data);
	/**
	 * ��ȡָ���ʾ���Ϣ
	 * @param questionID �ʾ�������
	 * @return �ʾ���Ϣ
	 */
	public QuestionInfo getQuestionInfo(Long questionID);
	/**
	 * ��ȡ������Ϣ�б�

	 * @return List<QuestionInfo>�ʾ���Ϣ
	 */
	public List<QuestionInfo> getQuestionInfoList();
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
	public List<QuestionInfo> findByPage(final int questionType,final String keyword,final int firstResult, final int maxResult);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getTotal(int questionType,String keyword);
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
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<QuestionInfo> findByPage(final int firstResult, final int maxResult);
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
}
