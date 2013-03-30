package org.xsaas.xstat.web.action.manage.edit;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.xsaas.xstat.web.conf.ProvinceConstants;
import org.xsaas.xstat.web.conf.QuestionTypeConstants;

import org.xsaas.xstat.business.ICityInfoService;
import org.xsaas.xstat.business.IClientAccountInfoService;
import org.xsaas.xstat.business.IClientInfoService;
import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IInformantInfoService;
import org.xsaas.xstat.po.CityInfo;
import org.xsaas.xstat.po.ClientAccountInfo;
import org.xsaas.xstat.po.ClientInfo;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.InformantInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditClientAccountAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5248039003761278571L;
	private static Log logger = LogFactory.getLog(EditClientAccountAction.class);
	
	private IClientAccountInfoService clientAccountInfoService = null;
	private IClientInfoService clientInfoService = null;
	private ICityInfoService cityInfoService = null;
	private IInformantInfoService informantInfoService = null;
	
	private Long clientID = null;
	private Integer type = null;
	private Long informantID = null;
	private String clientName = null;
	private String loginName = null;
	private String passWord = null;
	private String country = null;
	private Integer province = null;
	private Long cityID = null;
	private String telephone = null;
	private String mobile = null;
	private String lastIP = null;
	private Timestamp lastLongin = null;
	private Long fatherID = null;
	private Integer status = null;;
	
	private Long accountID = null;
	private List<CityInfo> cityList = null;
	private List<InformantInfo> inList = null;
	private List<String> typeList = null;
	private List<ClientInfo> clientInfoList = null;	
	
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			String isOK = (String)ActionContext.getContext().getSession().get("CLIENTINPUTADDISOK");

			if(isOK != null && "OK".equals(isOK)) {//验证是不是在input过来的。
				ClientAccountInfo info = (ClientAccountInfo) ActionContext.getContext().getSession().get("ACCOUNTEDIT");
				HttpServletRequest request = ServletActionContext.getRequest();	
				info.setLastIP(""+request.getRemoteAddr());//获取来访者地址
				if(clientID != null) {
					info.setClientID(clientID);					
				}
				if(type != null) {
					info.setType(type);
				}
				if(informantID != null) {
					info.setInformantID(informantID);
				}
				if(loginName != null) {
					info.setLoginName(loginName);					
				}
				if(country != null) {
					info.setCountry(country);					
				}
				if(cityID != null) {
					info.setCityID(cityID);					
				}
				if(telephone != null) {
					info.setTelephone(telephone);					
				}
				if(clientName != null) {
					info.setClientName(clientName);					
				}
				if(province != null) {
					info.setProvince(province);					
				}
				if(passWord != null) {
					info.setPassWord(passWord);					
				}
				if(mobile != null) {
					info.setMobile(mobile);					
				}
				if(fatherID != null) {
					info.setFatherID(fatherID);					
				}
				clientAccountInfoService.updateClientAccountInfo(info);
				ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","NOT");
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String edit() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			if(accountID == null){
				this.addActionError("编号为空！");
				return ERROR;
			}

			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");
			ActionContext.getContext().getSession().put("COMPANY",QuestionTypeConstants.CompanyDict); 
			ActionContext.getContext().getSession().put("COUNTRY",ProvinceConstants.countryDict);
			int selectProvince = 0;
			if(province == null){
				cityList = cityInfoService.getCityInfoList();
				if(cityList.size() > 0){
					CityInfo info = cityList.get(0);
					if(info!=null && info.getProvince()!=null){
						selectProvince = info.getProvince().intValue();
						ActionContext.getContext().getSession().put("PROVINCE",selectProvince);//初始化省份信息
					}
					
				}
				ActionContext.getContext().getSession().put("PROVINCELIST",ProvinceConstants.provinceDict); //获取数据库中的省份
			}else{
				selectProvince = province.intValue();
			}
			cityList = cityInfoService.getCityInfoList(selectProvince);
			ActionContext.getContext().getSession().put("CITYLIST",cityList);
			
			List<ClientInfo> clientInfoList = (List<ClientInfo>)ActionContext.getContext().getSession().get("GLOBALCLIENTINFOLIST");
			if(clientInfoList == null) {
				clientInfoList = clientInfoService.getClientInfoList();
				ActionContext.getContext().getSession().put("GLOBALCLIENTINFOLIST",clientInfoList);//初始化省份信息
			}
			
			long selectID = 0;
			if(clientID == null){				
				if(clientInfoList.size()>0){
					ClientInfo ci = clientInfoList.get(0);
					if(ci!=null){
						selectID = ci.getClientID().longValue();
						ActionContext.getContext().getSession().put("CLIENTVALUE",selectID);//初始化省份信息
					}
				}
			}else{
				selectID = clientID.longValue();
			}
			inList = informantInfoService.getInformantInfoList(selectID);				
			InformantInfo ii = new InformantInfo();
			long informantID = -1; //表示所有
			ii.setInformantID(informantID);
			ii.setName("所有");
			inList.add(ii);
			ActionContext.getContext().getSession().put("INFORMANTLIST",inList);

			if(accountID != null){
				List<ClientAccountInfo> caiList = new java.util.LinkedList<ClientAccountInfo>();
				caiList.add(clientAccountInfoService.getClientAccountInfo(accountID));
				ActionContext.getContext().put("FATHERINFOLIST",caiList);
			}		
			
			ClientAccountInfo info = clientAccountInfoService.getClientAccountInfo(accountID);
			ActionContext.getContext().getSession().put("ACCOUNTEDIT",info);	
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}


	
		return SUCCESS;
	}		

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	public Integer getProvince() {
		return province;
	}

	public void setProvince(Integer province) {
		this.province = province;
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

	
	
	
	public Long getFatherID() {
		return fatherID;
	}
	public void setFatherID(Long fatherID) {
		this.fatherID = fatherID;
	}

	public String getLoginName() {
		return loginName;
	}


	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public Long getInformantID() {
		return informantID;
	}


	public void setInformantID(Long informantID) {
		this.informantID = informantID;
	}


	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	public String getLastIP() {
		return lastIP;
	}

	public void setLastIP(String lastIP) {
		this.lastIP = lastIP;
	}

	public Timestamp getLastLongin() {
		return lastLongin;
	}

	public void setLastLongin(Timestamp lastLongin) {
		this.lastLongin = lastLongin;
	}


	public void setClientAccountInfoService(
			IClientAccountInfoService clientAccountInfoService) {
		this.clientAccountInfoService = clientAccountInfoService;
	}
	public Long getClientID() {
		return clientID;
	}
	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}
	public Long getCityID() {
		return cityID;
	}
	public void setCityID(Long cityID) {
		this.cityID = cityID;
	}


	public Integer getType() {
		return type;
	}


	public void setType(Integer type) {
		this.type = type;
	}

	public Long getAccountID() {
		return accountID;
	}

	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}

	public List<CityInfo> getCityList() {
		return cityList;
	}

	public List<InformantInfo> getInList() {
		return inList;
	}

	public List<String> getTypeList() {
		return typeList;
	}

	public List<ClientInfo> getClientInfoList() {
		return clientInfoList;
	}

	public void setClientInfoService(IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}

	public void setCityInfoService(ICityInfoService cityInfoService) {
		this.cityInfoService = cityInfoService;
	}

	public void setInformantInfoService(IInformantInfoService informantInfoService) {
		this.informantInfoService = informantInfoService;
	}

	
}
