package org.xsaas.xstat.utils.page;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class DateUtil {
	
	public static final SimpleDateFormat DATE_FORMAT_LONG = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	public static final SimpleDateFormat DATE_FORMAT_SHORT = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat DATE_FORMAT_MIDDLE = new SimpleDateFormat("yyyy-MM-dd HH-mm");
	public static final SimpleDateFormat DATE_FORMAT_LONG_ZH = new SimpleDateFormat("yyyy��MM��dd�� HH��mm��ss��");
	public static final SimpleDateFormat DATE_FORMAT_SHORT_ZH = new SimpleDateFormat("yyyy��MM��dd��");
	public static final SimpleDateFormat DATE_FORMAT_MIDDLE_ZH = new SimpleDateFormat("yyyy��MM��dd�� HH��mm��");
	public static final SimpleDateFormat DATE_FORMAT_DATETOWEEK_ZH = new SimpleDateFormat("MM��dd��");
	
	/**
	 * �ؼ۲���������
	 * @author hanwei (hanwei.1980@hotmail.com)
	 * Create on Apr 1, 2009 10:01:13 AM
	 * @param week	���������ڼ��ܣ�Ĭ��Ϊ��ǰ��
	 * @param year	����������һ�꣬Ĭ��Ϊ��ǰ��
	 * @return
	 */
	public static HashMap<String ,Object> getDateToWeek(int week , int year){
		Calendar calendar = Calendar.getInstance(Locale.UK);
		//�ܺ��겻Ϊ��ʱ�򣬷���������ָ����ĳ��ĳ��
		if (week != 0 && year != 0) {
			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.WEEK_OF_YEAR, week);
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		//������һ�Ǽ��¼���
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		map.put("monday", DATE_FORMAT_DATETOWEEK_ZH.format(calendar.getTime()));
		map.put("starttime", DATE_FORMAT_SHORT.format(calendar.getTime()));
		//�����ܶ��Ǽ��¼���
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		map.put("tuesday", DATE_FORMAT_DATETOWEEK_ZH.format(calendar.getTime()));
		//���������Ǽ��¼���
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		map.put("wednesday", DATE_FORMAT_DATETOWEEK_ZH.format(calendar.getTime()));
		//���������Ǽ��¼���
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		map.put("thursday", DATE_FORMAT_DATETOWEEK_ZH.format(calendar.getTime()));
		//���������Ǽ��¼���
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		map.put("friday", DATE_FORMAT_DATETOWEEK_ZH.format(calendar.getTime()));
		//���������Ǽ��¼���
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		map.put("saturday", DATE_FORMAT_DATETOWEEK_ZH.format(calendar.getTime()));
		//���������Ǽ��¼���
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		map.put("sunday", DATE_FORMAT_DATETOWEEK_ZH.format(calendar.getTime()));
		map.put("endtime", DATE_FORMAT_SHORT.format(calendar.getTime()));
		//���õ�ǰ�ǽ���ĵڼ���
		map.put("week", calendar.get(Calendar.WEEK_OF_YEAR));
		//��һ��
		map.put("year", calendar.get(Calendar.YEAR));
		//��ǰ�꣬���������ʱ��cyear=year������һ����ڵ�ǰ��
		map.put("cyear", map.get("year"));
		//������һ�ܣ�����ڵ�ǰ��
		calendar.add(Calendar.WEEK_OF_YEAR,-1);
		map.put("preweek", calendar.get(Calendar.WEEK_OF_YEAR));
		//�������õ�ǰ��
		calendar.set(Calendar.WEEK_OF_YEAR, (Integer)map.get("week"));
		//������һ�ܣ�����ڵ�ǰ��
		calendar.add(Calendar.WEEK_OF_YEAR,1);
		map.put("nextweek", calendar.get(Calendar.WEEK_OF_YEAR));

		//������������
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
