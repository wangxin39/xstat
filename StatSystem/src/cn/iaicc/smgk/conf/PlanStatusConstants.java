package cn.iaicc.smgk.conf;

import java.util.LinkedHashMap;
import java.util.Map;

public class PlanStatusConstants {
	// ״̬
	public final static int NOT_STATUS = 1;
	public final static int START_STATUS = 2;
	public final static int END_STATUS = 3;
	
	// Ȩ��ģʽ
	public final static int GENERAL = 1;
	public final static int INFORMANT = 2;
	
	
	public final static int BEGIN_CHECKSTATUS = 1;
	public final static int OVER_CHECKSTATUS = 2;
	public final static int NOT_CHECKSTATUS = 3;
	
	//weght Ȩ��ģʽ
	public static Map<Integer,String> weightDict = null;	
	public static Map<Integer, String> statusMap = null;	
	public static Map<Integer, String> checkMap = null;	
	
	static{
		weightDict = new LinkedHashMap<Integer,String>();			
		weightDict.put(new Integer(GENERAL),"ͨ��Ȩ��");
		weightDict.put(new Integer(INFORMANT),"����Ȩ��");
		
		
		statusMap = new LinkedHashMap<Integer, String>();			
		statusMap.put(new Integer(NOT_STATUS), "ĩ��ʼ");
		statusMap.put(new Integer(START_STATUS), "��ʼ��");
		statusMap.put(new Integer(END_STATUS), "�����");

		checkMap = new LinkedHashMap<Integer, String>();			
		checkMap.put(new Integer(BEGIN_CHECKSTATUS), "���ڼ��");
		checkMap.put(new Integer(OVER_CHECKSTATUS), "������");
		checkMap.put(new Integer(NOT_CHECKSTATUS), "�������");
		
	}
}
