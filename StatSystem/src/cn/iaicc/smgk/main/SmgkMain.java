package cn.iaicc.smgk.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.util.SpringHelper;

public class SmgkMain {
	private static Log logger = LogFactory.getLog(SmgkMain.class);	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			logger.info("正在启动管理平台维护系统");
			// 启动统计分析
			SpringHelper.startup();
            logger.info("统计分析处理器启动完毕");
            // 启用JMS监听容器
			SpringHelper.receiver();
            logger.info("调查问卷处理器启动完毕");
            logger.info("等待执行任务  ......"); 
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}		
	}
}
