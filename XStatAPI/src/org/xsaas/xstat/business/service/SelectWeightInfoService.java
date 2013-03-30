package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.ISelectWeightInfoService;
import org.xsaas.xstat.dao.ISelectWeightInfoDao;
import org.xsaas.xstat.po.SelectWeightInfo;


public class SelectWeightInfoService implements	ISelectWeightInfoService {

	private ISelectWeightInfoDao selectWeightInfoDao =null;

	public void setSelectWeightInfoDao(ISelectWeightInfoDao selectWeightInfoDao) {
		this.selectWeightInfoDao = selectWeightInfoDao;
	}

	@Override
	public void delete(SelectWeightInfo data) {
		this.selectWeightInfoDao.delete(data);		
	}

	@Override
	public List<SelectWeightInfo> findByDelStatus(int firstResult, int maxResult) {
		return this.selectWeightInfoDao.findByDelStatus(firstResult, maxResult);
	}

	@Override
	public List<SelectWeightInfo> findByPage(int firstResult, int maxResult) {		
		return this.selectWeightInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public List<SelectWeightInfo> findByPage(Long inquisitionID,
			int firstResult, int maxResult) {
		return this.selectWeightInfoDao.findByPage(inquisitionID, firstResult, maxResult);
	}

	@Override
	public List<SelectWeightInfo> findByPage(Long inquisitionID, Long partID,
			int firstResult, int maxResult) {
		return this.selectWeightInfoDao.findByPage(inquisitionID, partID, firstResult, maxResult);
	}

	@Override
	public List<SelectWeightInfo> findByPart(Long inquisitionID, Long partID) {
		return this.selectWeightInfoDao.findByPart(inquisitionID, partID);
	}

	@Override
	public List<SelectWeightInfo> findByPartQuestion(Long inquisitionID,
			Long partQuestionID) {
		return this.selectWeightInfoDao.findByPartQuestion(inquisitionID, partQuestionID);
	}

	@Override
	public int getCountWeight(Long inquisitionID, Long partID) {
		return this.selectWeightInfoDao.getCountWeight(inquisitionID, partID);
	}

	@Override
	public SelectWeightInfo getSelectWeightInfo(Long inquisitionID,
			Long partQuestionID, Long selectID) {
		return this.selectWeightInfoDao.getSelectWeightInfo(inquisitionID, partQuestionID, selectID);
	}

	@Override
	public SelectWeightInfo getSelectWeightInfo(Long qpID) {
		return this.selectWeightInfoDao.getSelectWeightInfo(qpID);
	}

	@Override
	public int getTotal() {
		return this.selectWeightInfoDao.getTotal();
	}

	@Override
	public int getTotal(Long inquisitionID, Long partID) {		
		return this.selectWeightInfoDao.getTotal(inquisitionID, partID);
	}

	@Override
	public int getTotal(Long inquisitionID) {
		return this.selectWeightInfoDao.getTotal(inquisitionID);
	}

	@Override
	public int getTotalByDelStatus() {		
		return this.selectWeightInfoDao.getTotalByDelStatus();
	}

	@Override
	public void save(SelectWeightInfo data) {
		this.selectWeightInfoDao.save(data);
	}

	@Override
	public void update(SelectWeightInfo data) {
		this.selectWeightInfoDao.update(data);
	}

	@Override
	public int getSumWeightByQuestion(Long inquisitionID, Long partQuestionID) {
		return this.selectWeightInfoDao.getSumWeightByQuestion(inquisitionID, partQuestionID);
	}


}
