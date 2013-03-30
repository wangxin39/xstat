package org.xsaas.xstat.web.action.manage.edit;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.ProvinceConstants;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IAddressCatalogInfoService;
import org.xsaas.xstat.business.ICityInfoService;
import org.xsaas.xstat.business.IEmailAddressInfoService;
import org.xsaas.xstat.po.AddressCatalogInfo;
import org.xsaas.xstat.po.CityInfo;
import org.xsaas.xstat.po.EmailAddressInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditAddressAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7332811562714125510L;
	private static Log logger = LogFactory.getLog(EditAddressAction.class);
	private IEmailAddressInfoService emailAddressInfoService = null;
	private IAddressCatalogInfoService addressCatalogInfoService = null;
	private ICityInfoService cityInfoService = null;


	private Long acID = null;
	private Long cityID = null;
	private String name = null;
	private String email = null;
	private String telephone = null;
	private String mobile = null;
	private String QQ = null;
	private String MSN = null;
	private String address = null;
	private String job = null;
	private String notes = null;
	private String postCode = null;
	private String company = null;
	private Integer province = null;
	private Integer status = null;
	
	
	
	private Long addressID = null;
	private List<CityInfo> cityInfoList = new LinkedList<CityInfo>();
	
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {		
		try{		
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			String isOK = (String)ActionContext.getContext().getSession().get("CLIENTINPUTADDISOK");
			if(isOK != null && "OK".equals(isOK)) {
				EmailAddressInfo info = (EmailAddressInfo) ActionContext.getContext().getSession().get("ADDRESSLIST");
				info.setAcID(acID);
				info.setAddress(address);
				info.setEmail(email);
				info.setName(name);
				info.setMobile(mobile);
				info.setMSN(MSN);
				info.setProvince(province);
				info.setQQ(QQ);
				info.setTelephone(telephone);
				info.setCityID(cityID);
				info.setCompany(company);
				info.setJob(job);
				info.setNotes(notes);
				info.setPostCode(postCode);
				emailAddressInfoService.updateEmailAddressInfo(info);
				ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","NOT");
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		
		return SUCCESS;
	}
	
	// 修改界面
	@SuppressWarnings("unchecked")
	public String edit() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			
			if(username == null || password == null) {
				return LOGIN;
			}
			if(addressID == null) {
				this.addActionError("找不到该地址信息");
				return ERROR;
			}
			List<AddressCatalogInfo> list = addressCatalogInfoService.getAddressCatalogInfoList();
			ActionContext.getContext().getSession().put("ADDRESSLIST",list);
			if(province == null){
				cityInfoList = cityInfoService.getCityInfoList();
				if(cityInfoList.size()>0){
					CityInfo info = cityInfoList.get(0);
					ActionContext.getContext().getSession().put("PROVINCE",info.getProvince());//初始化省份信息
					ActionContext.getContext().getSession().put("CITYVALUE",info.getCityID());//初始化城市信息
				}
				ActionContext.getContext().getSession().put("PROVINCELIST",ProvinceConstants.provinceDict); //获取数据库中的省份
			}else{
				cityInfoList = cityInfoService.getCityInfoList(province);
				ActionContext.getContext().getSession().put("CITYLIST",cityInfoList);
			}
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");//防止刷新提交多次相同信息
			EmailAddressInfo info = emailAddressInfoService.getEmailAddressInfo(addressID);
			ActionContext.getContext().getSession().put("ADDRESSLIST",info);
			ActionContext.getContext().getSession().put("STATUS",StatusConstants.StatusDict);	
			
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}		
		return SUCCESS;
	}			

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String qq) {
		QQ = qq;
	}

	public String getMSN() {
		return MSN;
	}

	public void setMSN(String msn) {
		MSN = msn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public Long getAcID() {
		return acID;
	}

	public void setAcID(Long acID) {
		this.acID = acID;
	}


	public void setEmailAddressInfoService(
			IEmailAddressInfoService emailAddressInfoService) {
		this.emailAddressInfoService = emailAddressInfoService;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCityID() {
		return cityID;
	}

	public void setCityID(Long cityID) {
		this.cityID = cityID;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}



	public Integer getProvince() {
		return province;
	}



	public void setProvince(Integer province) {
		this.province = province;
	}



	public Integer getStatus() {
		return status;
	}



	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getAddressID() {
		return addressID;
	}

	public void setAddressID(Long addressID) {
		this.addressID = addressID;
	}

	public List<CityInfo> getCityInfoList() {
		return cityInfoList;
	}

	public void setAddressCatalogInfoService(
			IAddressCatalogInfoService addressCatalogInfoService) {
		this.addressCatalogInfoService = addressCatalogInfoService;
	}

	public void setCityInfoService(ICityInfoService cityInfoService) {
		this.cityInfoService = cityInfoService;
	}

}
