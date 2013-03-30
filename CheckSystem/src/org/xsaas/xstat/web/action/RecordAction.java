package org.xsaas.xstat.web.action;

import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.xsaas.xstat.jms.JmsHelper;
import org.xsaas.xstat.jms.RecordInfo;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 答案处理中心
 * @author wangxin
 *
 */

public class RecordAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -983733882867389586L;
	private static Log logger = LogFactory.getLog(RecordAction.class);

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {				
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			
			if(username == null || password == null) {
				return LOGIN;
			}
			Long inquisitionID = (Long)ActionContext.getContext().getSession().get("INQUISITIONID");
			Long planID = (Long)ActionContext.getContext().getSession().get("PLANID");			
		
			if(planID == null || inquisitionID == null) {
				return INPUT;
			}
			HttpServletRequest request = ServletActionContext.getRequest();
			logger.debug("planID:"+planID+"|inquisitionID:"+inquisitionID);			
			RecordInfo ri = new RecordInfo();
			ri.setPlanID(planID);
			ri.setInquisitionID(inquisitionID);

			Map parameters = new LinkedHashMap();
			parameters.putAll(request.getParameterMap());
			
			ri.setParameters(parameters);
			ri.setSendTime(new Timestamp(System.currentTimeMillis()));

			// 通过JMS发送答案到问卷处理器中处理
			JmsHelper.getRecordSender().send(ri);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}
}
