package cn.iaicc.smgk.jms;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RecordListener implements MessageListener {
	private static Log logger = LogFactory.getLog(RecordListener.class);
	
	@Override
	public void onMessage(Message msg) {
		try{
			ObjectMessage message = (ObjectMessage)msg;
			
			// ��Ϣ header �г��е� ���Զ���    
		    logger.debug("��Ϣ���룺" + message.getJMSMessageID()); 
		    logger.debug("Ŀ�����" + message.getJMSDestination()); 
		    logger.debug("��Ϣģʽ��" + message.getJMSDeliveryMode()); // ��Ϣ��ģʽ ��Ϊ�־�ģʽ�ͷǳ־�ģʽ, Ĭ���� �ǳ־õ�ģʽ��2�� 
		        
		    long sendTime = message.getJMSTimestamp(); 
		    Date date = new Date(sendTime); 
		    DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		    String temp = f.format(date); 
		        
		    logger.debug("��Ϣ����ʱ�䣺" + temp);    
		    logger.debug("��ϢʧЧʱ�䣺" + message.getJMSExpiration()); // ������һ�� ����ֵ 0 ��ʾ ����Ϣ��Զ������� 
		    logger.debug("��Ϣ���ȼ���" + message.getJMSPriority()); // ���ȼ� 0~9, 0 ��ʾ��� 
		        
		    logger.debug("�Ƿ�ǩ�չ���" + message.getJMSRedelivered()); // ����� �� ,��ʾ�ͻ����յ�������Ϣ,���ǲ�û��ǩ�� 
		        
			logger.debug("�Ѿ����Է�����Ϣ�Ĵ�����" + message.getStringProperty("JMSXDeliveryCount")); 
			
			RecordInfo recordInfo = (RecordInfo)message.getObject();
			
			logger.debug("PlanID:"+recordInfo.getPlanID()+"|InquisitionID:"+recordInfo.getInquisitionID());
			
//			Map parameters = recordInfo.getParameters();
//			Iterator<String> it = parameters.keySet().iterator();
//			while(it.hasNext()) {
//				String key = it.next();
//				String[] arrs = (String[])parameters.get(key);
//				logger.debug(""+key+"|value:"+arrs[0]+"|length:"+arrs.length);
//			}			
			// �����ͷ��
			RecordHelper.saveHeader(recordInfo);			
			// ���沿�ִ�
			RecordHelper.savePart(recordInfo);
			
		}catch(JMSException ex) {
			logger.error(ex.getMessage(),ex.getCause());
		}			

	}

}
