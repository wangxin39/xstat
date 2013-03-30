package org.xsaas.xstat.web.conf;

import java.util.LinkedHashMap;

public class StatusConstants {

	//神秘顾客信息表状态
	public static final int ZHUCEWEIYAZHENG = 1;
	public static final int YANZHENGYITONGGUO = 2;
	public static final int YANZHENGWEITONGGUO = 3;
	
	//神秘顾客测试信息表
	public static final int WEIWANCHENG = 1;
	public static final int YIWANCHENG = 2;
	
	//神秘顾客认证信息表
	public static final int ZHENGZAISHENGHE = 1;
	public static final int YANZHENGCHENGGONG = 2;
	public static final int YANZHENGSHIBAI = 3;
	
	//正常与删除
	public static final int ZHENGCHANG = 1;
	public static final int SHANCHU = 2;

	//调查问卷信息表
	public static final int ZHENGZAIZUJUAN = 1;
	public static final int WUXIAOWENJUAN = 2;
	public static final int ZHENGZAIJIANCE = 3;
	public static final int JIANCEJIESU = 4;
	
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
	//**********************************
	
	
	//神秘顾客信息表状态
	public static LinkedHashMap<Integer,String> SmgStatusDict;
	
	//神秘顾客测试信息表
	public static LinkedHashMap<Integer,String> SmStatusDict;
	
	//神秘顾客认证信息表
	public static LinkedHashMap<Integer,String> AuStatusDict;
	
	//正常与删除
	public static LinkedHashMap<Integer,String> StatusDict;
	
	//调查问卷信息表
	public static LinkedHashMap<Integer,String> InStatusDict;
	
	//调查检测信息表
	public static LinkedHashMap<Integer,String> CStatusDict;
	
	//报告模板信息表
	public static LinkedHashMap<Integer,String> JaStatusDict;
	
	//申诉信息表
	public static LinkedHashMap<Integer,String> ReStatusDict;
	
	//员工信息表
	public static LinkedHashMap<Integer,String> EmStatusDict;

	//计划信息表
	public static LinkedHashMap<Integer,String> PlanStatusDict;
//**********************************
	static{
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
		
		//神秘顾客信息表状态
		SmgStatusDict.put(new Integer(ZHUCEWEIYAZHENG),"注册末验证");
		SmgStatusDict.put(new Integer(YANZHENGYITONGGUO),"验证已通过");
		SmgStatusDict.put(new Integer(YANZHENGWEITONGGUO),"验证末通过");
		
		//神秘顾客测试信息表
		SmStatusDict.put(new Integer(WEIWANCHENG),"末完成");
		SmStatusDict.put(new Integer(YIWANCHENG),"已完成");
		
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
	}
}
