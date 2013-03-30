package cn.iaicc.smgk.web.action.manage.delete;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IPartSelectInfoService;
import cn.iaicc.smgk.po.PartQuestionInfo;
import cn.iaicc.smgk.po.PartSelectInfo;
import cn.iaicc.smgk.web.conf.StatusConstants;

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
