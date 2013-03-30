package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.SmgkMenuInfo;


public interface ISmgkMenuInfoDao {
	/**
	 * ����˵���Ϣ
	 * @param data �˵���Ϣ
	 */
	public void save(SmgkMenuInfo data);
	/**
	 * ���²˵���Ϣ
	 * @param data �˵���Ϣ
	 */	
	public void update(SmgkMenuInfo data);
	/**
	 * ɾ���˵�
	 * @param data �˵���Ϣ
	 */
	public void delete(SmgkMenuInfo data);
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
	public int getTotal();
	/**
	 * ��ȡ�˵�
	 * @return List<SmgkMenuInfo> �˵��б�
	 */
	public List<SmgkMenuInfo> getSmgkMenuInfoList();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<SmgkMenuInfo> findByPage(final int firstResult,final int maxResult);
	
}
