package org.xsaas.xstat.web.action.manage.add;

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



public class AddAddressActions extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7332811562714125510L;
	private static Log logger = LogFactory.getLog(AddAddressActions.class);
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
				if(acID == null){
					ActionContext.getContext().put("nullError","分类名称不能为空，请先添加分类信息!");
					return INPUT;
				}
				if(cityID == null){
					ActionContext.getContext().put("nullError","城市名称不能为空,请选择省份!");
					return INPUT;
				}
				EmailAddressInfo info = new EmailAddressInfo();
				info.setAcID(acID);
				info.setAddress(address);
				info.setEmail(email);
				info.setName(name);
				info.setMobile(mobile);
				info.setMSN(MSN);
				info.setQQ(QQ);
				info.setTelephone(telephone);
				info.setCityID(cityID);
				info.setCompany(company);
				info.setJob(job);
				info.setProvince(province);
				info.setNotes(notes);
				info.setPostCode(postCode);
				info.setStatus(StatusConstants.ZHENGCHANG);
				emailAddressInfoService.saveEmailAddressInfo(info);
				ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","NOT");
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		
		return SUCCESS;
	}
	// 增加输入界面
	@SuppressWarnings("unchecked")
	public String input() throws Exception {
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		try{
			if(username == null || password == null) {
				return LOGIN;
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
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}		

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
