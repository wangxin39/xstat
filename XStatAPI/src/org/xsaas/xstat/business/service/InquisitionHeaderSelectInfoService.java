package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IInquisitionHeaderSelectInfoService;
import org.xsaas.xstat.dao.IInquisitionHeaderSelectInfoDao;
import org.xsaas.xstat.po.InquisitionHeaderSelectInfo;


public class InquisitionHeaderSelectInfoService implements IInquisitionHeaderSelectInfoService {
	private IInquisitionHeaderSelectInfoDao inquisitionHeaderSelectInfoDao = null;

	public void setInquisitionHeaderSelectInfoDao(IInquisitionHeaderSelectInfoDao inquisitionHeaderSelectInfoDao) {
		this.inquisitionHeaderSelectInfoDao = inquisitionHeaderSelectInfoDao;
	}

	@Override
	public void delete(InquisitionHeaderSelectInfo data) {
		
		inquisitionHeaderSelectInfoDao.delete(data);		
	}

	@Override
	public List<InquisitionHeaderSelectInfo> findByPage(Long headerID,int firstResult,	int maxResult) {		
		return inquisitionHeaderSelectInfoDao.findByPage(headerID,firstResult, maxResult);
	}

	@Override
	public InquisitionHeaderSelectInfo getInfo(Long headerSelectID) {		
		return inquisitionHeaderSelectInfoDao.getInquisitionHeaderSelectInfo(headerSelectID);
	}

	@Override
	public List<InquisitionHeaderSelectInfo> getList() {		
		return inquisitionHeaderSelectInfoDao.getList();
	}

	@Override
	public int getTotal(Long headerID) {		
		return inquisitionHeaderSelectInfoDao.getTotal(headerID);
	}

	@Override
	public void save(InquisitionHeaderSelectInfo data) {		
		inquisitionHeaderSelectInfoDao.save(data);
	}

	@Override
	public void update(InquisitionHeaderSelectInfo data) {		
		inquisitionHeaderSelectInfoDao.update(data);
	}

	@Override
	public List<InquisitionHeaderSelectInfo> findByPage(int firstResult, int maxResult) {	
		return inquisitionHeaderSelectInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public int getInquisitionHeaderSelectInfoTotal() {		
		return inquisitionHeaderSelectInfoDao.getTotal();
	}

	@Override
	public List<InquisitionHeaderSelectInfo> getList(Long inquisitionID, Long headerID) {
		return inquisitionHeaderSelectInfoDao.getList(inquisitionID, headerID);
	}

	@Override
	public List<InquisitionHeaderSelectInfo> findPageByDelStatus(int firstResult, int maxResult) {		
		return inquisitionHeaderSelectInfoDao.findPageByDelStatus(firstResult, maxResult);
	}

	@Override
	public int getTotalByDelStatus() {		
		return inquisitionHeaderSelectInfoDao.getTotalByDelStatus();
	}

	@Override
	public int getTotal() {	
		return inquisitionHeaderSelectInfoDao.getTotal();
	}

}
