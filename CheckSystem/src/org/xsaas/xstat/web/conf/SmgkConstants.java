package org.xsaas.xstat.web.conf;

/**
 * 管理系统全局常量设置对象<br/>
 * 在此处设置全局常量<br/>
 * <br/>
 * 例:<br/>
 * <br/>
 * 	分页中用到了设置每页最大返回记录数<br/>
 *  int page = 1;<br/>
 *  if(num != null) page = num.intValue();<br/>
 *  int total = XXService.getXXTotal();<br/>
 *  //在此处使用<br/>
 *  PaginationUtil pu = new PaginationUtil(total,page,UrlConstants.PAGE_MAX_RESULT);<br/>
 *  List list = XXService.findXX(pu.getStartRecord(),UrlConstants.PAGE_MAX_RESULT);<br/>
 * 
 * @author wangxin
 * @version 0.1
 */
public class SmgkConstants {
	public static final String backend_title = "神秘顾客网络管理平台";
	public static final String fromMail = "wsitcxy@sina.com";
	public static final String encoding = "gb2312";
	/**
	 * 每页最大返回记录数,默认10条记录
	 */
	public static final int PAGE_MAX_RESULT = 10;
	/**
	 * 管理员权限类型常量
	 */
	public static final int ADMIN_POPEDOM_TYPE = 1;
	/**
	 * 编辑权限类型常量
	 */
	public static final int EDITOR_POPEDOM_TYPE = 1;	
	
}
