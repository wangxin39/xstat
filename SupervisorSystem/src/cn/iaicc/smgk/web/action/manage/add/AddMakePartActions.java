package cn.iaicc.smgk.web.action.manage.add;


import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IPartInfoService;
import cn.iaicc.smgk.po.PartInfo;
import cn.iaicc.smgk.web.conf.StatusConstants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddMakePartActions extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6466443869055598571L;
	private static Log logger = LogFactory.getLog(AddMakePartActions.class);
	private IPartInfoService partInfoService = null;

	private List<String> inquisitionList = new LinkedList<String>();
	private Long inquisitionID = null; 
	private Integer showOrder = null;
	private String showNum = null;
	private String name = null;
	private String englishName = null;
	
	@SuppressWarnings("unchecked")
	public String execute()throws Exception{
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			String isOK = (String)ActionContext.getContext().getSession().get("CLIENTINPUTADDISOK");
			if(isOK != null && "OK".equals(isOK)) {
				if(inquisitionID == null){
					ActionContext.getContext().put("nullError","问卷类型不能为空，请先添加调查问卷信息!");
					return INPUT;
				}
				PartInfo info = new PartInfo();
				if(inquisitionID != null) {
					info.setInquisitionID(inquisitionID);					
				}
				if(name != null) {
					info.setName(name);
				}
				if(showNum != null) {
					info.setShowNum(showNum);					
				}
				if(showOrder != null) {
					info.setShowOrder(showOrder);					
				}
				if(englishName != null) {
					info.setEnglishName(englishName);
				}
				info.setStatus(StatusConstants.ZHENGCHANG);
				partInfoService.savePartInfo(info);
				ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","NOT");
			}
			
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}
	public List<String> getInquisitionList() {
		return inquisitionList;
	}

	public void setInquisitionList(List<String> inquisitionList) {
		this.inquisitionList = inquisitionList;
	}

	public Long getInquisitionID() {
		return inquisitionID;
	}

	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}

	public Integer getShowOrder() {
		return showOrder;
	}

	public void setShowOrder(Integer showOrder) {
		this.showOrder = showOrder;
	}

	public String getShowNum() {
		return showNum;
	}

	public void setShowNum(String showNum) {
		this.showNum = showNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void setPartInfoService(IPartInfoService partInfoService) {
		this.partInfoService = partInfoService;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

}
