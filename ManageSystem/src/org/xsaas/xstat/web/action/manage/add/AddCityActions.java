package org.xsaas.xstat.web.action.manage.add;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.ProvinceConstants;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.ICityInfoService;
import org.xsaas.xstat.po.CityInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddCityActions extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6769434775929025493L;
	private static Log logger = LogFactory.getLog(AddCityActions.class);
	private ICityInfoService cityInfoService = null;

	private Long cityID = null;
	private Integer province = null;
	private String name = null;
	private String englishName = null;


	@SuppressWarnings("unchecked")
	public String execute()throws Exception{
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			String isOK = (String)ActionContext.getContext().getSession().get("CLIENTINPUTADDISOK");
			if(isOK != null && "OK".equals(isOK)) {
				CityInfo info = new CityInfo();
				info.setName(name);
				info.setProvince(province);
				info.setEnglishName(englishName);
				info.setStatus(StatusConstants.ZHENGCHANG);
				cityInfoService.saveCityInfo(info);
				ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","NOT");
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String input() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}			
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");//防止刷新提交多次相同信息
			ActionContext.getContext().getSession().put("PROVINCE",ProvinceConstants.provinceDict);

		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}		
		return SUCCESS;
	}	
	public Long getCityID() {
		return cityID;
	}

	public void setCityID(Long cityID) {
		this.cityID = cityID;
	}
	
	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}



	public Integer getProvince() {
		return province;
	}

	public void setProvince(Integer province) {
		this.province = province;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCityInfoService(ICityInfoService cityInfoService) {
		this.cityInfoService = cityInfoService;
	}
	
}
