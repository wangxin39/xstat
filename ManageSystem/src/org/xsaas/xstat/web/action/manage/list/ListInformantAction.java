package org.xsaas.xstat.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.ProvinceConstants;
import org.xsaas.xstat.web.conf.SmgkConstants;
import org.xsaas.xstat.web.conf.StatusConstants;
import org.xsaas.xstat.web.util.PaginationUtil;

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

public class ListInformantAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8925259348189164568L;
	private static Log logger = LogFactory.getLog(ListInformantAction.class);
	private IInformantInfoService informantInfoService = null;
	private IClientInfoService clientInfoService = null;
	private ICityInfoService cityInfoService = null;
	
	private List<String> statusList = new LinkedList<String>();
	private Long informantID = null;
	private Long clientID = null;
	private Integer province = null;
	private List<CityInfo> cityList = new LinkedList<CityInfo>();
	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<InformantInfo> pageList = null;	

	private PaginationUtil pu = null;
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {	
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			int page = 1;
			if(num != null){
				page = num.intValue();
			}
			List<ClientInfo> clientInfoList = (List<ClientInfo>)ActionContext.getContext().getSession().get("GLOBALCLIENTINFOLIST");
			if(clientInfoList == null) {
				clientInfoList = clientInfoService.getClientInfoList();
				ActionContext.getContext().getSession().put("GLOBALCLIENTINFOLIST",clientInfoList);//初始化省份信息
			}
			//先添加调查问卷
			long selectClientID = 0;
			if(clientID != null) {
				selectClientID = clientID.longValue();
			}else{
				//客户信息不为空
				if(clientInfoList.size() >0) {
					ClientInfo ci = clientInfoList.get(0);
					selectClientID = ci.getClientID();				
				}
			}
			int total = 0;
			if(selectClientID != 0){
				total = informantInfoService.getInformantInfoTotal(selectClientID);
			}else{
				total = informantInfoService.getInformantInfoTotal();
			}
			
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			if(selectClientID != 0){
				pageList = informantInfoService.findInformantInfoByPage(selectClientID,pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
			}else{
				pageList = informantInfoService.findInformantInfoByPage(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
			}
		
			for(InformantInfo info:pageList){
				if(info.getStatus()!= null){
					statusList.add(""+StatusConstants.StatusDict.get(info.getStatus()));
				}else{
					statusList.add("");
				}
			}			
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}


		return SUCCESS;
	}
	
	public String detail() throws Exception{
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	

			if(username == null || password == null) {
				return LOGIN;
			}
			if(informantID == null) {
				this.addActionError("找不到该调查对象！");
				return ERROR;
			}

			InformantInfo info = informantInfoService.getInformantInfo(informantID);
			ActionContext.getContext().put("INFORMANTLIST",info);	
			if(info != null && info.getStatus()!=null){
				ActionContext.getContext().put("INFORMANTDETAIL",info);	
				ActionContext.getContext().put("STATUS",StatusConstants.StatusDict.get(info.getStatus()));	
			}
			
			if(info.getProvince() != null && info.getProvince() != null) {
				ActionContext.getContext().put("PROVINCE",ProvinceConstants.provinceDict.get(info.getProvince()));		
				
			}else{
				ActionContext.getContext().put("PROVINCE","");			
			}
			CityInfo cityInfo = cityInfoService.getCityInfo(info.getCityID());
			if(cityInfo != null && info.getCityID() != null){
				ActionContext.getContext().put("CITY",cityInfo.getName());	
				
			}else{
				ActionContext.getContext().put("CITY","");	
			}
			ClientInfo clientInfo = clientInfoService.getClientInfo(info.getClientID());
			if(clientInfo != null && info.getClientID() != null){
			
				ActionContext.getContext().put("COMPANY",clientInfo.getCompany());
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

	public void setInformantInfoService(IInformantInfoService informantInfoService) {
		this.informantInfoService = informantInfoService;
	}

	
	public Long getInformantID() {
		return informantID;
	}
	public void setInformantID(Long informantID) {
		this.informantID = informantID;
	}
	public List<InformantInfo> getPageList() {
		return pageList;
	}
	public void setPageList(List<InformantInfo> pageList) {
		this.pageList = pageList;
	}
	public List<String> getStatusList() {
		return statusList;
	}
	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}
	public void setClientInfoService(IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}
	public Long getClientID() {
		return clientID;
	}
	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}
	public PaginationUtil getPu() {
		return pu;
	}
	public Integer getProvince() {
		return province;
	}
	public void setProvince(Integer province) {
		this.province = province;
	}
	public void setCityInfoService(ICityInfoService cityInfoService) {
		this.cityInfoService = cityInfoService;
	}
	public List<CityInfo> getCityList() {
		return cityList;
	}
	public void setCityList(List<CityInfo> cityList) {
		this.cityList = cityList;
	}
}
