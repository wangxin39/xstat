package org.xsaas.xstat.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.SmgkConstants;
import org.xsaas.xstat.web.conf.StatusConstants;
import org.xsaas.xstat.web.util.PaginationUtil;

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

public class ListVideoAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8925259348189164568L;
	private static Log logger = LogFactory.getLog(ListVideoAction.class);
	private IVideoInfoService videoInfoService = null;
	private IInformantInfoService informantInfoService = null;
	private IClientInfoService clientInfoService = null;
	
	private List<String> statusList = new LinkedList<String>();
	private Long informantID = null;
	private Long clientID = null;
	private Long videoID = null;
	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<VideoInfo> pageList = null;		
	private PaginationUtil pu = null;
	
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
					if(ci!=null){
						selectClientID = ci.getClientID();			
						ActionContext.getContext().put("CLIENTVALUE",selectClientID);
					}
				}
			}
			
			inforList = informantInfoService.getInformantInfoList(selectClientID);
			ActionContext.getContext().getSession().put("INFORMANTLIST",inforList);
			
			long selectInformantID = 0;
			if(informantID !=null){
				selectInformantID = informantID.longValue();
			}else{
				inforList = informantInfoService.getInformantInfoList();
				if(inforList.size()>0){
					InformantInfo ii = inforList.get(0);
					selectInformantID = ii.getInformantID().longValue();
				}
			}
			
			int total = 0;
			if(selectClientID != 0 && selectInformantID!=0){
				total = videoInfoService.getTotal(selectClientID,selectInformantID);
			}else{
				total = videoInfoService.getVideoInfoTotal();
			}
			
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			if(selectClientID != 0 && selectInformantID!=0){
				pageList = videoInfoService.findByPage(selectClientID,selectInformantID,pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
			}else{
				pageList = videoInfoService.findVideoInfoByPage(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
			}
		
			for(VideoInfo info:pageList){
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

	
	public String detail() throws Exception {
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
			VideoInfo info = videoInfoService.getVideoInfo(videoID);
			if(info!=null && info.getStatus()!=null){
				ActionContext.getContext().put("VIDEODETAIL",info);
				ActionContext.getContext().put("STATUS",StatusConstants.StatusDict.get(info.getStatus()));
			}
			ClientInfo ci = clientInfoService.getClientInfo(info.getClientID());
			InformantInfo ii = informantInfoService.getInformantInfo(info.getInformantID());
			if(ci!=null && ci.getCompany()!=null){
				ActionContext.getContext().put("CLIENT",ci.getCompany());
			}
			if(ii!=null && ii.getName()!=null){
				ActionContext.getContext().put("INFORMANT",ii.getName());
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
	public Long getVideoID() {
		return videoID;
	}
	public void setVideoID(Long videoID) {
		this.videoID = videoID;
	}
	public List<VideoInfo> getPageList() {
		return pageList;
	}
	public void setPageList(List<VideoInfo> pageList) {
		this.pageList = pageList;
	}
	public List<InformantInfo> getInforList() {
		return inforList;
	}
	public void setInforList(List<InformantInfo> inforList) {
		this.inforList = inforList;
	}
	public void setVideoInfoService(IVideoInfoService videoInfoService) {
		this.videoInfoService = videoInfoService;
	}
}
