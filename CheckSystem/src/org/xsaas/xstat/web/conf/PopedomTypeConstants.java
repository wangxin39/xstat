package org.xsaas.xstat.web.conf;

import java.util.HashMap;

/**
 * 神秘顾客网络管理系统所有权限类型定义
 * @author wangxin
 *
 * 	使用方式，在具体操作时，检查当前页是否具有该操作的权限
 *  如该用户的权限哈希表。
 *	UserInfo.hashMap.get(PopedomTypeConstants.CLIENT_ADD) //如果返回true，则具有该权限
 */
public class PopedomTypeConstants {

	/*
	111	增加客户	客户管理(110)
	112	修改客户	客户管理(110)
	113	浏览客户	客户管理(110)
	114	删除客户	客户管理(110)
	 */
	public static final int CUSTOMER_ADD = 111;
	public static final int CUSTOMER_EDIT = 112;
	public static final int CUSTOMER_LIST = 113;
	public static final int CUSTOMER_DELETE = 114;
	
	/*
	121	增加神秘顾客	神秘顾客管理(120)
	122	修改神秘顾客	神秘顾客管理(120)
	123	浏览神秘顾客	神秘顾客管理(120)
	124	删除神秘顾客	神秘顾客管理(120)
	 */
	public static final int CLIENT_ADD = 121;
	public static final int CLIENT_EDIT = 122;
	public static final int CLIENT_LIST = 123;
	public static final int CLIENT_DELETE = 124;
	
	
	/*
	131	增加网站	网站管理(130)
	132	修改网站	网站管理(130)
	133	浏览网站	网站管理(130)
	134	删除网站	网站管理(130)
	 */
	public static final int SITE_ADD = 131;
	public static final int SITE_EDIT = 132;
	public static final int SITE_LIST = 133;
	public static final int SITE_DELETE = 134;
	
	
	public static HashMap<Integer, Boolean> sitePopedom;		
	public static HashMap<Integer, String> sitePopedomDict;	
	
	public static HashMap<Integer, Boolean> smgkPopedom;		
	public static HashMap<Integer, String> smgkPopedomDict;	
	
	public static HashMap<Integer, Boolean> clientPopedom;		
	public static HashMap<Integer, String> clientPopedomDict;	
	static{
		sitePopedom = new HashMap<Integer,Boolean>();
		sitePopedomDict = new HashMap<Integer, String>();
		
		smgkPopedom = new HashMap<Integer,Boolean>();
		smgkPopedomDict = new HashMap<Integer, String>();
		
		clientPopedom = new HashMap<Integer,Boolean>();
		clientPopedomDict = new HashMap<Integer, String>();
		
		/**
		 * 神秘顾客权限
		 */
		
		smgkPopedom.put(new Integer(CUSTOMER_ADD),new Boolean(true));
		smgkPopedom.put(new Integer(CUSTOMER_EDIT),new Boolean(true));
		smgkPopedom.put(new Integer(CUSTOMER_LIST),new Boolean(true));
		smgkPopedom.put(new Integer(CUSTOMER_DELETE),new Boolean(true));
		
		smgkPopedomDict.put(new Integer(CUSTOMER_ADD), "增加神秘顾客");
		smgkPopedomDict.put(new Integer(CUSTOMER_EDIT), "修改神秘顾客");
		smgkPopedomDict.put(new Integer(CUSTOMER_LIST), "浏览神秘顾客");
		smgkPopedomDict.put(new Integer(CUSTOMER_DELETE), "删除神秘顾客");
		
		/**
		 * 客户权限
		 */
		
		clientPopedom.put(new Integer(CLIENT_ADD),new Boolean(true));
		clientPopedom.put(new Integer(CLIENT_EDIT),new Boolean(true));
		clientPopedom.put(new Integer(CLIENT_LIST),new Boolean(true));
		clientPopedom.put(new Integer(CLIENT_DELETE),new Boolean(true));
		
		clientPopedomDict.put(new Integer(CLIENT_ADD), "增加客户");
		clientPopedomDict.put(new Integer(CLIENT_EDIT), "修改客户");
		clientPopedomDict.put(new Integer(CLIENT_LIST), "浏览客户");
		clientPopedomDict.put(new Integer(CLIENT_DELETE), "删除客户");
		
		/**
		 * 网站权限
		 */
		
		sitePopedom.put(new Integer(SITE_ADD),new Boolean(true));
		sitePopedom.put(new Integer(SITE_EDIT),new Boolean(true));
		sitePopedom.put(new Integer(SITE_LIST),new Boolean(true));
		sitePopedom.put(new Integer(SITE_DELETE),new Boolean(true));
		
		sitePopedomDict.put(new Integer(SITE_ADD), "增加网站");
		sitePopedomDict.put(new Integer(SITE_EDIT), "修改网站");
		sitePopedomDict.put(new Integer(SITE_LIST), "浏览网站");
		sitePopedomDict.put(new Integer(SITE_DELETE), "删除网站");
	}
}
