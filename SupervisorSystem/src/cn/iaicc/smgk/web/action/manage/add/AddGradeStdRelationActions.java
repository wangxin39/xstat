package cn.iaicc.smgk.web.action.manage.add;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IGradeStdInfoService;
import cn.iaicc.smgk.business.IGradeStdRelationInfoService;
import cn.iaicc.smgk.business.ISelectWeightInfoService;
import cn.iaicc.smgk.po.GradeStdInfo;
import cn.iaicc.smgk.po.GradeStdRelationInfo;
import cn.iaicc.smgk.po.SelectWeightInfo;
import cn.iaicc.smgk.web.conf.StatusConstants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddGradeStdRelationActions extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3092454915764068202L;
	private static Log logger = LogFactory.getLog(AddGradeStdRelationActions.class);
		
	private IGradeStdInfoService gradeStdInfoService = null;
	private IGradeStdRelationInfoService gradeStdRelationInfoService = null;
	private ISelectWeightInfoService selectWeightInfoService = null;
	
	
	private Long gradeStdID = null;
	private Long selectWeightID = null;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			if(gradeStdID == null || selectWeightID == null) {
				this.addActionError("请选择要添加的数据");
				return ERROR;
			}
			String isOK = (String)ActionContext.getContext().getSession().get("ADDGRADESTDRELAATIONISOK");
			if(isOK != null && "OK".equals(""+isOK)) {
				GradeStdRelationInfo info = new GradeStdRelationInfo();
				info.setGradeStdID(gradeStdID);
				info.setSelectWeightID(selectWeightID);
				info.setStatus(StatusConstants.ZHENGCHANG);
			
				gradeStdRelationInfoService.save(info);
				ActionContext.getContext().getSession().put("ADDGRADESTDRELAATIONISOK","NOT");
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
			
			ActionContext.getContext().getSession().put("ADDGRADESTDRELAATIONISOK","OK");
			
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
}
