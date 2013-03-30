package cn.iaicc.smgk.web.action.manage.add;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IClientInfoService;
import cn.iaicc.smgk.business.IEmployeeInfoService;
import cn.iaicc.smgk.business.IInformantInfoService;
import cn.iaicc.smgk.business.IVideoInfoService;
import cn.iaicc.smgk.po.ClientInfo;
import cn.iaicc.smgk.po.EmployeeInfo;
import cn.iaicc.smgk.po.InformantInfo;
import cn.iaicc.smgk.po.VideoInfo;
import cn.iaicc.smgk.web.conf.StatusConstants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddVideoActions extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8925259348189164568L;
	private static Log logger = LogFactory.getLog(AddVideoActions.class);
	private IVideoInfoService videoInfoService = null;
	private IInformantInfoService informantInfoService = null;
	private IClientInfoService clientInfoService = null;

	private Long clientID = null;
	private Long informantID = null;
	private String name = null;
	private String url = null;	
	private String englishName = null;
		
	private List<InformantInfo> inforList = null;	
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			if(clientID == null){
				ActionContext.getContext().put("nullError","客户名称不能为空，请先添加客户信息!");
				return INPUT;
			}
			if(informantID == null){
				ActionContext.getContext().put("nullError","调查对象不能为空,请先添加调查对象!");
				return INPUT;
			}
			String isOK = (String)ActionContext.getContext().getSession().get("CLIENTINPUTADDISOK");
			if(isOK != null && "OK".equals(isOK)) {
				VideoInfo info = new VideoInfo();
				info.setClientID(clientID);
				info.setAddTime(new Timestamp(System.currentTimeMillis()));
				info.setName(name);
				info.setInformantID(informantID);
				info.setEnglishName(englishName);
				info.setUrl(url);
				info.setStatus(StatusConstants.ZHENGCHANG);
				videoInfoService.saveVideoInfo(info);
				ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","NOT");
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}


		
		return SUCCESS;
	}
	// 增加输入界面
	@SuppressWarnings("unchecked")
	public String input() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	

			if(username == null || password == null) {
				return LOGIN;
			}
			long selectClientID = 0;
			if(clientID == null) {
				List<ClientInfo> clientInfoList = (List<ClientInfo>)ActionContext.getContext().getSession().get("GLOBALCLIENTINFOLIST");
				if(clientInfoList == null) {
					clientInfoList = clientInfoService.getClientInfoList();					
					ActionContext.getContext().getSession().put("GLOBALCLIENTINFOLIST",clientInfoList);
				}
				if(clientInfoList.size() >0) {
					ClientInfo ci = clientInfoList.get(0);
					if(ci!=null){
						selectClientID = ci.getClientID().longValue();
						ActionContext.getContext().put("CLIENTVALUE",ci.getClientID());		
					}
				}
			}else{
				selectClientID = clientID.longValue();
			}
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");
			inforList = informantInfoService.getInformantInfoList(selectClientID);
			ActionContext.getContext().getSession().put("INFORMANTLIST",inforList);
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

	public Long getClientID() {
		return clientID;
	}

	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}

	public Long getInformantID() {
		return informantID;
	}


	public void setInformantID(Long informantID) {
		this.informantID = informantID;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public void setVideoInfoService(IVideoInfoService videoInfoService) {
		this.videoInfoService = videoInfoService;
	}



	public String getEnglishName() {
		return englishName;
	}


	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public List<InformantInfo> getInforList() {
		return inforList;
	}
	public void setInformantInfoService(IInformantInfoService informantInfoService) {
		this.informantInfoService = informantInfoService;
	}
	public void setClientInfoService(IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}

}
