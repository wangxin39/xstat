package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.SitePopedomInfo;


public interface ISitePopedomInfoDao {
	/**
	 * ������վȨ����Ϣ
	 * @param data ������Դ������Ϣ
	 */
	public void save(SitePopedomInfo data);
	/**
	 * ������վȨ����Ϣ
	 * @param data ��վȨ����Ϣ
	 */
	public void update(SitePopedomInfo data);
	/**
	 * ɾ����վȨ����Ϣ
	 * @param data ��վȨ����Ϣ
	 */
	public void delete(SitePopedomInfo data);	
	/**
	 * ��ȡ��վȨ����Ϣ
	 * @param sitePopedomID ��վȨ�ޱ��
	 * @return ��վȨ����Ϣ
	 */
	public SitePopedomInfo getSitePopedomInfo(Long sitePopedomID);
	/**
	 * ��ȡ��վȨ����Ϣ�б�
	 * @return ��վȨ����Ϣ�б�
	 */
	public List<SitePopedomInfo> getSitePopedomInfoList();
	/**
	 * ��ȡ��վȨ����Ϣ�б�
	 * @return ��վȨ����Ϣ�б�
	 */
	public List<SitePopedomInfo> getSitePopedomInfoList(Long employeeID);
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
	public List<SitePopedomInfo> findByPage(final int firstResult, final int maxResult);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getSitePopedomInfoTotal(long employeeID);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<SitePopedomInfo> findSitePopedomInfoByPage(long employeeID,final int firstResult, final int maxResult);

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
	public List<SitePopedomInfo> findPageByDelStatus(final int firstResult, final int maxResult);
	
}
