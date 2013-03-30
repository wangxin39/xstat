package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.OptionRelationInfo;


public interface IOptionRelationInfoService {
	/**
	 * ����
	 * @param data
	 */
	public void save(OptionRelationInfo data);
	/**
	 * ɾ��
	 * @param data
	 */
	public void delete(OptionRelationInfo data);
	/**
	 * ����
	 * @param data
	 */
	public void update(OptionRelationInfo data);
	/**
	 * ��ȡָ����Ϣ
	 * @param optionRelationID
	 * @return ָ����Ϣ
	 */
	public OptionRelationInfo getOptionRelationInfo(Long optionRelationID);
	/**
	 * ��ȡ��¼��
	 * @return ��¼��
	 */
	public int getTotal();
	/**
	 * ��ȡָ����ʼ�ͽ�����Χ��¼����
	 * @param firstResult
	 * @param maxResult
	 * @return ѡ���ϵ�б�
	 */
	public List<OptionRelationInfo> getList(final int firstResult, final int maxResult);
	/**
	 * ��ȡָ��ѡ��ģ��ѡ���ϵ�б�
	 * @param optionTemplateID
	 * @return ѡ���ϵ�б�
	 */
	public List<OptionRelationInfo> getList(Long optionTemplateID);	
}
