package org.xsaas.xstat.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.EducationConstants;
import org.xsaas.xstat.web.conf.NationsConstants;
import org.xsaas.xstat.web.conf.ProvinceConstants;
import org.xsaas.xstat.web.conf.QuestionTypeConstants;
import org.xsaas.xstat.web.conf.SmgkConstants;
import org.xsaas.xstat.web.conf.StatusConstants;
import org.xsaas.xstat.web.util.PaginationUtil;

import org.xsaas.xstat.business.ICityInfoService;
import org.xsaas.xstat.business.ISmgkInfoService;

import org.xsaas.xstat.po.CityInfo;
import org.xsaas.xstat.po.SmgkInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListCustomerAction extends ActionSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7568400183849106961L;
	private static Log logger = LogFactory.getLog(ListCustomerAction.class);
	private ISmgkInfoService smgkInfoService = null;
	private ICityInfoService cityInfoService = null;

	private List<String> nationList = new LinkedList<String>();
	private List<String> provinceList = new LinkedList<String>();
	private List<String> educationList = new LinkedList<String>();
	private List<String> cityList = new LinkedList<String>();
	private List<String> statusList = new LinkedList<String>();

	private Long smgkID = null;
	private Integer regStatus = null;	
	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<SmgkInfo> pageList = null;		
	private PaginationUtil pu = null;	
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			ActionContext.getContext().getSession().put("SMGKSTATUSDICT",StatusConstants.SmgStatusDict);
			Integer selectStatus = StatusConstants.ZHUCEWEIYAZHENG;
			if(regStatus != null) {
				selectStatus = regStatus;
			}
			logger.debug("selectStatus:"+selectStatus);

			int total = 0;
			if(selectStatus != 0) {
				total = smgkInfoService.getSmgkInfoTotal(selectStatus);
			}else{
				total = smgkInfoService.getSmgkInfoTotal();
			}
			int page = 1;
			if (num != null) {
				page = num.intValue();
			}
			pu = new PaginationUtil(total, page,SmgkConstants.PAGE_MAX_RESULT);
			if(selectStatus != 0) {
				pageList = smgkInfoService.findSmgkInfoByPage(selectStatus,pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);
			}else{
				pageList = smgkInfoService.findSmgkInfoByPage(pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);
			}
			if(pageList != null) {
				for(SmgkInfo info:pageList){
					if(info.getCityID() != null) {
						CityInfo ci = cityInfoService.getCityInfo(info.getCityID());
						if(ci != null) {
							cityList.add(""+ci.getName());				
						}else{
							cityList.add("");
						}							
					}else{
						cityList.add("");
					}

					if(info.getNation() != null) {
						nationList.add(""+NationsConstants.nationDict.get(info.getNation()));				
					}else{
						nationList.add("");				
					}
					if(info.getEducation() != null) {
						educationList.add(""+EducationConstants.educationDict.get(info.getEducation()));				
					}else{
						educationList.add("");
					}
					
					if(info.getProvince() != null) {
						provinceList.add(""+ProvinceConstants.provinceDict.get(info.getProvince()));				
					}else{
						provinceList.add("");
					}
				}					
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}
		
		return SUCCESS;
	}
			
	public String detail() throws Exception{
		if(smgkID == null) {
			this.addActionError("编号为空！");
			return ERROR;
		}
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		try{
			if(username == null || password == null) {
				return LOGIN;
			}
			SmgkInfo smgkInfo = smgkInfoService.getSmgkInfo(smgkID);
			if(smgkInfo != null && smgkInfo.getRegStatus()!=null){
				ActionContext.getContext().put("SMGKINFO", smgkInfo);
				ActionContext.getContext().put("REGSTATUS",StatusConstants.SmgStatusDict.get(smgkInfo.getRegStatus()));
			}
			
			CityInfo cInfo = cityInfoService.getCityInfo(smgkInfo.getCityID());	
			if(cInfo != null && cInfo.getName() != null){
				ActionContext.getContext().put("NAME",cInfo.getName());
			}
			if(smgkInfo.getStatus() != null){
				ActionContext.getContext().put("STATUS",StatusConstants.StatusDict.get(smgkInfo.getStatus()));
			}
			if(smgkInfo.getProvince() != null){
				ActionContext.getContext().put("PROVINCE",ProvinceConstants.provinceDict.get(smgkInfo.getProvince()));		
			}
			if(smgkInfo.getNation() != null){
				ActionContext.getContext().put("NATION",NationsConstants.nationDict.get(smgkInfo.getNation()));
			}
			if(smgkInfo.getFileType() != null){
				ActionContext.getContext().put("TYPE",QuestionTypeConstants.AuthTypeDict.get(smgkInfo.getFileType()));
			}
			if(smgkInfo.getAuthStatus() != null){
				ActionContext.getContext().put("AUTHSTATUS",StatusConstants.AuStatusDict.get(smgkInfo.getAuthStatus()));
			}
			if(smgkInfo.getEducation() != null){
				ActionContext.getContext().put("EDUCATION",EducationConstants.educationDict.get(smgkInfo.getEducation()));
			}
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}		

		return SUCCESS;
	}

	
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public void setSmgkInfoService(ISmgkInfoService smgkInfoService) {
		this.smgkInfoService = smgkInfoService;
	}


	public void setCityInfoService(ICityInfoService cityInfoService) {
		this.cityInfoService = cityInfoService;
	}


	public Long getSmgkID() {
		return smgkID;
	}

	public void setSmgkID(Long smgkID) {
		this.smgkID = smgkID;
	}

	public List<String> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}

	public List<String> getNationList() {
		return nationList;
	}

	public void setNationList(List<String> nationList) {
		this.nationList = nationList;
	}

	public List<String> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<String> provinceList) {
		this.provinceList = provinceList;
	}

	public List<String> getEducationList() {
		return educationList;
	}

	public void setEducationList(List<String> educationList) {
		this.educationList = educationList;
	}

	public List<SmgkInfo> getPageList() {
		return pageList;
	}
	public void setPageList(List<SmgkInfo> pageList) {
		this.pageList = pageList;
	}
	public PaginationUtil getPu() {
		return pu;
	}

	public Integer getRegStatus() {
		return regStatus;
	}

	public void setRegStatus(Integer regStatus) {
		this.regStatus = regStatus;
	}

	public List<String> getCityList() {
		return cityList;
	}

	public void setCityList(List<String> cityList) {
		this.cityList = cityList;
	}

}
