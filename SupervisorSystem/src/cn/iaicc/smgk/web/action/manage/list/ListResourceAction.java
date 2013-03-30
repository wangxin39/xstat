package cn.iaicc.smgk.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IResourceInfoService;

import cn.iaicc.smgk.po.ResourceInfo;
import cn.iaicc.smgk.web.conf.QuestionTypeConstants;
import cn.iaicc.smgk.web.conf.SmgkConstants;
import cn.iaicc.smgk.web.conf.StatusConstants;
import cn.iaicc.smgk.web.util.PaginationUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListResourceAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6466443869055598571L;
	private static Log logger = LogFactory.getLog(ListResourceAction.class);
	private IResourceInfoService resourceInfoService = null;
	private List<String> typeList = new LinkedList<String>();
	private List<String> statusList = new LinkedList<String>();

	private Long resID = null;
	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<ResourceInfo> pageList = null;	
	private PaginationUtil pu = null;		

	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			int page = 1;
			if(num != null){
				page = num.intValue();
			}
			int total = resourceInfoService.getTotal();
		    pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			pageList = resourceInfoService.findByPage(pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);
			for(ResourceInfo info:pageList){
				if(pageList != null){
					if(info.getStatus() != null){
						statusList.add(""+StatusConstants.StatusDict.get(info.getStatus()));
					}else{
						statusList.add("");
					}
					if(info.getFileType()!= null){
						typeList.add(""+QuestionTypeConstants.ResTypeDict.get(info.getFileType()));
					}else{
						typeList.add("");
					}
				}else{
					this.addActionMessage("数据库中没有数据!");
				}
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}


		return SUCCESS;
	}
	
			
	public List<String> getTypeList() {
		return typeList;
	}


	public void setTypeList(List<String> typeList) {
		this.typeList = typeList;
	}


	public List<String> getStatusList() {
		return statusList;
	}
	public Long getResID() {
		return resID;
	}
	public void setResID(Long resID) {
		this.resID = resID;
	}

	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}

	
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public List<ResourceInfo> getPageList() {
		return pageList;
	}
	public void setPageList(List<ResourceInfo> pageList) {
		this.pageList = pageList;
	}
	public PaginationUtil getPu() {
		return pu;
	}


	public void setResourceInfoService(IResourceInfoService resourceInfoService) {
		this.resourceInfoService = resourceInfoService;
	}

}
