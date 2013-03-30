package org.xsaas.xstat.business.service;

import java.util.List;

import org.xsaas.xstat.business.IVideoInfoService;
import org.xsaas.xstat.dao.IVideoInfoDao;
import org.xsaas.xstat.po.VideoInfo;


public class VideoInfoService implements	IVideoInfoService {

	private IVideoInfoDao videoInfoDao =null;


	@Override
	public void deleteVideoInfo(VideoInfo data) {
		
		videoInfoDao.delete(data);
	}


	@Override
	public VideoInfo getVideoInfo(Long qpID) {
		
		return videoInfoDao.getVideoInfo(qpID);
	}

	@Override
	public List<VideoInfo> getVideoInfoList() {
		
		return videoInfoDao.getVideoInfoList();
	}

	@Override
	public void updateVideoInfo(VideoInfo data) {
		
		videoInfoDao.update(data);
	}

	@Override
	public List<VideoInfo> findVideoInfoByPage(int firstResult, int maxResult) {
		
		return videoInfoDao.findByPage(firstResult, maxResult);
	}

	@Override
	public int getVideoInfoTotal() {
		
		return videoInfoDao.getTotal();
	}

	public void setVideoInfoDao(IVideoInfoDao videoInfoDao) {
		this.videoInfoDao = videoInfoDao;
	}


	@Override
	public void saveVideoInfo(VideoInfo data) {
		this.videoInfoDao.save(data);
	}


	@Override
	public List<VideoInfo> findByPage(Long clientID, Long informantID,
			int firstResult, int maxResult) {		
		return videoInfoDao.findByPage(clientID, informantID, firstResult, maxResult);
	}


	@Override
	public int getTotal(Long clientID, Long informantID) {
		return videoInfoDao.getTotal(clientID, informantID);
	}


	@Override
	public List<VideoInfo> findByPage(Long clientID, int firstResult,
			int maxResult) {		
		return videoInfoDao.findByPage(clientID, firstResult, maxResult);
	}


	@Override
	public int getTotal(Long clientID) {
		return videoInfoDao.getTotal(clientID);
	}


	@Override
	public List<VideoInfo> findPageByDelStatus(int firstResult, int maxResult) {
		
		return videoInfoDao.findPageByDelStatus(firstResult, maxResult);
	}


	@Override
	public int getTotalByDelStatus() {
		
		return videoInfoDao.getTotalByDelStatus();
	}

}
