package cn.iaicc.smgk.conf;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Constants {
	// 默认输出目录
	public static final String OUTPUT_DIR = "outputs/";
	// 当前目录
	public static String CURRENT_DIR = null;
	// 日期格式
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	static {
		CURRENT_DIR = sdf.format(new Date());
	}
	
	private static int year = 0;
	private static int month = 0;
	private static int day = 0;
	
	public static List<Integer> init(Timestamp time) {
		List<Integer> list = new LinkedList<Integer>();
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		String sYear = df.format(time);
		df = new SimpleDateFormat("MM");
		String sMonth = df.format(time);
		df = new SimpleDateFormat("dd");
		String sDay = df.format(time);
		try{
			year = Integer.parseInt(sYear);
			month = Integer.parseInt(sMonth);			
			day = Integer.parseInt(sDay);
			
			list.add(year);
			list.add(month);
			list.add(day);
			
		}catch(Exception e) {
			
		}
		return list;
	}
}
