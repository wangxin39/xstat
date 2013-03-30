package org.xsaas.xstat.web.action.backend.list;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.EducationConstants;
import org.xsaas.xstat.web.conf.NationsConstants;
import org.xsaas.xstat.web.conf.ProvinceConstants;
import org.xsaas.xstat.web.conf.QuestionTypeConstants;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.ICityInfoService;
import org.xsaas.xstat.business.ISmgkInfoService;
import org.xsaas.xstat.po.CityInfo;
import org.xsaas.xstat.po.SmgkInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListBasicAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7568400183849106961L;
	private static Log logger = LogFactory.getLog(ListBasicAction.class);
	private ISmgkInfoService smgkInfoService = null;
	private ICityInfoService cityInfoService = null;

	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}			
			SmgkInfo smgkInfo = smgkInfoService.isLogin(username, password);
			if(smgkInfo == null) {
				return LOGIN;
			}
			if(smgkInfo != null) {
				if(smgkInfo.getFileType() !=null){
					ActionContext.getContext().put("FILETYPE", QuestionTypeConstants.AuthTypeDict.get(new Integer(smgkInfo.getFileType())));	
				}
				if(smgkInfo.getRegStatus() !=null){
					ActionContext.getContext().put("REGSTATUS", StatusConstants.SmgStatusDict.get(new Integer(smgkInfo.getRegStatus())));
				}
				if(smgkInfo.getAuthStatus() !=null){
					ActionContext.getContext().put("AUTHSTATUS", StatusConstants.AuStatusDict.get(new Integer(smgkInfo.getAuthStatus())));
				}
				if(smgkInfo.getStatus() !=null){
					ActionContext.getContext().put("STATUS", StatusConstants.StatusDict.get(new Integer(smgkInfo.getStatus())));
				}
				if(smgkInfo.getProvince() != null){
					ActionContext.getContext().put("PROVINCE",ProvinceConstants.provinceDict.get(new Integer(smgkInfo.getProvince())));	
				}
				if(smgkInfo.getNation() !=null){
					ActionContext.getContext().put("NATION",NationsConstants.nationDict.get(new Integer(smgkInfo.getNation())));
				}
				if(smgkInfo.getEducation() !=null){
					ActionContext.getContext().put("EDUCATION",EducationConstants.educationDict.get(new Integer(smgkInfo.getEducation())));
				}
				if(smgkInfo.getProvince() !=null){
					ActionContext.getContext().put("PROVINCE", ProvinceConstants.provinceDict.get(new Integer(smgkInfo.getProvince())));
				}
				CityInfo cityInfo = cityInfoService.getCityInfo(smgkInfo.getCityID());
				if(smgkInfo.getCityID() != null) {
					ActionContext.getContext().put("NAME",cityInfo.getName());							
				}
				ActionContext.getContext().put("SMGKINFO", smgkInfo);			
			}else{
				ActionContext.getContext().put("SMGKINFO", null);
				ActionContext.getContext().put("PROVINCE","");
				ActionContext.getContext().put("NATION","");
				ActionContext.getContext().put("EDUCATION","");
				ActionContext.getContext().put("NAME","");							
			}
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}
		

		return SUCCESS;
	}


	public void setSmgkInfoService(ISmgkInfoService smgkInfoService) {
		this.smgkInfoService = smgkInfoService;
	}


	public void setCityInfoService(ICityInfoService cityInfoService) {
		this.cityInfoService = cityInfoService;
	}	
}
