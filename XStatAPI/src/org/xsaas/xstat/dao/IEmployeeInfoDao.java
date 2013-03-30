package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.EmployeeInfo;


public interface IEmployeeInfoDao {
	/**
	 * ����Ա����Ϣ
	 * @param data Ա����Ϣ
	 */
	public void saveEmployeeInfo(EmployeeInfo data);
	/**
	 * ����Ա����Ϣ
	 * @param data Ա����Ϣ
	 */
	public void updateEmployeeInfo(EmployeeInfo data);
	/**
	 * ɾ��Ա����Ϣ
	 * @param data Ա����Ϣ
	 */
	public void deleteEmployeeInfo(EmployeeInfo data);	
	/**
	 * ��ȡԱ����Ϣ
	 * @param employeeID �ʾ���
	 * @return Ա����Ϣ
	 */
	public EmployeeInfo getEmployeeInfo(Long employeeID);
	/**
	 * ��ȡԱ����Ϣ�б�
	 * @return Ա����Ϣ�б�
	 */
	public List<EmployeeInfo> getEmployeeInfoList();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getEmployeeInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<EmployeeInfo> findEmployeeInfoByPage(final int firstResult, final int maxResult);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getEmployeeInfoTotal(int status);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<EmployeeInfo> findEmployeeInfoByPage(int status,final int firstResult, final int maxResult);
	/**
	 * ��½ϵͳ
	 * @param username �û�����
	 * @param password �û�����
	 * @return SmgkInfo
	 */
	public EmployeeInfo isLogin(String loginname,String password);
	public boolean isRegister(String loginname,String password);
	
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
	public List<EmployeeInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
