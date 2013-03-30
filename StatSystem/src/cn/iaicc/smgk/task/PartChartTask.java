package cn.iaicc.smgk.task;

import java.io.File;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.chart.ComparisonBarChartUtil;
import cn.iaicc.smgk.chart.bo.PartDatasetInfo;
import cn.iaicc.smgk.conf.Constants;
import cn.iaicc.smgk.po.InformantInfo;
import cn.iaicc.smgk.po.IssueInfo;
import cn.iaicc.smgk.po.StatChartInfo;
import cn.iaicc.smgk.util.ServiceUtils;

public class PartChartTask implements Runnable {
	
	private static Log logger = LogFactory.getLog(PartChartTask.class);
	private IssueInfo issueInfo = null;
	private InformantInfo informantInfo = null;
	
	public PartChartTask(IssueInfo issueInfo,InformantInfo informantInfo) {
		this.issueInfo = issueInfo;
		this.informantInfo = informantInfo;
	}
	
	
	@Override
	public void run() {
		if(issueInfo != null && informantInfo != null) {
			logger.debug("统计图生成处理开始:"+informantInfo.getName());
			
			makePartChart();
			
			logger.debug("统计图生成");
		}

	}
	
	/**
	 * 生成部分统计图
	 */
	private void makePartChart() {
		logger.debug("生成部分统计图处理开始");
		try{
			List<PartDatasetInfo> datasetList = null; // 需处理此处，获得数据
			ComparisonBarChartUtil cbc = new ComparisonBarChartUtil();				
			
			String savePath = Constants.OUTPUT_DIR+"charts/"+Constants.CURRENT_DIR;	
			logger.debug("分析performance:"+savePath);
			File dir = new File(savePath);
			if(!dir.exists()) {
				dir.mkdir();
			}
			cbc.init(""+informantInfo.getEnglishName()+" performance compared with overall average performance","/"+informantInfo.getEnglishName()+"performance.png",savePath, datasetList);
			StatChartInfo sci = new StatChartInfo();
			sci.setFileName(""+informantInfo.getEnglishName()+"performance.png");
			sci.setSavePath(savePath);
			sci.setIssueID(issueInfo.getIssueID());
			sci.setType(1); //1:部分统计图，2：调查对象图
			
			//此处需要检查是否已保存到数据库，存在的话才允许保存		
//			ServiceUtils.get().getStatChartInfoService().saveStatChartInfo(sci);
			logger.debug("生成统计图："+sci.getFileName()+"|保存路径："+sci.getSavePath());				
		}catch(Exception e) {
			logger.error("MakePartChart Error:"+e.getMessage());
		}
	}

}
