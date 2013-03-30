package cn.iaicc.smgk.web.action.manage.edit;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IClientInfoService;
import cn.iaicc.smgk.business.IGradeRelationInfoService;
import cn.iaicc.smgk.business.IGradeStdInfoService;
import cn.iaicc.smgk.business.IInformantInfoService;
import cn.iaicc.smgk.business.IIssueInfoService;
import cn.iaicc.smgk.po.ClientInfo;
import cn.iaicc.smgk.po.GradeRelationInfo;
import cn.iaicc.smgk.po.GradeStdInfo;
import cn.iaicc.smgk.po.InformantInfo;
import cn.iaicc.smgk.po.IssueInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditGradeRelationAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5281237270740934847L;
	private static Log logger = LogFactory.getLog(EditGradeRelationAction.class);
	private IClientInfoService clientInfoService = null;
	private IIssueInfoService issueInfoService = null;
	private IInformantInfoService informantInfoService = null;
	private IGradeStdInfoService gradeStdInfoService = null;
	private IGradeRelationInfoService gradeRelationInfoService = null;
	
	private Long clientID = null;
	private Long issueID = null;
	private Long informantID = null;
	private Long gradeStdID = null;	
	
	private Long gradeRelationID = null;
	
	
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			GradeRelationInfo info = (GradeRelationInfo)ActionContext.getContext().getSession().get("EDITGRADERELATIONINFO");
			if(info == null) {
				this.addActionError("找不到要编辑的信息！");
				return ERROR;
			}
			if(clientID != null) {
				info.setClientID(clientID);				
			}
			if(informantID != null) {
				info.setInformantID(informantID);				
			}
			if(issueID != null) {
				info.setIssueID(issueID);				
			}
			if(gradeStdID != null) {
				info.setGradeStdID(gradeStdID);				
			}			
			gradeRelationInfoService.update(info);
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
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
			if(gradeRelationID == null) {
				this.addActionError("找不到要编辑的信息！");
				return ERROR;
			}
			GradeRelationInfo info = gradeRelationInfoService.getGradeRelationInfo(gradeRelationID);
			ActionContext.getContext().getSession().put("EDITGRADERELATIONINFO",info);
			
			List<ClientInfo> clientInfoList = (List<ClientInfo>)ActionContext.getContext().getSession().get("GLOBALCLIENTINFOLIST");
			if(clientInfoList == null) {
				clientInfoList = clientInfoService.getClientInfoList();
				ActionContext.getContext().getSession().put("GLOBALCLIENTINFOLIST",clientInfoList);
			}
			List<IssueInfo> issueInfoList = (List<IssueInfo>)ActionContext.getContext().getSession().get("GLOBALISSUEINFOLIST");
			if(issueInfoList == null) {
				issueInfoList = issueInfoService.getIssueInfoList();
				ActionContext.getContext().getSession().put("GLOBALISSUEINFOLIST",issueInfoList);
			}
			List<InformantInfo> informantInfoList = (List<InformantInfo>)ActionContext.getContext().getSession().get("GLOBALINFORMANTINFOLIST");
			if(informantInfoList == null) {				
				informantInfoList = informantInfoService.getInformantInfoList();
				ActionContext.getContext().getSession().put("GLOBALINFORMANTINFOLIST",informantInfoList);
			}			
			List<GradeStdInfo> gradeStdInfoList = gradeStdInfoService.findByPage(0, Integer.MAX_VALUE);
			
			ActionContext.getContext().getSession().put("GLOBALGRADESTDINFOLIST",gradeStdInfoList);
			
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}			
		return SUCCESS;
	}

	public Long getClientID() {
		return clientID;
	}

	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}

	public Long getIssueID() {
		return issueID;
	}

	public void setIssueID(Long issueID) {
		this.issueID = issueID;
	}

	public Long getInformantID() {
		return informantID;
	}

	public void setInformantID(Long informantID) {
		this.informantID = informantID;
	}

	public Long getGradeStdID() {
		return gradeStdID;
	}

	public void setGradeStdID(Long gradeStdID) {
		this.gradeStdID = gradeStdID;
	}

	public Long getGradeRelationID() {
		return gradeRelationID;
	}

	public void setGradeRelationID(Long gradeRelationID) {
		this.gradeRelationID = gradeRelationID;
	}

	public void setClientInfoService(IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}

	public void setIssueInfoService(IIssueInfoService issueInfoService) {
		this.issueInfoService = issueInfoService;
	}

	public void setInformantInfoService(IInformantInfoService informantInfoService) {
		this.informantInfoService = informantInfoService;
	}

	public void setGradeStdInfoService(IGradeStdInfoService gradeStdInfoService) {
		this.gradeStdInfoService = gradeStdInfoService;
	}

	public void setGradeRelationInfoService(
			IGradeRelationInfoService gradeRelationInfoService) {
		this.gradeRelationInfoService = gradeRelationInfoService;
	}
}
