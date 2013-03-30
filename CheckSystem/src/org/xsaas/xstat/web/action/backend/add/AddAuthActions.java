package org.xsaas.xstat.web.action.backend.add;

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

import org.xsaas.xstat.business.ISmgkInfoService;
import org.xsaas.xstat.po.SmgkInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddAuthActions extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -100961714851657624L;
	private static Log logger = LogFactory.getLog(AddAuthActions.class);
	private ISmgkInfoService smgkInfoService = null;
	private String idFileName = null;
	private String idNumber =null;
	
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

	@Override
	public String execute() throws Exception {
		
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		
		SmgkInfo info = (SmgkInfo)ActionContext.getContext().getSession().get("SMGKINFO");
		if(info == null || username == null || password == null) {
			return LOGIN;
		}	
		
		String filterResult = filterType(new String[]{"image/png","image/x-png","image/pjpeg","image/gif"});
		if(filterResult != null) {
			this.addActionMessage("您要上传的文件类型不正确！");
			return ERROR;
		}	
		if(logger.isDebugEnabled()) {
			logger.debug("uploadContentType:"+uploadContentType);			
		}
		String filename = getUploadFileName();
		// 上传单个文件
		// 以服务器的文件保存地址和原文件名建立上传文件输出流
		FileOutputStream out = null;
		FileInputStream in = null;
		try{
			if(filename != null) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");	
				int pos = StringUtils.lastIndexOf(filename,".");
				String suffix = filename.substring(pos+1,filename.length());
				filename = sdf.format(new Timestamp(System.currentTimeMillis()))+"."+suffix;
				logger.debug("filename:"+filename);				
				
				out = new FileOutputStream(getSavePath()+"//"+ filename);
				// 以上传文件建立一个<SPAN class=hilite2>文件上传</SPAN>流
				in = new FileInputStream(getUpload());
				// 将上传文件的内容写入服务器
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = in.read(buffer)) > 0) {
					out.write(buffer, 0, len);
				}
				out.flush();	
			}			
		
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}finally{
			if(in != null) {
				in.close();
			}
			if(out != null) {
				out.close();
			}			
		}
		if(filename != null) {
			info.setIdFileName(filename);			
		}
		info.setIdNumber(idNumber);
		if("image/pjpeg".equals(uploadContentType)){
			info.setFileType(QuestionTypeConstants.AJPEG);			
		}else if("image/png".equals(uploadContentType) || "image/x-png".equals(uploadContentType)) {
			info.setFileType(QuestionTypeConstants.APNG);			
		}else if("image/gif".equals(uploadContentType)) {
			info.setFileType(QuestionTypeConstants.AGIF);
		}
		smgkInfoService.updateSmgkInfo(info);		
		
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String input() throws Exception{
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			
			SmgkInfo smgkInfo = smgkInfoService.isLogin(username, password);
			if(smgkInfo == null) {
				return LOGIN;
			}		
			ActionContext.getContext().getSession().put("SMGKINFO",smgkInfo);
			ActionContext.getContext().getSession().put("TYPE",QuestionTypeConstants.AuthTypeDict);			
		}catch(Exception e) {
			
		}

		return SUCCESS;
	}
	public String filterType(String[] types) {
		logger.debug(""+"uploadContentType:"+uploadContentType);
		for(String type:types) {
			if(type.equals(uploadContentType)) {
				return null;
			}
		}
		return SUCCESS;
	}
	public String getIdFileName() {
		return idFileName;
	}

	public void setIdFileName(String idFileName) {
		this.idFileName = idFileName;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public void setSmgkInfoService(ISmgkInfoService smgkInfoService) {
		this.smgkInfoService = smgkInfoService;
	}

}
