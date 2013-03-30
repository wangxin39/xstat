package cn.iaicc.smgk.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringHelper {
	private static ApplicationContext ctx = null;
	
	static {
		ctx = new FileSystemXmlApplicationContext(new String[]{"classpath*:jms_receiver.xml","classpath*:quarz.xml"});
	}
	
	public static void startup() {
		ctx.getBean("timerFactory");
	}
	
	public static void receiver() {
		ctx.getBean("listenerContainer");
	}
}
