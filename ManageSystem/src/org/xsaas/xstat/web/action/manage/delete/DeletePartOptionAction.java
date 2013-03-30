package org.xsaas.xstat.web.action.manage.delete;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IPartSelectInfoService;
import org.xsaas.xstat.po.PartQuestionInfo;
import org.xsaas.xstat.po.PartSelectInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeletePartOptionAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8214185261887712162L;
	private static Log logger = LogFactory.getLog(DeletePartOptionAction.class);
	private IPartSelectInfoService partSelectInfoService = null;

	private Long partSelectID = null;
	
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			PartQuestionInfo  partInfo = (PartQuestionInfo) ActionContext.getContext().getSession().get("QUESTIONLI");
			if(partInfo == null) {
				this.addActionError("末能获取到部分信息，请联系管理员.");
				return ERROR;
			}
			PartSelectInfo info = partSelectInfoService.getPartSelectInfo(partSelectID);
			info.setStatus(StatusConstants.SHANCHU);
			partSelectInfoService.updatePartSelectInfo(info);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}

	public Long getPartSelectID() {
		return partSelectID;
	}


	public void setPartSelectID(Long partSelectID) {
		this.partSelectID = partSelectID;
	}


	public void setPartSelectInfoService(
			IPartSelectInfoService partSelectInfoService) {
		this.partSelectInfoService = partSelectInfoService;
	}

	
}
