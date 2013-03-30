package cn.iaicc.smgk.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IAddressCatalogInfoService;
import cn.iaicc.smgk.business.IArticleInfoService;
import cn.iaicc.smgk.business.ICheckDetailInfoService;
import cn.iaicc.smgk.business.ICityInfoService;
import cn.iaicc.smgk.business.IClientAccountInfoService;
import cn.iaicc.smgk.business.IClientInfoService;
import cn.iaicc.smgk.business.IEmailAddressInfoService;
import cn.iaicc.smgk.business.IEmailDraftInfoService;
import cn.iaicc.smgk.business.IEmailSendInfoService;
import cn.iaicc.smgk.business.IEmployeeInfoService;
import cn.iaicc.smgk.business.IInformantInfoService;
import cn.iaicc.smgk.business.IInquisitionHeaderInfoService;
import cn.iaicc.smgk.business.IInquisitionHeaderSelectInfoService;
import cn.iaicc.smgk.business.IInquisitionInfoService;
import cn.iaicc.smgk.business.IInquisitionTemplateInfoService;
import cn.iaicc.smgk.business.IIssueInfoService;
import cn.iaicc.smgk.business.IMenuInfoService;
import cn.iaicc.smgk.business.IOptionInfoService;
import cn.iaicc.smgk.business.IOptionRelationInfoService;
import cn.iaicc.smgk.business.IOptionTemplateInfoService;
import cn.iaicc.smgk.business.IPartInfoService;
import cn.iaicc.smgk.business.IPartQuestionInfoService;
import cn.iaicc.smgk.business.IPartSelectInfoService;
import cn.iaicc.smgk.business.IPlanInfoService;
import cn.iaicc.smgk.business.IProjectInfoService;
import cn.iaicc.smgk.business.IPublishInfoService;
import cn.iaicc.smgk.business.IQuestionInfoService;
import cn.iaicc.smgk.business.IRealityCheckInfoService;
import cn.iaicc.smgk.business.IRemarkInfoService;
import cn.iaicc.smgk.business.IReportInfoService;
import cn.iaicc.smgk.business.IReportTemplateInfoService;
import cn.iaicc.smgk.business.IResourceInfoService;
import cn.iaicc.smgk.business.ISelectWeightInfoService;
import cn.iaicc.smgk.business.ISmgkInfoService;
import cn.iaicc.smgk.business.IThemeInfoService;
import cn.iaicc.smgk.business.IThemeStyleInfoService;
import cn.iaicc.smgk.business.IVideoInfoService;
import cn.iaicc.smgk.po.AddressCatalogInfo;
import cn.iaicc.smgk.po.ArticleInfo;
import cn.iaicc.smgk.po.CheckDetailInfo;
import cn.iaicc.smgk.po.CityInfo;
import cn.iaicc.smgk.po.ClientAccountInfo;
import cn.iaicc.smgk.po.ClientInfo;
import cn.iaicc.smgk.po.EmailAddressInfo;
import cn.iaicc.smgk.po.EmailDraftInfo;
import cn.iaicc.smgk.po.EmailSendInfo;
import cn.iaicc.smgk.po.EmployeeInfo;
import cn.iaicc.smgk.po.InformantInfo;
import cn.iaicc.smgk.po.InquisitionHeaderInfo;
import cn.iaicc.smgk.po.InquisitionInfo;
import cn.iaicc.smgk.po.InquisitionTemplateInfo;
import cn.iaicc.smgk.po.IssueInfo;
import cn.iaicc.smgk.po.MenuInfo;
import cn.iaicc.smgk.po.PartInfo;
import cn.iaicc.smgk.po.PartSelectInfo;
import cn.iaicc.smgk.po.PlanInfo;
import cn.iaicc.smgk.po.ProjectInfo;
import cn.iaicc.smgk.po.PublishInfo;
import cn.iaicc.smgk.po.QuestionInfo;
import cn.iaicc.smgk.po.RealityCheckInfo;
import cn.iaicc.smgk.po.RemarkInfo;
import cn.iaicc.smgk.po.ReportInfo;
import cn.iaicc.smgk.po.ReportTemplateInfo;
import cn.iaicc.smgk.po.ResourceInfo;
import cn.iaicc.smgk.po.SelectWeightInfo;
import cn.iaicc.smgk.po.SmgkInfo;
import cn.iaicc.smgk.po.ThemeInfo;
import cn.iaicc.smgk.po.ThemeStyleInfo;
import cn.iaicc.smgk.po.VideoInfo;
import cn.iaicc.smgk.web.bo.RecycledInfo;
import cn.iaicc.smgk.web.conf.DelStatusConstants;
import cn.iaicc.smgk.web.conf.SmgkConstants;
import cn.iaicc.smgk.web.conf.StatusConstants;
import cn.iaicc.smgk.web.util.PaginationUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListRecycledAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5248039003761278571L;
	private static Log logger = LogFactory.getLog(ListRecycledAction.class);
	private IRealityCheckInfoService realityCheckInfoService = null;
	private IInquisitionInfoService inquisitionInfoService = null;
	private IIssueInfoService issueInfoService = null;
	private IInformantInfoService informantInfoService = null;
	private IInquisitionHeaderInfoService inquisitionHeaderInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;	
	private IMenuInfoService menuInfoService = null;
	private IClientAccountInfoService clientAccountInfoService = null;
	private IClientInfoService clientInfoService = null;
	private IAddressCatalogInfoService addressCatalogInfoService = null;   
	private IArticleInfoService articleInfoService = null;   
	private ICityInfoService cityInfoService = null;   
	private IEmailAddressInfoService emailAddressInfoService = null;   
	private IEmailDraftInfoService emailDraftInfoService = null;   
	private IEmailSendInfoService emailSendInfoService = null;   
	private IInquisitionHeaderSelectInfoService inquisitionHeaderSelectInfoService = null;   
	private IInquisitionTemplateInfoService inquisitionTemplateInfoService = null;   
	private IPartInfoService partInfoService = null; 
	private IPartQuestionInfoService partQuestionInfoService = null; 
	private IPartSelectInfoService partSelectInfoService = null; 
	private IPlanInfoService planInfoService = null; 
	private IProjectInfoService projectInfoService = null; 
	private IPublishInfoService publishInfoService = null; 
	private IQuestionInfoService questionInfoService = null; 
	private IOptionInfoService optionInfoService = null;
	private IOptionTemplateInfoService optionTemplateInfoService = null;
	private IOptionRelationInfoService optionRelationInfoService = null;
	private IResourceInfoService resourceInfoService = null;
	private IRemarkInfoService remarkInfoService = null; 
	private IReportInfoService reportInfoService = null; 
	private IReportTemplateInfoService reportTemplateInfoService = null; 
	private ISelectWeightInfoService selectWeightInfoService = null; 
	private ISmgkInfoService smgkInfoService = null; 
	private IThemeInfoService  themeInfoService = null; 
	private IThemeStyleInfoService  themeStyleInfoService = null; 
	private IVideoInfoService videoInfoService = null; 
	private ICheckDetailInfoService checkDetailInfoService = null;
	
	private List<String> statusList = new LinkedList<String>();
	private Long id = null;
	private Integer type = null;
	
	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<RecycledInfo> pageList = null;	
	private Integer total = null;
	private PaginationUtil pu = null;
	
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			int page = 1;
			if(num != null) {
				page = num.intValue();
			}
			
			type = DelStatusConstants.CLIENT;
			if(id != null) {
				type = id.intValue();
			}

			ActionContext.getContext().put("DELTYPE",type);//初始信息
			statusList.add(""+DelStatusConstants.DelStatusDict);
			ActionContext.getContext().put("DELLIST",DelStatusConstants.DelStatusDict);//列表信息
			
			
			RecycledInfo recycledInfo = new RecycledInfo();
			pageList = new LinkedList<RecycledInfo>();
			switch(type) {
				case DelStatusConstants.CLIENT:
					// 从客户信息表中取得删除状态的分页数据
					total = clientInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<ClientInfo> ciList = clientInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(ClientInfo ci:ciList) {
						recycledInfo.setName(ci.getCompany());
						recycledInfo.setId(ci.getClientID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					
					break;
				case DelStatusConstants.CLIENTACCOUNT:
					// 从客户信息表中取得删除状态的分页数据
					total = clientAccountInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<ClientAccountInfo> aciList = clientAccountInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(ClientAccountInfo cai:aciList){
						recycledInfo.setName(cai.getClientName());
						recycledInfo.setId(cai.getAccountID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					
					break;
				case DelStatusConstants.PROJECT:
					// 从客户信息表中取得删除状态的分页数据
					total = projectInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<ProjectInfo> piList = projectInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(ProjectInfo pi:piList){
						recycledInfo.setName(pi.getName());
						recycledInfo.setId(pi.getProjectID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					break;
				case DelStatusConstants.ISSUE:
					// 从客户信息表中取得删除状态的分页数据
					total = issueInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<IssueInfo> issueList = issueInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(IssueInfo issueInfo:issueList){
						recycledInfo.setName(issueInfo.getIssue());
						recycledInfo.setId(issueInfo.getIssueID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					break;
				case DelStatusConstants.INFORMANT:
					// 从客户信息表中取得删除状态的分页数据
					total = informantInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<InformantInfo> inforList = informantInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(InformantInfo infor:inforList){
						recycledInfo.setName(infor.getName());
						recycledInfo.setId(infor.getInformantID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					break;
				case DelStatusConstants.SMGK:
					// 从客户信息表中取得删除状态的分页数据
					total = smgkInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<SmgkInfo> siList = smgkInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(SmgkInfo si:siList){
						recycledInfo.setName(si.getUserName());
						recycledInfo.setId(si.getSmgkID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					break;
					
				case DelStatusConstants.ARTICLE:
					// 从客户信息表中取得删除状态的分页数据
					total = articleInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<ArticleInfo> aiList = articleInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(ArticleInfo ai:aiList){
						recycledInfo.setName(ai.getTitle());
						recycledInfo.setId(ai.getArticleID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					break;
					
				case DelStatusConstants.PUBLISH:
					// 从客户信息表中取得删除状态的分页数据
					total = publishInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<PublishInfo> publishList = publishInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(PublishInfo publishInfo:publishList){
						recycledInfo.setName(publishInfo.getType().toString());
						recycledInfo.setId(publishInfo.getPublishID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					break;
					
				case DelStatusConstants.TEMPLATEREPORT:
					// 从客户信息表中取得删除状态的分页数据
					total = reportTemplateInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<ReportTemplateInfo> rtiList = reportTemplateInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(ReportTemplateInfo rti:rtiList){
						recycledInfo.setName(rti.getName());
						recycledInfo.setId(rti.getReportTemplateID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					break;
				case DelStatusConstants.PLAN:
					// 从客户信息表中取得删除状态的分页数据
					total = planInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<PlanInfo> planList = planInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(PlanInfo planInfo:planList){
						recycledInfo.setName(planInfo.getName());
						recycledInfo.setId(planInfo.getPlanID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					break;
				case DelStatusConstants.MAKEEXAM:
					// 从客户信息表中取得删除状态的分页数据
					total = inquisitionInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<InquisitionInfo> iiList = inquisitionInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(InquisitionInfo ii:iiList){
						recycledInfo.setName(ii.getTitle());
						recycledInfo.setId(ii.getInquisitionID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					break;
				case DelStatusConstants.HEADER:
					// 从客户信息表中取得删除状态的分页数据
					total = inquisitionHeaderInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<InquisitionHeaderInfo> ihiList = inquisitionHeaderInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(InquisitionHeaderInfo ihi:ihiList){
						recycledInfo.setName(ihi.getFieldName());
						recycledInfo.setId(ihi.getHeaderID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					break;
				case DelStatusConstants.MAKEPART:
					// 从客户信息表中取得删除状态的分页数据
					total = partInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<PartInfo> partList= partInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(PartInfo pi:partList){
						recycledInfo.setName(pi.getName());
						recycledInfo.setId(pi.getPartID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					break;

					
				case DelStatusConstants.WEIGHT:
					// 从客户信息表中取得删除状态的分页数据
					total = selectWeightInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<SelectWeightInfo> swiList = selectWeightInfoService.findByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(SelectWeightInfo swi:swiList){
						recycledInfo.setName(swi.getWeight().toString());
						recycledInfo.setId(swi.getSelectWeightID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					break;
				case DelStatusConstants.CRITIQUE:
					// 从客户信息表中取得删除状态的分页数据
					total = remarkInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<RemarkInfo> riList = remarkInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(RemarkInfo ri:riList){
						recycledInfo.setName(ri.getStrengths());
						recycledInfo.setId(ri.getRemarkID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					break;
				case DelStatusConstants.QUESTION:
					// 从客户信息表中取得删除状态的分页数据
					total = questionInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<QuestionInfo> qiList = questionInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(QuestionInfo qi:qiList){
						recycledInfo.setName(qi.getQuestion());
						recycledInfo.setId(qi.getQuestionID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					break;
				case DelStatusConstants.SELECTMANAGE:
					// 从客户信息表中取得删除状态的分页数据
					total = partSelectInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<PartSelectInfo> psiList = partSelectInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(PartSelectInfo psi:psiList){
						recycledInfo.setName(psi.getComment());
						recycledInfo.setId(psi.getPartSelectID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					break;
				case DelStatusConstants.RESOURCE:
					// 从客户信息表中取得删除状态的分页数据
					total = resourceInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<ResourceInfo> qriList = resourceInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(ResourceInfo qri:qriList){
						recycledInfo.setName(qri.getFileName());
						recycledInfo.setId(qri.getResourceID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					break;
				case DelStatusConstants.JASPERREPORT:
					// 从客户信息表中取得删除状态的分页数据
					total = inquisitionTemplateInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<InquisitionTemplateInfo> itiList = inquisitionTemplateInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(InquisitionTemplateInfo iti:itiList){
						recycledInfo.setName(iti.getName());
						recycledInfo.setId(iti.getTemplateID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					break;				
				case DelStatusConstants.REPORT:
					// 从客户信息表中取得删除状态的分页数据
					total = reportInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<ReportInfo> reportList = reportInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(ReportInfo ri:reportList){
						recycledInfo.setName(ri.getCheckName());
						recycledInfo.setId(ri.getReportID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					break;
					
				case DelStatusConstants.SEND:
					// 从客户信息表中取得删除状态的分页数据
					total = emailSendInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<EmailSendInfo> esiList = emailSendInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(EmailSendInfo esi:esiList){
						recycledInfo.setName(esi.getTopic());
						recycledInfo.setId(esi.getSendID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					
					break;
				case DelStatusConstants.DRAFT:
					// 从客户信息表中取得删除状态的分页数据
					total = emailDraftInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<EmailDraftInfo> ediList = emailDraftInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(EmailDraftInfo edi:ediList){
						recycledInfo.setName(edi.getTopic());
						recycledInfo.setId(edi.getDraftID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					break;
				case DelStatusConstants.CATALOG:
					// 从客户信息表中取得删除状态的分页数据
					total = addressCatalogInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<AddressCatalogInfo> catalogList = addressCatalogInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(AddressCatalogInfo aci:catalogList){
						recycledInfo.setName(aci.getName());
						recycledInfo.setId(aci.getAcID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					break;
				case DelStatusConstants.ADDRESS:
					// 从客户信息表中取得删除状态的分页数据
					total = emailAddressInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<EmailAddressInfo> eaiList = emailAddressInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(EmailAddressInfo eai:eaiList){
						recycledInfo.setName(eai.getName());
						recycledInfo.setId(eai.getAddressID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					break;
				case DelStatusConstants.EMPLOYEE:
					// 从客户信息表中取得删除状态的分页数据
					total = employeeInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<EmployeeInfo> eiList = employeeInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(EmployeeInfo ei:eiList){
						recycledInfo.setName(ei.getName());
						recycledInfo.setId(ei.getEmployeeID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					break;
					
				case DelStatusConstants.CITY:
					// 从客户信息表中取得删除状态的分页数据
					total = cityInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<CityInfo> cityList = cityInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(CityInfo ci:cityList){
						recycledInfo.setName(ci.getName());
						recycledInfo.setId(ci.getCityID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					break;
					
				case DelStatusConstants.MENU:
					// 从客户信息表中取得删除状态的分页数据
					total = menuInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<MenuInfo> miList = menuInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(MenuInfo mi:miList){
						recycledInfo.setName(mi.getMenu());
						recycledInfo.setId(mi.getMenuID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					break;
				case DelStatusConstants.VIDEO:
					// 从客户信息表中取得删除状态的分页数据
					total = videoInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<VideoInfo> viList = videoInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(VideoInfo vi:viList){
						recycledInfo.setName(vi.getName());
						recycledInfo.setId(vi.getVideoID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					break;
				case DelStatusConstants.CHECK:
					// 从客户信息表中取得删除状态的分页数据
					total = checkDetailInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<CheckDetailInfo> cdiList = checkDetailInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(CheckDetailInfo cdi:cdiList){
						recycledInfo.setName(cdi.getWhat());
						recycledInfo.setId(cdi.getCheckDetailID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					break;
				case DelStatusConstants.THEME:
					// 从客户信息表中取得删除状态的分页数据
					total = themeInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<ThemeInfo> tiList = themeInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(ThemeInfo ti:tiList){
						recycledInfo.setName(ti.getTitle());
						recycledInfo.setId(ti.getThemeID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					break;
				case DelStatusConstants.STYLE:
					// 从客户信息表中取得删除状态的分页数据
					total = themeStyleInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<ThemeStyleInfo> tsiList = themeStyleInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(ThemeStyleInfo tsi:tsiList){
						recycledInfo.setName(tsi.getTitle());
						recycledInfo.setId(tsi.getStyleID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					break;
				case DelStatusConstants.REALITY:
					// 从客户信息表中取得删除状态的分页数据
					total = realityCheckInfoService.getTotalByDelStatus();
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
					List<RealityCheckInfo> rciList = realityCheckInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					for(RealityCheckInfo rci:rciList){
						recycledInfo.setName(rci.getThisTime());
						recycledInfo.setId(rci.getRealityCheckID());
						recycledInfo.setType(type);
						pageList.add(recycledInfo);
					}
					break;
					
//					case DelStatusConstants.GRADE:
//						// 从客户信息表中取得删除状态的分页数据
//						total = statQuestionInfoService.getTotalByDelStatus();
//						pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
//						List<StatQuestionInfo> spiList = statQuestionInfoService.findPageByDelStatus(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
//						for(StatQuestionInfo spi:spiList){
//							recycledInfo.setName(spi.getMarks());
//							recycledInfo.setId(spi.getPartQuestionID());
//							recycledInfo.setType(type);
//							pageList.add(recycledInfo);
//						}
//						break;
			}
			

		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}


		return SUCCESS;
	}

	public String recover()throws Exception{
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		try{
			if(username == null || password == null) {
				return LOGIN;
			}
			if(id == null && type ==null){
				  this.addActionError("id或type为空！");
				  return ERROR;
				}
			
				switch(type) {
					case DelStatusConstants.CLIENT:
						ClientInfo ci = clientInfoService.getClientInfo(id);
						if(ci != null) {
							ci.setStatus(StatusConstants.ZHENGCHANG);
							clientInfoService.updateClientInfo(ci);						
						}
						break;
					case DelStatusConstants.CLIENTACCOUNT:
						ClientAccountInfo aci = clientAccountInfoService.getClientAccountInfo(id);
						if(aci != null) {
							aci.setStatus(StatusConstants.ZHENGCHANG);
							clientAccountInfoService.updateClientAccountInfo(aci);							
						}
						break;
					case DelStatusConstants.PROJECT:
						ProjectInfo pi = projectInfoService.getProjectInfo(id);
						if(pi != null) {
							pi.setStatus(StatusConstants.ZHENGCHANG);
							projectInfoService.updateProjectInfo(pi);						
						}
						break;
					case DelStatusConstants.ISSUE:
						IssueInfo issueInfo = issueInfoService.getIssueInfo(id);
						if(issueInfo != null) {
							issueInfo.setStatus(StatusConstants.ZHENGCHANG);
							issueInfoService.updateIssueInfo(issueInfo);							
						}
						break;
					case DelStatusConstants.INFORMANT:
						InformantInfo informantInfo = informantInfoService.getInformantInfo(id);
						if(informantInfo != null) {
							informantInfo.setStatus(StatusConstants.ZHENGCHANG);
							informantInfoService.updateInformantInfo(informantInfo);							
						}
						break;
					case DelStatusConstants.SMGK:
						SmgkInfo smgkInfo = smgkInfoService.getSmgkInfo(id);
						if(smgkInfo != null) {
							smgkInfo.setStatus(StatusConstants.ZHENGCHANG);
							smgkInfoService.updateSmgkInfo(smgkInfo);							
						}
						break;						
					case DelStatusConstants.ARTICLE:
						ArticleInfo articleInfo = articleInfoService.getArticleInfo(id);
						if(articleInfo != null) {
							articleInfo.setStatus(StatusConstants.ZHENGCHANG);
							articleInfoService.updateArticleInfo(articleInfo);							
						}
						break;						
					case DelStatusConstants.PUBLISH:
						PublishInfo publishInfo = publishInfoService.getPublishInfo(id);
						if(publishInfo != null) {
							publishInfo.setStatus(StatusConstants.ZHENGCHANG);
							publishInfoService.updatePublishInfo(publishInfo);							
						}
						break;						
					case DelStatusConstants.TEMPLATEREPORT:						
						ReportTemplateInfo reportTemplateInfo = reportTemplateInfoService.getReportTemplateInfo(id);
						if(reportTemplateInfo != null) {
							reportTemplateInfo.setStatus(StatusConstants.ZHENGCHANG);
							reportTemplateInfoService.updateReportTemplateInfo(reportTemplateInfo);							
						}
						break;
					case DelStatusConstants.PLAN:
						PlanInfo planInfo = planInfoService.getPlanInfo(id);
						if(planInfo != null) {
							planInfo.setStatus(StatusConstants.ZHENGCHANG);
							planInfoService.updatePlanInfo(planInfo);							
						}
						break;
					case DelStatusConstants.MAKEEXAM:
						InquisitionInfo inquisitionInfo = inquisitionInfoService.getInquisitionInfo(id);
						if(inquisitionInfo != null) {
							inquisitionInfo.setStatus(StatusConstants.ZHENGCHANG);
							inquisitionInfoService.updateInquisitionInfo(inquisitionInfo);							
						}
						break;
					case DelStatusConstants.HEADER:
						InquisitionHeaderInfo inquisitionHeaderInfo = inquisitionHeaderInfoService.getInquisitionHeaderInfo(id);
						if(inquisitionHeaderInfo != null) {
							inquisitionHeaderInfo.setStatus(StatusConstants.ZHENGCHANG);
							inquisitionHeaderInfoService.updateInquisitionHeaderInfo(inquisitionHeaderInfo);							
						}
						break;
					case DelStatusConstants.MAKEPART:
						PartInfo partInfo = partInfoService.getPartInfo(id);
						if(partInfo != null) {
							partInfo.setStatus(StatusConstants.ZHENGCHANG);
							partInfoService.updatePartInfo(partInfo);							
						}
						break;						
					case DelStatusConstants.WEIGHT:
						SelectWeightInfo selectWeightInfo = selectWeightInfoService.getSelectWeightInfo(id);
						if(selectWeightInfo != null) {
							selectWeightInfo.setStatus(StatusConstants.ZHENGCHANG);
							selectWeightInfoService.update(selectWeightInfo);							
						}
						break;
					case DelStatusConstants.CRITIQUE:
						RemarkInfo remarkInfo = remarkInfoService.getRemarkInfo(id);
						if(remarkInfo != null) {
							remarkInfo.setStatus(StatusConstants.ZHENGCHANG);
							remarkInfoService.updateRemarkInfo(remarkInfo);							
						}
						break;
					case DelStatusConstants.QUESTION:
						QuestionInfo questionInfo = questionInfoService.getQuestionInfo(id);
						if(questionInfo != null) {
							questionInfo.setStatus(StatusConstants.ZHENGCHANG);
							questionInfoService.update(questionInfo);							
						}
						break;
					case DelStatusConstants.SELECTMANAGE:
						PartSelectInfo partSelectInfo = partSelectInfoService.getPartSelectInfo(id);
						if(partSelectInfo != null) {
							partSelectInfo.setStatus(StatusConstants.ZHENGCHANG);
							partSelectInfoService.updatePartSelectInfo(partSelectInfo);							
						}
						break;
					case DelStatusConstants.RESOURCE:
						ResourceInfo resourceInfo = resourceInfoService.getResourceInfo(id);
						if(resourceInfo != null) {
							resourceInfo.setStatus(StatusConstants.ZHENGCHANG);
							resourceInfoService.update(resourceInfo);							
						}
						break;
					case DelStatusConstants.JASPERREPORT:
						InquisitionTemplateInfo inquisitionTemplateInfo = inquisitionTemplateInfoService.getInquisitionTemplateInfo(id);
						if(inquisitionTemplateInfo != null) {
							inquisitionTemplateInfo.setStatus(StatusConstants.ZHENGCHANG);
							inquisitionTemplateInfoService.updateInquisitionTemplateInfo(inquisitionTemplateInfo);							
						}
						break;				
					case DelStatusConstants.REPORT:
						ReportInfo reportInfo = reportInfoService.getReportInfo(id);
						if(reportInfo != null) {
							reportInfo.setStatus(StatusConstants.ZHENGCHANG);
							reportInfoService.updateReportInfo(reportInfo);							
						}
						break;						
					case DelStatusConstants.SEND:
						EmailSendInfo emailSendInfo = emailSendInfoService.getEmailSendInfo(id);
						if(emailSendInfo != null) {
							emailSendInfo.setStatus(StatusConstants.ZHENGCHANG);
							emailSendInfoService.updateEmailSendInfo(emailSendInfo);							
						}
						break;
					case DelStatusConstants.DRAFT:
						EmailDraftInfo emailDraftInfo = emailDraftInfoService.getEmailDraftInfo(id);
						if(emailDraftInfo != null) {
							emailDraftInfo.setStatus(StatusConstants.ZHENGCHANG);
							emailDraftInfoService.updateEmailDraftInfo(emailDraftInfo);							
						}
						break;
					case DelStatusConstants.CATALOG:
						AddressCatalogInfo addressCatalogInfo = addressCatalogInfoService.getAddressCatalogInfo(id);
						if(addressCatalogInfo != null) {
							addressCatalogInfo.setStatus(StatusConstants.ZHENGCHANG);
							addressCatalogInfoService.updateAddressCatalogInfo(addressCatalogInfo);							
						}
						break;
					case DelStatusConstants.ADDRESS:
						EmailAddressInfo emailAddressInfo = emailAddressInfoService.getEmailAddressInfo(id);
						if(emailAddressInfo != null) {
							emailAddressInfo.setStatus(StatusConstants.ZHENGCHANG);
							emailAddressInfoService.updateEmailAddressInfo(emailAddressInfo);							
						}
						break;
					case DelStatusConstants.EMPLOYEE:
						EmployeeInfo employeeInfo = employeeInfoService.getEmployeeInfo(id);
						if(employeeInfo != null) {
							employeeInfo.setStatus(StatusConstants.ZHENGCHANG);
							employeeInfoService.updateEmployeeInfo(employeeInfo);							
						}
						break;						
					case DelStatusConstants.CITY:
						CityInfo cityInfo = cityInfoService.getCityInfo(id);
						if(cityInfo != null) {
							cityInfo.setStatus(StatusConstants.ZHENGCHANG);
							cityInfoService.updateCityInfo(cityInfo);							
						}
						break;						
					case DelStatusConstants.MENU:
						MenuInfo mInfo = menuInfoService.getMenuInfo(id);
						if(mInfo != null) {
							mInfo.setStatus(StatusConstants.ZHENGCHANG);
							menuInfoService.updateMenuInfo(mInfo);							
						}
						break;
					case DelStatusConstants.VIDEO:
						VideoInfo vInfo = videoInfoService.getVideoInfo(id);
						if(vInfo != null) {
							vInfo.setStatus(StatusConstants.ZHENGCHANG);
							videoInfoService.updateVideoInfo(vInfo);							
						}
						break;
					case DelStatusConstants.CHECK:
						CheckDetailInfo cdInfo = checkDetailInfoService.getCheckDetailInfo(id);
						if(cdInfo != null) {
							cdInfo.setStatus(StatusConstants.ZHENGCHANG);
							checkDetailInfoService.updateCheckDetailInfo(cdInfo);							
						}
						break;
					case DelStatusConstants.THEME:
						ThemeInfo tInfo = themeInfoService.getThemeInfo(id);
						if(tInfo != null) {
							tInfo.setStatus(StatusConstants.ZHENGCHANG);
							themeInfoService.updateThemeInfo(tInfo);							
						}
						break;
					case DelStatusConstants.STYLE:
						ThemeStyleInfo tsInfo = themeStyleInfoService.getThemeStyleInfo(id);
						if(tsInfo != null) {
							tsInfo.setStatus(StatusConstants.ZHENGCHANG);
							themeStyleInfoService.updateThemeStyleInfo(tsInfo);							
						}
						break;
					case DelStatusConstants.REALITY:
						RealityCheckInfo rci = realityCheckInfoService.getRealityCheckInfo(id);
						if(rci != null) {
							rci.setStatus(StatusConstants.ZHENGCHANG);
							realityCheckInfoService.updateRealityCheckInfo(rci);							
						}
						break;
				}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}

	public List<String> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public List<RecycledInfo> getPageList() {
		return pageList;
	}

	public void setPageList(List<RecycledInfo> pageList) {
		this.pageList = pageList;
	}
	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public PaginationUtil getPu() {
		return pu;
	}

	public void setRealityCheckInfoService(
			IRealityCheckInfoService realityCheckInfoService) {
		this.realityCheckInfoService = realityCheckInfoService;
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

	public void setInquisitionHeaderInfoService(
			IInquisitionHeaderInfoService inquisitionHeaderInfoService) {
		this.inquisitionHeaderInfoService = inquisitionHeaderInfoService;
	}

	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

	public void setMenuInfoService(IMenuInfoService menuInfoService) {
		this.menuInfoService = menuInfoService;
	}

	public void setClientAccountInfoService(
			IClientAccountInfoService clientAccountInfoService) {
		this.clientAccountInfoService = clientAccountInfoService;
	}

	public void setClientInfoService(IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}

	public void setAddressCatalogInfoService(
			IAddressCatalogInfoService addressCatalogInfoService) {
		this.addressCatalogInfoService = addressCatalogInfoService;
	}

	public void setArticleInfoService(IArticleInfoService articleInfoService) {
		this.articleInfoService = articleInfoService;
	}

	public void setCityInfoService(ICityInfoService cityInfoService) {
		this.cityInfoService = cityInfoService;
	}

	public void setEmailAddressInfoService(
			IEmailAddressInfoService emailAddressInfoService) {
		this.emailAddressInfoService = emailAddressInfoService;
	}

	public void setEmailDraftInfoService(
			IEmailDraftInfoService emailDraftInfoService) {
		this.emailDraftInfoService = emailDraftInfoService;
	}

	public void setEmailSendInfoService(IEmailSendInfoService emailSendInfoService) {
		this.emailSendInfoService = emailSendInfoService;
	}

	public void setInquisitionTemplateInfoService(
			IInquisitionTemplateInfoService inquisitionTemplateInfoService) {
		this.inquisitionTemplateInfoService = inquisitionTemplateInfoService;
	}

	public void setPartInfoService(IPartInfoService partInfoService) {
		this.partInfoService = partInfoService;
	}

	public void setPartSelectInfoService(
			IPartSelectInfoService partSelectInfoService) {
		this.partSelectInfoService = partSelectInfoService;
	}

	public void setPlanInfoService(IPlanInfoService planInfoService) {
		this.planInfoService = planInfoService;
	}

	public void setProjectInfoService(IProjectInfoService projectInfoService) {
		this.projectInfoService = projectInfoService;
	}

	public void setPublishInfoService(IPublishInfoService publishInfoService) {
		this.publishInfoService = publishInfoService;
	}

	public void setQuestionInfoService(IQuestionInfoService questionInfoService) {
		this.questionInfoService = questionInfoService;
	}
	public void setRemarkInfoService(IRemarkInfoService remarkInfoService) {
		this.remarkInfoService = remarkInfoService;
	}

	public void setReportInfoService(IReportInfoService reportInfoService) {
		this.reportInfoService = reportInfoService;
	}

	public void setReportTemplateInfoService(
			IReportTemplateInfoService reportTemplateInfoService) {
		this.reportTemplateInfoService = reportTemplateInfoService;
	}

	public void setSelectWeightInfoService(
			ISelectWeightInfoService selectWeightInfoService) {
		this.selectWeightInfoService = selectWeightInfoService;
	}

	public void setSmgkInfoService(ISmgkInfoService smgkInfoService) {
		this.smgkInfoService = smgkInfoService;
	}

	public void setThemeInfoService(IThemeInfoService themeInfoService) {
		this.themeInfoService = themeInfoService;
	}

	public void setThemeStyleInfoService(
			IThemeStyleInfoService themeStyleInfoService) {
		this.themeStyleInfoService = themeStyleInfoService;
	}

	public void setVideoInfoService(IVideoInfoService videoInfoService) {
		this.videoInfoService = videoInfoService;
	}

	public void setCheckDetailInfoService(
			ICheckDetailInfoService checkDetailInfoService) {
		this.checkDetailInfoService = checkDetailInfoService;
	}

	public void setInquisitionHeaderSelectInfoService(
			IInquisitionHeaderSelectInfoService inquisitionHeaderSelectInfoService) {
		this.inquisitionHeaderSelectInfoService = inquisitionHeaderSelectInfoService;
	}

	public void setPartQuestionInfoService(
			IPartQuestionInfoService partQuestionInfoService) {
		this.partQuestionInfoService = partQuestionInfoService;
	}

	public void setPu(PaginationUtil pu) {
		this.pu = pu;
	}

	public void setOptionInfoService(IOptionInfoService optionInfoService) {
		this.optionInfoService = optionInfoService;
	}

	public void setOptionTemplateInfoService(
			IOptionTemplateInfoService optionTemplateInfoService) {
		this.optionTemplateInfoService = optionTemplateInfoService;
	}

	public void setOptionRelationInfoService(
			IOptionRelationInfoService optionRelationInfoService) {
		this.optionRelationInfoService = optionRelationInfoService;
	}

	public void setResourceInfoService(IResourceInfoService resourceInfoService) {
		this.resourceInfoService = resourceInfoService;
	}
	
}
