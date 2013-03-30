package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * �����ʾ��˹�����
 */
public class VideoInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8451804955699802244L;
	/**
	 * ������
	 */
	private Long videoID = null;
	/**
	 * ������
	 */
	private Long clientID = null;
	/**
	 * ������
	 */
	private Long informantID = null;
	/**
	 * �����������
	 */
	private String name = null;
	/**
	 * �������
	 */
	private String englishName =null;
	/**
	 * �����������
	 */
	private String url = null;

	/**
	 * ���ʱ��
	 */
	private Timestamp addTime = null;
	
	private Integer status = null;
	
	public VideoInfo() {
		super();
		
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public VideoInfo(Long videoID, Long clientID, Long informantID,
			String name, String englishName, String url, Timestamp addTime,
			Integer status) {
		super();
		this.videoID = videoID;
		this.clientID = clientID;
		this.informantID = informantID;
		this.name = name;
		this.englishName = englishName;
		this.url = url;
		this.addTime = addTime;
		this.status = status;
	}

	public Long getInformantID() {
		return informantID;
	}



	public void setInformantID(Long informantID) {
		this.informantID = informantID;
	}



	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getVideoID() {
		return videoID;
	}

	public void setVideoID(Long videoID) {
		this.videoID = videoID;
	}

	public Long getClientID() {
		return clientID;
	}

	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * ��ȡʱ��
	 */
	public Timestamp getAddTime() {
		return addTime;
	}
	/**
	 * ����ʱ��
	 */
	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

}
