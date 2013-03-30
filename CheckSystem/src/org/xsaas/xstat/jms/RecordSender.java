package org.xsaas.xstat.jms;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.core.support.JmsGatewaySupport;

public class RecordSender extends JmsGatewaySupport {
	private static Log logger = LogFactory.getLog(RecordSender.class);
	/**
	 * 通过JMS异步发送记录到答卷处理器
	 * @param recordInfo RecordInfo
	 */
	public void send(final RecordInfo recordInfo) {
		this.getJmsTemplate().send(new MessageCreator() {
			private ObjectMessage message = null;

			@Override
			public ObjectMessage createMessage(Session session) throws JMSException {
				try{
					this.message = session.createObjectMessage(RecordInfo.class);
					this.message.setObject(recordInfo);
				}catch(Exception e) {
					logger.error(e.getMessage(),e.getCause());
				}
				return message;
			}
			
		});
	}
}
