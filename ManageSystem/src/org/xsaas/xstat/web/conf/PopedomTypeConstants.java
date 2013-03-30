package org.xsaas.xstat.web.conf;

import java.util.LinkedHashMap;

/**
 * 神秘顾客网络管理系统所有权限类型定义
 * @author wangxin
 *
 * 	使用方式，在具体操作时，检查当前页是否具有该操作的权限
 *  如该用户的权限哈希表。
 *	UserInfo.hashMap.get(PopedomTypeConstants.CLIENT_ADD) //如果返回true，则具有该权限
 */
public class PopedomTypeConstants {
	
	//地址薄分类../email/listEmailCatalog.do
	public static final int CATALOG_ADD = 1;
	public static final int CATALOG_EDIT = 2;
	public static final int CATALOG_DELETE = 3;
	public static final int CATALOG_LIST = 4;
	
	//神秘顾客../customer/listCustomer.do

	public static final int CUSTOMER_ADD = 11;
	public static final int CUSTOMER_EDIT = 12;
	public static final int CUSTOMER_LIST = 13;
	public static final int CUSTOMER_DELETE = 14;
	
	//客户管理../jasper/listClient.do

	public static final int CLIENT_ADD = 21;
	public static final int CLIENT_EDIT = 22;
	public static final int CLIENT_LIST = 23;
	public static final int CLIENT_DELETE = 24;
	

	//翻译管理../translate/listTranslate.do');
	public static final int TRANSLATE_ADD = 31;
	public static final int TRANSLATE_EDIT = 32;
	public static final int TRANSLATE_DELETE = 33;
	public static final int TRANSLATE_LIST = 34;
	
	//帐户管理../jasper/listClientAccount.do
	public static final int ACCOUNT_ADD = 41;
	public static final int ACCOUNT_EDIT = 42;
	public static final int ACCOUNT_DELETE = 43;
	public static final int ACCOUNT_LIST = 44;
	
	//调查项目../jasper/listProject.do
	public static final int PROJECT_ADD = 51;
	public static final int PROJECT_EDIT = 52;
	public static final int PROJECT_DELETE = 53;
	public static final int PROJECT_LIST = 54;
	
	//期次../jasper/listIssue.do
	public static final int ISSUE_ADD = 61;
	public static final int ISSUE_EDIT = 62;
	public static final int ISSUE_DELETE = 63;
	public static final int ISSUE_LIST = 64;
	
	//申诉管理../translate/listAppeal.do	
	public static final int APPEAL_ADD = 71;
	public static final int APPEAL_EDIT = 72;
	public static final int APPEAL_DELETE = 73;
	public static final int APPEAL_LIST = 74;
	
	//员工管理../customer/listAuth.do
	public static final int EMPLOYEE_ADD = 81;
	public static final int EMPLOYEE_EDIT = 82;
	public static final int EMPLOYEE_DELETE = 83;
	public static final int EMPLOYEE_LIST = 84;
	
	//审核注册../translate/listAuditing.do
	public static final int AUDITING_ADD = 91;
	public static final int AUDITING_EDIT = 92;
	public static final int AUDITING_DELETE = 93;
	public static final int AUDITING_LIST = 94;
	
	//文章管理../content/listArticle.do
	public static final int ARTICLE_ADD = 101;
	public static final int ARTICLE_EDIT = 102;
	public static final int ARTICLE_DELETE = 103;
	public static final int ARTICLE_LIST = 104;
	
	//发布管理../content/listBulletin.do
	public static final int PUBLISH_ADD = 111;
	public static final int PUBLISH_EDIT = 112;
	public static final int PUBLISH_DELETE = 113;
	public static final int PUBLISH_LIST = 114;

	//逻辑管理../content/listNews.do
	public static final int LOGIC_ADD = 121;
	public static final int LOGIC_EDIT = 122;
	public static final int LOGIC_DELETE = 123;
	public static final int LOGIC_LIST = 124;
	
	//菜单管理../system/listMenu.do
	public static final int MENU_ADD = 131;
	public static final int MENU_EDIT = 132;
	public static final int MENU_DELETE = 133;
	public static final int MENU_LIST = 134;
	
	//模版管理../template/listTemplateReport.do
	public static final int TEMPLATE_ADD = 141;
	public static final int TEMPLATE_EDIT = 142;
	public static final int TEMPLATE_DELETE = 143;
	public static final int TEMPLATE_LIST = 144;
	
	//计划管理../inquisition/listPlan.do
	public static final int PLAN_ADD = 151;
	public static final int PLAN_EDIT = 152;
	public static final int PLAN_DELETE = 153;
	public static final int PLAN_LIST = 154;
	
	//问卷管理../inquisition/listMakeExam.do
	public static final int MAKE_ADD = 161;
	public static final int MAKE_EDIT = 162;
	public static final int MAKE_DELETE = 163;
	public static final int MAKE_LIST = 164;
	
	//表头管理../inquisition/listHeader.do
	public static final int HEADER_ADD = 171;
	public static final int HEADER_EDIT = 172;
	public static final int HEADER_DELETE = 173;
	public static final int HEADER_LIST = 174;
	
	//部分管理../inquisition/listMakePart.do
	public static final int PART_ADD = 181;
	public static final int PART_EDIT = 182;
	public static final int PART_DELETE = 183;
	public static final int PART_LIST = 184;
	
	//评分管理../inquisition/listGrade.do
	public static final int GRADE_ADD = 191;
	public static final int GRADE_EDIT = 192;
	public static final int GRADE_DELETE = 193;
	public static final int GRADE_LIST = 194;
	
	//评论管理../translate/listCritique.do
	public static final int CRITIQUE_ADD = 201;
	public static final int CRITIQUE_EDIT = 202;
	public static final int CRITIQUE_DELETE = 203;
	public static final int CRITIQUE_LIST = 204;
	
	//问题管理../question/listQuestion.do
	public static final int QUESTION_ADD = 211;
	public static final int QUESTION_EDIT = 212;
	public static final int QUESTION_DELETE = 213;
	public static final int QUESTION_LIST = 214;
	
	//选项管理../question/listSelectManage.do
	public static final int SELECT_ADD = 221;
	public static final int SELECT_EDIT = 222;
	public static final int SELECT_DELETE = 223;
	public static final int SELECT_LIST = 224;
	
	//资源管理../question/listResource.do
	public static final int RESOURCE_ADD = 231;
	public static final int RESOURCE_EDIT = 232;
	public static final int RESOURCE_DELETE = 233;
	public static final int RESOURCE_LIST = 234;
	
	//模板管理../jasper/listJasperReport.do
	public static final int JASPER_ADD = 241;
	public static final int JASPER_EDIT = 242;
	public static final int JASPER_DELETE = 243;
	public static final int JASPER_LIST = 244;
	
	//导出管理../jasper/listReportExport.do
	public static final int EXPORT_ADD = 251;
	public static final int EXPORT_EDIT = 252;
	public static final int EXPORT_DELETE = 253;
	public static final int EXPORT_LIST = 254;
	
	//报告管理../jasper/listReport.do
	public static final int REPORT_ADD = 261;
	public static final int REPORT_EDIT = 262;
	public static final int REPORT_DELETE = 263;
	public static final int REPORT_LIST = 264;
	
	//我的发送箱../email/listSend.do
	public static final int SEND_ADD = 271;
	public static final int SEND_EDIT = 272;
	public static final int SEND_DELETE = 273;
	public static final int SEND_LIST = 274;
	
	//我的草稿箱../email/listDraft.do
	public static final int DRAFT_ADD = 281;
	public static final int DRAFT_EDIT = 282;
	public static final int DRAFT_DELETE = 283;
	public static final int DRAFT_LIST = 284;
	
	//通讯地址薄../email/listAddress.do
	public static final int ADDRESS_ADD = 301;
	public static final int ADDRESS_EDIT = 302;
	public static final int ADDRESS_DELETE = 303;
	public static final int ADDRESS_LIST = 304;
	
	//城市管理../system/listCity.do
	public static final int CITY_ADD = 291;
	public static final int CITY_EDIT = 292;
	public static final int CITY_DELETE = 293;
	public static final int CITY_LIST = 294;

	
	//浏览任务../translate/listTask.do
	public static final int TASK_ADD = 311;
	public static final int TASK_EDIT = 312;
	public static final int TASK_DELETE = 313;
	public static final int TASK_LIST = 314;
	
	public static LinkedHashMap<Integer, String> sitePopedomDict;	
	
	static{
		
		sitePopedomDict = new LinkedHashMap<Integer, String>();
		
		/**
		 * 神秘顾客权限
		 */
		sitePopedomDict.put(new Integer(CUSTOMER_ADD), "增加神秘顾客");
		sitePopedomDict.put(new Integer(CUSTOMER_EDIT), "修改神秘顾客");
		sitePopedomDict.put(new Integer(CUSTOMER_LIST), "浏览神秘顾客");
		sitePopedomDict.put(new Integer(CUSTOMER_DELETE), "删除神秘顾客");
		
		/**
		 * 客户权限
		 */
		sitePopedomDict.put(new Integer(CLIENT_ADD), "增加客户");
		sitePopedomDict.put(new Integer(CLIENT_EDIT), "修改客户");
		sitePopedomDict.put(new Integer(CLIENT_LIST), "浏览客户");
		sitePopedomDict.put(new Integer(CLIENT_DELETE), "删除客户");
		
		//帐户管理../jasper/listClientAccount.do');
		sitePopedomDict.put(new Integer(ACCOUNT_ADD), "增加账户");
		sitePopedomDict.put(new Integer(ACCOUNT_EDIT), "修改账户");
		sitePopedomDict.put(new Integer(ACCOUNT_LIST), "浏览账户");
		sitePopedomDict.put(new Integer(ACCOUNT_DELETE), "删除账户");
		//调查项目../jasper/listProject.do');		
		sitePopedomDict.put(new Integer(PROJECT_ADD), "增加项目");
		sitePopedomDict.put(new Integer(PROJECT_EDIT), "修改项目");
		sitePopedomDict.put(new Integer(PROJECT_LIST), "浏览项目");
		sitePopedomDict.put(new Integer(PROJECT_DELETE), "删除项目");
		//被调查客户../jasper/listInformant.do');
		sitePopedomDict.put(new Integer(ISSUE_ADD), "增加期次");
		sitePopedomDict.put(new Integer(ISSUE_EDIT), "修改期次");
		sitePopedomDict.put(new Integer(ISSUE_LIST), "浏览期次");
		sitePopedomDict.put(new Integer(ISSUE_DELETE), "删除期次");
		//员工管理../customer/listAuth.do');
		sitePopedomDict.put(new Integer(EMPLOYEE_ADD), "增加员工");
		sitePopedomDict.put(new Integer(EMPLOYEE_EDIT), "修改员工");
		sitePopedomDict.put(new Integer(EMPLOYEE_LIST), "浏览员工");
		sitePopedomDict.put(new Integer(EMPLOYEE_DELETE), "删除员工");
		
		//文章管理../content/listArticle.do');
		sitePopedomDict.put(new Integer(ARTICLE_ADD), "增加文章");
		sitePopedomDict.put(new Integer(ARTICLE_EDIT), "修改文章");
		sitePopedomDict.put(new Integer(ARTICLE_LIST), "浏览文章");
		sitePopedomDict.put(new Integer(ARTICLE_DELETE), "删除文章");
		//发布管理../content/listBulletin.do');
		sitePopedomDict.put(new Integer(PUBLISH_ADD), "增加发布");
		sitePopedomDict.put(new Integer(PUBLISH_EDIT), "修改发布");
		sitePopedomDict.put(new Integer(PUBLISH_LIST), "浏览发布");
		sitePopedomDict.put(new Integer(PUBLISH_DELETE), "删除发布");
		//逻辑管理../content/listNews.do');
		sitePopedomDict.put(new Integer(LOGIC_ADD), "增加逻辑");
		sitePopedomDict.put(new Integer(LOGIC_EDIT), "修改逻辑");
		sitePopedomDict.put(new Integer(LOGIC_LIST), "浏览逻辑");
		sitePopedomDict.put(new Integer(LOGIC_DELETE), "删除逻辑");
		
		//模版管理../template/listTemplateReport.do');
		sitePopedomDict.put(new Integer(TEMPLATE_ADD), "增加模板");
		sitePopedomDict.put(new Integer(TEMPLATE_EDIT), "修改模板");
		sitePopedomDict.put(new Integer(TEMPLATE_LIST), "浏览模板");
		sitePopedomDict.put(new Integer(TEMPLATE_DELETE), "删除模板");
		//计划管理../inquisition/listPlan.do');
		sitePopedomDict.put(new Integer(PLAN_ADD), "增加计划");
		sitePopedomDict.put(new Integer(PLAN_EDIT), "修改计划");
		sitePopedomDict.put(new Integer(PLAN_LIST), "浏览计划");
		sitePopedomDict.put(new Integer(PLAN_DELETE), "删除计划");
		//问卷管理../inquisition/listMakeExam.do');
		sitePopedomDict.put(new Integer(MAKE_ADD), "增加问卷");
		sitePopedomDict.put(new Integer(MAKE_EDIT), "修改问卷");
		sitePopedomDict.put(new Integer(MAKE_LIST), "浏览问卷");
		sitePopedomDict.put(new Integer(MAKE_DELETE), "删除问卷");
		//表头管理../inquisition/listHeader.do');
		sitePopedomDict.put(new Integer(HEADER_ADD), "增加表头");
		sitePopedomDict.put(new Integer(HEADER_EDIT), "修改表头");
		sitePopedomDict.put(new Integer(HEADER_LIST), "浏览表头");
		sitePopedomDict.put(new Integer(HEADER_DELETE), "删除表头");
		//部分管理../inquisition/listMakePart.do');
		sitePopedomDict.put(new Integer(PART_ADD), "增加部分");
		sitePopedomDict.put(new Integer(PART_EDIT), "修改部分");
		sitePopedomDict.put(new Integer(PART_LIST), "浏览部分");
		sitePopedomDict.put(new Integer(PART_DELETE), "删除部分");
		//评分管理../inquisition/listGrade.do');
		sitePopedomDict.put(new Integer(GRADE_ADD), "增加评分");
		sitePopedomDict.put(new Integer(GRADE_EDIT), "修改评分");
		sitePopedomDict.put(new Integer(GRADE_LIST), "浏览评分");
		sitePopedomDict.put(new Integer(GRADE_DELETE), "删除评分");
		//评论管理../translate/listCritique.do');
		sitePopedomDict.put(new Integer(CRITIQUE_ADD), "增加评论");
		sitePopedomDict.put(new Integer(CRITIQUE_EDIT), "修改评论");
		sitePopedomDict.put(new Integer(CRITIQUE_LIST), "浏览评论");
		sitePopedomDict.put(new Integer(CRITIQUE_DELETE), "删除评论");
		//问题管理../question/listQuestion.do');
		sitePopedomDict.put(new Integer(QUESTION_ADD), "增加问题");
		sitePopedomDict.put(new Integer(QUESTION_EDIT), "修改问题");
		sitePopedomDict.put(new Integer(QUESTION_LIST), "浏览问题");
		sitePopedomDict.put(new Integer(QUESTION_DELETE), "删除问题");
		//选项管理../question/listSelectManage.do');
		sitePopedomDict.put(new Integer(SELECT_ADD), "增加选项");
		sitePopedomDict.put(new Integer(SELECT_EDIT), "修改选项");
		sitePopedomDict.put(new Integer(SELECT_LIST), "浏览选项");
		sitePopedomDict.put(new Integer(SELECT_DELETE), "删除选项");
	
		//资源管理../question/listResource.do');
		sitePopedomDict.put(new Integer(RESOURCE_ADD), "增加资源");
		sitePopedomDict.put(new Integer(RESOURCE_EDIT), "修改资源");
		sitePopedomDict.put(new Integer(RESOURCE_LIST), "浏览资源");
		sitePopedomDict.put(new Integer(RESOURCE_DELETE), "删除资源");
		//模板管理../jasper/listJasperReport.do');
		sitePopedomDict.put(new Integer(JASPER_ADD), "增加模板");
		sitePopedomDict.put(new Integer(JASPER_EDIT), "修改模板");
		sitePopedomDict.put(new Integer(JASPER_LIST), "浏览模板");
		sitePopedomDict.put(new Integer(JASPER_DELETE), "删除模板");
		//导出管理../jasper/listReportExport.do');
		sitePopedomDict.put(new Integer(EXPORT_ADD), "增加导出");
		sitePopedomDict.put(new Integer(EXPORT_EDIT), "修改导出");
		sitePopedomDict.put(new Integer(EXPORT_LIST), "浏览导出");
		sitePopedomDict.put(new Integer(EXPORT_DELETE), "删除导出");
		//报告管理../jasper/listReport.do');
		sitePopedomDict.put(new Integer(REPORT_ADD), "增加报告");
		sitePopedomDict.put(new Integer(REPORT_EDIT), "修改报告");
		sitePopedomDict.put(new Integer(REPORT_LIST), "浏览报告");
		sitePopedomDict.put(new Integer(REPORT_DELETE), "删除报告");
		//我的发送箱../email/listSend.do');
		sitePopedomDict.put(new Integer(SEND_ADD), "增加发送箱");
		sitePopedomDict.put(new Integer(SEND_EDIT), "修改发送箱");
		sitePopedomDict.put(new Integer(SEND_LIST), "浏览发送箱");
		sitePopedomDict.put(new Integer(SEND_DELETE), "删除发送箱");
		//我的草稿箱../email/listDraft.do');
		sitePopedomDict.put(new Integer(DRAFT_ADD), "增加草稿箱");
		sitePopedomDict.put(new Integer(DRAFT_EDIT), "修改草稿箱");
		sitePopedomDict.put(new Integer(DRAFT_LIST), "浏览草稿箱");
		sitePopedomDict.put(new Integer(DRAFT_DELETE), "删除草稿箱");
		//地址薄分类../email/listEmailCatalog.do');
		sitePopedomDict.put(new Integer(CATALOG_ADD), "增加地址簿");
		sitePopedomDict.put(new Integer(CATALOG_EDIT), "修改地址簿");
		sitePopedomDict.put(new Integer(CATALOG_LIST), "浏览地址簿");
		sitePopedomDict.put(new Integer(CATALOG_DELETE), "删除地址簿");
		//通讯地址薄../email/listAddress.do');
		sitePopedomDict.put(new Integer(ADDRESS_ADD), "增加通讯地址簿");
		sitePopedomDict.put(new Integer(ADDRESS_EDIT), "修改通讯地址簿");
		sitePopedomDict.put(new Integer(ADDRESS_LIST), "浏览通讯地址簿");
		sitePopedomDict.put(new Integer(ADDRESS_DELETE), "删除通讯地址簿");
		//城市管理../system/listCity.do');
		sitePopedomDict.put(new Integer(CITY_ADD), "增加城市");
		sitePopedomDict.put(new Integer(CITY_EDIT), "修改城市");
		sitePopedomDict.put(new Integer(CITY_LIST), "浏览城市");
		sitePopedomDict.put(new Integer(CITY_DELETE), "删除城市");
		//菜单管理../system/listMenu.do');
		sitePopedomDict.put(new Integer(MENU_ADD), "增加菜单");
		sitePopedomDict.put(new Integer(MENU_EDIT), "修改菜单");
		sitePopedomDict.put(new Integer(MENU_LIST), "浏览菜单");
		sitePopedomDict.put(new Integer(MENU_DELETE), "删除菜单");
		//审核注册../translate/listAuditing.do');
		sitePopedomDict.put(new Integer(AUDITING_ADD), "增加审核");
		sitePopedomDict.put(new Integer(AUDITING_EDIT), "修改审核");
		sitePopedomDict.put(new Integer(AUDITING_LIST), "浏览审核");
		sitePopedomDict.put(new Integer(AUDITING_DELETE), "删除审核");
		//翻译管理../translate/listTranslate.do');
		sitePopedomDict.put(new Integer(TRANSLATE_ADD), "增加翻译");
		sitePopedomDict.put(new Integer(TRANSLATE_EDIT), "修改翻译");
		sitePopedomDict.put(new Integer(TRANSLATE_LIST), "浏览翻译");
		sitePopedomDict.put(new Integer(TRANSLATE_DELETE), "删除翻译");
		//浏览任务../translate/listTask.do');
		sitePopedomDict.put(new Integer(TASK_ADD), "增加任务");
		sitePopedomDict.put(new Integer(TASK_EDIT), "修改任务");
		sitePopedomDict.put(new Integer(TASK_LIST), "浏览任务");
		sitePopedomDict.put(new Integer(TASK_DELETE), "删除任务");
		//申诉管理../translate/listAppeal.do');
		sitePopedomDict.put(new Integer(APPEAL_ADD), "增加申诉");
		sitePopedomDict.put(new Integer(APPEAL_EDIT), "修改申诉");
		sitePopedomDict.put(new Integer(APPEAL_LIST), "浏览申诉");
		sitePopedomDict.put(new Integer(APPEAL_DELETE), "删除申诉");

	}
	
}
