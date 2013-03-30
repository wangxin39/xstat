package cn.iaicc.smgk.report;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import org.springframework.ui.jasperreports.JasperReportsUtils;

import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.fill.JRFileVirtualizer;

//import cn.iaicc.smgk.conf.Constants;

/**
 * 报告生成辅助工具
 * @author wangxin
 *
 */

public class ReportUtil {
	
	/**
	 * 报告输出打印主jasper
	 */
	private JasperPrint jasperPrint = null;
	
	private JRFileVirtualizer virtualizer = null;
	private HashMap<String, JRFileVirtualizer> caches = null;
	/**
	 * 参数存储的队列
	 */
	private List<Map<String, String>> list = new ArrayList<Map<String,String>>(); 
	/**
	 * 参数和对应的值$F{name}
	 */
	private Map<String, String> parameters = new HashMap<String,String>();
	
	public ReportUtil(int cacheSize) {
		virtualizer = new JRFileVirtualizer(cacheSize,new File("caches").getAbsolutePath());
        caches = new HashMap<String,JRFileVirtualizer>();
        caches.put(JRParameter.REPORT_VIRTUALIZER, virtualizer);
	}

	public synchronized void addParameter(String key,String value) {		
		parameters.put(key, value);
	}
	public synchronized void clearParameters() {
		parameters.clear();
	}
	
	@SuppressWarnings("unchecked")
	public synchronized void addPage(String template) throws JRException {		
		list.clear();
		list.add(parameters);
		
		JRMapCollectionDataSource ds = new JRMapCollectionDataSource(list);		
		JasperPrint jp = JasperFillManager.fillReport(template,caches,ds);
		// 第一个作为默认
		if(jasperPrint == null) {
			jasperPrint = jp;
		}else{ //追加进去
			List<JRPrintPage> pages = jp.getPages();
			for(JRPrintPage page:pages) {
			    jasperPrint.addPage(page);
			}			
		}
	}
	
	public synchronized static boolean checkDir(String dir) {
        File currentDir = new File(dir);
        if(!currentDir.exists()){
        	currentDir.mkdir();
        }
        return true;
	}
	
	public synchronized static void jasperCompile(String sourceName,String jasperName) throws JRException {
		//将.jrxml模板文件编译成为.jasper文件,当然,其文件名可以指定,如果没指定,则与.jrxml文件名一样.只是后缀不同而已
		JasperCompileManager.compileReportToFile(sourceName, new File(jasperName).getAbsolutePath());
	}	
	
	/**
	 * 输出文件
	 * @param filename 输出的文件名称
	 * @throws JRException
	 */
	public synchronized void exportToPdfFile(String filename) throws JRException {
//		JasperReportsUtils.renderAsPdf(jasperPrint, parameters);
		JasperExportManager.exportReportToPdfFile(jasperPrint,filename);        
	}
	/**
	 * 输出文件
	 * @param filename 输出的文件名称
	 * @throws JRException
	 */	
	public synchronized void exportToHtmlFile(String filename) throws JRException {
		JasperExportManager.exportReportToHtmlFile(jasperPrint,filename);		
	}
	/**
	 * 输出文件
	 * @param filename 输出的文件名称
	 * @throws JRException
	 */
	public synchronized void exportToExcelFile(String filename) throws JRException {
		JasperExportManager.exportReportToXmlFile(jasperPrint,filename,true);
	}
}
