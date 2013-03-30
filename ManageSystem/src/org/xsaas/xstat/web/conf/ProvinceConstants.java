package org.xsaas.xstat.web.conf;

import java.util.LinkedHashMap;

public class ProvinceConstants {

	//省份信息
	public static final int ANHUI = 1;
	public static final int AOMEN = 2;
	public static final int BEIJING = 3;
	public static final int FUJIAN = 4;
	public static final int GANSU = 5;
	public static final int GUANGDONG = 6;
	public static final int GUANGXI = 7;
	public static final int GUIZHOU = 8;
	public static final int HAINAN = 9;
	public static final int HEBEI = 10;
	public static final int HENAN = 11;
	public static final int HEILONGJIANG = 12;
	public static final int HUBEI = 13;
	public static final int HUNAN = 14;
	public static final int JILIN = 15;
	public static final int JIANGSU = 16;
	public static final int JIANGXI = 17;
	public static final int LIAONING = 18;
	public static final int NEIMENGGU = 19;
	public static final int NINGXIA = 20;
	public static final int CHONGQING = 21;
	public static final int QINGHAI = 22;
	public static final int SHANDONG = 23;
	public static final int SHANXI = 24;
	public static final int SANXI = 25;
	public static final int SHANGHAI = 26;
	public static final int SICHUANG = 27;
	public static final int TAIWAN = 28;
	public static final int TIANJING = 29;
	public static final int XIZANG = 30;
	public static final int XIANGGANG = 31;
	public static final int XINJING = 32;
	public static final int YUNNAN = 33;
	public static final int ZHEJIANG = 34;
	public static final int QITA = 35;

	
	public static final int CHINA = 100;
	
	public static LinkedHashMap<Integer,String> provinceDict;
	
	public static LinkedHashMap<Integer,String> countryDict;
	
	static{
		
		provinceDict = new LinkedHashMap<Integer,String>();
			
		countryDict = new LinkedHashMap<Integer,String>();
	
		provinceDict.put(new Integer(ANHUI),"安徽");
		provinceDict.put(new Integer(AOMEN),"澳门");
		provinceDict.put(new Integer(BEIJING),"北京");
		provinceDict.put(new Integer(FUJIAN),"福建");
		provinceDict.put(new Integer(GANSU),"甘肃");
		provinceDict.put(new Integer(GUANGDONG),"广东");
		provinceDict.put(new Integer(GUANGXI),"广西");
		provinceDict.put(new Integer(GUIZHOU),"贵州");
		provinceDict.put(new Integer(HAINAN),"海南");
		provinceDict.put(new Integer(HEBEI),"河北");
		provinceDict.put(new Integer(HENAN),"河南");
		provinceDict.put(new Integer(HEILONGJIANG),"黑龙江");
		provinceDict.put(new Integer(HUBEI),"湖北");
		provinceDict.put(new Integer(HUNAN),"湖南");
		provinceDict.put(new Integer(JILIN),"吉林");
		provinceDict.put(new Integer(JIANGSU),"江苏");
		provinceDict.put(new Integer(JIANGXI),"江西");
		provinceDict.put(new Integer(LIAONING),"辽宁");
		provinceDict.put(new Integer(NEIMENGGU),"内蒙古");
		provinceDict.put(new Integer(NINGXIA),"宁夏");
		provinceDict.put(new Integer(CHONGQING),"重庆");
		provinceDict.put(new Integer(QINGHAI),"青海");
		provinceDict.put(new Integer(SHANDONG),"山东");
		provinceDict.put(new Integer(SHANXI),"山西");
		provinceDict.put(new Integer(SANXI),"陕西");
		provinceDict.put(new Integer(SHANGHAI),"上海");
		provinceDict.put(new Integer(SICHUANG),"四川");
		provinceDict.put(new Integer(TAIWAN),"台湾");
		provinceDict.put(new Integer(TIANJING),"天津");
		provinceDict.put(new Integer(XIZANG),"西藏");
		provinceDict.put(new Integer(XIANGGANG),"香港");
		provinceDict.put(new Integer(XINJING),"新疆");
		provinceDict.put(new Integer(YUNNAN),"云南");
		provinceDict.put(new Integer(ZHEJIANG),"浙江");
		provinceDict.put(new Integer(QITA),"其他");
		
		  
		countryDict.put(new Integer(CHINA),"中国");
	}
}

