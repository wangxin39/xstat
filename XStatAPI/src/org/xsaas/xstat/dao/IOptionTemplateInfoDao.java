package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.OptionTemplateInfo;


public interface IOptionTemplateInfoDao {
	/**
	 * ����
	 * @param data
	 */
	public void save(OptionTemplateInfo data);
	/**
	 * ɾ��
	 * @param data
	 */
	public void delete(OptionTemplateInfo data);
	/**
	 * ����
	 * @param data
	 */
	public void update(OptionTemplateInfo data);
	/**
	 * ��ȡָ����Ϣ
	 * @param optionTemplateID
	 * @return ָ����Ϣ
	 */
	public OptionTemplateInfo getOptionTemplateInfo(Long optionTemplateID);
	/**
	 * ��ȡ��¼��
	 * @return
	 */
	public int getTotal();
	/**
	 * ��ȡָ�����ϼ�¼
	 * @param firstResult
	 * @param maxResult
	 * @return ָ����ʼ�ͽ�����Χ�ڵ�ѡ��ģ���б�
	 */
	public List<OptionTemplateInfo> getList(final int firstResult,final int maxResult);	
}
