package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.OutputInfo;


public interface IOutputInfoService {
	/**
	 * ���汨�淭����Ϣ
	 * @param data ���淭����Ϣ
	 */
	public void saveOutputInfo(OutputInfo data);
	/**
	 * ���±��淭����Ϣ
	 * @param data ���淭����Ϣ
	 */
	public void updateOutputInfo(OutputInfo data);
	/**
	 * ɾ�����淭����Ϣ
	 * @param data ���淭����Ϣ
	 */
	public void deleteOutputInfo(OutputInfo data);	
	/**
	 * ��ȡ���淭����Ϣ
	 * @param translateID ���淭����
	 * @return ���淭����Ϣ
	 */
	public OutputInfo getOutputInfo(Long translateID);
	/**
	 * ��ȡ���淭����Ϣ�б�
	 * @return ���淭����Ϣ�б�
	 */
	public List<OutputInfo> getOutputInfoList();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getOutputInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<OutputInfo> findOutputInfoByPage(final int firstResult, final int maxResult);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getOutputInfoTotal(Long informantID,Long issueID);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<OutputInfo> findOutputInfoByPage(Long informantID,Long issueID,final int firstResult, final int maxResult);

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
	public List<OutputInfo> findPageByDelStatus(final int firstResult, final int maxResult);

}
