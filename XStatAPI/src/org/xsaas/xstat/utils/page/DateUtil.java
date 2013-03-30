package org.xsaas.xstat.utils.page;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class DateUtil {
	
	public static final SimpleDateFormat DATE_FORMAT_LONG = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	public static final SimpleDateFormat DATE_FORMAT_SHORT = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat DATE_FORMAT_MIDDLE = new SimpleDateFormat("yyyy-MM-dd HH-mm");
	public static final SimpleDateFormat DATE_FORMAT_LONG_ZH = new SimpleDateFormat("yyyy年MM月dd日 HH点mm分ss秒");
	public static final SimpleDateFormat DATE_FORMAT_SHORT_ZH = new SimpleDateFormat("yyyy年MM月dd日");
	public static final SimpleDateFormat DATE_FORMAT_MIDDLE_ZH = new SimpleDateFormat("yyyy年MM月dd日 HH点mm分");
	public static final SimpleDateFormat DATE_FORMAT_DATETOWEEK_ZH = new SimpleDateFormat("MM月dd日");
	
	/**
	 * 特价菜增加日历
	 * @author hanwei (hanwei.1980@hotmail.com)
	 * Create on Apr 1, 2009 10:01:13 AM
	 * @param week	日历翻到第几周，默认为当前周
	 * @param year	日历翻到哪一年，默认为当前年
	 * @return
	 */
	public static HashMap<String ,Object> getDateToWeek(int week , int year){
		Calendar calendar = Calendar.getInstance(Locale.UK);
		//周和年不为空时候，翻到日历到指定的某年某周
		if (week != 0 && year != 0) {
			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.WEEK_OF_YEAR, week);
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		//设置周一是几月几号
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		map.put("monday", DATE_FORMAT_DATETOWEEK_ZH.format(calendar.getTime()));
		map.put("starttime", DATE_FORMAT_SHORT.format(calendar.getTime()));
		//设置周二是几月几号
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		map.put("tuesday", DATE_FORMAT_DATETOWEEK_ZH.format(calendar.getTime()));
		//设置周三是几月几号
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		map.put("wednesday", DATE_FORMAT_DATETOWEEK_ZH.format(calendar.getTime()));
		//设置周四是几月几号
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		map.put("thursday", DATE_FORMAT_DATETOWEEK_ZH.format(calendar.getTime()));
		//设置周五是几月几号
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		map.put("friday", DATE_FORMAT_DATETOWEEK_ZH.format(calendar.getTime()));
		//设置周六是几月几号
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		map.put("saturday", DATE_FORMAT_DATETOWEEK_ZH.format(calendar.getTime()));
		//设置周日是几月几号
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		map.put("sunday", DATE_FORMAT_DATETOWEEK_ZH.format(calendar.getTime()));
		map.put("endtime", DATE_FORMAT_SHORT.format(calendar.getTime()));
		//设置当前是今年的第几周
		map.put("week", calendar.get(Calendar.WEEK_OF_YEAR));
		//上一年
		map.put("year", calendar.get(Calendar.YEAR));
		//当前年，当不跨年的时候cyear=year，即上一年等于当前年
		map.put("cyear", map.get("year"));
		//设置上一周，相对于当前周
		calendar.add(Calendar.WEEK_OF_YEAR,-1);
		map.put("preweek", calendar.get(Calendar.WEEK_OF_YEAR));
		//从新设置当前周
		calendar.set(Calendar.WEEK_OF_YEAR, (Integer)map.get("week"));
		//设置下一周，相对于当前周
		calendar.add(Calendar.WEEK_OF_YEAR,1);
		map.put("nextweek", calendar.get(Calendar.WEEK_OF_YEAR));

		//跨年的情况处理
		if ((Integer)map.get("preweek") > (Integer)map.get("nextweek")) {
			calendar.add(Calendar.YEAR, 1);
			map.put("nextyear", calendar.get(Calendar.YEAR));
			if (year == 0 ) {
				year = (Integer)map.get("year");
			}
			if ((Integer)map.get("week") == 1) {
				map.put("cyear", map.get("nextyear"));
			}else{
				map.put("cyear", year);
			}
		}else{
			map.put("nextyear", map.get("year"));
		}
		return map;
	}


	public static void main(String args[]){
		HashMap<String ,Object> map = getDateToWeek(1,2010);
		for (Object o : map.keySet()) {
			System.out.println(map.get(o));
		}
	}
}
