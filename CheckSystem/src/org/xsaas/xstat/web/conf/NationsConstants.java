package org.xsaas.xstat.web.conf;

import java.util.LinkedHashMap;


public class NationsConstants {

	//民族信息
	
	public static final int HANZU = 100;
	public static final int MANZU = 101;
	public static final int HUIZU = 102;
	public static final int MIAOZU = 103;
	public static final int MENGGUZU = 104;
	public static final int DAIZU = 105;
	public static final int HANIZU = 106;
	public static final int DAHANERZU = 107;
	public static final int BENGLONGZU = 108;
	public static final int HASAKEZU = 109;
	public static final int MOLAOZU = 110;
	public static final int BAOANZU = 111;
	public static final int YUGUZU = 112;
	public static final int JINGZU = 113;
	public static final int BULANGZU = 114;
	public static final int LIZU = 115;
	public static final int ZANGZU = 116;
	public static final int WEIWUERZU = 117;
	public static final int SULIZU = 118;
	public static final int SALAZU = 119;
	public static final int TATAERZU = 120;
	public static final int DULONGZU = 121;
	public static final int ELUNCHUNZU = 122;
	public static final int MAONANZU = 123;
	public static final int WAZU = 124;
	public static final int QILAOZU = 125;
	public static final int YUZU = 126;
	public static final int YIZU = 127;
	public static final int GAOSHANZU = 128;
	public static final int ZHUANGZU = 129;
	public static final int XIBOZU = 130;
	public static final int HEZHEZU = 131;
	public static final int MENBAZU = 132;
	public static final int GEBAZU = 133;
	public static final int ACHANGZU = 134;
	public static final int LAGUZU = 135;
	public static final int PUMIZU = 136;
	public static final int SHUIZU = 137;
	public static final int BUYIZU = 138;
	public static final int CHAOXIANZU = 139;
	public static final int JINUOZU = 140;
	public static final int TAJIKEZU = 141;
	public static final int DONGXIANGZU = 142;
	public static final int NUZU = 143;
	public static final int TONGZU = 144;
	public static final int NAXIZU = 145;	
	public static final int WUZIBIEKEZU = 146;
	public static final int ELUOSIZU = 147;	
	public static final int TUJIAZU = 148;	
	public static final int BAIZU = 149;
	public static final int YAOZU = 150;	
	public static final int JINGPOZU = 151;
	public static final int KEERKEZIZU = 152;	
	public static final int TUZU = 153;
	public static final int EWENKEZU = 154;	
	public static final int QITA = 155;
	public static final int QIANZU = 156;
	public static final int WAIGUO = 157;	
		
	public static LinkedHashMap<Integer,String> nationDict;
	
	static {
		nationDict = new LinkedHashMap<Integer,String>();		
		
		nationDict.put(new Integer(HANZU),"汉族");
		nationDict.put(new Integer(HUIZU),"回族");
		nationDict.put(new Integer(MIAOZU),"苗族");
		nationDict.put(new Integer(MANZU),"满族");
		nationDict.put(new Integer(TUZU),"土族");
		nationDict.put(new Integer(YAOZU),"瑶族");
		nationDict.put(new Integer(BAIZU),"白族");
		nationDict.put(new Integer(TONGZU),"侗族");
		nationDict.put(new Integer(DAIZU),"傣族");
		nationDict.put(new Integer(QIANZU),"羌族");
		nationDict.put(new Integer(JINGZU),"京族");
		nationDict.put(new Integer(LIZU),"黎族");
		nationDict.put(new Integer(ZANGZU),"藏族");
		nationDict.put(new Integer(WAZU),"佤族");
		nationDict.put(new Integer(YUZU),"畲族");
		nationDict.put(new Integer(YIZU),"彝族");
		nationDict.put(new Integer(ZHUANGZU),"壮族");
		nationDict.put(new Integer(SHUIZU),"水族");
		nationDict.put(new Integer(NUZU),"怒族");
		nationDict.put(new Integer(TUJIAZU),"土家族");
		nationDict.put(new Integer(JINGPOZU),"景颇族");
		nationDict.put(new Integer(NAXIZU),"纳西族");
		nationDict.put(new Integer(MENGGUZU),"蒙古族");
		nationDict.put(new Integer(HANIZU),"哈尼族");
		nationDict.put(new Integer(BENGLONGZU),"崩龙族");
		nationDict.put(new Integer(HASAKEZU),"哈萨克族");
		nationDict.put(new Integer(MOLAOZU),"仫佬族");
		nationDict.put(new Integer(BAOANZU),"保安族");
		nationDict.put(new Integer(YUGUZU),"裕固族");
		nationDict.put(new Integer(BULANGZU),"布朗族");
		nationDict.put(new Integer(SULIZU),"傈僳族");
		nationDict.put(new Integer(SALAZU),"撒拉族");
		nationDict.put(new Integer(DULONGZU),"独龙族");
		nationDict.put(new Integer(MAONANZU),"毛难族");
		nationDict.put(new Integer(QILAOZU),"仡佬族");
		nationDict.put(new Integer(GAOSHANZU),"高山族");
		nationDict.put(new Integer(XIBOZU),"锡伯族");
		nationDict.put(new Integer(HEZHEZU),"赫哲族");
		nationDict.put(new Integer(PUMIZU),"普米族");
		nationDict.put(new Integer(MENBAZU),"门巴族");
		nationDict.put(new Integer(GEBAZU),"珞巴族");
		nationDict.put(new Integer(ACHANGZU),"阿昌族");
		nationDict.put(new Integer(LAGUZU),"拉祜族");
		nationDict.put(new Integer(BUYIZU),"布依族");
		nationDict.put(new Integer(CHAOXIANZU),"朝鲜族");
		nationDict.put(new Integer(JINUOZU),"基诺族");
		nationDict.put(new Integer(TAJIKEZU),"塔吉克族");
		nationDict.put(new Integer(DONGXIANGZU),"东乡族");
		nationDict.put(new Integer(WEIWUERZU),"维吾尔族");
		nationDict.put(new Integer(ELUOSIZU),"俄罗斯族");
		nationDict.put(new Integer(EWENKEZU),"鄂温克族");		
		nationDict.put(new Integer(DAHANERZU),"达斡尔族");
		nationDict.put(new Integer(TATAERZU),"塔塔尔族");
		nationDict.put(new Integer(ELUNCHUNZU),"鄂伦春族");
		nationDict.put(new Integer(KEERKEZIZU),"柯尔克孜族");
		nationDict.put(new Integer(WUZIBIEKEZU),"乌孜别克族");
		nationDict.put(new Integer(WAIGUO),"外国血统");
		nationDict.put(new Integer(QITA),"其他民族");	
		
	}							
}
