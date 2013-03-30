package cn.iaicc.smgk.web.action.manage.edit;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IGradeStdInfoService;
import cn.iaicc.smgk.business.IInquisitionInfoService;
import cn.iaicc.smgk.po.GradeStdInfo;
import cn.iaicc.smgk.po.InquisitionInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditGradeStdAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1436026729956551336L;
	private static Log logger = LogFactory.getLog(EditGradeStdAction.class);
	private IInquisitionInfoService inquisitionInfoService = null;
	
	private Long gradeStdID = null;
	
	private IGradeStdInfoService gradeStdInfoService = null;

	private Long inquisitionID = null;
	private String title = null;
	private String description = null;

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
			GradeStdInfo info = (GradeStdInfo)ActionContext.getContext().getSession().get("EDITGRADESTDINFO");
			if(info != null) {
				if(inquisitionID != null) {
					info.setInquisitionID(inquisitionID);					
				}
				if(title != null) {
					info.setTitle(title);					
				}
				if(description != null) {
					info.setDescription(description);				
				}				
				gradeStdInfoService.update(info);
			}
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
			if(gradeStdID == null) {
				this.addActionError("非法操作！请联系管理员！");
				return INPUT;
			}
			List<InquisitionInfo> inquisitionInfoList = (List<InquisitionInfo>)ActionContext.getContext().getSession().get("GLOBALINQUISITIONINFOLIST");
			if(inquisitionInfoList == null) {
				inquisitionInfoList =  inquisitionInfoService.getInquisitionInfoList();
				ActionContext.getContext().getSession().put("GLOBALINQUISITIONINFOLIST",inquisitionInfoList);
			}		
			GradeStdInfo info = gradeStdInfoService.getGradeStdInfo(gradeStdID);
			ActionContext.getContext().getSession().put("EDITGRADESTDINFO", info);
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}		
		return SUCCESS;
	}
	
	public void setGradeStdInfoService(IGradeStdInfoService gradeStdInfoService) {
		this.gradeStdInfoService = gradeStdInfoService;
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
	public void setInquisitionInfoService(
			IInquisitionInfoService inquisitionInfoService) {
		this.inquisitionInfoService = inquisitionInfoService;
	}	
	public Long getGradeStdID() {
		return gradeStdID;
	}
	public void setGradeStdID(Long gradeStdID) {
		this.gradeStdID = gradeStdID;
	}	
}
