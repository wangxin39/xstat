package org.xsaas.xstat.web.conf;

import java.util.LinkedHashMap;

public class EducationConstants {

	public static final int CHUZHONG = 101;	
	public static final int GAOZHONG = 102;
	public static final int DAZHUAN = 103;	  
	public static final int BENKE = 104;
	public static final int SUOSHI = 105;	
	public static final int BOSHI = 106;	
	public static final int UQITA = 107;
	
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
