package org.xsaas.xstat.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.ProvinceConstants;
import org.xsaas.xstat.web.conf.SmgkConstants;
import org.xsaas.xstat.web.util.PaginationUtil;

import org.xsaas.xstat.business.ICityInfoService;
import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.po.CityInfo;
import org.xsaas.xstat.po.EmployeeInfo;



import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListCityAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5248039003761278571L;
	private static Log logger = LogFactory.getLog(ListCityAction.class);
	private ICityInfoService cityInfoService = null;
	private List<String> provinceList = new LinkedList<String>();
	private Integer province = null;
	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<CityInfo> pageList = null;
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
			if (num != null) {
				page = num.intValue();
			}
			Integer curProvince = ProvinceConstants.BEIJING;
			if(province != null) {
				curProvince = province;
			}
			int total = 0;
			if(curProvince != null){
				// 根据传入的省份，浏览相应的城市
				total = cityInfoService.getCityInfoTotal(curProvince);
			}
			pu = new PaginationUtil(total, page,SmgkConstants.PAGE_MAX_RESULT);
			if(curProvince != null){
				pageList = cityInfoService.findCityInfoByPage(curProvince,pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);
			}
			for(CityInfo info:pageList){
				if(pageList != null){
					if(info.getProvince() != null) {
						provinceList.add(""+ProvinceConstants.provinceDict.get(info.getProvince()));		
					}else{
						provinceList.add("");
					}		
				}else{
					this.addActionMessage("数据库中没有数据!");
				}
				
			}

			ActionContext.getContext().put("CURPROVINCE",curProvince.intValue());
			ActionContext.getContext().getSession().put("PROVINCE",ProvinceConstants.provinceDict);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

	
		
		return SUCCESS;
	}
	public Integer getProvince() {
		return province;
	}
	public void setProvince(Integer province) {
		this.province = province;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public List<CityInfo> getPageList() {
		return pageList;
	}
	public void setPageList(List<CityInfo> pageList) {
		this.pageList = pageList;
	}
	public PaginationUtil getPu() {
		return pu;
	}
	public void setCityInfoService(ICityInfoService cityInfoService) {
		this.cityInfoService = cityInfoService;
	}
	public List<String> getProvinceList() {
		return provinceList;
	}
	public void setProvinceList(List<String> provinceList) {
		this.provinceList = provinceList;
	}			

}
