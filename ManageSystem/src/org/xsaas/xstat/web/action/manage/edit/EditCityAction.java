package org.xsaas.xstat.web.action.manage.edit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.ProvinceConstants;

import org.xsaas.xstat.business.ICityInfoService;
import org.xsaas.xstat.business.IEmployeeInfoService;

import org.xsaas.xstat.po.CityInfo;
import org.xsaas.xstat.po.EmployeeInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditCityAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6769434775929025493L;
	private static Log logger = LogFactory.getLog(EditCityAction.class);
	private ICityInfoService cityInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;

	
	private Integer province = null;
	private String name = null;
	private String englishName = null;
	
	
	private Long cityID = null;
	
	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

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
				CityInfo info = (CityInfo) ActionContext.getContext().getSession().get("CITYEDIT");
				info.setName(name);
				info.setProvince(province);
				info.setEnglishName(englishName);
				cityInfoService.updateCityInfo(info);
				ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","NOT");
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		
		return SUCCESS;
	}

	
	@SuppressWarnings( "unchecked")
	public String edit() throws Exception {
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		if(username == null || password == null) {
			return LOGIN;
		}
		try{
			
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}		
		ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");//防止刷新提交多次相同信息
		if(cityID == null){
			this.addActionError("编号为空！");
			return ERROR;
		}
		CityInfo cInfo = cityInfoService.getCityInfo(cityID);
		ActionContext.getContext().getSession().put("CITYEDIT",cInfo);
		ActionContext.getContext().getSession().put("PROVINCE",ProvinceConstants.provinceDict);
		return SUCCESS;
	}

	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
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

	public Long getCityID() {
		return cityID;
	}

	public void setCityID(Long cityID) {
		this.cityID = cityID;
	}

}
