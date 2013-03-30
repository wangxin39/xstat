package org.xsaas.xstat.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

public class AppUtil {
	private static final Logger log = LoggerFactory.getLogger(AppUtil.class);

	private AppUtil() {

	}

	/*****
	 *字符串转换为整形
	 * 
	 * @param value
	 * @return
	 */
	public static int ObjectToInt(Object value) {
		int va = 0;
		try {
			if (value != null)
				va = Integer.parseInt(String.valueOf(value));
		} catch (Exception ex) {
			log.error(ex.getMessage());
			ex.printStackTrace();
		}
		return va;
	}

	/*****
	 *字符串转换为long
	 * 
	 * @param value
	 * @return
	 */
	public static long ObjectToLong(Object value) {
		long va = 0;
		try {
			if (value != null)
				va = Long.valueOf(String.valueOf(value));
		} catch (Exception ex) {
			log.error(ex.getMessage());
			ex.printStackTrace();
		}
		return va;
	}

	/*****
	 * 日期转换为字符串
	 * 
	 * @param value
	 * @param type
	 * @return
	 */
	public static String DateToString(Date value, String type) {
		SimpleDateFormat df = new SimpleDateFormat(type);
		String str = null;
		try {
			str = df.format(value);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error("DateToString is error !!");
		}
		return str;
	}

	/*****
	 * 日期转换为字符串
	 * 
	 * @param value
	 * @param type
	 * @return
	 */
	public static String DateToString(Date value) {
		SimpleDateFormat df = new SimpleDateFormat();
		String str = null;
		try {
			str = df.format(value);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error("DateToString is error !!");
		}
		return str;
	}

	/*****
	 * 字符串转换为日期
	 * 
	 * @param value
	 * @param type
	 * @return
	 */
	public static Date StringToDate(String value, String type) {
		SimpleDateFormat df = new SimpleDateFormat(type);
		Date str = null;
		try {
			str = df.parse(value);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error("StringToDate is error !!");
		}
		return str;
	}

	/******
	 * Object 转换 float
	 * 
	 * @param key
	 * @return
	 */
	public static float ObjectToFloat(Object key) {
		float value = 0;
		try {
			if (null != key && !String.valueOf(key).equalsIgnoreCase("null"))
				value = Float.valueOf(String.valueOf(key));

		} catch (Exception ex) {
			ex.printStackTrace();
			log.error("ObjectToFloat is error !!! ");
		}

		return value;
	}

	/*******
	 * 订单类型转换
	 * 
	 * @param type
	 * @return
	 */
	public static String getOrderState(int type) {
		String value = null;
		switch (type) {
		case 1:
			value = "等待确认";
			break;
		case 2:
			value = "订单作废";
			break;
		case 3:
			value = "客人确认订单";
			break;
		case 4:
			value = "订单作废";
			break;
		case 5:
			value = "饭店取消";
			break;
		case 6:
			value = "客人未去用餐";
			break;
		case 7:
			value = "餐厅无法就餐";
			break;
		case 8:
			value = "成功用餐";
			break;
		case 9:
			value = "餐厅确认";
			break;
		case 10:
			value = "客人准备去用餐";
			break;
		case 11:
			value = "客人已回访";
			break;
		case 12:
			value = "餐厅确认取消订单";
			break;
		case 13:
			value = "客人修改订单";
			break;
		case 14:
			value = "客人取消订单";
			break;
		case 15:
			value = "餐厅不接受预定";
			break;

		}
		return value;
	}

	/******
	 * 计算日期相差几天
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int SubtractForDate(String startDate, String endDate) {
		long DAY = 24L * 60L * 60L * 1000L;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = null;
		Date d2 = null;
		int num = 0;
		try {
			d1 = df.parse(startDate);
			d2 = df.parse(endDate);
			num = (int) ((d2.getTime() - d1.getTime()) / DAY);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	/******
	 * 计算日期相差几天
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int SubtractForDate(Date startDate, Date endDate) {
		long DAY = 24L * 60L * 60L * 1000L;
		int num = 0;
		try {
			num = (int) ((startDate.getTime() - endDate.getTime()) / DAY);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	/******
	 * MD5加密
	 * 
	 * @param data
	 * @return
	 */
	public static String hash(String data) {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("MD5");
			digest.update(data.getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return encodeHex(digest.digest());
	}

	/*****
	 * 返回固定长度
	 * 
	 * @param bytes
	 * @return
	 */
	private static String encodeHex(byte[] bytes) {
		StringBuffer buf = new StringBuffer(bytes.length * 2);
		int i;
		for (i = 0; i < bytes.length; i++) {
			if ((bytes[i] & 0xff) < 0x10) {
				buf.append("0");
			}
			buf.append(Long.toString(bytes[i] & 0xff, 16));
		}
		return buf.toString().toUpperCase();
	}

	/**
	 * sha-1二次散列加密
	 * @return
	 */
	public static String SHA1(String data) {
		return DigestUtils.shaHex(DigestUtils.sha(data.getBytes()));
	}

	/**
	 * md5二次散列加密
	 * @param data
	 * @return
	 */
	public static String MD5(String data) {
		return DigestUtils.md5Hex(DigestUtils.md5(data.getBytes()));
	}

	public static Gson gson() {
		return new Gson();
	}

}
