package org.xsaas.xstat.web.action.manage.add;

import java.sql.Timestamp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IReqResultInfoService;
import org.xsaas.xstat.po.ReqInfo;
import org.xsaas.xstat.po.ReqResultInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddAppealResultActions extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4426877640765909187L;
	private static Log logger = LogFactory.getLog(AddAppealResultActions.class);
	private IReqResultInfoService reqResultInfoService = null;

	private Long reqID = null;
	private Timestamp reqTime = null;
	private String content = null;
	private String title = null;

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		if(username == null || password == null) {
			return LOGIN;
		}
		try{
			
			String isOK = (String)ActionContext.getContext().getSession().get("CLIENTINPUTADDISOK");
			if(isOK != null && "OK".equals(isOK)) {
				try{
					ReqResultInfo info = new ReqResultInfo();
					ReqInfo ri = (ReqInfo) ActionContext.getContext().getSession().get("REQINFO");
					long id =  (Long) ActionContext.getContext().getSession().get("LOGINID");

					info.setAccountID(ri.getAccountID());
					info.setEmployeeID(id);
					info.setReqID(reqID);
					info.setReqTime(new Timestamp(System.currentTimeMillis()));
					info.setContent(content);
					info.setTitle(title);
					info.setStatus(StatusConstants.ZHENGCHANG);
					reqResultInfoService.saveReqResultInfo(info);
					}catch(Exception e){
						e.printStackTrace();
						System.out.println(e.getMessage());
					}
				ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","NOT");
			}
			
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}
	
		return SUCCESS;
	}

	public void setReqResultInfoService(IReqResultInfoService reqResultInfoService) {
		this.reqResultInfoService = reqResultInfoService;
	}


	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public Timestamp getReqTime() {
		return reqTime;
	}


	public void setReqTime(Timestamp reqTime) {
		this.reqTime = reqTime;
	}



	public Long getReqID() {
		return reqID;
	}



	public void setReqID(Long reqID) {
		this.reqID = reqID;
	}





}
