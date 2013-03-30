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
			
			// 消息 header 中常有的 属性定义    
		    logger.debug("消息编码：" + message.getJMSMessageID()); 
		    logger.debug("目标对象：" + message.getJMSDestination()); 
		    logger.debug("消息模式：" + message.getJMSDeliveryMode()); // 消息的模式 分为持久模式和非持久模式, 默认是 非持久的模式（2） 
		        
		    long sendTime = message.getJMSTimestamp(); 
		    Date date = new Date(sendTime); 
		    DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		    String temp = f.format(date); 
		        
		    logger.debug("消息发送时间：" + temp);    
		    logger.debug("消息失效时间：" + message.getJMSExpiration()); // 这里是一个 整型值 0 表示 该消息永远不会过期 
		    logger.debug("消息优先级：" + message.getJMSPriority()); // 优先级 0~9, 0 表示最低 
		        
		    logger.debug("是否签收过：" + message.getJMSRedelivered()); // 如果是 真 ,表示客户端收到过该消息,但是并没有签收 
		        
			logger.debug("已经尝试发送消息的次数：" + message.getStringProperty("JMSXDeliveryCount")); 
			
			RecordInfo recordInfo = (RecordInfo)message.getObject();
			
			logger.debug("PlanID:"+recordInfo.getPlanID()+"|InquisitionID:"+recordInfo.getInquisitionID());
			
//			Map parameters = recordInfo.getParameters();
//			Iterator<String> it = parameters.keySet().iterator();
//			while(it.hasNext()) {
//				String key = it.next();
//				String[] arrs = (String[])parameters.get(key);
//				logger.debug(""+key+"|value:"+arrs[0]+"|length:"+arrs.length);
//			}			
			// 保存表头答案
			RecordHelper.saveHeader(recordInfo);			
			// 保存部分答案
			RecordHelper.savePart(recordInfo);
			
		}catch(JMSException ex) {
			logger.error(ex.getMessage(),ex.getCause());
		}			

	}

}
