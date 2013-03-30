package cn.iaicc.smgk.web.action.manage.add;

import static cn.iaicc.smgk.web.conf.StatusConstants.ZHENGCHANG;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import cn.iaicc.smgk.business.IAddressCatalogInfoService;
import cn.iaicc.smgk.business.IEmailAddressInfoService;
import cn.iaicc.smgk.business.IEmailDraftInfoService;
import cn.iaicc.smgk.business.IEmailSendInfoService;
import cn.iaicc.smgk.business.IEmployeeInfoService;
import cn.iaicc.smgk.po.AddressCatalogInfo;
import cn.iaicc.smgk.po.EmailAddressInfo;
import cn.iaicc.smgk.po.EmailDraftInfo;
import cn.iaicc.smgk.po.EmailSendInfo;
import cn.iaicc.smgk.po.EmployeeInfo;
import cn.iaicc.smgk.web.conf.SmgkConstants;
import cn.iaicc.smgk.web.conf.StatusConstants;
import cn.iaicc.smgk.web.util.MailUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddSendActions extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2907110765258863578L;
	private static Log logger = LogFactory.getLog(AddSendActions.class);
	private IEmailSendInfoService emailSendInfoService = null;
	private IAddressCatalogInfoService addressCatalogInfoService = null;
	private IEmailAddressInfoService emailAddressInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;
	private IEmailDraftInfoService emailDraftInfoService = null;

	private static Log log = LogFactory.getLog(AddSendActions.class);
	private List<String> eList = new LinkedList<String>();
	private List<String> eaList = new LinkedList<String>();
	private List<String> acList = new LinkedList<String>();
	private Long addressID = null;
	private Long acID = null;
	private String sendTo = null;
	private Timestamp sendTime = null;
	private String att = null;
	private String topic = null;
	private String content = null;
	private Integer status = null;

	// 封装单个上传文件域的属性
	private File upload;
	// 封装单个上传文件类型的属性
	private String uploadContentType;
	// 封装单个上传文件名的属性
	private String uploadFileName;

	// 动态设置上传文件保存地址
	private String savePath;

	@SuppressWarnings("deprecation")
	public String getSavePath() {
		return ServletActionContext.getRequest().getRealPath(savePath);
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}


	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			String filterResult = filterType(new String[]{"text/plain","text/html"});
			if(filterResult != null) {
				ActionContext.getContext().put("typeError", "您要上传的文件类型不正确！正确格式是以flt为后缀名的文件！");
				return filterResult;
			}
		}catch(Exception e) {
			logger.error("upload|"+e.getMessage(),e.getCause());
		}

	
		if(log.isDebugEnabled()) {
			log.debug("uploadContentType:"+uploadContentType);			
		}
		// 上传单个文件
		try {
			// 以服务器的文件保存地址和原文件名建立上传文件输出流
			FileOutputStream fos = new FileOutputStream(getSavePath()+"//"+ getUploadFileName());
			// 以上传文件建立一个<SPAN class=hilite2>文件上传</SPAN>流
			FileInputStream fis = new FileInputStream(getUpload());
			// 将上传文件的内容写入服务器
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
			fos.flush();
			fos.close();
			fis.close();
		} catch (Exception e) {
			logger.error("addTemplateReport:"+e.getMessage(),e.getCause());			
		}		
		try{
			StringBuffer sb = new StringBuffer();	
			sb.append(content);						
			
			MailUtil.get().send(sendTo,SmgkConstants.fromMail,topic,sb.toString(),SmgkConstants.encoding);	

			String isOK = (String)ActionContext.getContext().getSession().get("CLIENTINPUTADDISOK");
			if(isOK != null && "OK".equals(isOK)) {
				EmailSendInfo info = new EmailSendInfo();

				if(addressID == null){
					ActionContext.getContext().put("nullError","通讯录名不能为空，请先添加通讯录信息!");
					return INPUT;
				}
				if(acID == null){
					ActionContext.getContext().put("nullError","分类名称不能为空，请先添加分类信息!");
					return INPUT;
				}
				long id = (Long) ActionContext.getContext().getSession().get("LOGINID");
				info.setAcID(acID);
				info.setAddressID(addressID);
				info.setAtt(att);
				info.setContent(content);
				info.setEmployeeID(id);
				info.setSendTime(new Timestamp(System.currentTimeMillis()));
				info.setSendTo(sendTo);
				info.setTopic(topic);
				info.setStatus(StatusConstants.ZHENGCHANG);
				EmailDraftInfo dInfo = new EmailDraftInfo();	
				dInfo.setAcID(acID);
				dInfo.setAddressID(addressID);
				dInfo.setAtt(att);
				dInfo.setContent(content);
				dInfo.setEmployeeID(id);
				dInfo.setSendTime(new Timestamp(System.currentTimeMillis()));
				dInfo.setSendTo(sendTo);
				dInfo.setTopic(topic);
				dInfo.setStatus(ZHENGCHANG);
				ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","NOT");					
				//发邮件
				MailUtil.get().send(sendTo,SmgkConstants.fromMail,topic,content,SmgkConstants.encoding);	
				

				emailSendInfoService.saveEmailSendInfo(info);
				emailDraftInfoService.saveEmailDraftInfo(dInfo);
			}
		}catch(Exception e) {
			logger.error("save|"+e.getMessage(),e.getCause());
		}		
		

		
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String input() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			
			if(username == null || password == null) {
				return LOGIN;
			}
			
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");//防止刷新提交多次相同信息
			List<EmployeeInfo> eList = employeeInfoService.getEmployeeInfoList();
			List<EmailAddressInfo> eaList = emailAddressInfoService.getEmailAddressInfoList();
			List<AddressCatalogInfo> acList = addressCatalogInfoService.getAddressCatalogInfoList();
			ActionContext.getContext().getSession().put("EMPLOYEESELECT",eList);
			ActionContext.getContext().getSession().put("EMAILSELEST",eaList);
			ActionContext.getContext().getSession().put("CATALOGSELECT",acList);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}	

	public static Log getLog() {
		return log;
	}

	public static void setLog(Log log) {
		AddSendActions.log = log;
	}

	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

	public String filterType(String[] types) {
		log.debug(""+"uploadContentType:"+uploadContentType);
		for(String type:types) {
			if(type.equals(uploadContentType)) {
				return null;
			}
		}
		return INPUT;
	}
	

	// 上传单个文件对应文件内容的setter和getter方法
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public File getUpload() {
		return (this.upload);
	}

	// 上传单个文件的文件类型的setter和getter方法
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadContentType() {
		return (this.uploadContentType);
	}

	// 上传单个文件的文件名的setter和getter方法
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadFileName() {
		return (this.uploadFileName);
	}
	public List<String> getEList() {
		return eList;
	}

	public void setEList(List<String> list) {
		eList = list;
	}



	public List<String> getEaList() {
		return eaList;
	}

	public void setEaList(List<String> eaList) {
		this.eaList = eaList;
	}

	public List<String> getAcList() {
		return acList;
	}

	public void setAcList(List<String> acList) {
		this.acList = acList;
	}

	public Long getAddressID() {
		return addressID;
	}

	public void setAddressID(Long addressID) {
		this.addressID = addressID;
	}

	public Long getAcID() {
		return acID;
	}

	public void setAcID(Long acID) {
		this.acID = acID;
	}

	public String getSendTo() {
		return sendTo;
	}

	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}

	public Timestamp getSendTime() {
		return sendTime;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}

	public String getAtt() {
		return att;
	}

	public void setAtt(String att) {
		this.att = att;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}



	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public void setEmailSendInfoService(IEmailSendInfoService emailSendInfoService) {
		this.emailSendInfoService = emailSendInfoService;
	}

	public void setEmailDraftInfoService(
			IEmailDraftInfoService emailDraftInfoService) {
		this.emailDraftInfoService = emailDraftInfoService;
	}

	public void setAddressCatalogInfoService(
			IAddressCatalogInfoService addressCatalogInfoService) {
		this.addressCatalogInfoService = addressCatalogInfoService;
	}

	public void setEmailAddressInfoService(
			IEmailAddressInfoService emailAddressInfoService) {
		this.emailAddressInfoService = emailAddressInfoService;
	}
}
