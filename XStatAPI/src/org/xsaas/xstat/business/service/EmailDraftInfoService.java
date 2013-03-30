package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IEmailDraftInfoService;
import org.xsaas.xstat.dao.IEmailDraftInfoDao;
import org.xsaas.xstat.po.EmailDraftInfo;


public class EmailDraftInfoService implements IEmailDraftInfoService {

	private IEmailDraftInfoDao emailDraftInfoDao = null;

	public void setEmailDraftInfoDao(IEmailDraftInfoDao emailDraftInfoDao) {
		this.emailDraftInfoDao = emailDraftInfoDao;
	}

	@Override
	public void deleteEmailDraftInfo(EmailDraftInfo data) {
		
		emailDraftInfoDao.deleteEmailDraftInfo(data);
	}

	@Override
	public List<EmailDraftInfo> findEmailDraftInfoByPage(int firstResult,
			int maxResult) {
		
		return emailDraftInfoDao.findEmailDraftInfoByPage(firstResult, maxResult);
	}

	@Override
	public EmailDraftInfo getEmailDraftInfo(Long draftID) {
		
		return emailDraftInfoDao.getEmailDraftInfo(draftID);
	}

	@Override
	public List<EmailDraftInfo> getEmailDraftInfoList() {
		
		return emailDraftInfoDao.getEmailDraftInfoList();
	}

	@Override
	public int getEmailDraftInfoTotal() {
		
		return emailDraftInfoDao.getEmailDraftInfoTotal();
	}

	@Override
	public void saveEmailDraftInfo(EmailDraftInfo data) {
		
		emailDraftInfoDao.saveEmailDraftInfo(data);
	}

	@Override
	public void updateEmailDraftInfo(EmailDraftInfo data) {
		
		emailDraftInfoDao.updateEmailDraftInfo(data);
	}

	@Override
	public List<EmailDraftInfo> findPageByDelStatus(int firstResult,
			int maxResult) {
		
		return emailDraftInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
		
		return emailDraftInfoDao.getTotalByDelStatus();
	}

	
}
