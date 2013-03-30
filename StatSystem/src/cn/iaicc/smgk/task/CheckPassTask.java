package cn.iaicc.smgk.task;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.conf.Constants;
import cn.iaicc.smgk.po.FinalEvaluationInfo;
import cn.iaicc.smgk.po.InformantEvaluationInfo;
import cn.iaicc.smgk.po.InformantInfo;
import cn.iaicc.smgk.po.InquisitionMarkInfo;
import cn.iaicc.smgk.po.IssueInfo;
import cn.iaicc.smgk.po.PartInfo;
import cn.iaicc.smgk.po.StatPartInfo;
import cn.iaicc.smgk.util.ServiceUtils;
/**
 * 计算期次中所有调查对象的每个部分通过不通过
 * @author Administrator
 *
 */

public class CheckPassTask implements Runnable {
	
	private static Log logger = LogFactory.getLog(CheckPassTask.class);
	private IssueInfo issueInfo = null;
	
//	private final double PASS = 0.75; // 大于和等于0.75分，则通过，否则不通过
	
	public CheckPassTask(IssueInfo issueInfo) {
		this.issueInfo = issueInfo;
	}
	
	
	@Override
	public void run() {
		if(issueInfo != null) {
			logger.debug("通过检测开始:"+issueInfo.getIssue());
			check();
			logger.debug("通过检测结束");
		}

	}
	// 此期评估检测
	public void check() {
		
		try{
			FinalEvaluationInfo info = new FinalEvaluationInfo();
			List<Integer> times = null;
			// 如果指定了生成日期，则取该值
			if(issueInfo.getCheckTime() != null) {
				info.setCheckTime(issueInfo.getCheckTime());
			}else{ // 否则取当前时间做为生成时间
				info.setCheckTime(new Timestamp(System.currentTimeMillis()));
			}
			times = Constants.init(info.getCheckTime());
			info.setYear(times.get(0));
			info.setMonth(times.get(1));
			info.setDay(times.get(2));
			info.setClientID(issueInfo.getClientID());
			info.setProjectID(issueInfo.getProjectID());
			info.setIssueID(issueInfo.getIssueID());
				
			
			List<InformantInfo> informantInfoList = ServiceUtils.get().getInformantInfoService().getInformantInfoList(issueInfo.getClientID());
			// 总调查对象数
			info.setInformantNum(informantInfoList.size());
			// 计算通过数:如当前期次中，某个调查对象，有一个部分不通过，则此调查对象为失败
			int passNum = 0;
			// 计算失败数：
			int failNum = 0;
			
			List<InformantEvaluationInfo> informantEvaluationInfoList = null;
			boolean isFail = false;
			
			for(InformantInfo ii:informantInfoList) {
				// 取得评估信息
				informantEvaluationInfoList = ServiceUtils.get().getInquisitionEvaluateInfoService().findByInformant(issueInfo.getIssueID(), ii.getInformantID());
				isFail = false;
				if(informantEvaluationInfoList != null && informantEvaluationInfoList.size() > 0) {
					for(InformantEvaluationInfo iei:informantEvaluationInfoList) {
						// 通过
						if(iei.getEvaluation() == 2 && !isFail) {
							isFail = true;
						}
					}
					
					if(isFail) {
						passNum ++;
					}else{
						failNum ++;
					}
				}
			}
			
			info.setPassNum(passNum);
			info.setFailNum(failNum);
			info.setAverage(ServiceUtils.get().getInquisitionMarkInfoService().getAverage(issueInfo.getIssueID()));
			logger.debug("平均值："+info.getAverage()+"|passNum:"+passNum+"|failNum:"+failNum);
			// 平均值		
			ServiceUtils.get().getFinalEvaluationInfoService().saveFinalEvaluationInfo(info);
			
			
			
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}
		
		
		
	}

}
