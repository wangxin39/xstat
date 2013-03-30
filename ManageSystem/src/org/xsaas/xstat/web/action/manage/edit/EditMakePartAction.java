package org.xsaas.xstat.web.action.manage.edit;


import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.xsaas.xstat.business.IInquisitionInfoService;
import org.xsaas.xstat.business.IPartInfoService;
import org.xsaas.xstat.po.InquisitionInfo;
import org.xsaas.xstat.po.PartInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditMakePartAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6466443869055598571L;
	private static Log logger = LogFactory.getLog(EditMakePartAction.class);
	private IPartInfoService partInfoService = null;
	private IInquisitionInfoService inquisitionInfoService = null;

	private List<String> inquisitionList = new LinkedList<String>();
	private Long inquisitionID = null; 

	private Integer showOrder = null;
	private String showNum = null;
	private String name = null;
	private String englishName = null;
	
	private Long partID = null;
	
	public String execute()throws Exception{
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			PartInfo info = (PartInfo) ActionContext.getContext().getSession().get("EDITPARTINTO");
			if(info != null) {
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
				partInfoService.updatePartInfo(info);
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}
	
		
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String edit() throws Exception  {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			PartInfo info = partInfoService.getPartInfo(partID);
			ActionContext.getContext().getSession().put("EDITPARTINTO",info);
			
			List<InquisitionInfo> inquisitionInfoList = (List<InquisitionInfo>)ActionContext.getContext().getSession().get("GLOBALINQUISITIONINFOLIST");
			if(inquisitionInfoList == null) {
				inquisitionInfoList = inquisitionInfoService.getInquisitionInfoList();
				ActionContext.getContext().getSession().put("GLOBALINQUISITIONINFOLIST", inquisitionInfoList);
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

	public Long getPartID() {
		return partID;
	}

	public void setPartID(Long partID) {
		this.partID = partID;
	}

	public void setInquisitionInfoService(
			IInquisitionInfoService inquisitionInfoService) {
		this.inquisitionInfoService = inquisitionInfoService;
	}

}
