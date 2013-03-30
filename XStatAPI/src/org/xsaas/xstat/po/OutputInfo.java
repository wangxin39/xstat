package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * ������Ϣ
 */
public class OutputInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6637352219217225296L;
	/**
	 * ������
	 */
	private Long outputID = null;
	/**
	 * ������
	 */
	private Long issueID = null;
	/**
	 * ������
	 */
	private Long informantID = null;
	/**
	 * ������
	 */
	private Long clientID = null;

	/**
	 * ��������
	 */
	private Integer fileType = null;

	/**
	 * ����
	 */
	private String fileName = null;
	/**
	 * ��������
	 */
	private String savePath = null;
	/**
	 * ��������
	 */
	private Timestamp makeTime = null;
	
	/**
	 * ��������
	 */
	private Integer status = null;
	
	public OutputInfo() {
		super();
		
	}

	public OutputInfo(Long outputID, Long issueID, Long informantID,
			Long clientID, Integer fileType, String fileName, String savePath,
			Timestamp makeTime, Integer status) {
		super();
		this.outputID = outputID;
		this.issueID = issueID;
		this.informantID = informantID;
		this.clientID = clientID;
		this.fileType = fileType;
		this.fileName = fileName;
		this.savePath = savePath;
		this.makeTime = makeTime;
		this.status = status;
	}

	public String getSavePath() {
		return savePath;
	}


	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}



	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getOutputID() {
		return outputID;
	}

	public void setOutputID(Long outputID) {
		this.outputID = outputID;
	}

	public Long getIssueID() {
		return issueID;
	}

	public void setIssueID(Long issueID) {
		this.issueID = issueID;
	}

	public Long getInformantID() {
		return informantID;
	}

	public void setInformantID(Long informantID) {
		this.informantID = informantID;
	}

	public Long getClientID() {
		return clientID;
	}

	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}

	public Integer getFileType() {
		return fileType;
	}

	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Timestamp getMakeTime() {
		return makeTime;
	}

	public void setMakeTime(Timestamp makeTime) {
		this.makeTime = makeTime;
	}

}
