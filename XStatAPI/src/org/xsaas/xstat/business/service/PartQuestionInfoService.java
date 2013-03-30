package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IPartQuestionInfoService;
import org.xsaas.xstat.dao.IPartQuestionInfoDao;
import org.xsaas.xstat.po.PartQuestionInfo;


public class PartQuestionInfoService implements	IPartQuestionInfoService {

	private IPartQuestionInfoDao partQuestionInfoDao =null;

	@Override
	public void deletePartQuestionInfo(PartQuestionInfo data) {
		
		partQuestionInfoDao.delete(data);
	}

	@Override
	public List<PartQuestionInfo> getPartQuestionInfoList() {
		
		return partQuestionInfoDao.getPartQuestionInfoList();
	}

	@Override
	public int getPartQuestionInfoTotal(Long questionID,Long partID, Long inquisitionID) {
		
		return partQuestionInfoDao.getTotal(questionID, inquisitionID, inquisitionID);
	}

	@Override
	public void savePartQuestionInfo(PartQuestionInfo data) {
		
		partQuestionInfoDao.save(data);
	}

	@Override
	public void updatePartQuestionInfo(PartQuestionInfo data) {
		
		partQuestionInfoDao.update(data);
	}

	@Override
	public List<PartQuestionInfo> getPartQuestionInfoList(Long questionID,Long partID, Long inquisitionID) {	
		return partQuestionInfoDao.getPartQuestionInfoList(inquisitionID, partID, inquisitionID);
	}


	@Override
	public List<PartQuestionInfo> findPartQuestionInfoByPage(Long questionID,Long inquisitionID, Long partID, int firstResult, int maxResult) {
	
		return partQuestionInfoDao.findByPage(questionID, inquisitionID, partID, firstResult, maxResult);
	}

	@Override
	public PartQuestionInfo getPartQuestionInfo(Long inquisitionID) {
		return partQuestionInfoDao.getPartQuestionInfo(inquisitionID);
	}

	@Override
	public List<PartQuestionInfo> getPartQuestionInfoList(Long inquisitionID,Long partID) {
		return partQuestionInfoDao.getPartQuestionInfoList(inquisitionID,partID);
	}

	@Override
	public int getQuestionTotal(Long inquisitionID) {
		return partQuestionInfoDao.getQuestionTotal(inquisitionID);
	}

	public void setPartQuestionInfoDao(IPartQuestionInfoDao partQuestionInfoDao) {
		this.partQuestionInfoDao = partQuestionInfoDao;
	}

	@Override
	public List<PartQuestionInfo> getFatherPqInfo(Long fatherPqID) {
		return partQuestionInfoDao.getFatherPqInfo(fatherPqID);
	}

	@Override
	public List<PartQuestionInfo> findPartQuestionInfoByPage(
			Long inquisitionID, Long partID, int firstResult, int maxResult) {
		
		return partQuestionInfoDao.findPartQuestionInfoByPage(inquisitionID, partID, firstResult, maxResult);
	}

	@Override
	public int getPartQuestionInfoTotal(Long partID, Long inquisitionID) {
		
		return partQuestionInfoDao.getPartQuestionInfoTotal(partID, inquisitionID);
	}

	@Override
	public List<PartQuestionInfo> findPartQuestionInfoByPage(Long partID,
			int firstResult, int maxResult) {
		
		return partQuestionInfoDao.findPartQuestionInfoByPage(partID, firstResult, maxResult);
	}

	@Override
	public int getPartQuestionTotal(Long partID) {
		
		return partQuestionInfoDao.getPartQuestionTotal(partID);
	}

	@Override
	public List<PartQuestionInfo> getPartQuestionInfoList(Long partID) {
		
		return partQuestionInfoDao.getList(partID);
	}

	@Override
	public List<PartQuestionInfo> findPageByDelStatus(int firstResult,
			int maxResult) {
		
		return partQuestionInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
		
		return partQuestionInfoDao.getTotalByDelStatus();
	}

	@Override
	public List<PartQuestionInfo> findByPage(int firstResult, int maxResult) {
		return partQuestionInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public int getTotal() {
		return partQuestionInfoDao.getTotal();
	}

	@Override
	public int getLastShowNum(Long inquisitionID) {
		return this.partQuestionInfoDao.getLastShowNum(inquisitionID);
	}

	@Override
	public List<PartQuestionInfo> findByFather(Long partQuestionID) {		
		return this.partQuestionInfoDao.findByFather(partQuestionID);
	}}


