package org.xsaas.xstat.web.action.manage.edit;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.ProvinceConstants;

import org.xsaas.xstat.business.ICityInfoService;
import org.xsaas.xstat.business.IClientInfoService;
import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IInformantInfoService;
import org.xsaas.xstat.po.CityInfo;
import org.xsaas.xstat.po.ClientInfo;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.InformantInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditInformantAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8925259348189164568L;
	private static Log logger = LogFactory.getLog(EditInformantAction.class);
	private IInformantInfoService informantInfoService = null;
	private IClientInfoService clientInfoService = null;
	private ICityInfoService cityInfoService = null;

	private Long clientID = null;
	private String name = null;
	private String englishName = null;
	private String aliasName = null;
	private String englishAliasName = null;
	private String serviceLang = null;
	private String country = null;
	private Integer province = null;
	private Long cityID = null;
	private String telephone = null;
	private String mobile = null;
	private String email = null;
	private String address = null;
	private String postCode = null;
	private String serviceType = null;
	private String area = null;
	
	
	private Long informantID = null;
	private List<CityInfo> cityList = new LinkedList<CityInfo>();
	
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
				InformantInfo info = (InformantInfo) ActionContext.getContext().getSession().get("INFORMANTLIST");;
				info.setName(name);
				info.setClientID(clientID);
				info.setAliasName(aliasName);
				info.setEnglishAliasName(englishAliasName);
				info.setEnglishName(englishName);
				info.setAddress(address);
				info.setArea(area);
				info.setCityID(cityID);
				info.setCountry(country);
				info.setEmail(email);
				info.setMobile(mobile);
				info.setTelephone(telephone);
				info.setServiceType(serviceType);
				info.setServiceTime(new Timestamp(System.currentTimeMillis()));
				info.setServiceLang(serviceLang);
				info.setPostCode(postCode);
				info.setProvince(province);
				informantInfoService.updateInformantInfo(info);
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
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		try{
			if(username == null || password == null) {
				return LOGIN;
			}
			if(informantID == null){
				this.addActionError("找到不该调查对象！");
				return ERROR;
			}
			InformantInfo informantInfo = informantInfoService.getInformantInfo(informantID);
			ActionContext.getContext().getSession().put("INFORMANTLIST",informantInfo);
			
			List<ClientInfo> clientInfoList = (List<ClientInfo>)ActionContext.getContext().getSession().get("GLOBALCLIENTINFOLIST");
			if(clientInfoList == null) {
				clientInfoList = clientInfoService.getClientInfoList();
				ActionContext.getContext().getSession().put("GLOBALCLIENTINFOLIST",clientInfoList);//初始化省份信息
			}
			cityList = cityInfoService.getCityInfoList();
			ActionContext.getContext().getSession().put("CITYLIST",cityList);
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");
			ActionContext.getContext().getSession().put("COUNTRY",ProvinceConstants.countryDict);
			
			if(province == null){
				cityList = cityInfoService.getCityInfoList();
				if(cityList.size()>0){
					CityInfo info = cityList.get(0);
					ActionContext.getContext().getSession().put("PROVINCE",info.getProvince());//初始化省份信息
					ActionContext.getContext().getSession().put("CITYVALUE",info.getCityID());//初始化城市信息
				}
				ActionContext.getContext().getSession().put("PROVINCELIST",ProvinceConstants.provinceDict); //获取数据库中的省份
			}else{
			    cityList = cityInfoService.getCityInfoList(province);
				ActionContext.getContext().getSession().put("CITYLIST",cityList);
			}
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

	public void setInformantInfoService(IInformantInfoService informantInfoService) {
		this.informantInfoService = informantInfoService;
	}


	public Long getClientID() {
		return clientID;
	}

	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getEnglishAliasName() {
		return englishAliasName;
	}

	public void setEnglishAliasName(String englishAliasName) {
		this.englishAliasName = englishAliasName;
	}

	public String getServiceLang() {
		return serviceLang;
	}


	public void setServiceLang(String serviceLang) {
		this.serviceLang = serviceLang;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public Integer getProvince() {
		return province;
	}


	public void setProvince(Integer province) {
		this.province = province;
	}


	public Long getCityID() {
		return cityID;
	}


	public void setCityID(Long cityID) {
		this.cityID = cityID;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPostCode() {
		return postCode;
	}


	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}


	public String getServiceType() {
		return serviceType;
	}


	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getInformantID() {
		return informantID;
	}

	public void setInformantID(Long informantID) {
		this.informantID = informantID;
	}

	public List<CityInfo> getCityList() {
		return cityList;
	}

	public void setClientInfoService(IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}

	public void setCityInfoService(ICityInfoService cityInfoService) {
		this.cityInfoService = cityInfoService;
	}

}