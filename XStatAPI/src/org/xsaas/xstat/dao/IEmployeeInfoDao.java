package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.EmployeeInfo;


public interface IEmployeeInfoDao {
	/**
	 * 保存员工信息
	 * @param data 员工信息
	 */
	public void saveEmployeeInfo(EmployeeInfo data);
	/**
	 * 更新员工信息
	 * @param data 员工信息
	 */
	public void updateEmployeeInfo(EmployeeInfo data);
	/**
	 * 删除员工信息
	 * @param data 员工信息
	 */
	public void deleteEmployeeInfo(EmployeeInfo data);	
	/**
	 * 获取员工信息
	 * @param employeeID 问卷编号
	 * @return 员工信息
	 */
	public EmployeeInfo getEmployeeInfo(Long employeeID);
	/**
	 * 获取员工信息列表
	 * @return 员工信息列表
	 */
	public List<EmployeeInfo> getEmployeeInfoList();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getEmployeeInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<EmployeeInfo> findEmployeeInfoByPage(final int firstResult, final int maxResult);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getEmployeeInfoTotal(int status);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<EmployeeInfo> findEmployeeInfoByPage(int status,final int firstResult, final int maxResult);
	/**
	 * 登陆系统
	 * @param username 用户名称
	 * @param password 用户密码
	 * @return SmgkInfo
	 */
	public EmployeeInfo isLogin(String loginname,String password);
	public boolean isRegister(String loginname,String password);
	
	/**
	 * 删除状态总数
	 * @return int
	 */
	public int getTotalByDelStatus();
	/**
	 * 删除状态分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<EmployeeInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
