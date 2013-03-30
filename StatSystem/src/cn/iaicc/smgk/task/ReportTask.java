package cn.iaicc.smgk.task;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.jasperreports.JasperReportsUtils;

import cn.iaicc.smgk.conf.Constants;
import cn.iaicc.smgk.po.InformantInfo;
import cn.iaicc.smgk.po.IssueInfo;
import cn.iaicc.smgk.po.OutputInfo;
import cn.iaicc.smgk.po.PartInfo;
import cn.iaicc.smgk.po.RemarkInfo;
import cn.iaicc.smgk.report.ReportUtil;
import cn.iaicc.smgk.util.ServiceUtils;

/**
 * 用于处理生成报告任务
 * @author wangxin
 *
 */

public class ReportTask implements Runnable {
	private static Log logger = LogFactory.getLog(ReportTask.class);
	/**
	 * 要统计的期次
	 */
	private IssueInfo issueInfo = null;
	private InformantInfo informantInfo = null;
	
	public ReportTask(IssueInfo issueInfo,InformantInfo informantInfo) {
		super();
		this.issueInfo = issueInfo;
		this.informantInfo = informantInfo;
	}
	
	@Override
	public void run() {
		if(issueInfo != null && informantInfo != null) {
			logger.debug("报告生成处理开始:"+informantInfo.getName());
			String reportSource = "";
	        String jasperName = "";
	        
	        // 通过传入参数获取报告设置信息
	        // 通过期次和调查对象获取生成单项报告设置信息
	        // 通过期次获取生成总结报告设置信息	        
	        
	        try {       	
	        	int size = 40;
	            ReportUtil report = new ReportUtil(size);
	    		reportSource = "templates/index.jrxml";
	    		jasperName = "templates/jasper_index.jasper";
	    		ReportUtil.jasperCompile(reportSource,jasperName); 
	           
	            report.addParameter("projectTitle","Porsche Centre MS Check");
	            report.addParameter("quarterTitle","2008 Q3");
	            report.addParameter("reportTitle","PC "+informantInfo.getEnglishName()+" Summary Report");
	            report.addParameter("backImage", "templates/index.png");
	            
	            report.addPage(jasperName);

	            report.clearParameters();
	            
	            report.addParameter("projectTitle","Porsche Centre MS Check");
	            report.addParameter("quarterTitle","2008 Q3");
	            report.addParameter("reportTitle",""+informantInfo.getAliasName()+"总结报告");
	            report.addParameter("backImage", "templates/index.png");     
	            
	            report.addPage(jasperName);
	            
	            // 使用的报告模板
	            reportSource = "templates/part.jrxml";            
	    		jasperName = "templates/jasper_part.jasper";   
	    		
	    		ReportUtil.jasperCompile(reportSource,jasperName); 
	            
	    		List<PartInfo> partInfoList = ServiceUtils.get().getPartInfoService().getPartInfoList(issueInfo.getInquisitionID());
	    		
	    		// 读取当前问卷所有的评语
	            //从评语信息表中取得当前评语，参数：期次编号，调查对象编号，调查问卷编号
	    		List<RemarkInfo> remarkInfoList = ServiceUtils.get().getRemarkInfoService().findByInformant(issueInfo.getIssueID(),informantInfo.getInformantID(), issueInfo.getInquisitionID());
	    		// 转换为MAP方式，以便于获取
	    		Map<Long, RemarkInfo> remarkMap = new HashMap<Long, RemarkInfo>();
	    		for(RemarkInfo ri:remarkInfoList) {
	    			remarkMap.put(ri.getPartID(), ri);
	    		}    		
	    		
	    		for(PartInfo pi:partInfoList) {
		            report.clearParameters();
		            // 根据部分编号，获取该部分评语
		            RemarkInfo remarkInfo = remarkMap.get(pi.getPartID());
		            
		            if(remarkInfo != null) {
			            report.addParameter("title","Section "+pi.getShowNum()+": "+pi.getEnglishName());
			            report.addParameter("h1","Strengths");
			            report.addParameter("v1",""+remarkInfo.getEnStrengths());
			            report.addParameter("h2","Weaknesses");
			            report.addParameter("v2",""+remarkInfo.getEnWeaknesses());
			            report.addParameter("h3","Conclusion\n & \n Suggestion");
			            report.addParameter("v3",""+remarkInfo.getEnConclusion());            
			            report.addParameter("backImage", "templates/content.png");          
			            
			            report.addPage(jasperName);

			            report.clearParameters();
			            
			            report.addParameter("title",""+pi.getShowNum()+"部分: "+pi.getEnglishName());
			    		report.addParameter("h1","优点");
			    		report.addParameter("v1",""+remarkInfo.getStrengths());
			    		report.addParameter("h2","不足");
			    		report.addParameter("v2",""+remarkInfo.getWeaknesses());
			    		report.addParameter("h3","总结与建议");
			    		report.addParameter("v3",""+remarkInfo.getConclusion());            
			    		report.addParameter("backImage", "templates/content.png");
			    		
			    		report.addPage(jasperName);
		            }
	    		}
	            
	    		String dir = Constants.OUTPUT_DIR+"pdf/"+Constants.CURRENT_DIR;
	            ReportUtil.checkDir(dir);
	            dir += "/"+issueInfo.getIssueID();
	            ReportUtil.checkDir(dir);
	            
	            report.exportToPdfFile(dir+"/"+informantInfo.getEnglishName()+"report.pdf");	            
	            
	            dir = Constants.OUTPUT_DIR+"html/"+Constants.CURRENT_DIR;
	            ReportUtil.checkDir(dir);
	            dir += "/"+issueInfo.getIssueID();
	            ReportUtil.checkDir(dir);

	            OutputInfo oi = new OutputInfo();
	            oi.setClientID(issueInfo.getClientID());
	            oi.setInformantID(informantInfo.getInformantID());
	            oi.setIssueID(issueInfo.getIssueID());
	            oi.setFileType(2); // 2:pdf
	            oi.setFileName(informantInfo.getEnglishName()+"report.pdf");
	            oi.setSavePath(dir);
	            oi.setMakeTime(new Timestamp(System.currentTimeMillis()));
	            
	            ServiceUtils.get().getOutputInfoService().saveOutputInfo(oi);
	            
	            
//	            report.exportToHtmlFile(dir+"/"+informantInfo.getEnglishName()+"report.html");
//	            dir = Constants.OUTPUT_DIR+"excel/"+Constants.CURRENT_DIR;	            
//	            ReportUtil.checkDir(dir);
//	            dir += "/"+issueInfo.getIssueID();
//	            ReportUtil.checkDir(dir);	            
//	            
//	            report.exportToExcelFile(dir+"/"+informantInfo.getEnglishName()+"report.xls");	            	
	            logger.debug("生成报告:"+dir+"/"+informantInfo.getEnglishName()+"report.pdf");
	            

	        } catch (Exception e) {
	        	logger.error(""+e.getMessage());
	        }			
		}

	}

}
