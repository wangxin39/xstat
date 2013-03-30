package cn.iaicc.smgk.web.action.manage.add;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IEmployeeInfoService;
import cn.iaicc.smgk.business.IReportTemplateInfoService;
import cn.iaicc.smgk.business.IThemeInfoService;
import cn.iaicc.smgk.business.IThemeStyleInfoService;
import cn.iaicc.smgk.po.EmployeeInfo;
import cn.iaicc.smgk.po.ReportTemplateInfo;
import cn.iaicc.smgk.po.ThemeInfo;
import cn.iaicc.smgk.po.ThemeStyleInfo;
import cn.iaicc.smgk.web.conf.QuestionTypeConstants;
import cn.iaicc.smgk.web.conf.StatusConstants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddThemeStyleActions extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7127570233615470183L;
	private static Log logger = LogFactory.getLog(AddThemeStyleActions.class);
	private IThemeStyleInfoService themeStyleInfoService = null;
	private IThemeInfoService themeInfoService = null;
	private IReportTemplateInfoService reportTemplateInfoService = null;



	private String statChart = null;
	private String imageName = null;
  	private String content = null;
	private String savePath = null;
  	private String title = null;
  	private Integer statType = null;
  	private Integer isBackImage = null;
  	private Long reportTemplateID = null;
  	private Long themeID = null;
  	private Integer pageNum = null;

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {	
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			String isOK = (String)ActionContext.getContext().getSession().get("CLIENTINPUTADDISOK");
			if(isOK != null && "OK".equals(isOK)) {
				if(themeID == null){
					ActionContext.getContext().put("nullError","主题名称不能为空，请先添加主题信息!");
					return INPUT;
				}
				if(reportTemplateID == null){
					ActionContext.getContext().put("nullError","模板名称不能为空，请先添加主题模板信息!");
					return INPUT;
				}
				
				ThemeStyleInfo info = new ThemeStyleInfo() ;
				info.setContent(content);
				info.setTitle(title);
				info.setImageName(imageName);
				info.setIsBackImage(isBackImage);
				info.setPageNum(pageNum);
				info.setReportTemplateID(reportTemplateID);
				info.setSavePath(savePath);
				info.setStatChart(statChart);
				info.setStatType(statType);
				info.setThemeID(themeID);
				info.setStatus(StatusConstants.ZHENGCHANG);
				
				themeStyleInfoService.saveThemeStyleInfo(info);
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
			List<ThemeInfo> tList = themeInfoService.getThemeInfoList();
			ActionContext.getContext().getSession().put("THEMELIST",tList);
			List<ReportTemplateInfo> rtiList = reportTemplateInfoService.getReportTemplateInfoList(); 
			ActionContext.getContext().getSession().put("TEMPLATE",rtiList);
			ActionContext.getContext().getSession().put("STATTYPE",QuestionTypeConstants.StatDict);
			ActionContext.getContext().getSession().put("BACK",QuestionTypeConstants.BackDict);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}		

		return SUCCESS;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getStatChart() {
		return statChart;
	}


	public void setStatChart(String statChart) {
		this.statChart = statChart;
	}


	public String getImageName() {
		return imageName;
	}


	public void setImageName(String imageName) {
		this.imageName = imageName;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getSavePath() {
		return savePath;
	}


	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}


	public Integer getStatType() {
		return statType;
	}


	public void setStatType(Integer statType) {
		this.statType = statType;
	}


	public Integer getIsBackImage() {
		return isBackImage;
	}


	public void setIsBackImage(Integer isBackImage) {
		this.isBackImage = isBackImage;
	}


	public Long getReportTemplateID() {
		return reportTemplateID;
	}


	public void setReportTemplateID(Long reportTemplateID) {
		this.reportTemplateID = reportTemplateID;
	}


	public Long getThemeID() {
		return themeID;
	}


	public void setThemeID(Long themeID) {
		this.themeID = themeID;
	}


	public Integer getPageNum() {
		return pageNum;
	}


	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}


	public void setThemeStyleInfoService(
			IThemeStyleInfoService themeStyleInfoService) {
		this.themeStyleInfoService = themeStyleInfoService;
	}
	public void setThemeInfoService(IThemeInfoService themeInfoService) {
		this.themeInfoService = themeInfoService;
	}
	public void setReportTemplateInfoService(
			IReportTemplateInfoService reportTemplateInfoService) {
		this.reportTemplateInfoService = reportTemplateInfoService;
	}
	
}
