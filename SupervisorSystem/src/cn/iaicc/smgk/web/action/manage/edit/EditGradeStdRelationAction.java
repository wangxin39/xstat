package cn.iaicc.smgk.web.action.manage.edit;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IGradeStdInfoService;
import cn.iaicc.smgk.business.IGradeStdRelationInfoService;
import cn.iaicc.smgk.business.ISelectWeightInfoService;
import cn.iaicc.smgk.po.GradeStdInfo;
import cn.iaicc.smgk.po.GradeStdRelationInfo;
import cn.iaicc.smgk.po.SelectWeightInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditGradeStdRelationAction extends ActionSupport {

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8235247330818815801L;
	private static Log logger = LogFactory.getLog(EditGradeStdRelationAction.class);	

	private IGradeStdInfoService gradeStdInfoService = null;
	private IGradeStdRelationInfoService gradeStdRelationInfoService = null;
	private ISelectWeightInfoService selectWeightInfoService = null;	
	
	private Long gradeStdID = null;
	private Long selectWeightID = null;
		
	private Long stdRelationID = null;
	
	
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			GradeStdRelationInfo info = (GradeStdRelationInfo)ActionContext.getContext().getSession().get("EDITGRADESTDRELATIONINFO");
			if(info == null) {
				this.addActionError("找不到你要编辑的信息！");
				return ERROR;
			}
			if(gradeStdID != null) {
				info.setGradeStdID(gradeStdID);				
			}
			if(selectWeightID != null) {
				info.setSelectWeightID(selectWeightID);				
			}	
			gradeStdRelationInfoService.update(info);
			
			
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
			if(stdRelationID == null) {
				this.addActionError("找不到你要编辑的信息！");
				return ERROR;
			}
			GradeStdRelationInfo info = gradeStdRelationInfoService.getGradeStdRelationInfo(stdRelationID);
			ActionContext.getContext().getSession().put("EDITGRADESTDRELATIONINFO",info);
			
			List<SelectWeightInfo> selectWeightInfoList = (List<SelectWeightInfo>)ActionContext.getContext().getSession().get("GLOBALSELECTWEIGHTINFOLIST");
			if(selectWeightInfoList == null) {
				selectWeightInfoList = selectWeightInfoService.findByPage(0, Integer.MAX_VALUE);		
				ActionContext.getContext().getSession().put("GLOBALSELECTWEIGHTINFOLIST",selectWeightInfoList);
			}			
			
			
			
			List<GradeStdInfo> gradeStdInfoList = (List<GradeStdInfo>)ActionContext.getContext().getSession().get("GLOBALGRADESTDINFOLIST");
			if(gradeStdInfoList == null) {
				gradeStdInfoList = gradeStdInfoService.findByPage(0, Integer.MAX_VALUE);
				ActionContext.getContext().getSession().put("GLOBALGRADESTDINFOLIST",gradeStdInfoList);
			}
			
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}		
		return SUCCESS;
	}

	public Long getGradeStdID() {
		return gradeStdID;
	}

	public void setGradeStdID(Long gradeStdID) {
		this.gradeStdID = gradeStdID;
	}

	public Long getSelectWeightID() {
		return selectWeightID;
	}

	public void setSelectWeightID(Long selectWeightID) {
		this.selectWeightID = selectWeightID;
	}

	public void setGradeStdInfoService(IGradeStdInfoService gradeStdInfoService) {
		this.gradeStdInfoService = gradeStdInfoService;
	}

	public void setGradeStdRelationInfoService(
			IGradeStdRelationInfoService gradeStdRelationInfoService) {
		this.gradeStdRelationInfoService = gradeStdRelationInfoService;
	}

	public void setSelectWeightInfoService(
			ISelectWeightInfoService selectWeightInfoService) {
		this.selectWeightInfoService = selectWeightInfoService;
	}

	public Long getStdRelationID() {
		return stdRelationID;
	}

	public void setStdRelationID(Long stdRelationID) {
		this.stdRelationID = stdRelationID;
	}

}
