package org.xsaas.xstat.web.conf;

import java.util.LinkedHashMap;

public class StatusConstants {

	
	//神秘顾客信息表状态
	public static final int ZHUCEWEIYAZHENG = 1;
	public static final int YANZHENGYITONGGUO = 2;
	public static final int YANZHENGWEITONGGUO = 3;
	

	//神秘顾客认证信息表
	public static final int ZHENGZAISHENGHE = 1;
	public static final int YANZHENGCHENGGONG = 2;
	public static final int YANZHENGSHIBAI = 3;
	
	
	//神秘顾客测试信息表
	public static final int WEIWANCHENG = 1;
	public static final int YIWANCHENG = 2;
	
	
	//正常与删除
	public static final int ZHENGCHANG = 1;
	public static final int SHANCHU = 2;

	//调查问卷信息表
	public static final int ZHENGZAIZUJUAN = 1;
	public static final int WUXIAOWENJUAN = 4;
	public static final int ZHENGZAIJIANCE = 2;
	public static final int JIANCEJIESU = 3;
	
	//调查检测信息表
	public static final int CZHENGZAIJIANCE = 1;
	public static final int CJIANCEJIESU = 2;

	
	//报告模板信息表
	public static final int YOUXIAO = 1;
	public static final int WUXIAO = 2;

	//申诉信息表
	public static final int SHENSHUQINGQIU = 1;
	public static final int CHULIWANBI = 2;
	public static final int WUXIAOSHENSHU = 3;
	
	//员工信息表
	public static final int ZAIZHI = 1;
	public static final int LIZHI = 2;
	
	//计划信息表
	public static final int PZHENGZAIJIANCE = 1;
	public static final int PWANCHENGJIANCE = 2;
	public static final int PJIANCEZUOFEI = 3;
	
	//正在翻译 完成翻译
	public static final int KAISHIFANYI = 1;
	public static final int WANCHENGFANYI = 2;

	// 帐号类型
	// 公司总部
	public static final int GONGSIZONGBU_TYPE = 1;
	// 片区经理
	public static final int PIANQUJINGLI_TYPE = 2;
	// 调查对象
	public static final int DIAOCHADUIXIANG_TYPE = 3;
	
	// 当年第一期
	public static final int FIRST_ISSE = 1;
	// 不是当年第一期
	public static final int NOTYEAR_ISSE = 2;
	
	
	//神秘顾客信息表状态
	public static LinkedHashMap<Integer,String> SmgStatusDict = null;
	
	//神秘顾客测试信息表
	public static LinkedHashMap<Integer,String> SmStatusDict = null;
	
	//神秘顾客认证信息表
	public static LinkedHashMap<Integer,String> AuStatusDict = null;
	
	//正常与删除
	public static LinkedHashMap<Integer,String> StatusDict = null;
	
	//调查问卷信息表
	public static LinkedHashMap<Integer,String> InStatusDict = null;
	
	//调查检测信息表
	public static LinkedHashMap<Integer,String> CStatusDict = null;
	
	//报告模板信息表
	public static LinkedHashMap<Integer,String> JaStatusDict = null;
	
	//申诉信息表
	public static LinkedHashMap<Integer,String> ReStatusDict = null;
	
	//员工信息表
	public static LinkedHashMap<Integer,String> EmStatusDict = null;

	//计划信息表
	public static LinkedHashMap<Integer,String> PlanStatusDict = null;
	
	//正在翻译 完成翻译
	public static LinkedHashMap<Integer,String> RemarkDict = null;
	
	//删除状态
	public static LinkedHashMap<Integer,String> DeleteDict = null;
	
	public static LinkedHashMap<Integer,String> AccountTypeDict = null;
	
	public static LinkedHashMap<Integer,String> FirstYearDict = null;
	
	//**********************************
	static {
	//神秘顾客信息表状态
		SmgStatusDict = new LinkedHashMap<Integer,String>();
	
	//神秘顾客测试信息表
		SmStatusDict = new LinkedHashMap<Integer,String>();
	
	//神秘顾客认证信息表
		AuStatusDict = new LinkedHashMap<Integer,String>();
	
	//正常与删除
		StatusDict = new LinkedHashMap<Integer,String>();
	
	//调查问卷信息表
		InStatusDict = new LinkedHashMap<Integer,String>();
	
	
	//调查检测信息表
		CStatusDict = new LinkedHashMap<Integer,String>();
		
	//报告模板信息表
		JaStatusDict = new LinkedHashMap<Integer,String>();
	
	//申诉信息表
		ReStatusDict = new LinkedHashMap<Integer,String>();
	
	//员工信息表
		EmStatusDict = new LinkedHashMap<Integer,String>();
		
	//计划信息表
		PlanStatusDict = new LinkedHashMap<Integer,String>();		

		//正在翻译 完成翻译
		RemarkDict = new LinkedHashMap<Integer,String>();
		
		
		AccountTypeDict = new LinkedHashMap<Integer,String>();		
		
		FirstYearDict = new LinkedHashMap<Integer,String>();
		
		
		//*********************************************************************
		
		//神秘顾客信息表状态
		SmgStatusDict.put(new Integer(ZHUCEWEIYAZHENG),"注册未验证");
		SmgStatusDict.put(new Integer(YANZHENGYITONGGUO),"验证已通过");
		SmgStatusDict.put(new Integer(YANZHENGWEITONGGUO),"验证未通过");
		
//		//神秘顾客测试信息表
//		SmStatusDict.put(new Integer(WEIWANCHENG),"末完成");
//		SmStatusDict.put(new Integer(YIWANCHENG),"已完成");
//		
		//神秘顾客认证信息表
		AuStatusDict.put(new Integer(ZHENGZAISHENGHE),"正在审核");
		AuStatusDict.put(new Integer(YANZHENGCHENGGONG),"验证成功");
		AuStatusDict.put(new Integer(YANZHENGSHIBAI),"验证失败");
				
		//正常与删除
		StatusDict.put(new Integer(ZHENGCHANG),"正常");
		StatusDict.put(new Integer(SHANCHU),"删除");
		
		
		//调查问卷信息表
		InStatusDict.put(new Integer(ZHENGZAIZUJUAN),"正在组卷");
		InStatusDict.put(new Integer(WUXIAOWENJUAN),"无效问卷");
		InStatusDict.put(new Integer(ZHENGZAIJIANCE),"正在检测");
		InStatusDict.put(new Integer(JIANCEJIESU),"检测结束");
		
		//调查检测信息表
		CStatusDict.put(new Integer(CZHENGZAIJIANCE),"正在检测");
		CStatusDict.put(new Integer(CJIANCEJIESU),"检测结束");
		
		//报告模板信息表
		JaStatusDict.put(new Integer(YOUXIAO),"有效");
		JaStatusDict.put(new Integer(WUXIAO),"无效");
		
		//申诉信息表
		ReStatusDict.put(new Integer(SHENSHUQINGQIU),"申诉请求");
		ReStatusDict.put(new Integer(CHULIWANBI),"处理完毕");
		ReStatusDict.put(new Integer(WUXIAOSHENSHU),"无效申诉");
				
		//员工信息表
		EmStatusDict.put(new Integer(ZAIZHI),"在职");
		EmStatusDict.put(new Integer(LIZHI),"离职");
		
		//计划信息表
		PlanStatusDict.put(new Integer(PZHENGZAIJIANCE),"正在检测");
		PlanStatusDict.put(new Integer(PWANCHENGJIANCE),"完成检测");
		PlanStatusDict.put(new Integer(PJIANCEZUOFEI),"检测作废");
		
		//正在翻译 完成翻译
		RemarkDict.put(new Integer(KAISHIFANYI),"开始翻译");
		RemarkDict.put(new Integer(WANCHENGFANYI),"完成翻译");
		
		// 帐号类型 
		AccountTypeDict.put(new Integer(GONGSIZONGBU_TYPE), "公司总部");
		AccountTypeDict.put(new Integer(PIANQUJINGLI_TYPE), "片区经理");
		AccountTypeDict.put(new Integer(DIAOCHADUIXIANG_TYPE), "调查对象");
		
		// 比较类型		
		FirstYearDict.put(new Integer(FIRST_ISSE), "当年第一期");
		FirstYearDict.put(new Integer(NOTYEAR_ISSE), "不是第一期");		
		
	}
}
