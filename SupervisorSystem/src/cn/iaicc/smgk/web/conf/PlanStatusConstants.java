package cn.iaicc.smgk.web.conf;

import java.util.LinkedHashMap;
import java.util.Map;

public class PlanStatusConstants {
	// 状态
	public final static int NOT_STATUS = 1;
	public final static int START_STATUS = 2;
	public final static int END_STATUS = 3;
	
	// 权重模式
	public final static int GENERAL = 1;
	public final static int INFORMANT = 2;
	
	
	public final static int BEGIN_CHECKSTATUS = 1;
	public final static int OVER_CHECKSTATUS = 2;
	public final static int NOT_CHECKSTATUS = 3;
	
	//weght 权重模式
	public static Map<Integer,String> weightDict = null;	
	public static Map<Integer, String> statusMap = null;	
	public static Map<Integer, String> checkMap = null;	
	
	static{
		weightDict = new LinkedHashMap<Integer,String>();			
		weightDict.put(new Integer(GENERAL),"通用权重");
		weightDict.put(new Integer(INFORMANT),"个性权重");
		
		
		statusMap = new LinkedHashMap<Integer, String>();			
		statusMap.put(new Integer(NOT_STATUS), "末开始");
		statusMap.put(new Integer(START_STATUS), "开始中");
		statusMap.put(new Integer(END_STATUS), "已完成");

		checkMap = new LinkedHashMap<Integer, String>();			
		checkMap.put(new Integer(BEGIN_CHECKSTATUS), "正在检测");
		checkMap.put(new Integer(OVER_CHECKSTATUS), "检测结束");
		checkMap.put(new Integer(NOT_CHECKSTATUS), "检测作废");
		
	}
	
}
