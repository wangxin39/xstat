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

public class InformantChartTask implements Runnable {
	
	private static Log logger = LogFactory.getLog(InformantChartTask.class);
	private IssueInfo issueInfo = null;
	private InformantInfo informantInfo = null;
	
	public InformantChartTask(IssueInfo issueInfo,InformantInfo informantInfo) {
		this.issueInfo = issueInfo;
		this.informantInfo = informantInfo;
	}
	
	
	@Override
	public void run() {
		if(issueInfo != null && informantInfo != null) {
			logger.debug("ͳ��ͼ���ɴ���ʼ:"+informantInfo.getName());
			makeInformantChart();			
			logger.debug("ͳ��ͼ����");
		}

	}
	
	/**
	 * ���ɵ������ͳ��ͼ
	 */
	private void makeInformantChart() {
		List<PartDatasetInfo> datasetList = null; // �账��˴����������
		ComparisonBarChartUtil cbc = new ComparisonBarChartUtil();				
		try{
			logger.debug("���ɵ������ͳ��ͼ��ʼ");
			
			String savePath = Constants.OUTPUT_DIR+"charts/"+Constants.CURRENT_DIR;	
			logger.debug("����performance:"+savePath);
			File dir = new File(savePath);
			if(!dir.exists()) {
				dir.mkdir();
			}
			cbc.init(""+informantInfo.getEnglishName()+" performance compared with overall average performance","/"+informantInfo.getEnglishName()+"performance.png",savePath, datasetList);
			StatChartInfo sci = new StatChartInfo();
			sci.setFileName(""+informantInfo.getEnglishName()+"performance.png");
			sci.setSavePath(savePath);
			sci.setIssueID(issueInfo.getIssueID());
			sci.setType(2); //1:����ͳ��ͼ��2���������ͼ
			
			//�˴���Ҫ����Ƿ��ѱ��浽���ݿ⣬���ڵĻ���������		
//			ServiceUtils.get().getStatChartInfoService().saveStatChartInfo(sci);
			logger.debug("����ͳ��ͼ��"+sci.getFileName()+"|����·����"+sci.getSavePath());					
		}catch(Exception e) {
			logger.error("MakeInformantChart Error:"+e.getMessage());
		}

	}

}
