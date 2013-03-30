package org.xsaas.xstat.web.util;

import javax.jms.MapMessage;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class JmsUtil {
	private static BeanFactory factory = null;
	private static JmsUtil instance = null;
	private JmsUtil() {
		factory = new ClassPathXmlApplicationContext("classpath*:jms.xml");
	}
	
	public static JmsUtil get() {
		if(instance == null) {
			instance = new JmsUtil();
		}
		return instance;
	}
	
	public static void send(MapMessage map) {
		try {			
			JmsTemplate template = (JmsTemplate)factory.getBean("jmsTemplate");
			template.convertAndSend(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
