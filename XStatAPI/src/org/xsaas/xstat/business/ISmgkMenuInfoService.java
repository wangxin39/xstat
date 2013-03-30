package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.SmgkMenuInfo;


public interface ISmgkMenuInfoService {
	/**
	 * ����˵���Ϣ
	 * @param data �˵���Ϣ
	 */
	public void saveSmgkMenuInfo(SmgkMenuInfo data);
	/**
	 * ���²˵���Ϣ
	 * @param data �˵���Ϣ
	 */	
	public void updateSmgkMenuInfo(SmgkMenuInfo data);
	/**
	 * ɾ���˵�
	 * @param data �˵���Ϣ
	 */
	public void deleteSmgkMenuInfo(SmgkMenuInfo data);
	/**
	 * ��ȡ�˵�
	 * @return List<SmgkMenuInfo> �˵��б�
	 */
	public List<SmgkMenuInfo> getSmgkMenuInfoList();
	/**
	 * ��ȡָ���༭�˵���Ϣ
	 * @param menuID �˵����
	 * @return �˵���Ϣ
	 */
	public SmgkMenuInfo getSmgkMenuInfo(Long menuID);

	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getSmgkMenuInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<SmgkMenuInfo> findSmgkMenuInfoByPage(final int firstResult, final int maxResult);

}
