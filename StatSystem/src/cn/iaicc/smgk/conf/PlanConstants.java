package cn.iaicc.smgk.conf;

import java.util.LinkedHashMap;

public class PlanConstants {
	
	public final static int NOT_STATUS = 1;
	public final static int START_STATUS = 2;
	public final static int END_STATUS = 3;
	
	public static LinkedHashMap<Integer, String> statusMap = null;
	static {
		statusMap = new LinkedHashMap<Integer, String>();
		
		statusMap.put(new Integer(NOT_STATUS), "末开始");
		statusMap.put(new Integer(START_STATUS), "开始中");
		statusMap.put(new Integer(END_STATUS), "已完成");
		
	}
}
