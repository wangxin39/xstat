package cn.iaicc.smgk.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IClientInfoService;
import cn.iaicc.smgk.business.IEmployeeInfoService;
import cn.iaicc.smgk.business.IInquisitionInfoService;
import cn.iaicc.smgk.business.IInquisitionTemplateInfoService;
import cn.iaicc.smgk.po.ClientInfo;
import cn.iaicc.smgk.po.EmployeeInfo;
import cn.iaicc.smgk.po.InquisitionInfo;
import cn.iaicc.smgk.po.InquisitionTemplateInfo;
import cn.iaicc.smgk.web.conf.SmgkConstants;
import cn.iaicc.smgk.web.conf.StatusConstants;
import cn.iaicc.smgk.web.util.PaginationUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListMakeExamAction extends ActionSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8122202414454388824L;
	private static Log logger = LogFactory.getLog(ListMakeExamAction.class);
	private IInquisitionInfoService inquisitionInfoService = null;
	private IClientInfoService clientInfoService = null;
	private IInquisitionTemplateInfoService inquisitionTemplateInfoService = null;
	private List<ClientInfo> clientList = null;
	
	private List<InquisitionTemplateInfo> templateList = null;
	private List<String> statusList = null;
	private List<String> typeList = null;

	private Long inquisitionID = null;

	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<InquisitionInfo> pageList = null;
	
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
			
			int total = inquisitionInfoService.getInquisitionInfoTotal();

			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			pageList = inquisitionInfoService.findInquisitionInfoByPage(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
			
			templateList = new LinkedList<InquisitionTemplateInfo>();
			clientList = new LinkedList<ClientInfo>();
		
			statusList = new LinkedList<String>();
			typeList = new LinkedList<String>();
			
			if(pageList != null){
				for(InquisitionInfo info:pageList){						
					if(info.getTemplateID() != null){					
						InquisitionTemplateInfo iti = inquisitionTemplateInfoService.getInquisitionTemplateInfo(info.getTemplateID());
						if(iti != null) {
							templateList.add(iti);						
						}else{
							templateList.add(new InquisitionTemplateInfo());
						}
					}else{
						templateList.add(new InquisitionTemplateInfo());
					}
					if(info.getClientID() != null) {
						ClientInfo ci = clientInfoService.getClientInfo(info.getClientID());
						if(ci != null){
							clientList.add(ci);
						}else{
							clientList.add(new ClientInfo());
						}
						
			
					}else{
						clientList.add(new ClientInfo());
					}
					
					if(info.getStatus() != null){						
						statusList.add(""+StatusConstants.InStatusDict.get(info.getStatus()));
					}else{						
						statusList.add("");
					}			
				}	
			}else{
				this.addActionMessage("数据库中没有数据！");
			}		
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}


		return SUCCESS;
	}
	
	public String detail() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			
			if(username == null || password == null) {
				return LOGIN;
			}
			if(inquisitionID == null){
				this.addActionError("编号为空！");
				return ERROR;
			}
			InquisitionInfo info = inquisitionInfoService.getInquisitionInfo(inquisitionID);
			if(info != null){
				ActionContext.getContext().put("INQUISITIONINFO",info);
			}
		
			ClientInfo clientInfo = clientInfoService.getClientInfo(info.getClientID());
			if(clientInfo !=null && clientInfo.getCompany() !=null){
				ActionContext.getContext().put("CLIENTINFO",clientInfo.getCompany());
			}
			if(info.getStatus()!=null && info.getInquisitionStatus()!=null){
				ActionContext.getContext().put("STATUS",StatusConstants.StatusDict.get(info.getStatus()));
				ActionContext.getContext().put("INSTATUS",StatusConstants.InStatusDict.get(info.getInquisitionStatus()));
			}
			
			InquisitionTemplateInfo templateInfo = inquisitionTemplateInfoService.getInquisitionTemplateInfo(info.getTemplateID());
			if(templateInfo != null && templateInfo.getName()!= null){
				ActionContext.getContext().put("TEMPLATEINFO",templateInfo.getName());
			}
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}
	
		
	
		return SUCCESS;
	}			
		

	public List<ClientInfo> getClientList() {
		return clientList;
	}

	public void setClientList(List<ClientInfo> clientList) {
		this.clientList = clientList;
	}


	public List<InquisitionTemplateInfo> getTemplateList() {
		return templateList;
	}

	public void setTemplateList(List<InquisitionTemplateInfo> templateList) {
		this.templateList = templateList;
	}
	public Long getInquisitionID() {
		return inquisitionID;
	}
	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}
	
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public void setInquisitionInfoService(
			IInquisitionInfoService inquisitionInfoService) {
		this.inquisitionInfoService = inquisitionInfoService;
	}

	public void setClientInfoService(IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}

	public void setInquisitionTemplateInfoService(
			IInquisitionTemplateInfoService inquisitionTemplateInfoService) {
		this.inquisitionTemplateInfoService = inquisitionTemplateInfoService;
	}

	public List<String> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}

	public List<String> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<String> typeList) {
		this.typeList = typeList;
	}

	public List<InquisitionInfo> getPageList() {
		return pageList;
	}
	public void setPageList(List<InquisitionInfo> pageList) {
		this.pageList = pageList;
	}

	public PaginationUtil getPu() {
		return pu;
	}

}
