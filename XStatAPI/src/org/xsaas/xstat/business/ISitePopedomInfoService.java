package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.SitePopedomInfo;


public interface ISitePopedomInfoService {
	/**
	 * ������վȨ����Ϣ
	 * @param data ��վȨ����Ϣ
	 */
	public void saveSitePopedomInfo(SitePopedomInfo data);
	/**
	 * ������վȨ����Ϣ
	 * @param data ��վȨ����Ϣ
	 */
	public void updateSitePopedomInfo(SitePopedomInfo data);
	/**
	 * ɾ����վȨ����Ϣ
	 * @param data ��վȨ����Ϣ
	 */
	public void deleteSitePopedomInfo(SitePopedomInfo data);	
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
	 * ��Ϣ����
	 * @return ����
	 */
	public int getSitePopedomInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<SitePopedomInfo> findSitePopedomInfoByPage(final int firstResult, final int maxResult);
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
	/**
	 * ��ȡ��վȨ����Ϣ�б�
	 * @return ��վȨ����Ϣ�б�
	 */
	public List<SitePopedomInfo> getSitePopedomInfoList(Long employeeID);

}
