package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.InformantEvaluationInfo;


public interface IInformantEvaluationInfoService {
	/**
	 * ��������ʾ���Ϣ
	 * @param data �����ʾ���Ϣ
	 */
	public void save(InformantEvaluationInfo data);
	/**
	 * ���µ����ʾ���Ϣ
	 * @param data �����ʾ���Ϣ
	 */
	public void update(InformantEvaluationInfo data);
	/**
	 * ɾ�������ʾ���Ϣ
	 * @param data �����ʾ���Ϣ
	 */
	public void delete(InformantEvaluationInfo data);	
	/**
	 * ��ȡ�����ʾ���Ϣ
	 * @param inquisitionID �����ʾ���
	 * @return �����ʾ���Ϣ
	 */
	public InformantEvaluationInfo getInformantEvaluationInfo(Long inquisitionID);
	/**
	 * ��ȡ�����ʾ���Ϣ�б�
	 * @return �����ʾ���Ϣ�б�
	 */
	public List<InformantEvaluationInfo> getInformantEvaluationInfoList();
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
	public List<InformantEvaluationInfo> findByPage(final int firstResult, final int maxResult);
	/**
	 * ȡ��ָ���ڴκ͵����������������Ϣ
	 * @param issueID
	 * @param informantID
	 * @return ������Ϣ�б�
	 */
	public List<InformantEvaluationInfo> findByInformant(Long issueID,Long informantID);
}
