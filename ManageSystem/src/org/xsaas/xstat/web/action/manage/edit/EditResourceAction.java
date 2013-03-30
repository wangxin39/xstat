package org.xsaas.xstat.web.action.manage.edit;

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

public class EditResourceAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6466443869055598571L;
	private static Log logger = LogFactory.getLog(EditResourceAction.class);
	private IResourceInfoService resourceInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;
	private Long resourceID = null;
	
	private Integer status = null;
	private Integer fileType = null;
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
			String filename = getUploadFileName();
			if(getUploadFileName() != null) {
				String filterResult = filterType(new String[]{"text/plain","video/x-msvideo","application/msword","audio/mpeg","video/mp4","application/vnd.rn-realmedia","application/x-shockwave-flash","application/vnd.ms-excel","image/png","image/pjpeg","image/gif"});
				if(filterResult != null) {
					ActionContext.getContext().put("typeError", "您要上传的文件类型不正确！");
					return filterResult;
				}
				if(logger.isDebugEnabled()) {
					logger.debug("uploadContentType:"+uploadContentType);			
				}
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
			}


			ResourceInfo info = (ResourceInfo) ActionContext.getContext().getSession().get("QUESTIONINFOEDIT");
			String isOK = (String)ActionContext.getContext().getSession().get("CLIENTINPUTADDISOK");
			if(isOK != null && "OK".equals(isOK) && info != null) {
				if(getUploadFileName() != null) {
					info.setFileName(filename);					
				}
				if(savePath != null) {
					info.setSavePath(savePath);					
				}
				if(fileType != null) {
					info.setFileType(fileType);					
				}
				resourceInfoService.update(info);
				ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","NOT");
			}			
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String edit() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");//防止刷新提交多次相同信息
			if(resourceID == null){
				this.addActionError("编号为空！");
				return ERROR;
			}
			ActionContext.getContext().getSession().put("STATUS",StatusConstants.StatusDict);
			ResourceInfo info = resourceInfoService.getResourceInfo(resourceID);
			ActionContext.getContext().getSession().put("TYPE",QuestionTypeConstants.ResTypeDict);
			ActionContext.getContext().getSession().put("QUESTIONINFOEDIT", info);
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public Integer getFileType() {
		return fileType;
	}

	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}

	public void setResourceInfoService(IResourceInfoService resourceInfoService) {
		this.resourceInfoService = resourceInfoService;
	}

	public Long getResourceID() {
		return resourceID;
	}

	public void setResourceID(Long resourceID) {
		this.resourceID = resourceID;
	}

}
