package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.AddressCatalogInfo;


public interface IAddressCatalogInfoService {
	/**
	 * ����ͨѶ¼������Ϣ
	 * @param data ͨѶ¼������Ϣ
	 */
	public void saveAddressCatalogInfo(AddressCatalogInfo data);
	/**
	 * ����ͨѶ¼������Ϣ
	 * @param data ͨѶ¼������Ϣ
	 */
	public void updateAddressCatalogInfo(AddressCatalogInfo data);
	/**
	 * ɾ��ͨѶ¼������Ϣ
	 * @param data ͨѶ¼������Ϣ
	 */
	public void deleteAddressCatalogInfo(AddressCatalogInfo data);	
	/**
	 * ��ȡͨѶ¼������Ϣ
	 * @param acID �ʾ���
	 * @return ͨѶ¼������Ϣ
	 */
	public AddressCatalogInfo getAddressCatalogInfo(Long acID);
	/**
	 * ��ȡͨѶ¼������Ϣ�б�
	 * @return ͨѶ¼������Ϣ�б�
	 */
	public List<AddressCatalogInfo> getAddressCatalogInfoList();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getAddressCatalogInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<AddressCatalogInfo> findAddressCatalogInfoByPage(final int firstResult, final int maxResult);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getTotalByDelStatus();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<AddressCatalogInfo> findPageByDelStatus(final int firstResult, final int maxResult);

}
