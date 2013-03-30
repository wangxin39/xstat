package org.xsaas.xstat.web.action.manage.delete;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IPartInfoService;
import org.xsaas.xstat.business.IPartQuestionInfoService;
import org.xsaas.xstat.po.PartInfo;
import org.xsaas.xstat.po.PartQuestionInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeletePartQuestionAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8214185261887712162L;
	private static Log logger = LogFactory.getLog(DeletePartQuestionAction.class);
	
	private IPartQuestionInfoService partQuestionInfoService = null;
	
	private Long partQuestionID = null;
	
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			PartQuestionInfo partQuestionInfo = partQuestionInfoService.getPartQuestionInfo(partQuestionID);
			partQuestionInfo.setStatus(StatusConstants.SHANCHU);
			partQuestionInfoService.updatePartQuestionInfo(partQuestionInfo);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}

	public Long getPartQuestionID() {
		return partQuestionID;
	}

	public void setPartQuestionID(Long partQuestionID) {
		this.partQuestionID = partQuestionID;
	}

	public void setPartQuestionInfoService(
			IPartQuestionInfoService partQuestionInfoService) {
		this.partQuestionInfoService = partQuestionInfoService;
	}
}
