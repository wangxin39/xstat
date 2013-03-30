package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IReportInfoService;
import org.xsaas.xstat.dao.IReportInfoDao;
import org.xsaas.xstat.po.ReportInfo;


public class ReportInfoService implements
		IReportInfoService {

	private IReportInfoDao reportInfoDao = null;

	public void setReportInfoDao(
			IReportInfoDao reportInfoDao) {
		this.reportInfoDao = reportInfoDao;
	}


	@Override
	public void deleteReportInfo(ReportInfo data) {
		reportInfoDao.delete(data);

	}

	@Override
	public List<ReportInfo> findReportInfoByPage(
			int firstResult, int maxResult) {

		return reportInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public ReportInfo getReportInfo(Long reportID) {

		return reportInfoDao.getReportInfo(reportID);
	}

	@Override
	public List<ReportInfo> getReportInfoList() {

		return reportInfoDao.getReportInfoList();
	}

	@Override
	public int getReportInfoTotal() {

		return reportInfoDao.getTotal();
	}

	@Override
	public void saveReportInfo(ReportInfo data) {

		reportInfoDao.save(data);
	}

	@Override
	public void updateReportInfo(ReportInfo data) {

		reportInfoDao.update(data);
	}


	@Override
	public List<ReportInfo> findReportInfoByPage(Long issueID,
			Long informantID, int firstResult, int maxResult) {
		
		return reportInfoDao.findByPage(issueID, informantID, firstResult, maxResult);
	}


	@Override
	public int getReportInfoTotal(Long issueID, Long informantID) {
		
		return reportInfoDao.getTotal(issueID, informantID);
	}


	@Override
	public List<ReportInfo> findPageByDelStatus(int firstResult, int maxResult) {
		
		return reportInfoDao.findPageByDelStatus(firstResult, maxResult);
	}


	@Override
	public int getTotalByDelStatus() {
		
		return reportInfoDao.getTotalByDelStatus();
	}

}
