package cn.iaicc.smgk.main;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.conf.IssueConstants;
import cn.iaicc.smgk.conf.PlanConstants;
import cn.iaicc.smgk.conf.PlanStatusConstants;
import cn.iaicc.smgk.po.InformantInfo;
import cn.iaicc.smgk.po.IssueInfo;
import cn.iaicc.smgk.po.PlanInfo;
import cn.iaicc.smgk.task.CheckPassTask;
import cn.iaicc.smgk.task.InformantChartTask;
import cn.iaicc.smgk.task.PartChartTask;
import cn.iaicc.smgk.task.ReportTask;
import cn.iaicc.smgk.task.StatTask;
import cn.iaicc.smgk.util.ServiceUtils;

public class StatTool {
	private Log logger = LogFactory.getLog(StatTool.class);
	// 执行服务的线程池
	private ExecutorService service = null;
	// 线程池大小
	private int poolSize = 25;
	
	public void run() {
		try{
			service = Executors.newFixedThreadPool(poolSize);
			//任务调度处理
			taskSheduer();

		}catch(Exception e) {
			logger.error(e.getMessage());
		}	
	}

	/**
	 * 任务调度
	 */
	private void taskSheduer() {

		StatTask statTask = null;
		ReportTask reportTask = null;
		InformantChartTask informantChartTask = null;
		PartChartTask partChartTask = null;
		CheckPassTask checkPassTask = null;

		List<IssueInfo> issueInfoList = null;	
		List<PlanInfo> planInfoList = null;
		List<InformantInfo> informantInfoList = null;
		
		//计划检查
		//期次检查
		
		////检查所有报告没有生成的期次
		issueInfoList = ServiceUtils.get().getIssueInfoService().findIssueInfoListByReportStatus();
		if(issueInfoList != null) {
			// 期次检查
			for(IssueInfo issueInfo:issueInfoList) {
				if(issueInfo != null) {
					logger.debug("期次:"+issueInfo.getIssue());
				}else{
					logger.debug("期次:");
					continue;
				}
				
				// 获取当前期次相同客户的调查对象信息
				informantInfoList = ServiceUtils.get().getInformantInfoService().getInformantInfoList(issueInfo.getClientID());
				
				// 当期次没有进行统计过，则进行检查当前期次是否有计划需要统计分析
				if((issueInfo.getActions() == IssueConstants.INQUISITION_DO || issueInfo.getActions() == IssueConstants.INQUISITION_STAT) && issueInfo.getStatStatus() == IssueConstants.NOT_STATUS) {
					planInfoList = ServiceUtils.get().getPlanInfoService().findByIssue(issueInfo.getIssueID());
					// 处理所有计划
					for(PlanInfo info:planInfoList) {				
						// 当检测状态为检测,并没有开始统计则开始统计
						if(info.getStatStatus() == PlanConstants.NOT_STATUS && info.getCheckStatus() == PlanStatusConstants.OVER_CHECKSTATUS) {
							logger.debug("调查计划："+info.getName());
							// 统计调查问卷，分析统计数据并产生相应图表
							statTask = new StatTask(issueInfo,info);
							service.execute(statTask);							
						}
					}
				}
				
				// 当前期次需要进行统计分析，并且统计结束
				if(issueInfo.getActions() == IssueConstants.INQUISITION_STAT && issueInfo.getStatStatus() == IssueConstants.END_STATUS) {										
					for(InformantInfo informantInfo:informantInfoList) {
						logger.debug("调查对象："+informantInfo.getName());

						// 部分统计图
						partChartTask = new PartChartTask(issueInfo,informantInfo);
						service.execute(partChartTask);

						// 调查对象统计图						
						informantChartTask = new InformantChartTask(issueInfo,informantInfo);
						service.execute(informantChartTask);						
					}					
					
					// 计算期次中所有调查对象整体通过不通过
					checkPassTask = new CheckPassTask(issueInfo);
					service.execute(checkPassTask);					
				}
				
				
				// 当前期次需要进行生成报告，并且末开始生成,评论已完成
				if(issueInfo.getActions() == IssueConstants.INQUISITION_REPORT && issueInfo.getReportStatus() == IssueConstants.NOT_STATUS 
						&& issueInfo.getEvaluationStatus() == IssueConstants.END_STATUS) {
					// 对每一个调查对象生成单项报告生成处理				
					for(InformantInfo informantInfo:informantInfoList) {
						logger.debug("调查对象："+informantInfo.getName());											
						
						//调查对象生成相应报告（PDF/EXCEL/HTML）
						reportTask = new ReportTask(issueInfo,informantInfo);
						service.execute(reportTask);	

					}					
				}
			}						
		}


	}	
}
