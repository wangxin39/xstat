package cn.iaicc.smgk.web.action.manage.delete;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IEmployeeInfoService;
import cn.iaicc.smgk.business.IVideoInfoService;
import cn.iaicc.smgk.po.EmployeeInfo;
import cn.iaicc.smgk.po.VideoInfo;
import cn.iaicc.smgk.web.conf.StatusConstants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteVideoAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8925259348189164568L;
	private static Log logger = LogFactory.getLog(DeleteVideoAction.class);
	private IEmployeeInfoService employeeInfoService = null;
	private IVideoInfoService videoInfoService = null;
	private Long videoID = null;
	
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}

			VideoInfo info = videoInfoService.getVideoInfo(videoID);

			info.setStatus(StatusConstants.SHANCHU);
			videoInfoService.updateVideoInfo(info);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}


		return SUCCESS;
	}

	public void setVideoInfoService(IVideoInfoService videoInfoService) {
		this.videoInfoService = videoInfoService;
	}


	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

	public Long getVideoID() {
		return videoID;
	}

	public void setVideoID(Long videoID) {
		this.videoID = videoID;
	}


}
