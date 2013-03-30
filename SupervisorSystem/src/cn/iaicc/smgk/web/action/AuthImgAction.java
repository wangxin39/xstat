package cn.iaicc.smgk.web.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import cn.iaicc.smgk.web.util.CheckCodeUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AuthImgAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 910800624442660589L;
	
	private static Log logger = LogFactory.getLog(AuthImgAction.class);
	
	private InputStream imageStream = null;
	private String contentType = null;
	private String fileName = null;

	@SuppressWarnings("unchecked")
	@Override
	public String execute() {			
         try{
     		contentType = "image/jpeg";
    		fileName = "authImage.jpg";
    		
    		 HttpServletResponse response = ServletActionContext.getResponse();
    		//阻止页面被缓存
             response.setHeader("Pragma", "No-cache");
             response.setHeader("Cache-Control", "no-cache");
             response.setDateHeader("Expires", 0);
             //指定图片的大小
             int width=100,height=18;
             
        	 ByteArrayOutputStream output = new ByteArrayOutputStream();
        	 String rand = CheckCodeUtil.getCodeImage("", width, height, 1, output);
			//将系统生成的图形验证码添加到用户session中
			ActionContext.getContext().getSession().put("rand", rand);			
			this.imageStream = new ByteArrayInputStream(output.toByteArray()); 
			output.close();
         }catch(Exception e) {
        	logger.error(""+e.getMessage(),e.getCause()); 
         }
        return SUCCESS;
	}



	public InputStream getImageStream() {
		return imageStream;
	}



	public void setImageStream(InputStream imageStream) {
		this.imageStream = imageStream;
	}



	public String getContentType() {
		return contentType;
	}



	public void setContentType(String contentType) {
		this.contentType = contentType;
	}



	public String getFileName() {
		return fileName;
	}



	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
