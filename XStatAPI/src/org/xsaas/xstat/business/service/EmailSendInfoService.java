package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IEmailSendInfoService;
import org.xsaas.xstat.dao.IEmailSendInfoDao;
import org.xsaas.xstat.po.EmailSendInfo;


public class EmailSendInfoService implements IEmailSendInfoService {

	private IEmailSendInfoDao emailSendInfoDao = null;

	public void setEmailSendInfoDao(IEmailSendInfoDao emailSendInfoDao) {
		this.emailSendInfoDao = emailSendInfoDao;
	}

	@Override
	public void deleteEmailSendInfo(EmailSendInfo data) {
		
		emailSendInfoDao.deleteEmailSendInfo(data);
	}

	@Override
	public List<EmailSendInfo> findEmailSendInfoByPage(int firstResult,
			int maxResult) {
		
		return emailSendInfoDao.findEmailSendInfoByPage(firstResult, maxResult);
	}

	@Override
	public EmailSendInfo getEmailSendInfo(Long sendID) {
		
		return emailSendInfoDao.getEmailSendInfo(sendID);
	}

	@Override
	public List<EmailSendInfo> getEmailSendInfoList() {
		
		return emailSendInfoDao.getEmailSendInfoList();
	}

	@Override
	public int getEmailSendInfoTotal() {
		
		return emailSendInfoDao.getEmailSendInfoTotal();
	}

	@Override
	public void saveEmailSendInfo(EmailSendInfo data) {
		
		emailSendInfoDao.saveEmailSendInfo(data);
	}

	@Override
	public void updateEmailSendInfo(EmailSendInfo data) {
		
		emailSendInfoDao.updateEmailSendInfo(data);
	}

	@Override
	public List<EmailSendInfo> findPageByDelStatus(int firstResult,
			int maxResult) {
		
		return emailSendInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
		
		return emailSendInfoDao.getTotalByDelStatus();
	}

	
}
