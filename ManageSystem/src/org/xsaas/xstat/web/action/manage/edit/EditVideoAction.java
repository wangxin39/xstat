package org.xsaas.xstat.web.action.manage.edit;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IClientInfoService;
import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IInformantInfoService;
import org.xsaas.xstat.business.IVideoInfoService;
import org.xsaas.xstat.po.ClientInfo;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.InformantInfo;
import org.xsaas.xstat.po.VideoInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditVideoAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8925259348189164568L;
	private static Log logger = LogFactory.getLog(EditVideoAction.class);
	private IVideoInfoService videoInfoService = null;
	private IInformantInfoService informantInfoService = null;
	private IClientInfoService clientInfoService = null;

	private Long clientID = null;
	private Long informantID = null;
	private String name = null;
	private String url = null;	
	private Integer status = null;
	private String englishName = null;
	
	private Long videoID = null;
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
			String isOK = (String)ActionContext.getContext().getSession().get("CLIENTINPUTADDISOK");
			if(isOK != null && "OK".equals(isOK)) {
				VideoInfo info = (VideoInfo) ActionContext.getContext().getSession().get("VIDEOEDIT");
				info.setClientID(clientID);
				info.setAddTime(new Timestamp(System.currentTimeMillis()));
				info.setName(name);
				info.setEnglishName(englishName);
				info.setInformantID(informantID);
				info.setUrl(url);
				videoInfoService.updateVideoInfo(info);
				ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","NOT");
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}


		
		return SUCCESS;
	}

	// 修改界面
	@SuppressWarnings("unchecked")
	public String edit() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	

			if(username == null || password == null) {
				return LOGIN;
			}
			if(videoID == null){
				this.addActionError("编号为空！");
				return ERROR;
			}
			List<ClientInfo> clientInfoList = (List<ClientInfo>)ActionContext.getContext().getSession().get("GLOBALCLIENTINFOLIST");
			if(clientInfoList == null) {
				clientInfoList = clientInfoService.getClientInfoList();
				ActionContext.getContext().getSession().put("GLOBALCLIENTINFOLIST",clientInfoList);//初始化省份信息
			}
			Long selectClientID = null;
			if(clientID == null) {
				//客户信息不为空
				if(clientInfoList.size() >0) {
					ClientInfo ci = clientInfoList.get(0);
					if(ci != null){
						selectClientID = ci.getClientID();
						ActionContext.getContext().put("CLIENTVALUE",ci.getClientID());		
					}
				}
			}else{
				selectClientID = clientID;
			}
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");
			inforList = informantInfoService.getInformantInfoList(selectClientID);
			ActionContext.getContext().getSession().put("INFORMANTLIST",inforList);			
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");
			VideoInfo vi = videoInfoService.getVideoInfo(videoID);
			ActionContext.getContext().getSession().put("VIDEOEDIT",vi);
			ActionContext.getContext().getSession().put("STATUS",StatusConstants.StatusDict);
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


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getEnglishName() {
		return englishName;
	}


	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public Long getVideoID() {
		return videoID;
	}

	public void setVideoID(Long videoID) {
		this.videoID = videoID;
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
