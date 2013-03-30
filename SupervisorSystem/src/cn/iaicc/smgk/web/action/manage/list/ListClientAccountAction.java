package cn.iaicc.smgk.web.action.manage.list;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import cn.iaicc.smgk.business.ICityInfoService;
import cn.iaicc.smgk.business.IClientAccountInfoService;
import cn.iaicc.smgk.business.IClientInfoService;
import cn.iaicc.smgk.business.IInformantInfoService;
import cn.iaicc.smgk.po.CityInfo;
import cn.iaicc.smgk.po.ClientAccountInfo;
import cn.iaicc.smgk.po.ClientInfo;
import cn.iaicc.smgk.po.InformantInfo;
import cn.iaicc.smgk.web.conf.ProvinceConstants;
import cn.iaicc.smgk.web.conf.QuestionTypeConstants;
import cn.iaicc.smgk.web.conf.SmgkConstants;
import cn.iaicc.smgk.web.conf.StatusConstants;
import cn.iaicc.smgk.web.util.PaginationUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListClientAccountAction extends ActionSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7568400183849106961L;
	private static Log logger = LogFactory.getLog(ListClientAccountAction.class);
	private IClientAccountInfoService clientAccountInfoService = null;
	private IClientInfoService clientInfoService = null;
	private ICityInfoService cityInfoService = null;
	private IInformantInfoService informantInfoService = null;

	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<ClientAccountInfo> pageList = null;	

	private PaginationUtil pu = null;
	
	private Long accountID = null;
	
	private Long fatherID = null;
	
	private Long clientID = null;
	
	private List<CityInfo> cityList = null;
	private Integer province = null;
	private List<InformantInfo> inList = null;
	private List<String> typeList = null;
	private List<ClientInfo> clientInfoList = null;
	
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
			if (num != null) {
				page = num.intValue();
			}
			clientInfoList = (List<ClientInfo>)ActionContext.getContext().getSession().get("GLOBALCLIENTINFOLIST");
			if(clientInfoList == null) {
				clientInfoList = clientInfoService.getClientInfoList();
				ActionContext.getContext().getSession().put("GLOBALCLIENTINFOLIST",clientInfoList);//初始化省份信息
			}

			
			long selectClientID = 0;
			if(clientID != null) {
				selectClientID = clientID.longValue();
			}else{
				//客户信息不为空
				if(clientInfoList.size() >0) {
					ClientInfo ci = clientInfoList.get(0);
					if(ci!=null){
						selectClientID = ci.getClientID().longValue();	
					}
								
				}
			}
			int total = 0;
			if(selectClientID != 0){
				total = clientAccountInfoService.getClientAccountInfoTotal(selectClientID);
			}else{
				total = clientAccountInfoService.getClientAccountInfoTotal();	
			}
			
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			if(selectClientID != 0){
				pageList = clientAccountInfoService.findClientAccountInfoByPage(selectClientID,pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
			}else{
				pageList = clientAccountInfoService.findClientAccountInfoByPage(pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);				
			}
			typeList = new java.util.LinkedList<String>();
			
			for(ClientAccountInfo cai:pageList) {
				if(cai != null && cai.getType() != null)
				typeList.add(StatusConstants.AccountTypeDict.get(cai.getType()));
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}

	public String detail() throws Exception{
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		if(username == null || password == null) {
			return LOGIN;
		}
		try{
			if(accountID == null) {
				this.addActionError("编号为空！");
				return ERROR;
			}
			ClientAccountInfo info = clientAccountInfoService.getClientAccountInfo(accountID);		
			if(info != null && info.getStatus()!=null){
				ActionContext.getContext().put("ACCOUNTINFO", info);
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
			if(info.getInformantID() != null && info.getInformantID() != -1) {
				InformantInfo iInfo = informantInfoService.getInformantInfo(info.getInformantID());
				if(iInfo != null && iInfo.getName() != null){
					ActionContext.getContext().put("INFORMANT",iInfo.getName());
				}				
			}
			else if(info.getInformantID() != null && info.getInformantID() == -1) {
				ActionContext.getContext().put("INFORMANT","所有");
			}

			if(info.getFatherID() != null) {
				ClientAccountInfo cai = clientAccountInfoService.getClientAccountInfo(info.getFatherID());
				if(cai != null && cai.getClientName() != null) {
					ActionContext.getContext().put("FATHERNAME", cai.getClientName());					
				}
			}
			if(info != null && info.getType() != null) {
				ActionContext.getContext().put("ACCOUNTTYPE", StatusConstants.AccountTypeDict.get(info.getType()));
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
	public void setClientAccountInfoService(
			IClientAccountInfoService clientAccountInfoService) {
		this.clientAccountInfoService = clientAccountInfoService;
	}

	public void setClientInfoService(IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}

	public List<ClientAccountInfo> getPageList() {
		return pageList;
	}

	public void setPageList(List<ClientAccountInfo> pageList) {
		this.pageList = pageList;
	}

	
	public void setCityInfoService(ICityInfoService cityInfoService) {
		this.cityInfoService = cityInfoService;
	}
	public Integer getProvince() {
		return province;
	}

	public void setProvince(Integer province) {
		this.province = province;
	}
	public Long getAccountID() {
		return accountID;
	}

	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}


	public PaginationUtil getPu() {
		return pu;
	}

	public Long getFatherID() {
		return fatherID;
	}

	public void setFatherID(Long fatherID) {
		this.fatherID = fatherID;
	}


	public Long getClientID() {
		return clientID;
	}

	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}

	public void setInformantInfoService(IInformantInfoService informantInfoService) {
		this.informantInfoService = informantInfoService;
	}

	public List<CityInfo> getCityList() {
		return cityList;
	}

	public void setCityList(List<CityInfo> cityList) {
		this.cityList = cityList;
	}
	
	public List<InformantInfo> getInList() {
		return inList;
	}

	public void setInList(List<InformantInfo> inList) {
		this.inList = inList;
	}

	public List<String> getTypeList() {
		return typeList;
	}

	public List<ClientInfo> getClientInfoList() {
		return clientInfoList;
	}

}
