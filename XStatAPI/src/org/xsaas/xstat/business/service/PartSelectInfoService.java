package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IPartSelectInfoService;
import org.xsaas.xstat.dao.IPartSelectInfoDao;
import org.xsaas.xstat.po.PartSelectInfo;


public class PartSelectInfoService implements IPartSelectInfoService {

	private IPartSelectInfoDao partSelectInfoDao =null;

	@Override
	public void deletePartSelectInfo(PartSelectInfo data) {
	
		partSelectInfoDao.delete(data);
	}

	@Override
	public List<PartSelectInfo> findPartSelectInfoByPage(long questionID,int firstResult, int maxResult) {
	
		return partSelectInfoDao.findByPage(questionID,firstResult, maxResult);
	}

	@Override
	public PartSelectInfo getPartSelectInfo(Long pasID) {
	
		return partSelectInfoDao.getPartSelectInfo(pasID);
	}

	@Override
	public List<PartSelectInfo> getPartSelectInfoList() {
	
		return partSelectInfoDao.getPartSelectInfoList();
	}

	@Override
	public int getPartSelectInfoTotal(long questionID) {
	
		return partSelectInfoDao.getTotal(questionID);
	}

	@Override
	public void savePartSelectInfo(PartSelectInfo data) {
		
		partSelectInfoDao.save(data);
	}

	@Override
	public void updatePartSelectInfo(PartSelectInfo data) {
	
		partSelectInfoDao.update(data);
	}

	@Override
	public List<PartSelectInfo> findByQuestion(Long inquisitionID,	Long partQuestionID) {		
		return partSelectInfoDao.findByQuestion(inquisitionID, partQuestionID);
	}

	public void setPartSelectInfoDao(
			IPartSelectInfoDao partSelectInfoDao) {
		this.partSelectInfoDao = partSelectInfoDao;
	}

	@Override
	public List<PartSelectInfo> findPartSelectInfoByPage(int firstResult,
			int maxResult) {
		return partSelectInfoDao.findPartSelectInfoByPage(firstResult, maxResult);
	}

	@Override
	public int getPartSelectInfoTotal() {
		
		return partSelectInfoDao.getPartSelectInfoTotal();
	}

	@Override
	public List<PartSelectInfo> findByQuestion(Long partQuestionID) {
		
		return partSelectInfoDao.getPartSelectInfoList();
	}

	@Override
	public List<PartSelectInfo> findPageByDelStatus(int firstResult,
			int maxResult) {
		
		return partSelectInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {
		
		return partSelectInfoDao.getTotalByDelStatus();
	}
	
}
