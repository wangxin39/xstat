package org.xsaas.xstat.web.action.manage.add;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.xsaas.xstat.web.conf.QuestionTypeConstants;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IResourceInfoService;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.ResourceInfo;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddResourceActions extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6466443869055598571L;
	private static Log logger = LogFactory.getLog(AddTemplateReportActions.class);
	private IResourceInfoService resourceInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;

	private Long resID = null;
	private Integer status = null;
	private Integer fileType = null;
	private Timestamp uploadTime = null;
	private String fileName = null;
	
	private String allowTypes;
	
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
	

	public String filterType(String[] types) {
		logger.debug(""+"uploadContentType:"+uploadContentType);
		for(String type:types) {
			if(type.equals(uploadContentType)) {
				return null;
			}
		}
		return INPUT;
	}
	
	@SuppressWarnings("unchecked")
	public String execute()throws Exception{
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			String filterResult = filterType(new String[]{"text/plain","video/x-msvideo","application/msword","audio/mpeg","video/mp4","application/vnd.rn-realmedia","application/x-shockwave-flash","application/vnd.ms-excel","image/png","image/pjpeg","image/gif"});
			if(filterResult != null) {
				ActionContext.getContext().put("typeError", "您要上传的文件类型不正确！");
				return filterResult;
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

			
		ResourceInfo info = new ResourceInfo();
		if(logger.isDebugEnabled()) {
			logger.debug("uploadContentType:"+uploadContentType);			
		}
		String filename = getUploadFileName();
		// 上传单个文件
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");	
			int pos = StringUtils.lastIndexOf(filename,".");
			String suffix = filename.substring(pos+1,filename.length());
			filename = sdf.format(new Timestamp(System.currentTimeMillis()))+"."+suffix;
			logger.debug("filename:"+filename);
			// 以服务器的文件保存地址和原文件名建立上传文件输出流
			FileOutputStream fos = new FileOutputStream(getSavePath()+"//"+ filename);
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
			logger.error("addResource:"+e.getMessage(),e.getCause());
		}	
		try{
			String isOK = (String)ActionContext.getContext().getSession().get("CLIENTINPUTADDISOK");
			if(isOK != null && "OK".equals(isOK)) {
			
				info.setFileName(filename);
				info.setSavePath(savePath);
				info.setStatus(StatusConstants.ZHENGCHANG);
				info.setFileType(fileType);
				info.setUploadTime(new Timestamp(System.currentTimeMillis()));
				resourceInfoService.save(info);
				ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","NOT");
			}			
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
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
			ActionContext.getContext().getSession().put("TYPE",QuestionTypeConstants.ResTypeDict);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}		

		return SUCCESS;
	}	
	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
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
	public Long getResID() {
		return resID;
	}
	public void setResID(Long resID) {
		this.resID = resID;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}



	public Integer getFileType() {
		return fileType;
	}

	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}

	public Timestamp getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getAllowTypes() {
		return allowTypes;
	}

	public void setAllowTypes(String allowTypes) {
		this.allowTypes = allowTypes;
	}

	public void setResourceInfoService(IResourceInfoService resourceInfoService) {
		this.resourceInfoService = resourceInfoService;
	}

}
