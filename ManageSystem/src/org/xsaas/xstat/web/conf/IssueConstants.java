package org.xsaas.xstat.web.conf;

import java.util.LinkedHashMap;

public class IssueConstants {
	
	public final static int NOT_STATUS = 1;
	public final static int START_STATUS = 2;
	public final static int END_STATUS = 3;
	
	public final static int INQUISITION_DO = 1;
	public final static int INQUISITION_STAT = 2;
	public final static int INQUISITION_EVALUATION = 3;
	public final static int INQUISITION_REPORT = 4;	
	
	public static LinkedHashMap<Integer, String> statusMap = null;
	public static LinkedHashMap<Integer, String> actionsMap = null;	
	static {
		statusMap = new LinkedHashMap<Integer, String>();
		actionsMap = new LinkedHashMap<Integer, String>();	
		
		statusMap.put(new Integer(NOT_STATUS), "末开始");
		statusMap.put(new Integer(START_STATUS), "开始中");
		statusMap.put(new Integer(END_STATUS), "已完成");
		
		actionsMap.put(new Integer(INQUISITION_DO), "问卷调查");
		actionsMap.put(new Integer(INQUISITION_STAT), "系统评分");
		actionsMap.put(new Integer(INQUISITION_EVALUATION), "人工评论");
		actionsMap.put(new Integer(INQUISITION_REPORT), "报告处理");
		
	}
}
