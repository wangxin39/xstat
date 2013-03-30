package cn.iaicc.smgk.web.action.manage.list;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IClientInfoService;

import cn.iaicc.smgk.po.ClientInfo;
import cn.iaicc.smgk.web.conf.SmgkConstants;
import cn.iaicc.smgk.web.conf.StatusConstants;
import cn.iaicc.smgk.web.util.PaginationUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListClientAction extends ActionSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7568400183849106961L;
	private static Log logger = LogFactory.getLog(ListClientAction.class);
	private IClientInfoService clientInfoService = null;

	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<ClientInfo> pageList = null;	
	
	private PaginationUtil pu = null;
	
	public Long clientID = null;
	
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			int page = 1;
			if(num != null) {
				page = num.intValue();
			}
			
			int total = clientInfoService.getClientInfoTotal();
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			pageList = clientInfoService.findClientInfoByPage(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
					
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}		
		return SUCCESS;
	}
	public String detail() throws Exception {
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		try{
			if(username == null || password == null) {
				return LOGIN;
			}
			if(clientID != null) {
				ClientInfo info = clientInfoService.getClientInfo(clientID);
				if(info != null && info.getStatus()!=null){
					ActionContext.getContext().put("CLIENTINFODETAIL",info);
					ActionContext.getContext().put("STATUS",StatusConstants.StatusDict.get(info.getStatus()));
				}
				
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}		
	

	public void setclientInfoService(
			IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}
	
	public void setClientInfoService(IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public List<ClientInfo> getPageList() {
		return pageList;
	}

	public Long getClientID() {
		return clientID;
	}
	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}
	public PaginationUtil getPu() {
		return pu;
	}
}
