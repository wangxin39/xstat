package org.xsaas.xstat.web.action.manage.add;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IClientInfoService;
import org.xsaas.xstat.business.IInformantInfoService;
import org.xsaas.xstat.business.IInquisitionInfoService;
import org.xsaas.xstat.business.IIssueInfoService;
import org.xsaas.xstat.business.IPartInfoService;
import org.xsaas.xstat.business.IProjectInfoService;
import org.xsaas.xstat.business.IRemarkInfoService;
import org.xsaas.xstat.po.ClientInfo;
import org.xsaas.xstat.po.InformantInfo;
import org.xsaas.xstat.po.InquisitionInfo;
import org.xsaas.xstat.po.IssueInfo;
import org.xsaas.xstat.po.PartInfo;
import org.xsaas.xstat.po.ProjectInfo;
import org.xsaas.xstat.po.RemarkInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddCritiqueActions extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 453855886740013266L;
	private static Log logger = LogFactory.getLog(AddCritiqueActions.class);
	private IRemarkInfoService remarkInfoService = null;
	private IPartInfoService partInfoService = null;
	private IInquisitionInfoService inquisitionInfoService = null;
	private IIssueInfoService issueInfoService = null;
	private IInformantInfoService informantInfoService = null;
	private IClientInfoService clientInfoService = null;
	private IProjectInfoService projectInfoService = null;


	private Long partID = null;
	private Long inquisitionID = null;
	private Long informantID = null;
	private Long issueID = null;
	private Long clientID = null;
	private Long projectID = null;
	private String strengths = null;
	private String enStrengths = null;
	private String weaknesses = null;
	private String enWeaknesses = null;
	private String conclusion = null;
	private String enConclusion = null;

	
	private Long remarkID = null;
	
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
				this.addActionMessage("请添加客户信息！");
				return INPUT;
			}
			if(projectID == null){
				this.addActionMessage("请添加项目信息！");
				return INPUT;
			}
			if(issueID == null){
				this.addActionMessage("请添加期次信息！");
				return INPUT;
			}
			if(informantID == null){
				this.addActionMessage("请添加调查对象信息！");
				return INPUT;
			}
			if(inquisitionID == null){
				this.addActionMessage("请添加调查问卷信息！");
				return INPUT;
			}
			if(partID == null){
				this.addActionMessage("请添加部分信息！");
				return INPUT;
			}			
			String isOK = (String)ActionContext.getContext().getSession().get("CLIENTINPUTADDISOK");
			if(isOK != null && "OK".equals(isOK)) {
				RemarkInfo info = new RemarkInfo();
				if(conclusion != null) {
					info.setConclusion(conclusion);					
				}
				if(enConclusion != null) {
					info.setEnConclusion(enConclusion);
				}
				if(enStrengths != null) {
					info.setEnStrengths(enStrengths);
				}
				if(enWeaknesses != null) {
					info.setEnWeaknesses(enWeaknesses);
				}
				if(partID != null) {
					info.setPartID(partID);
				}
				if(strengths != null) {
					info.setStrengths(strengths);
				}
				if(weaknesses != null) {
					info.setWeaknesses(weaknesses);
				}
				if(inquisitionID != null) {
					info.setInquisitionID(inquisitionID);
				}
				if(informantID != null) {
					info.setInformantID(informantID);
				}
				if(issueID != null) {
					info.setIssueID(issueID);
				}
				if(clientID != null) {
					info.setClientID(clientID);
				}
				if(projectID != null) {
					info.setProjectID(projectID);
				}
				Long employeeID = (Long) ActionContext.getContext().getSession().get("GLOBALEMPLOYEEID");				
				info.setEmployeeID(employeeID);
				info.setAddTime(new Timestamp(System.currentTimeMillis()));
				info.setRemarkStatus(StatusConstants.KAISHIFANYI);
				info.setStatus(StatusConstants.ZHENGCHANG);				
				remarkInfoService.saveRemarkInfo(info);
				ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","NOT");
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
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
	
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");//防止刷新提交多次相同信息
			List<ClientInfo> clientInfoList = (List<ClientInfo>)ActionContext.getContext().getSession().get("GLOBALCLIENTINFOLIST");
			if(clientInfoList == null) {
				clientInfoList = clientInfoService.getClientInfoList();				
				ActionContext.getContext().getSession().put("GLOBALCLIENTINFOLIST",clientInfoList);
			}
			Long selectClientID = null;
			if(clientID != null){
				selectClientID = clientID;
			}else{
				if(clientInfoList.size()>0){
					ClientInfo ci = clientInfoList.get(0);
					if(ci!=null){
						selectClientID = ci.getClientID();
					}
				}
			}
			ActionContext.getContext().put("CLIENTVALUE",selectClientID);		
			if(selectClientID == null) {
				this.addActionError("找不到你要操作的客户");
				return ERROR;
			}					
			
			List<InquisitionInfo> inquisitionList = inquisitionInfoService.getInquisitionInfoList(selectClientID);
			List<ProjectInfo> projectList = projectInfoService.getProjectInfoList(selectClientID);			
			List<InformantInfo> informantList = informantInfoService.getInformantInfoList(selectClientID);
			

			
			Long selectInquisitionID = null;
			InquisitionInfo ii = null;
			if(inquisitionID !=null){
				selectInquisitionID = inquisitionID;
			}else{
				if(inquisitionList.size() > 0){
					ii = inquisitionList.get(0);
					if(ii!=null){
						selectInquisitionID = ii.getInquisitionID();
					}
				}
			}	
			List<PartInfo> partInfoList = partInfoService.getPartInfoList(selectInquisitionID);
			Long selectProjectID = null;
			if( projectID == null ){
				if(projectList.size()>0){
					ProjectInfo pi = projectList.get(0);
					if(pi != null){
						selectProjectID = pi.getProjectID();
					}
				}
			}else{
				selectProjectID = projectID;
			}
			List<IssueInfo> issueList = null;
			if(selectProjectID != null && selectInquisitionID != null){
				issueList = issueInfoService.getList(selectProjectID, selectInquisitionID);

			}
			ActionContext.getContext().getSession().put("GLOBALISSUELIST",issueList);
			ActionContext.getContext().getSession().put("GLOBALPROJECTLIST",projectList);
			ActionContext.getContext().getSession().put("GLOBALINQUISITIONLIST",inquisitionList);
			ActionContext.getContext().getSession().put("GLOBALINFORMANTLIST",informantList);
			ActionContext.getContext().getSession().put("GLOBALPARTLIST",partInfoList);

		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}		
		return SUCCESS;
	}	
	public Long getInquisitionID() {
		return inquisitionID;
	}


	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}

	public void setRemarkInfoService(IRemarkInfoService remarkInfoService) {
		this.remarkInfoService = remarkInfoService;
	}

	public Long getPartID() {
		return partID;
	}

	public void setPartID(Long partID) {
		this.partID = partID;
	}

	public String getStrengths() {
		return strengths;
	}

	public void setStrengths(String strengths) {
		this.strengths = strengths;
	}

	public String getEnStrengths() {
		return enStrengths;
	}

	public void setEnStrengths(String enStrengths) {
		this.enStrengths = enStrengths;
	}

	public String getWeaknesses() {
		return weaknesses;
	}

	public void setWeaknesses(String weaknesses) {
		this.weaknesses = weaknesses;
	}

	public String getEnWeaknesses() {
		return enWeaknesses;
	}

	public void setEnWeaknesses(String enWeaknesses) {
		this.enWeaknesses = enWeaknesses;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public String getEnConclusion() {
		return enConclusion;
	}

	public void setEnConclusion(String enConclusion) {
		this.enConclusion = enConclusion;
	}
	public Long getInformantID() {
		return informantID;
	}


	public void setInformantID(Long informantID) {
		this.informantID = informantID;
	}


	public Long getIssueID() {
		return issueID;
	}


	public void setIssueID(Long issueID) {
		this.issueID = issueID;
	}


	public Long getClientID() {
		return clientID;
	}


	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}


	public Long getProjectID() {
		return projectID;
	}


	public void setProjectID(Long projectID) {
		this.projectID = projectID;
	}

	public Long getRemarkID() {
		return remarkID;
	}

	public void setRemarkID(Long remarkID) {
		this.remarkID = remarkID;
	}


	public void setPartInfoService(IPartInfoService partInfoService) {
		this.partInfoService = partInfoService;
	}

	public void setInquisitionInfoService(
			IInquisitionInfoService inquisitionInfoService) {
		this.inquisitionInfoService = inquisitionInfoService;
	}

	public void setIssueInfoService(IIssueInfoService issueInfoService) {
		this.issueInfoService = issueInfoService;
	}

	public void setInformantInfoService(IInformantInfoService informantInfoService) {
		this.informantInfoService = informantInfoService;
	}

	public void setClientInfoService(IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}

	public void setProjectInfoService(IProjectInfoService projectInfoService) {
		this.projectInfoService = projectInfoService;
	}
}
