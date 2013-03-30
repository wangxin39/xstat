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
	 *�ַ���ת��Ϊ����
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
	 *�ַ���ת��Ϊlong
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
	 * ����ת��Ϊ�ַ���
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
	 * ����ת��Ϊ�ַ���
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
	 * �ַ���ת��Ϊ����
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
	 * Object ת�� float
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
	 * ��������ת��
	 * 
	 * @param type
	 * @return
	 */
	public static String getOrderState(int type) {
		String value = null;
		switch (type) {
		case 1:
			value = "�ȴ�ȷ��";
			break;
		case 2:
			value = "��������";
			break;
		case 3:
			value = "����ȷ�϶���";
			break;
		case 4:
			value = "��������";
			break;
		case 5:
			value = "����ȡ��";
			break;
		case 6:
			value = "����δȥ�ò�";
			break;
		case 7:
			value = "�����޷��Ͳ�";
			break;
		case 8:
			value = "�ɹ��ò�";
			break;
		case 9:
			value = "����ȷ��";
			break;
		case 10:
			value = "����׼��ȥ�ò�";
			break;
		case 11:
			value = "�����ѻط�";
			break;
		case 12:
			value = "����ȷ��ȡ������";
			break;
		case 13:
			value = "�����޸Ķ���";
			break;
		case 14:
			value = "����ȡ������";
			break;
		case 15:
			value = "����������Ԥ��";
			break;

		}
		return value;
	}

	/******
	 * ������������
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
	 * ������������
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
	 * MD5����
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
	 * ���ع̶�����
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
	 * sha-1����ɢ�м���
	 * @return
	 */
	public static String SHA1(String data) {
		return DigestUtils.shaHex(DigestUtils.sha(data.getBytes()));
	}

	/**
	 * md5����ɢ�м���
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
