package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IOutputInfoService;
import org.xsaas.xstat.dao.IOutputInfoDao;
import org.xsaas.xstat.po.OutputInfo;


public class OutputInfoService implements IOutputInfoService {

	private IOutputInfoDao outputInfoDao =null;

	@Override
	public void deleteOutputInfo(OutputInfo data) {
		
		outputInfoDao.deleteOutputInfo(data);
	}

	@Override
	public List<OutputInfo> findOutputInfoByPage(int firstResult, int maxResult) {
		
		return outputInfoDao.findOutputInfoByPage(firstResult, maxResult);
	}

	@Override
	public OutputInfo getOutputInfo(Long translateID) {
		
		return outputInfoDao.getOutputInfo(translateID);
	}

	@Override
	public List<OutputInfo> getOutputInfoList() {
		
		return outputInfoDao.getOutputInfoList();
	}

	@Override
	public int getOutputInfoTotal() {
		
		return outputInfoDao.getOutputInfoTotal();
	}

	@Override
	public void saveOutputInfo(OutputInfo data) {
		
		outputInfoDao.saveOutputInfo(data);
	}

	@Override
	public void updateOutputInfo(OutputInfo data) {
		
		outputInfoDao.updateOutputInfo(data);
	}

	public void setOutputInfoDao(IOutputInfoDao outputInfoDao) {
		this.outputInfoDao = outputInfoDao;
	}

	@Override
	public List<OutputInfo> findPageByDelStatus(int firstResult, int maxResult) {
		
		return outputInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
		
		return outputInfoDao.getTotalByDelStatus();
	}

	@Override
	public List<OutputInfo> findOutputInfoByPage(Long informantID,
			Long issueID, int firstResult, int maxResult) {
		
		return outputInfoDao.findByPage(informantID, issueID, firstResult, maxResult);
	}

	@Override
	public int getOutputInfoTotal(Long informantID, Long issueID) {
		
		return outputInfoDao.getTotal(informantID, issueID);
	}

	
}
