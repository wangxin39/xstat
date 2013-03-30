package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IReportTemplateInfoService;
import org.xsaas.xstat.dao.IReportTemplateInfoDao;
import org.xsaas.xstat.po.ReportTemplateInfo;


public class ReportTemplateInfoService implements IReportTemplateInfoService {
	
	private IReportTemplateInfoDao reportTemplateInfoDao = null;

	public void setReportTemplateInfoDao(
			IReportTemplateInfoDao reportTemplateInfoDao) {
		this.reportTemplateInfoDao = reportTemplateInfoDao;
	}

	@Override
	public void deleteReportTemplateInfo(ReportTemplateInfo data) {
		
		reportTemplateInfoDao.deleteReportTemplateInfo(data);		
	}

	@Override
	public List<ReportTemplateInfo> findReportTemplateInfoByPage(int firstResult,
			int maxResult) {
		
		return reportTemplateInfoDao.findReportTemplateInfoByPage(firstResult, maxResult);
	}

	@Override
	public ReportTemplateInfo getReportTemplateInfo(Long multiLangID) {
		
		return reportTemplateInfoDao.getReportTemplateInfo(multiLangID);
	}

	@Override
	public List<ReportTemplateInfo> getReportTemplateInfoList() {
		
		return reportTemplateInfoDao.getReportTemplateInfoList();
	}

	@Override
	public int getReportTemplateInfoTotal() {
		
		return reportTemplateInfoDao.getReportTemplateInfoTotal();
	}

	@Override
	public void saveReportTemplateInfo(ReportTemplateInfo data) {
		
		reportTemplateInfoDao.saveReportTemplateInfo(data);
	}

	@Override
	public void updateReportTemplateInfo(ReportTemplateInfo data) {
		
		reportTemplateInfoDao.updateReportTemplateInfo(data);
	}

	@Override
	public List<ReportTemplateInfo> findPageByDelStatus(int firstResult,
			int maxResult) {
		
		return reportTemplateInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
		
		return reportTemplateInfoDao.getTotalByDelStatus();
	}

}
