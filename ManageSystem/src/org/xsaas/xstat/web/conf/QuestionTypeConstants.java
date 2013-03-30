package org.xsaas.xstat.web.conf;

import java.util.LinkedHashMap;

public class QuestionTypeConstants {

		//AuthType认证文件类型信息 auth_info
		
		public static final int AJPEG = 1;
		public static final int APNG = 2;
		public static final int AGIF = 3;
		
		//客户账户信息表
		
		public static final int COMPANYNO = 1;
		public static final int COMPANYYES = 2;
	
		//menuType主菜单系统信息类型 menuInfo
	
		public static final int SITESYSTEM = 1;
		public static final int SMGKSYSTEM = 2;
		public static final int CLIENTSYSTEM = 3;
		public static final int EDITSYSTEM = 4;
		
		//GradeType测试明细类型信息 smgk_test_history_info    grade_info
		
		public static final int BIAOTOUWENTI = 1;
		public static final int DIAOCHAWENTI = 2;
		
		
		
		//templateType 模板文件InquisitionTemplateInfo
		public static final int FTL = 1;
		
		//reportType 报告类型   report_info

		public static final int DANXIANG = 1;
		public static final int ZONGJIE = 2;
	
		//OptionValue选项值 question_select_info

		public static final int NA = 0;
		public static final int YES = 1;
		public static final int NO = 2;	
		
		// questionType问题类型信息 question_info
			
		public static final int DANXUANCAIDAN = 1;
		public static final int DANXUANANNIU = 2;
		public static final int DUOXUANCAIDAN = 3;
		public static final int DUOXUANJIANCHAKUANG = 4;
		public static final int TISHITIANKONG = 5;
		public static final int TISHIWENBEN = 6;

	
			
		// FieldType答案类型信息 question_info
			
		public static final int WENBEN = 1;
		public static final int SHUZI = 2;
		public static final int RIQI = 3;
		public static final int SHIJIAN = 4;
	
		
		//resType问题资源文件类型信息 question_res_info
			
		public static final int PNG = 1;
		public static final int JPEG = 2;
		public static final int GIF = 3;
		public static final int TXT = 4;
		public static final int XLS = 5;
		public static final int QDOC = 6;
		public static final int SWF = 7;
		public static final int AVI = 8;
		public static final int MP3 = 9;
		public static final int RM = 10;
		public static final int MP4 = 11;
		
		
		//inquestionType 调查问卷类型信息 inquisition_info      grade_info   stat_grade_info   remark_info
		public static final int JIANCEWENJUAN = 1;
		public static final int CESHIWENJUAN = 2;
		
		
		//IsinputType是否必填 Inquisition_header_info
		
		public static final int BIXUTIANXIE = 1;
		public static final int KEYIWEIKONG = 2;
	
		//languageType 报告语言 report_info

		public static final int CHINESE = 1;
		public static final int ENGLISH = 2;
		
		
		//jasperType报告模板文件类型 jasperreport_info
		public static final int JASPER = 1;
		public static final int JRXML = 2;
		public static final int JRPRINT = 3;
		
	
		
		//exportType 报告导出文件类型信息 jasperreport_export_info
		
		public static final int HTML = 1;
		public static final int PDF = 2;
		public static final int EXCEL = 3;
	
		
		//SelectType选项信息文件类型 jasperreport_info
		public static final int SDANXUAN = 1;
		public static final int SDUOXUAN = 2;
		
		//quarter 季度   问卷分数信息表 Inquisition_mark_info
		public static final int Q1 = 1;
		public static final int Q2 = 2;
		public static final int Q3 = 3;
		public static final int Q4 = 4;
		
		//发布文章 publishInfo
		public static final int SHOUCE = 1;
		public static final int GONGGAO = 2;
		public static final int XINWEN = 3;
		public static final int ZHISHI = 4;
		public static final int PEIXUN = 5;
		
		//是否有下级机构
		public static final int YOU = 0;
		public static final int MEIYOU = 1;
		
		//部分问题管理
		public static final int XUYAOYANZHENG = 1;
		public static final int PKEYIWEIKONG = 2;
		
		//selectType 选项类型
		
		public static final int HEADER = 1;
		public static final int ACCOUNT = 2;
		public static final int INFORMANT = 3;
		
		//BackType 选项类型
		
		public static final int QIYONG = 1;
		public static final int JINGYONG = 2;
		
		//statType 选项类型
		
		public static final int BUQIYONG = 0;
		public static final int TONGJITU = 1;
		public static final int PINGGUBIAO = 2;
		
		//CheckType 选项类型
		
		public static final int WHATUP = 1;
		public static final int WHATDOWN = 2;
		
		//模板类型 reportTemplateInfo
		public static final int SHOUYE = 1;
		public static final int CONTENT = 2;
		public static final int TUWEN = 3;
		public static final int PART = 4;
		public static final int PINGGU = 5;
		
		//round 轮次
		
		public static final int ONE = 1;
		public static final int TWO = 2;
		
		// 选项模板
		public static final int OPTION_TEMPLATE_TYPE = 1;
		public static final int OPTION_TYPE = 2;
		
		
		public static LinkedHashMap<Integer,String> selectTypeDict = null;
		
		//***************************************************
		
		// 客户帐户信息表
		public static LinkedHashMap<Integer,String> CompanyDict;
		
		
		// questionType问题类型信息 question_info
		public static LinkedHashMap<Integer,String> QuestionTypeDict;
		
	
		// FieldType答案类型信息 question_info
		public static LinkedHashMap<Integer,String> FieldTypeDict;
	
		
		//exportType 报告导出文件类型信息 jasperreport_export_info
		public static LinkedHashMap<Integer,String> ExportTypeDict;
		
		//GradeType测试明细类型信息 smgk_test_history_info    grade_info
		public static LinkedHashMap<Integer,String> GradeTypeDict;
		
		
		//IsinputType是否必填 Inquisition_header_info
		public static LinkedHashMap<Integer,String> IsinputTypeDict;
		
		
		//OptionValue选项值 question_select_info
		public static LinkedHashMap<Integer,String> OptionValueDict;
		
		//resType问题资源文件类型信息 question_res_info
		public static LinkedHashMap<Integer,String> ResTypeDict;
		
		//menuType主菜单系统信息类型 menuInfo
		public static LinkedHashMap<Integer,String> MenuTypeDict;
	
		
		//jasperType报告模板文件类型 jasperreport_info
		public static LinkedHashMap<Integer,String> JasperTypeDict;
	

		//languageType 报告语言 report_info
		public static LinkedHashMap<Integer,String> LanguageTypeDict;
		
		//reportType 报告类型   report_info
		public static LinkedHashMap<Integer,String> ReportTypeDict;
		
		//AuthType认证文件类型信息 auth_info
		public static LinkedHashMap<Integer,String> AuthTypeDict;
	
		//inquestionType 调查问卷类型信息 inquisition_info      grade_info   stat_grade_info   remark_info
		public static LinkedHashMap<Integer,String> InquisitionTypeDict;
	
		//quarter 季度   问卷分数信息表 Inquisition_mark_info
		public static LinkedHashMap<Integer,String> QuarterDict;
		
		//templateType 模板文件InquisitionTemplateInfo
		public static LinkedHashMap<Integer,String> TemplateTypeDict;
	
		//发布文章 publishInfo
		public static LinkedHashMap<Integer,String> PublishTypeDict;
		
		//是否有下级机构
		public static LinkedHashMap<Integer,String> SubCompanyDict;
		
		//部分问题管理
		public static LinkedHashMap<Integer,String> ValidationDict;
		
		//selectType 选项类型
		public static LinkedHashMap<Integer,String> SelectDict;
		
		//BackType 选项类型
		public static LinkedHashMap<Integer,String> BackDict;
		
		//statType 选项类型
		public static LinkedHashMap<Integer,String> StatDict;
		
		//CheckType
		public static LinkedHashMap<Integer,String> CheckDict;
		
		//模板类型 reportTemplateInfo
		public static LinkedHashMap<Integer,String> ReportDict;
		
		//round 轮次
		public static LinkedHashMap<Integer,String> RoundDict;
		
		
		static{
			
			selectTypeDict = new LinkedHashMap<Integer,String>();
			
			// 客户帐户信息表
			CompanyDict = new LinkedHashMap<Integer,String>();
			
			// QuestionType问题类型信息 question_info
			QuestionTypeDict = new LinkedHashMap<Integer,String>();
			
			// FieldType答案类型信息 question_info
			FieldTypeDict = new LinkedHashMap<Integer,String>();


			//ExportType 报告导出文件类型信息 jasperreport_Export_info
			ExportTypeDict = new LinkedHashMap<Integer,String>();
			
			//GradeType测试明细类型信息 smgk_test_history_info    grade_info
			GradeTypeDict = new LinkedHashMap<Integer,String>();
			
			//IsinputType是否必填 Inquisition_header_info
			IsinputTypeDict = new LinkedHashMap<Integer,String>();
			
			//OptionValue选项值 question_select_info
			OptionValueDict = new LinkedHashMap<Integer,String>();
			
			//ResType问题资源文件类型信息 question_res_info
			ResTypeDict = new LinkedHashMap<Integer,String>();
			
			//MenuType主菜单系统信息类型 menuInfo
			MenuTypeDict = new LinkedHashMap<Integer,String>();

			
			//JasperType报告模板文件类型 jasperreport_info
			JasperTypeDict = new LinkedHashMap<Integer,String>();
			
			//LanguageType 报告语言 report_info
			LanguageTypeDict = new LinkedHashMap<Integer,String>();
			
			//ReportType 报告类型   report_info
			ReportTypeDict = new LinkedHashMap<Integer,String>();
			
			//AuthType认证文件类型信息 auth_info
			AuthTypeDict = new LinkedHashMap<Integer,String>();
			
			//InquisitionType 调查问卷类型信息 inquisition_info      grade_info   stat_grade_info   remark_info
			InquisitionTypeDict = new LinkedHashMap<Integer,String>();
			
			//quarter 季度   问卷分数信息表 Inquisition_mark_info
			QuarterDict = new LinkedHashMap<Integer,String>();
			
			//templateType 模板文件InquisitionTemplateInfo
			TemplateTypeDict = new LinkedHashMap<Integer,String>();
			
			//发布文章 publishInfo
			PublishTypeDict = new LinkedHashMap<Integer,String>();
			
			//部分问题管理
			ValidationDict = new LinkedHashMap<Integer,String>();
			
			//selectType 选项类型
			SelectDict = new LinkedHashMap<Integer,String>();
			
			//BackType 选项类型
			BackDict = new LinkedHashMap<Integer,String>();
			
			//statType 选项类型
			StatDict = new LinkedHashMap<Integer,String>();
			
			//CheckType
			CheckDict = new LinkedHashMap<Integer,String>();
			
			//模板类型 reportTemplateInfo
			ReportDict = new LinkedHashMap<Integer,String>();
			
			//round 轮次
			RoundDict = new LinkedHashMap<Integer,String>();
			
			
			
			//*******************************************************
			
			// 客户帐户信息表
			CompanyDict.put(new Integer(COMPANYNO),"没有");
			CompanyDict.put(new Integer(COMPANYYES),"拥有");
			
			// QuestionType问题类型信息 question_info
			QuestionTypeDict.put(new Integer(DANXUANCAIDAN),"单选菜单");
			QuestionTypeDict.put(new Integer(DANXUANANNIU),"单选按钮");
			QuestionTypeDict.put(new Integer(DUOXUANCAIDAN),"多选菜单");
			QuestionTypeDict.put(new Integer(DUOXUANJIANCHAKUANG),"多选检查框");
			QuestionTypeDict.put(new Integer(TISHITIANKONG),"提示填空");
			QuestionTypeDict.put(new Integer(TISHIWENBEN),"提示文本");
			
			
			// FieldType答案类型信息 question_info
			FieldTypeDict.put(new Integer(WENBEN),"文本");
			FieldTypeDict.put(new Integer(SHUZI),"数字");
			FieldTypeDict.put(new Integer(RIQI),"日期");
			FieldTypeDict.put(new Integer(SHIJIAN),"时间");

			//ExportType 报告导出文件类型信息 jasperreport_Export_info
			ExportTypeDict.put(new Integer(HTML),"HTML");
			ExportTypeDict.put(new Integer(PDF),"PDF");
			ExportTypeDict.put(new Integer(EXCEL),"EXCEL");
			
		
			//神秘顾客类型信息
			GradeTypeDict.put(new Integer(BIAOTOUWENTI),"表头问题");
			GradeTypeDict.put(new Integer(DIAOCHAWENTI),"调查问题");

			
			//IsinputType是否必填 Inquisition_header_info
			IsinputTypeDict.put(new Integer(BIXUTIANXIE),"必须填写");
			IsinputTypeDict.put(new Integer(KEYIWEIKONG),"可以为空");
			
			//OptionValue选项值 question_select_info
			OptionValueDict.put(new Integer(NA),"N/A");
			OptionValueDict.put(new Integer(YES),"YES");
			OptionValueDict.put(new Integer(NO),"NO");
			
			//ResType问题资源文件类型信息 question_res_info
			ResTypeDict.put(new Integer(PNG),"png");
			ResTypeDict.put(new Integer(JPEG),"jpeg");
			ResTypeDict.put(new Integer(GIF),"gif");
			ResTypeDict.put(new Integer(TXT),"txt");
			ResTypeDict.put(new Integer(XLS),"xls");
			ResTypeDict.put(new Integer(QDOC),"doc");
			ResTypeDict.put(new Integer(SWF),"swf");
			ResTypeDict.put(new Integer(AVI),"avi");
			ResTypeDict.put(new Integer(MP3),"mp3");
			ResTypeDict.put(new Integer(RM),"rm");
			ResTypeDict.put(new Integer(MP4),"mp4");
			
			
			//MenuType主菜单系统信息类型 menuInfo
			MenuTypeDict.put(new Integer(SITESYSTEM),"网络管理系统");
			MenuTypeDict.put(new Integer(SMGKSYSTEM),"神秘顾客系统");
			MenuTypeDict.put(new Integer(CLIENTSYSTEM),"客户分析系统");
			MenuTypeDict.put(new Integer(EDITSYSTEM),"审核编辑系统");
			
			//JasperType报告模板文件类型 jasperreport_info
			JasperTypeDict.put(new Integer(JASPER),"jasper");
			JasperTypeDict.put(new Integer(JRXML),"jrxml");
			JasperTypeDict.put(new Integer(JRPRINT),"jrprint");
			

			
			//LanguageType 报告语言 report_info
			LanguageTypeDict.put(new Integer(CHINESE),"中文");
			LanguageTypeDict.put(new Integer(ENGLISH),"英文");
			
			//ReportType 报告类型   report_info
			ReportTypeDict.put(new Integer(DANXIANG),"单项报告");
			ReportTypeDict.put(new Integer(ZONGJIE),"总结报告");
			
			//AuthType认证文件类型信息 auth_info
			AuthTypeDict.put(new Integer(AJPEG),"jpeg");
			AuthTypeDict.put(new Integer(APNG),"png");
			AuthTypeDict.put(new Integer(AGIF),"gif");
			
			//InquisitionType 调查问卷类型信息 inquisition_info  part_weight_info answer_header_info answer_inquisition_info  remark_info   plan_info
			InquisitionTypeDict.put(new Integer(JIANCEWENJUAN),"调查问卷");
			InquisitionTypeDict.put(new Integer(CESHIWENJUAN),"测试问卷");
		
			//quarter 季度   问卷分数信息表 Inquisition_mark_info
			
			QuarterDict.put(new Integer(Q1),"Q1");
			QuarterDict.put(new Integer(Q2),"Q2");
			QuarterDict.put(new Integer(Q3),"Q3");
			QuarterDict.put(new Integer(Q4),"Q4");
			
			//templateType 模板文件InquisitionTemplateInfo
			TemplateTypeDict.put(new Integer(FTL),"FTL");
			
			//发布文章 publishInfo
			PublishTypeDict.put(new Integer(SHOUCE),"手册");
			PublishTypeDict.put(new Integer(GONGGAO),"公告");
			PublishTypeDict.put(new Integer(XINWEN),"新闻");
			PublishTypeDict.put(new Integer(ZHISHI),"知识");
			PublishTypeDict.put(new Integer(PEIXUN),"培训");
			
			//部分问题管理
			ValidationDict.put(new Integer(XUYAOYANZHENG),"需要验证");
			ValidationDict.put(new Integer(PKEYIWEIKONG),"可以为空");
			
			//selectType 选项类型
			SelectDict.put(new Integer(HEADER),"表头选项");
			SelectDict.put(new Integer(INFORMANT),"调查对象");
			SelectDict.put(new Integer(ACCOUNT),"客户账户");
			
			//模板类型 reportTemplateInfo
			ReportDict.put(new Integer(SHOUYE),"首页模板");
			ReportDict.put(new Integer(CONTENT),"内容模板");
			ReportDict.put(new Integer(TUWEN),"图文模板");
			ReportDict.put(new Integer(PART),"部分模板");
			ReportDict.put(new Integer(PINGGU),"评估模板");
			
			//BackType 选项类型
			BackDict.put(new Integer(QIYONG),"启用");
			BackDict.put(new Integer(JINGYONG),"禁用");
			
			
			//statType 选项类型
			StatDict.put(new Integer(BUQIYONG),"不启用");
			StatDict.put(new Integer(TONGJITU),"统计图");
			StatDict.put(new Integer(PINGGUBIAO),"评估表");
			
			//CheckType 选项类型
			
			CheckDict.put(new Integer(WHATUP),"上升原因");
			CheckDict.put(new Integer(WHATDOWN),"下降原因");
			
			//round 轮次
			RoundDict.put(new Integer(ONE),"第一轮");
			RoundDict.put(new Integer(TWO),"第二轮");
			
			
			selectTypeDict.put(new Integer(OPTION_TEMPLATE_TYPE), "选项模板");
			selectTypeDict.put(new Integer(OPTION_TYPE), "部分选项");			
			
		}
}
