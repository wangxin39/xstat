package org.xsaas.xstat.web.action;

import java.util.LinkedList;
import java.util.List;

import org.xsaas.xstat.web.conf.EducationConstants;
import org.xsaas.xstat.web.conf.NationsConstants;
import org.xsaas.xstat.web.conf.ProvinceConstants;

import org.xsaas.xstat.business.ICityInfoService;
import org.xsaas.xstat.business.ISmgkInfoService;
import org.xsaas.xstat.po.CityInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5350153218285223705L;

	private ISmgkInfoService smgkInfoService = null;
	private ICityInfoService cityInfoService =null;

	private Integer province = null;
	private Long cityID = null;
	private String loginName = null;
	private Boolean isRegister = false;
	private String passWord = null;
	private String confirm = null;
	private List<CityInfo> cityList = new LinkedList<CityInfo>();


	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		//LinkedHashMap<Integer,String> provinceMap = ProvinceConstants.provinceDict;		

		//ActionContext.getContext().getSession().put("PROVINCE",provinceMap); 
		ActionContext.getContext().getSession().put("NATION",NationsConstants.nationDict);
		ActionContext.getContext().getSession().put("EDUCATION",EducationConstants.educationDict);
		
		Integer selectProvince = null;
		if(province == null){
			cityList = cityInfoService.getCityInfoList();
			if(cityList.size()>0){
				CityInfo city = cityList.get(0);
				if(city!=null && city.getProvince()!=null){
					selectProvince = city.getProvince();
					ActionContext.getContext().getSession().put("PROVINCE",selectProvince);//初始化省份信息
				}
				
			}
			ActionContext.getContext().getSession().put("PROVINCELIST",ProvinceConstants.provinceDict); //获取数据库中的省份
		}else{
			selectProvince = province;
		}

		cityList = cityInfoService.getCityInfoList(selectProvince);
		ActionContext.getContext().getSession().put("CITYLIST",cityList);
		
		ActionContext.getContext().getSession().put("REGISTERUSER", "NOSAVE");
		
		return SUCCESS;
	}
	
	public String check() throws Exception {
		if(loginName != null) {
			isRegister = smgkInfoService.isRegister(loginName);
		}		
		return SUCCESS;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Boolean getIsRegister() {
		return isRegister;
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

	public List<CityInfo> getCityList() {
		return cityList;
	}

	public void setCityList(List<CityInfo> cityList) {
		this.cityList = cityList;
	}

	public void setCityInfoService(ICityInfoService cityInfoService) {
		this.cityInfoService = cityInfoService;
	}
	public void setIsRegister(Boolean isRegister) {
		this.isRegister = isRegister;
	}

	public void setSmgkInfoService(ISmgkInfoService smgkInfoService) {
		this.smgkInfoService = smgkInfoService;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

}
