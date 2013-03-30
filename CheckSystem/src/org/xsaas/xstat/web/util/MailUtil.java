package org.xsaas.xstat.web.util;

import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class MailUtil {	
	private static ApplicationContext ctx = null;
	private static Log logger = LogFactory.getLog(MailUtil.class);
	
	private static JavaMailSender javaMailSender = null;
	
	private static MailUtil util = null;
	
	public MailUtil() {
		try{
			//创建ApplicationContext实例
			ctx = new FileSystemXmlApplicationContext("classpath*:SendMail.xml");					
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	public static MailUtil get() {
		if(util == null) {
			util = new MailUtil();
		}
		return util;
	}
	public void send(final String toMail, final String fromMail, final String subject, final String html, final String encoding) {
		if(javaMailSender == null) {
			javaMailSender = (JavaMailSender)ctx.getBean("mailSender");					
		}
		javaMailSender.send(new MimeMessagePreparator(){
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true, encoding);
				mmh.setTo(toMail);
				mmh.setFrom(fromMail);
				
				mmh.setSubject(subject);
				mmh.setText(html,true);

			}
		});		
	}
}
