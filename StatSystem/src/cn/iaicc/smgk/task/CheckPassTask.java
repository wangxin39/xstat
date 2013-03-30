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
 * �����ڴ������е�������ÿ������ͨ����ͨ��
 * @author Administrator
 *
 */

public class CheckPassTask implements Runnable {
	
	private static Log logger = LogFactory.getLog(CheckPassTask.class);
	private IssueInfo issueInfo = null;
	
//	private final double PASS = 0.75; // ���ں͵���0.75�֣���ͨ��������ͨ��
	
	public CheckPassTask(IssueInfo issueInfo) {
		this.issueInfo = issueInfo;
	}
	
	
	@Override
	public void run() {
		if(issueInfo != null) {
			logger.debug("ͨ����⿪ʼ:"+issueInfo.getIssue());
			check();
			logger.debug("ͨ��������");
		}

	}
	// �����������
	public void check() {
		
		try{
			FinalEvaluationInfo info = new FinalEvaluationInfo();
			List<Integer> times = null;
			// ���ָ�����������ڣ���ȡ��ֵ
			if(issueInfo.getCheckTime() != null) {
				info.setCheckTime(issueInfo.getCheckTime());
			}else{ // ����ȡ��ǰʱ����Ϊ����ʱ��
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
			// �ܵ��������
			info.setInformantNum(informantInfoList.size());
			// ����ͨ����:�統ǰ�ڴ��У�ĳ�����������һ�����ֲ�ͨ������˵������Ϊʧ��
			int passNum = 0;
			// ����ʧ������
			int failNum = 0;
			
			List<InformantEvaluationInfo> informantEvaluationInfoList = null;
			boolean isFail = false;
			
			for(InformantInfo ii:informantInfoList) {
				// ȡ��������Ϣ
				informantEvaluationInfoList = ServiceUtils.get().getInquisitionEvaluateInfoService().findByInformant(issueInfo.getIssueID(), ii.getInformantID());
				isFail = false;
				if(informantEvaluationInfoList != null && informantEvaluationInfoList.size() > 0) {
					for(InformantEvaluationInfo iei:informantEvaluationInfoList) {
						// ͨ��
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
			logger.debug("ƽ��ֵ��"+info.getAverage()+"|passNum:"+passNum+"|failNum:"+failNum);
			// ƽ��ֵ		
			ServiceUtils.get().getFinalEvaluationInfoService().saveFinalEvaluationInfo(info);
			
			
			
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}
		
		
		
	}

}
