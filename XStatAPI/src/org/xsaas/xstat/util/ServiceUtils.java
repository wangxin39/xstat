package org.xsaas.xstat.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.xsaas.xstat.business.IAddressCatalogInfoService;
import org.xsaas.xstat.business.IArticleInfoService;
import org.xsaas.xstat.business.ICheckDetailInfoService;
import org.xsaas.xstat.business.ICityInfoService;
import org.xsaas.xstat.business.IClientAccountInfoService;
import org.xsaas.xstat.business.IClientInfoService;
import org.xsaas.xstat.business.IClientPopedomInfoService;
import org.xsaas.xstat.business.IEmailAddressInfoService;
import org.xsaas.xstat.business.IEmailDraftInfoService;
import org.xsaas.xstat.business.IEmailSendInfoService;
import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IFinalEvaluationInfoService;
import org.xsaas.xstat.business.IGradeRelationInfoService;
import org.xsaas.xstat.business.IGradeStdInfoService;
import org.xsaas.xstat.business.IGradeStdRelationInfoService;
import org.xsaas.xstat.business.IHeaderRecordInfoService;
import org.xsaas.xstat.business.IInformantEvaluationInfoService;
import org.xsaas.xstat.business.IInformantInfoService;
import org.xsaas.xstat.business.IInquisitionHeaderInfoService;
import org.xsaas.xstat.business.IInquisitionHeaderSelectInfoService;
import org.xsaas.xstat.business.IInquisitionInfoService;
import org.xsaas.xstat.business.IInquisitionMarkInfoService;
import org.xsaas.xstat.business.IInquisitionTemplateInfoService;
import org.xsaas.xstat.business.IIssueInfoService;
import org.xsaas.xstat.business.IMenuInfoService;
import org.xsaas.xstat.business.IOptionInfoService;
import org.xsaas.xstat.business.IOutputInfoService;
import org.xsaas.xstat.business.IPartInfoService;
import org.xsaas.xstat.business.IPartQuestionInfoService;
import org.xsaas.xstat.business.IPartRecordInfoService;
import org.xsaas.xstat.business.IPartSelectInfoService;
import org.xsaas.xstat.business.IPlanInfoService;
import org.xsaas.xstat.business.IProjectInfoService;
import org.xsaas.xstat.business.IPublishInfoService;
import org.xsaas.xstat.business.IQuestionInfoService;
import org.xsaas.xstat.business.IRealityCheckInfoService;
import org.xsaas.xstat.business.IRemarkInfoService;
import org.xsaas.xstat.business.IReportInfoService;
import org.xsaas.xstat.business.IReportTemplateInfoService;
import org.xsaas.xstat.business.IReqInfoService;
import org.xsaas.xstat.business.IReqResultInfoService;
import org.xsaas.xstat.business.IResourceInfoService;
import org.xsaas.xstat.business.ISelectWeightInfoService;
import org.xsaas.xstat.business.ISitePopedomInfoService;
import org.xsaas.xstat.business.ISmgkInfoService;
import org.xsaas.xstat.business.ISmgkMenuInfoService;
import org.xsaas.xstat.business.ISmgkPopedomInfoService;
import org.xsaas.xstat.business.IStatChartInfoService;
import org.xsaas.xstat.business.IStatPartInfoService;
import org.xsaas.xstat.business.IStatQuestionInfoService;
import org.xsaas.xstat.business.IThemeInfoService;
import org.xsaas.xstat.business.IThemeStyleInfoService;
import org.xsaas.xstat.business.IVideoInfoService;


public class ServiceUtils {
	private static final Logger log = LoggerFactory.getLogger(ServiceUtils.class);
	private static ApplicationContext ctx;
	private static ServiceUtils instance = null;
	private ServiceUtils(){
		try{
			ctx = new FileSystemXmlApplicationContext(new String[]{"classpath*:applicationContext.xml","classpath*:dao.xml","classpath*:service.xml"});
		}catch(Exception e) {
			log.error(e.getMessage(),e);
		}
	}
	
	public static ServiceUtils get() {
		if(instance == null) {
			instance = new ServiceUtils();
		}
		return instance;
	}
	
	public Object getBean(String name) {
		return ctx.getBean(name);
	}

	public IAddressCatalogInfoService getAddressCatalogInfoService() 
	{
		return (IAddressCatalogInfoService) getBean("addressCatalogInfoService");		
	}

	public IHeaderRecordInfoService getInquisitionRecordInfoService()
	{
		return(IHeaderRecordInfoService) getBean("inquisitionRecordInfoService");
	}
	public IArticleInfoService getArticleInfoService()
	{
		return(IArticleInfoService) getBean("articleInfoService");
	}
	public ICityInfoService getCityInfoService()
	{
		return (ICityInfoService) getBean("cityInfoService");
	}
	public IClientAccountInfoService getClientAccountInfoService()
	{
		return (IClientAccountInfoService) getBean("clientAccountInfoService");
	}
	public IClientInfoService getClientInfoService() {
		return (IClientInfoService) getBean("clientInfoService");
	}
	public IClientPopedomInfoService getClientPopedomInfoService() {
		return (IClientPopedomInfoService) getBean("clientPopedomInfoService");
	}
	public IEmailAddressInfoService getEmailAddressInfoService() {
		return (IEmailAddressInfoService) getBean("emailAddressInfoService");
	}
	public IEmailDraftInfoService getEmailDraftInfoServic() {
		return (IEmailDraftInfoService) getBean("emailDraftInfoServic");
	}
	public IEmailSendInfoService getEmailSendInfoService() {
		return (IEmailSendInfoService) getBean("emailSendInfoService");
	}
	public IEmployeeInfoService getEmployeeInfoService() {
		return (IEmployeeInfoService) getBean("employeeInfoService");
	}	
	public IPartInfoService getPartInfoService(){
		return (IPartInfoService) getBean("partInfoService");
	}
	public IQuestionInfoService getQuestionInfoService(){
		return (IQuestionInfoService) getBean("questionInfoService");
	}
	public IInquisitionTemplateInfoService getInquisitionTemplateInfoService(){
		return (IInquisitionTemplateInfoService) getBean("inquisitionTemplateInfoService");
	}
	public IInquisitionHeaderInfoService getInquisitionHeaderInfoService(){
		return (IInquisitionHeaderInfoService) getBean("inquisitionHeaderInfoService");
	}
	public IInquisitionHeaderSelectInfoService getInquisitionHeaderSelectInfoService(){
		return (IInquisitionHeaderSelectInfoService) getBean("inquisitionHeaderSelectInfoService");
	}
	public IInquisitionInfoService getInquisitionInfoService(){
		return (IInquisitionInfoService) getBean("inquisitionInfoService");
	}

	public IPartQuestionInfoService getPartQuestionInfoService(){
		return (IPartQuestionInfoService) getBean("partQuestionInfoService");
	}
	public IPartSelectInfoService getPartSelectInfoService(){
		return (IPartSelectInfoService) getBean("partSelectInfoService");
	}
	public ISelectWeightInfoService getPartWeightInfoService(){
		return (ISelectWeightInfoService) getBean("partWeightInfoService");
	}
	public IPlanInfoService getPlanInfoService(){
		return (IPlanInfoService) getBean("planInfoService");
	}
	public IProjectInfoService getProjectInfoService(){
		return (IProjectInfoService) getBean("projectInfoService");
	}	
	public IResourceInfoService getQuestionResInfoService(){
		return (IResourceInfoService) getBean("questionResInfoService");
	}
	public IOptionInfoService getQuestionSelectInfoService(){
		return (IOptionInfoService) getBean("questionSelectInfoService");
	}
	public IRemarkInfoService getRemarkInfoService(){
		return (IRemarkInfoService) getBean("remarkInfoService");
	}
	public IReportInfoService getReportInfoService(){
		return (IReportInfoService) getBean("reportInfoService"); 
	}
	public IReqInfoService getReqInfoService(){
		return (IReqInfoService) getBean("reqInfoService");
	}
	public ISitePopedomInfoService getSitePopedomInfoService(){
		return (ISitePopedomInfoService) getBean("sitePopedomInfoService");
	}
	public ISmgkInfoService getSmgkInfoService(){
		return (ISmgkInfoService) getBean("smgkInfoService");
	}
	public ISmgkMenuInfoService getSmgkMenuInfoService(){
		return (ISmgkMenuInfoService) getBean("smgkMenuInfoService");
	}
	public ISmgkPopedomInfoService getSmgkPopedomInfoService(){
		return (ISmgkPopedomInfoService) getBean("smgkPopedomInfoService");
	}
	public IStatPartInfoService getStatPartInfoService(){
		return (IStatPartInfoService) getBean("statPartInfoService");
	}
	public IReqResultInfoService getReqResultInfoService(){
		return (IReqResultInfoService) getBean("reqResultInfoService");
	}
	public IMenuInfoService getMenuInfoService(){
		return (IMenuInfoService) getBean("menuInfoService");
	}
	public IStatQuestionInfoService getStatQuestionInfoService(){
		return (IStatQuestionInfoService) getBean("statQuestionInfoService");
	}
	public IInformantInfoService getInformantInfoService(){
		return (IInformantInfoService) getBean("informantInfoService");
	}
	public ISelectWeightInfoService getSelectWeightInfoService(){
		return (ISelectWeightInfoService) getBean("selectWeightInfoService");
	}
	public IStatChartInfoService getStatChartInfoService(){
		return (IStatChartInfoService) getBean("statChartInfoService");
	}
	public IHeaderRecordInfoService getHeaderRecordInfoService() {
		return (IHeaderRecordInfoService) getBean("headerRecordInfoService");
	}
	public IPartRecordInfoService getPartRecordInfoService() {
		return (IPartRecordInfoService) getBean("partRecordInfoService");
	}
	public IIssueInfoService getIssueInfoService() {
		return (IIssueInfoService) getBean("issueInfoService");
	}
	public IPublishInfoService getPublishInfoService() {
		return (IPublishInfoService) getBean("publishInfoService");
	}
	public IFinalEvaluationInfoService getFinalEvaluationInfoService(){
		return (IFinalEvaluationInfoService) getBean("finalEvaluationInfoService");
	}
	public IInformantEvaluationInfoService getInquisitionEvaluateInfoService(){
		return (IInformantEvaluationInfoService) getBean("informantEvaluationInfoService");
	}
	public IInquisitionMarkInfoService getInquisitionMarkInfoService(){
		return (IInquisitionMarkInfoService) getBean("inquisitionMarkInfoService");
	}	
	public IThemeInfoService getThemeInfoService(){
		return (IThemeInfoService) getBean("themeInfoService");
	}
	public IOutputInfoService getOutputInfoService(){
		return (IOutputInfoService) getBean("outputInfoService");
	}
	
	public IReportTemplateInfoService getReportTemplateInfoService(){
		return (IReportTemplateInfoService) getBean("reportTemplateInfoService");
	}
	public IThemeStyleInfoService getThemeStyleInfoService(){
		return (IThemeStyleInfoService) getBean("themeStyleInfoService");
	}
	public IVideoInfoService getVideoInfoService(){
		return (IVideoInfoService) getBean("videoInfoService");
	}
	public IRealityCheckInfoService getRealityCheckInfoService(){
		return (IRealityCheckInfoService) getBean("realityCheckInfoService");
	}
	public ICheckDetailInfoService getCheckDetailInfoService(){
		return (ICheckDetailInfoService) getBean("checkDetailInfoService");
	}
	public IGradeRelationInfoService getGradeRelationInfoService() {
		return (IGradeRelationInfoService)getBean("gradeRelationInfoService");
	}
	public IGradeStdInfoService getGradeStdInfoService() {
		return (IGradeStdInfoService)getBean("gradeStdInfoService");
	}
	public IGradeStdRelationInfoService getGradeStdRelationInfoService() {
		return (IGradeStdRelationInfoService)getBean("gradeStdRelationInfoService");
	}
}