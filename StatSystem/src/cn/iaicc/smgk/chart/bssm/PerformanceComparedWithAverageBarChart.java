package cn.iaicc.smgk.chart.bssm;


import java.awt.Color;
import java.awt.GradientPaint;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;


public class PerformanceComparedWithAverageBarChart extends org.jfree.ui.ApplicationFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3581821582782839970L;

	private String createTitle = null;
	
	public PerformanceComparedWithAverageBarChart(String title) {
		super(title);
		CategoryDataset dataset = createDataset();
		this.createTitle = title;
		 JFreeChart chart = createChart(dataset);
		 ChartPanel chartPanel = new ChartPanel(chart,false);
		 chartPanel.setPreferredSize(new java.awt.Dimension(600,400));
		 setContentPane(chartPanel);
		 try {
			 File dir = new File("charts/2008/q1/a_B_S_S_M");
			 if(!dir.exists()){
				 dir.mkdir();
			 }
			// 生成PNG图片
			 System.out.print(dir);
			ChartUtilities.saveChartAsPNG(new File(dir,"comparisonwithprevious_B_S.png"), chart, 500, 270);
		 } catch (IOException e) {
			e.printStackTrace();
		}
		 
	}


	public static javax.swing.JPanel createDemoPanel(){
		return new javax.swing.JPanel();
	} 
 
    protected CategoryDataset createDataset() {
    	
    	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    	
        dataset.addValue(new Double(84.12),"2007(Q1-Q4)","Beijing I");
        dataset.addValue(new Double(82.12),"2007(Q1-Q4)","Beijing II");
        dataset.addValue(new Double(88.46),"2007(Q1-Q4)","Chengdu");
        dataset.addValue(new Double(80.76),"2007(Q1-Q4)","Chongqing");
        dataset.addValue(new Double(75.48),"2007(Q1-Q4)","Dalian");
        dataset.addValue(new Double(48.15),"2007(Q1-Q4)","Guangdong");
        dataset.addValue(new Double(94.53),"2007(Q1-Q4)","Hangzhou");
        dataset.addValue(new Double(88.99),"2007(Q1-Q4)","Qingdao");
        dataset.addValue(new Double(83.35),"2007(Q1-Q4)","Shanghai");
    	
        dataset.addValue(new Double(76.78),"2008 Q1","Beijing I");
        dataset.addValue(new Double(97.06),"2008 Q1","Beijing II");
        dataset.addValue(new Double(94.17),"2008 Q1","Chengdu");
        dataset.addValue(new Double(96.59),"2008 Q1","Chongqing");
        dataset.addValue(new Double(93.14),"2008 Q1","Dalian");
        dataset.addValue(new Double(88.83),"2008 Q1","Guangdong");
        dataset.addValue(new Double(87.29),"2008 Q1","Hangzhou");
        dataset.addValue(new Double(91.18),"2008 Q1","Qingdao");
        dataset.addValue(new Double(89.6),"2008 Q1","Shanghai");
    	
             
        return dataset;
    }   

    protected JFreeChart createChart(CategoryDataset dataset) {

        JFreeChart chart = ChartFactory.createBarChart3D(
        	createTitle,       // chart title
            "section",                     // domain axis label
            "comparisons(%)",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // the plot orientation
            false,                    // include legend
            true,
            false
        );

        TextTitle title = chart.getTitle();
        title.setBorder(0, 0, 1, 0);
        title.setBackgroundPaint(new GradientPaint(0f, 0f, Color.red, 100f, 0f, Color.white, true));
        title.setExpandToFitSpace(true);

        chart.setBackgroundPaint(new GradientPaint(0f, 0f, Color.yellow, 100f, 0f, Color.white, true));

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        CategoryAxis axis = plot.getDomainAxis();
        axis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI/8.0));
        
        NumberAxis rangeAxis = (NumberAxis)plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setRange(0.0f, 100.0f);
        rangeAxis.setTickMarkPaint(Color.black);

        return chart;

    }
    
	public static void main(java.lang.String[] args)
	{
		PerformanceComparedWithAverageBarChart demo = 
			new PerformanceComparedWithAverageBarChart
			("comparison scores between last yesr performance and 2008 Q1");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);

	}
}
