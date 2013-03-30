package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * Ա����Ϣ
 */
public class EmployeeInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6431534716890176672L;
	/**
	 * Ա�����
	 */
	private Long employeeID = null;
	/**
	 * ��ʵ����
	 */
	private String name = null;
	/**
	 * �Ա�
	 */
	private String sex = null;
	/**
	 * ����
	 */
	private String depart = null;
	/**
	 * ְλ
	 */
	private String job = null;
	/**
	 * ��λ����
	 */
	private String description = null;
	/**
	 * ��¼����
	 */
	private String loginName = null;
	/**
	 * ���ʱ��
	 */
	private Timestamp addTime = null;
	/**
	 * ��¼����
	 */
	private String passWord = null;
	/**
	 * ״̬
	 */
	private Integer status = null;
	
	
	public EmployeeInfo() {
		super();
		
	}

	public EmployeeInfo(Long employeeID, String name, String loginName,
			Timestamp addTime, String passWord, Integer status, String sex,
			String depart, String job, String description) {
		super();
		this.employeeID = employeeID;
		this.name = name;
		this.loginName = loginName;
		this.addTime = addTime;
		this.passWord = passWord;
		this.status = status;
		this.sex = sex;
		this.depart = depart;
		this.job = job;
		this.description = description;
	}

	/**
	 * ��ȡԱ�����
	 */
	public Long getEmployeeID() {
		return employeeID;
	}
	/**
	 * ����Ա�����
	 */
	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}

	/**
	 * ��ȡ��¼����
	 */
	public String getLoginName() {
		return loginName;
	}
	/**
	 * ���õ�¼���� 
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
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
	/**
	 * ��ȡ����
	 */
	public String getPassWord() {
		return passWord;
	}
	/**
	 * ��������
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	/**
	 * ��ȡ״̬
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * ����״̬
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * ��ȡ�Ա�
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * �����Ա�
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * ��ȡ����
	 */
	public String getDepart() {
		return depart;
	}
	/**
	 * ���ò���
	 */
	public void setDepart(String depart) {
		this.depart = depart;
	}
	/**
	 * ��ȡְλ
	 */
	public String getJob() {
		return job;
	}
	/**
	 * ����ְλ
	 */
	public void setJob(String job) {
		this.job = job;
	}
	/**
	 * ��ȡ����
	 */

	public String getName() {
		return name;
	}

	/**
	 * ��������
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��ȡ��λ����
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * ���ø�λ����
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
}
