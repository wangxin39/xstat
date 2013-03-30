package org.xsaas.xstat.web.action.manage.add;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IGradeStdInfoService;
import org.xsaas.xstat.business.IInquisitionInfoService;
import org.xsaas.xstat.po.GradeStdInfo;
import org.xsaas.xstat.po.InquisitionInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddGradeStdActions extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3092454915764068202L;
	private static Log logger = LogFactory.getLog(AddGradeStdActions.class);
	private IInquisitionInfoService inquisitionInfoService = null;
	private IGradeStdInfoService gradeStdInfoService = null;

	private Long inquisitionID = null;
	private String title = null;
	private String description = null;
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			if(title == null) {
				this.addActionError("请输入标题！");
				return INPUT;
			}
			GradeStdInfo info = new GradeStdInfo();
			info.setInquisitionID(inquisitionID);
			info.setTitle(title);
			if(description != null) {
				info.setDescription(description);				
			}
			info.setStatus(StatusConstants.ZHENGCHANG); //正常
					
			String isOK = (String)ActionContext.getContext().getSession().get("ISPROCESSOK");;
			if(!"YES".equals(isOK)) {
				gradeStdInfoService.save(info);
				ActionContext.getContext().getSession().put("ISPROCESSOK","YES");
			}
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String input() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			List<InquisitionInfo> inquisitionInfoList = (List<InquisitionInfo>)ActionContext.getContext().getSession().get("GLOBALINQUISITIONINFOLIST");
			if(inquisitionInfoList == null) {
				inquisitionInfoList =  inquisitionInfoService.getInquisitionInfoList();
				ActionContext.getContext().getSession().put("GLOBALINQUISITIONINFOLIST",inquisitionInfoList);
			}

			ActionContext.getContext().getSession().put("ISPROCESSOK","NOT");
			
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}		
		return SUCCESS;
	}	
	
	public Long getInquisitionID() {
		return inquisitionID;
	}
	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setGradeStdInfoService(IGradeStdInfoService gradeStdInfoService) {
		this.gradeStdInfoService = gradeStdInfoService;
	}

	public void setInquisitionInfoService(
			IInquisitionInfoService inquisitionInfoService) {
		this.inquisitionInfoService = inquisitionInfoService;
	}

}
