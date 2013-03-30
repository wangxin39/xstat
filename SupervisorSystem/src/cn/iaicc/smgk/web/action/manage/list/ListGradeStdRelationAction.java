package cn.iaicc.smgk.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IGradeStdInfoService;
import cn.iaicc.smgk.business.IGradeStdRelationInfoService;
import cn.iaicc.smgk.business.ISelectWeightInfoService;
import cn.iaicc.smgk.po.GradeStdInfo;
import cn.iaicc.smgk.po.GradeStdRelationInfo;
import cn.iaicc.smgk.po.SelectWeightInfo;
import cn.iaicc.smgk.web.conf.SmgkConstants;
import cn.iaicc.smgk.web.util.PaginationUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListGradeStdRelationAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6097185563352079379L;
	private static Log logger = LogFactory.getLog(ListGradeStdRelationAction.class);
	
	private IGradeStdInfoService gradeStdInfoService = null;
	private IGradeStdRelationInfoService gradeStdRelationInfoService = null;	
	private ISelectWeightInfoService selectWeightInfoService = null;
	
	private Long gradeStdID = null;
	
	private Integer num = null;
	
	private List<GradeStdRelationInfo> pageList = null;	
	private Map<String,String> pageNumList = null;
	private PaginationUtil pu = null;
	private List<String> gradeStdList = null;
	private List<String> selectWeightList = null;
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			List<GradeStdInfo> gradeStdInfoList = (List<GradeStdInfo>)ActionContext.getContext().get("GLOBALGRADESTDINFOLIST");
			if(gradeStdInfoList == null) {
				gradeStdInfoList = gradeStdInfoService.findByPage(0, Integer.MAX_VALUE);
			}
			
			int page = 1;
			if(num != null) {
				page = num.intValue();
			}
			
			int total = gradeStdRelationInfoService.getTotal();
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			pageList = gradeStdRelationInfoService.findByPage(pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);				
			
			gradeStdList = new LinkedList<String>();
			selectWeightList = new LinkedList<String>();
			
			SelectWeightInfo swi = null;
			GradeStdInfo gti = null;
			
			for(GradeStdRelationInfo info:pageList) {
				if(info.getSelectWeightID() != null) {
					swi = selectWeightInfoService.getSelectWeightInfo(info.getSelectWeightID());
				}				
				if(info.getGradeStdID() != null) {
					gti = gradeStdInfoService.getGradeStdInfo(info.getGradeStdID());					
				}
				
				if(swi != null) {
					selectWeightList.add(""+swi.getWeight());
				}else{
					selectWeightList.add("");
				}
				
				if(gti != null) {
					gradeStdList.add(""+gti.getTitle());
				}else{
					gradeStdList.add("");
				}
				
				
			}
			
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}

	public void setGradeStdInfoService(IGradeStdInfoService gradeStdInfoService) {
		this.gradeStdInfoService = gradeStdInfoService;
	}

	public Long getGradeStdID() {
		return gradeStdID;
	}

	public void setGradeStdID(Long gradeStdID) {
		this.gradeStdID = gradeStdID;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public List<GradeStdRelationInfo> getPageList() {
		return pageList;
	}

	public Map<String, String> getPageNumList() {
		return pageNumList;
	}

	public PaginationUtil getPu() {
		return pu;
	}

	public void setGradeStdRelationInfoService(
			IGradeStdRelationInfoService gradeStdRelationInfoService) {
		this.gradeStdRelationInfoService = gradeStdRelationInfoService;
	}

	public List<String> getGradeStdList() {
		return gradeStdList;
	}

	public List<String> getSelectWeightList() {
		return selectWeightList;
	}

	public void setSelectWeightInfoService(
			ISelectWeightInfoService selectWeightInfoService) {
		this.selectWeightInfoService = selectWeightInfoService;
	}

}
