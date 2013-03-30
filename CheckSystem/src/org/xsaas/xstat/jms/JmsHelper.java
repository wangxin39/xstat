package org.xsaas.xstat.jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class JmsHelper {
	private static ApplicationContext ctx = null;
	
	static {
		ctx = new FileSystemXmlApplicationContext("classpath*:jms_sender.xml");
	}
	
	public static RecordSender getRecordSender() {
		return (RecordSender)ctx.getBean("recordSender");
	}	
}
