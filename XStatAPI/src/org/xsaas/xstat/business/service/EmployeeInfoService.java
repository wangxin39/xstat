package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.dao.IEmployeeInfoDao;
import org.xsaas.xstat.po.EmployeeInfo;


public class EmployeeInfoService implements	IEmployeeInfoService {

	private IEmployeeInfoDao employeeInfoDao = null;

	public void setEmployeeInfoDao(IEmployeeInfoDao employeeInfoDao) {
		this.employeeInfoDao = employeeInfoDao;
	}

	@Override
	public void deleteEmployeeInfo(EmployeeInfo data) {
		
		employeeInfoDao.deleteEmployeeInfo(data);
	}

	@Override
	public List<EmployeeInfo> findEmployeeInfoByPage(int firstResult,
			int maxResult) {
		
		return employeeInfoDao.findEmployeeInfoByPage(firstResult, maxResult);
	}

	@Override
	public EmployeeInfo getEmployeeInfo(Long employeeID) {
		
		return employeeInfoDao.getEmployeeInfo(employeeID);
	}

	@Override
	public List<EmployeeInfo> getEmployeeInfoList() {
		
		return employeeInfoDao.getEmployeeInfoList();
	}

	@Override
	public int getEmployeeInfoTotal() {
		
		return employeeInfoDao.getEmployeeInfoTotal();
	}

	@Override
	public void saveEmployeeInfo(EmployeeInfo data) {
		
		employeeInfoDao.saveEmployeeInfo(data);
	}

	@Override
	public void updateEmployeeInfo(EmployeeInfo data) {
		
		employeeInfoDao.updateEmployeeInfo(data);
	}

	@Override
	public List<EmployeeInfo> findEmployeeInfoByPage(int status,
			int firstResult, int maxResult) {
		
		return employeeInfoDao.findEmployeeInfoByPage(status, firstResult, maxResult);
	}

	@Override
	public int getEmployeeInfoTotal(int status) {
		
		return employeeInfoDao.getEmployeeInfoTotal(status);
	}

	@Override
	public EmployeeInfo isLogin(String loginname, String password) {
		
		return employeeInfoDao.isLogin(loginname, password);
	}

	@Override
	public boolean isRegister(String loginname, String password) {
	
		return employeeInfoDao.isRegister(loginname, password);
	}

	@Override
	public List<EmployeeInfo> findPageByDelStatus(int firstResult, int maxResult) {
		
		return employeeInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
		
		return employeeInfoDao.getTotalByDelStatus();
	}
}
