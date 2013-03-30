package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.MenuInfo;


public interface IMenuInfoDao {
	/**
	 * ����˵���Ϣ
	 * @param data �˵���Ϣ
	 */
	public void save(MenuInfo data);
	/**
	 * ���²˵���Ϣ
	 * @param data �˵���Ϣ
	 */	
	public void update(MenuInfo data);
	/**
	 * ɾ���˵�
	 * @param data �˵���Ϣ
	 */
	public void delete(MenuInfo data);
	/**
	 * ��ȡָ���༭�˵���Ϣ
	 * @param menuID �˵����
	 * @return �˵���Ϣ
	 */
	public MenuInfo getMenuInfo(Long menuID);
	/**
	 * ��ȡ�˵�
	 * @param parentID Ϊ0����Ϊһ���˵���ָ���ϼ��˵���ţ��򷵻ظò˵��µĲ˵�
	 * @param type 1���������ϵͳ��2�����ع˿�ϵͳ��3���ͻ�����ϵͳ��4����˱༭ϵͳ
	 * @return List<MenuInfo> �˵��б�
	 */
	public List<MenuInfo> getMenuInfoList(Long parentID,int type);
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
	public List<MenuInfo> findByPage(final int firstResult, final int maxResult);
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
	public List<MenuInfo> findPageByDelStatus(final int firstResult, final int maxResult);

}
