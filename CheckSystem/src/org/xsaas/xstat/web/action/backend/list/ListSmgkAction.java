package org.xsaas.xstat.web.action.backend.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.EducationConstants;
import org.xsaas.xstat.web.conf.NationsConstants;
import org.xsaas.xstat.web.conf.ProvinceConstants;

import org.xsaas.xstat.business.ICityInfoService;
import org.xsaas.xstat.business.ISmgkInfoService;
import org.xsaas.xstat.po.CityInfo;
import org.xsaas.xstat.po.SmgkInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListSmgkAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2128313245760853103L;
	private static Log logger = LogFactory.getLog(ListSmgkAction.class);
//	private ISmgkInfoService smgkInfoService = null;
//	private ICityInfoService cityInfoService =null;
//
//	private Integer province = null;
//	
//	private List<CityInfo> cityList = new LinkedList<CityInfo>();	
	
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}
//
//	public void setSmgkInfoService(ISmgkInfoService smgkInfoService) {
//		this.smgkInfoService = smgkInfoService;
//	}
//	public void setCityInfoService(ICityInfoService cityInfoService) {
//		this.cityInfoService = cityInfoService;
//	}

}
