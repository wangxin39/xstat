package cn.iaicc.smgk.web.conf;

import java.util.LinkedHashMap;

public class EducationConstants {

	public static final int CHUZHONG = 1;	
	public static final int GAOZHONG = 2;
	public static final int DAZHUAN = 3;	  
	public static final int BENKE = 4;
	public static final int SUOSHI = 5;	
	public static final int BOSHI = 6;	
	public static final int UQITA = 7;
	
	public static LinkedHashMap<Integer,String> educationDict;
	
	static{
		educationDict = new LinkedHashMap<Integer,String>();		
		educationDict.put(new Integer(CHUZHONG),"初中");	
		educationDict.put(new Integer(GAOZHONG),"高中");	
		educationDict.put(new Integer(DAZHUAN),"大专");	  
		educationDict.put(new Integer(BENKE),"本科");
		educationDict.put(new Integer(SUOSHI),"硕士");	
		educationDict.put(new Integer(BOSHI),"博士");	
		educationDict.put(new Integer(UQITA ),"其他");
	}
}
