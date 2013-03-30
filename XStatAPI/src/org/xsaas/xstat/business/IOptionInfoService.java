package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.OptionInfo;


public interface IOptionInfoService {
	/**
	 * �����ʾ�ѡ����Ϣ
	 * @param data �ʾ�ѡ����Ϣ
	 */
	public void save(OptionInfo data);
	/**
	 * �����ʾ�ѡ����Ϣ
	 * @param data �ʾ�ѡ����Ϣ
	 */
	public void update(OptionInfo data);
	/**
	 * ɾ���ʾ�ѡ����Ϣ
	 * @param data �ʾ�ѡ����Ϣ
	 */
	public void delete(OptionInfo data);	
	/**
	 * ��ȡ�ʾ�ѡ����Ϣ
	 * @param optionID �ʾ�ѡ����
	 * @return �ʾ�ѡ����Ϣ
	 */
	public OptionInfo getOptionInfo(Long optionID);
	/**
	 * ��ȡ�ʾ�ѡ����Ϣ�б�
	 * @return �ʾ�ѡ����Ϣ�б�
	 */
	public List<OptionInfo> getList(Integer type);
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
	public List<OptionInfo> findByPage(final int firstResult, final int maxResult);
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
	public List<OptionInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
