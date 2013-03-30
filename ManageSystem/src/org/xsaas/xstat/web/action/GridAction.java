package org.xsaas.xstat.web.action;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.googlecode.jsonplugin.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;

public class GridAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4649445761706792608L;
	private static Log logger = LogFactory.getLog(GridAction.class);
	private int total = 0;
	private List<EmployeeInfo> list = new java.util.LinkedList<EmployeeInfo>();

	@Override
	public String execute() throws Exception {
		for(int i=0;i<30;i++) {
			EmployeeInfo ei = new EmployeeInfo();
			ei.setId(new Long(i+1));
			ei.setEmployeeName("员工"+i);
			ei.setJobTitle("工作"+(i+1));
			ei.setHireDate(new Timestamp(System.currentTimeMillis()));
			ei.setIsActive(true);

			list.add(ei);			
		}
		total = list.size();
			
		return super.execute();
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	@JSON(name="employees")
	public List<EmployeeInfo> getList() {
		return list;
	}

	public void setList(List<EmployeeInfo> list) {
		this.list = list;
	}

}
