package cn.iaicc.smgk.web.conf;

import java.util.LinkedHashMap;

public class DelStatusConstants {

	public static final int CLIENT = 1;	
	public static final int CLIENTACCOUNT = 2;
	public static final int PROJECT = 3;	  
	public static final int ISSUE = 4;
	public static final int INFORMANT = 5;	
	public static final int SMGK = 6;	
	public static final int ARTICLE = 7;
	public static final int PUBLISH = 8;	
	public static final int TEMPLATEREPORT = 9;
	public static final int PLAN = 10;	  
	public static final int MAKEEXAM = 11;
	public static final int HEADER = 12;	
	public static final int MAKEPART = 13;	
	public static final int STYLE = 14;
//	public static final int GRADE = 14;
	public static final int WEIGHT = 15;	
	public static final int CRITIQUE = 16;
	public static final int QUESTION = 17;	  
	public static final int SELECTMANAGE = 18;
	public static final int RESOURCE = 19;	
	public static final int JASPERREPORT = 20;	
	public static final int THEME = 21;
	public static final int REPORT = 22;	
	public static final int SEND = 23;
	public static final int DRAFT = 24;	  
	public static final int CATALOG = 25;
	public static final int ADDRESS = 26;	
	public static final int EMPLOYEE = 27;	
	public static final int CITY = 28;
	public static final int MENU = 29;	
	public static final int VIDEO = 30;
	public static final int CHECK = 31;
	public static final int REALITY = 32;

	
	public static LinkedHashMap<Integer,String> DelStatusDict;
	
	static{
		DelStatusDict = new LinkedHashMap<Integer,String>();
		
		DelStatusDict.put(new Integer(CLIENT),"客户管理");	
		DelStatusDict.put(new Integer(CLIENTACCOUNT),"帐户管理");	
		DelStatusDict.put(new Integer(PROJECT),"调查项目");	  
		DelStatusDict.put(new Integer(ISSUE),"期次管理");
		DelStatusDict.put(new Integer(INFORMANT),"调查对象");	
		DelStatusDict.put(new Integer(SMGK),"神秘顾客");	
		DelStatusDict.put(new Integer(ARTICLE),"文章管理");
		DelStatusDict.put(new Integer(PUBLISH),"发布管理");	
		DelStatusDict.put(new Integer(TEMPLATEREPORT),"模板管理");	
		DelStatusDict.put(new Integer(PLAN),"计划管理");	  
		DelStatusDict.put(new Integer(MAKEEXAM),"问卷管理");
		DelStatusDict.put(new Integer(HEADER),"表头管理");	
		DelStatusDict.put(new Integer(MAKEPART),"部分管理");	
		//DelStatusDict.put(new Integer(GRADE),"评分管理");
		DelStatusDict.put(new Integer(WEIGHT),"选项权重");	
		DelStatusDict.put(new Integer(CRITIQUE),"评语管理");	
		DelStatusDict.put(new Integer(QUESTION),"问题管理");	  
		DelStatusDict.put(new Integer(SELECTMANAGE),"选项管理");
		DelStatusDict.put(new Integer(RESOURCE),"资源管理");	
		DelStatusDict.put(new Integer(JASPERREPORT),"模板管理");	
		DelStatusDict.put(new Integer(REPORT),"报告管理");	
		DelStatusDict.put(new Integer(SEND),"发送箱");	
		DelStatusDict.put(new Integer(DRAFT),"草稿箱");	  
		DelStatusDict.put(new Integer(CATALOG),"地址簿分类");
		DelStatusDict.put(new Integer(ADDRESS),"通讯地址簿");	
		DelStatusDict.put(new Integer(EMPLOYEE),"员工管理");	
		DelStatusDict.put(new Integer(CITY),"城市管理");
		DelStatusDict.put(new Integer(MENU),"菜单管理");	
		DelStatusDict.put(new Integer(VIDEO),"视频管理");
		DelStatusDict.put(new Integer(CHECK),"改进管理");
		DelStatusDict.put(new Integer(THEME),"主题管理");
		DelStatusDict.put(new Integer(STYLE),"风格管理");
		DelStatusDict.put(new Integer(REALITY),"分析管理");
		
	}
}
