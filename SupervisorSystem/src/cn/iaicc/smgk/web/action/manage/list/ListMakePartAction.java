package cn.iaicc.smgk.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IEmployeeInfoService;
import cn.iaicc.smgk.business.IInquisitionInfoService;
import cn.iaicc.smgk.business.IPartInfoService;
import cn.iaicc.smgk.po.EmployeeInfo;
import cn.iaicc.smgk.po.InquisitionInfo;
import cn.iaicc.smgk.po.PartInfo;
import cn.iaicc.smgk.web.conf.SmgkConstants;
import cn.iaicc.smgk.web.util.PaginationUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListMakePartAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2665181524723171247L;
	private static Log logger = LogFactory.getLog(ListMakePartAction.class);
	private IInquisitionInfoService inquisitionInfoService = null;

	private IPartInfoService partInfoService = null;
	private List<String> clientList = new LinkedList<String>();
	private List<String> inquisitionList = new LinkedList<String>();
	private Long inquisitionID = null;
	private Long partID = null;

	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<PartInfo> pageList = null;	
	private PaginationUtil pu = null;	
	
			
	@SuppressWarnings("unchecked")
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
			List<InquisitionInfo> iList = inquisitionInfoService.getInquisitionInfoList();
			//先添加问卷信息
			long selectInquisitionID = 0;
			if(inquisitionID != null) {
				selectInquisitionID = inquisitionID.longValue();
			}else{
				//客户信息不为空
				if(iList.size() >0) {
					InquisitionInfo ci = iList.get(0);
					selectInquisitionID = ci.getInquisitionID();				
				}
			}
			ActionContext.getContext().getSession().put("INQUISITIONSELECT",iList);
			
			int total = 0;
			if(selectInquisitionID != 0)
			{
				total = partInfoService.getTotalPartInfo(selectInquisitionID);
			}else{
				total = partInfoService.getTotal();			
			}		
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			if(selectInquisitionID != 0) {
				pageList = partInfoService.findByPagePartInfo(selectInquisitionID,pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);			
			}else{
				pageList = partInfoService.findByPage(pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);			
			}

			for(PartInfo info:pageList){
				if(info.getInquisitionID() != null) {
					InquisitionInfo iInfo = inquisitionInfoService.getInquisitionInfo(info.getInquisitionID());
					ActionContext.getContext().put("INQUISITIONLIST",iInfo.getTitle());
					inquisitionList.add(""+iInfo.getTitle());				
				}else{
					ActionContext.getContext().put("INQUISITIONLIST","");				
					inquisitionList.add("");				
				}
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}


		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String input() throws Exception {
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		try{
			if(username == null || password == null) {
				return LOGIN;
			}
			List<InquisitionInfo> iList = inquisitionInfoService.getInquisitionInfoList();
			ActionContext.getContext().getSession().put("INQUISITIONSELECT",iList);
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");//防止刷新提交多次相同信息
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}		

		return SUCCESS;
	}	
	@SuppressWarnings("unchecked")
	public String edit() throws Exception {
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		try{
			if(username == null || password == null) {
				return LOGIN;
			}
			if(partID == null){
				this.addActionError("编号为空！");
				return ERROR;
			}
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");//防止刷新提交多次相同信息
			List<InquisitionInfo> iList = inquisitionInfoService.getInquisitionInfoList();
			ActionContext.getContext().getSession().put("INQUISITIONSELECT",iList);
			PartInfo info = partInfoService.getPartInfo(partID);
			ActionContext.getContext().getSession().put("QUESTIONEDIT",info);
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}		

		return SUCCESS;
	}			
	public List<String> getClientList() {
		return clientList;
	}

	public void setClientList(List<String> clientList) {
		this.clientList = clientList;
	}

	public List<String> getInquisitionList() {
		return inquisitionList;
	}

	public Long getInquisitionID() {
		return inquisitionID;
	}

	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}

	public Long getPartID() {
		return partID;
	}

	public void setPartID(Long partID) {
		this.partID = partID;
	}

	public void setInquisitionList(List<String> inquisitionList) {
		this.inquisitionList = inquisitionList;
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

	public void setPartInfoService(
			IPartInfoService partInfoService) {
		this.partInfoService = partInfoService;
	}
	public List<PartInfo> getPageList() {
		return pageList;
	}
	public void setPageList(List<PartInfo> pageList) {
		this.pageList = pageList;
	}
	public PaginationUtil getPu() {
		return pu;
	}
}
