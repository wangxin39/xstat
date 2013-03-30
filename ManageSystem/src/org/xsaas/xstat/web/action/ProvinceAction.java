package org.xsaas.xstat.web.action;

import java.util.LinkedHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.ProvinceConstants;


import com.opensymphony.xwork2.ActionSupport;

public class ProvinceAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6634755755576819786L;
	private static Log logger = LogFactory.getLog(ProvinceAction.class);
	
	private int length = 0;
	private LinkedHashMap<Integer,String> provinceMap = ProvinceConstants.provinceDict;
	
	@Override
	public String execute() throws Exception {
		length = provinceMap.size();
		return SUCCESS;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public LinkedHashMap<Integer, String> getProvinceMap() {
		return provinceMap;
	}

	public void setProvinceMap(LinkedHashMap<Integer, String> provinceMap) {
		this.provinceMap = provinceMap;
	}

}
