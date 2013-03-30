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
	// ִ�з�����̳߳�
	private ExecutorService service = null;
	// �̳߳ش�С
	private int poolSize = 25;
	
	public void run() {
		try{
			service = Executors.newFixedThreadPool(poolSize);
			//������ȴ���
			taskSheduer();

		}catch(Exception e) {
			logger.error(e.getMessage());
		}	
	}

	/**
	 * �������
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
		
		//�ƻ����
		//�ڴμ��
		
		////������б���û�����ɵ��ڴ�
		issueInfoList = ServiceUtils.get().getIssueInfoService().findIssueInfoListByReportStatus();
		if(issueInfoList != null) {
			// �ڴμ��
			for(IssueInfo issueInfo:issueInfoList) {
				if(issueInfo != null) {
					logger.debug("�ڴ�:"+issueInfo.getIssue());
				}else{
					logger.debug("�ڴ�:");
					continue;
				}
				
				// ��ȡ��ǰ�ڴ���ͬ�ͻ��ĵ��������Ϣ
				informantInfoList = ServiceUtils.get().getInformantInfoService().getInformantInfoList(issueInfo.getClientID());
				
				// ���ڴ�û�н���ͳ�ƹ�������м�鵱ǰ�ڴ��Ƿ��мƻ���Ҫͳ�Ʒ���
				if((issueInfo.getActions() == IssueConstants.INQUISITION_DO || issueInfo.getActions() == IssueConstants.INQUISITION_STAT) && issueInfo.getStatStatus() == IssueConstants.NOT_STATUS) {
					planInfoList = ServiceUtils.get().getPlanInfoService().findByIssue(issueInfo.getIssueID());
					// �������мƻ�
					for(PlanInfo info:planInfoList) {				
						// �����״̬Ϊ���,��û�п�ʼͳ����ʼͳ��
						if(info.getStatStatus() == PlanConstants.NOT_STATUS && info.getCheckStatus() == PlanStatusConstants.OVER_CHECKSTATUS) {
							logger.debug("����ƻ���"+info.getName());
							// ͳ�Ƶ����ʾ�����ͳ�����ݲ�������Ӧͼ��
							statTask = new StatTask(issueInfo,info);
							service.execute(statTask);							
						}
					}
				}
				
				// ��ǰ�ڴ���Ҫ����ͳ�Ʒ���������ͳ�ƽ���
				if(issueInfo.getActions() == IssueConstants.INQUISITION_STAT && issueInfo.getStatStatus() == IssueConstants.END_STATUS) {										
					for(InformantInfo informantInfo:informantInfoList) {
						logger.debug("�������"+informantInfo.getName());

						// ����ͳ��ͼ
						partChartTask = new PartChartTask(issueInfo,informantInfo);
						service.execute(partChartTask);

						// �������ͳ��ͼ						
						informantChartTask = new InformantChartTask(issueInfo,informantInfo);
						service.execute(informantChartTask);						
					}					
					
					// �����ڴ������е����������ͨ����ͨ��
					checkPassTask = new CheckPassTask(issueInfo);
					service.execute(checkPassTask);					
				}
				
				
				// ��ǰ�ڴ���Ҫ�������ɱ��棬����ĩ��ʼ����,���������
				if(issueInfo.getActions() == IssueConstants.INQUISITION_REPORT && issueInfo.getReportStatus() == IssueConstants.NOT_STATUS 
						&& issueInfo.getEvaluationStatus() == IssueConstants.END_STATUS) {
					// ��ÿһ������������ɵ�������ɴ���				
					for(InformantInfo informantInfo:informantInfoList) {
						logger.debug("�������"+informantInfo.getName());											
						
						//�������������Ӧ���棨PDF/EXCEL/HTML��
						reportTask = new ReportTask(issueInfo,informantInfo);
						service.execute(reportTask);	

					}					
				}
			}						
		}


	}	
}
