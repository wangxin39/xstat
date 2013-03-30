package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IEmailAddressInfoService;
import org.xsaas.xstat.dao.IEmailAddressInfoDao;
import org.xsaas.xstat.po.EmailAddressInfo;


public class EmailAddressInfoService implements	IEmailAddressInfoService {

	private IEmailAddressInfoDao emailAddressInfoDao = null;

	public void setEmailAddressInfoDao(IEmailAddressInfoDao emailAddressInfoDao) {
		this.emailAddressInfoDao = emailAddressInfoDao;
	}

	@Override
	public void deleteEmailAddressInfo(EmailAddressInfo data) {
		
		emailAddressInfoDao.deleteEmailAddressInfo(data);
	}

	@Override
	public List<EmailAddressInfo> findEmailAddressInfoByPage(int firstResult,
			int maxResult) {
		
		return emailAddressInfoDao.findEmailAddressInfoByPage(firstResult, maxResult);
	}

	@Override
	public EmailAddressInfo getEmailAddressInfo(Long addressID) {
		
		return emailAddressInfoDao.getEmailAddressInfo(addressID);
	}

	@Override
	public List<EmailAddressInfo> getEmailAddressInfoList() {
		
		return emailAddressInfoDao.getEmailAddressInfoList();
	}

	@Override
	public int getEmailAddressInfoTotal() {
		
		return emailAddressInfoDao.getEmailAddressInfoTotal();
	}

	@Override
	public void saveEmailAddressInfo(EmailAddressInfo data) {
		
		emailAddressInfoDao.saveEmailAddressInfo(data);
	}

	@Override
	public void updateEmailAddressInfo(EmailAddressInfo data) {
		
		emailAddressInfoDao.updateEmailAddressInfo(data);
	}

	@Override
	public List<EmailAddressInfo> findPageByDelStatus(int firstResult,
			int maxResult) {
		
		return emailAddressInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
		
		return emailAddressInfoDao.getTotalByDelStatus();
	}

	

}
