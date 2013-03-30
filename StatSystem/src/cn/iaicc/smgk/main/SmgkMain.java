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
			logger.info("������������ƽ̨ά��ϵͳ");
			// ����ͳ�Ʒ���
			SpringHelper.startup();
            logger.info("ͳ�Ʒ����������������");
            // ����JMS��������
			SpringHelper.receiver();
            logger.info("�����ʾ������������");
            logger.info("�ȴ�ִ������  ......"); 
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}		
	}
}
