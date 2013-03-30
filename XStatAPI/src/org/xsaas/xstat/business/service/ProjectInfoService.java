package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IProjectInfoService;
import org.xsaas.xstat.dao.IProjectInfoDao;
import org.xsaas.xstat.po.ProjectInfo;


public class ProjectInfoService implements IProjectInfoService {

	private IProjectInfoDao projectInfoDao = null;

	@Override
	public void deleteProjectInfo(ProjectInfo data) {
		
		projectInfoDao.deleteProjectInfo(data);
	}

	@Override
	public List<ProjectInfo> findProjectInfoByPage(int firstResult, int maxResult) {
		
		return projectInfoDao.findProjectInfoByPage(firstResult, maxResult);
	}

	@Override
	public ProjectInfo getProjectInfo(Long checkID) {
		
		return projectInfoDao.getProjectInfo(checkID);
	}

	@Override
	public List<ProjectInfo> getProjectInfoList() {
		
		return projectInfoDao.getProjectInfoList();
	}

	@Override
	public int getProjectInfoTotal() {
		
		return projectInfoDao.getProjectInfoTotal();
	}

	@Override
	public void saveProjectInfo(ProjectInfo data) {
		
		projectInfoDao.saveProjectInfo(data);
	}

	@Override
	public void updateProjectInfo(ProjectInfo data) {
		
		projectInfoDao.updateProjectInfo(data);
	}

	public void setProjectInfoDao(IProjectInfoDao projectInfoDao) {
		this.projectInfoDao = projectInfoDao;
	}

	@Override
	public List<ProjectInfo> findProjectInfoByPage(long clientID, int status,
			int firstResult, int maxResult) {
		
		return projectInfoDao.findProjectInfoByPage(clientID, status, firstResult, maxResult);
	}

	@Override
	public ProjectInfo getProjectInfoClient(long clientID) {
	
		return projectInfoDao.getProjectInfoClient(clientID);
	}

	@Override
	public int getProjectInfoTotal(long clientID, int status) {
		
		return projectInfoDao.getProjectInfoTotal(clientID, status);
	}

	@Override
	public List<ProjectInfo> findPageByDelStatus(int firstResult, int maxResult) {
		
		return projectInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
		
		return projectInfoDao.getTotalByDelStatus();
	}

	@Override
	public List<ProjectInfo> getProjectInfoList(Long clientID) {
		
		return projectInfoDao.getProjectInfoList(clientID);
	}

	
}
