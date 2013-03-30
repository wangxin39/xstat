package cn.iaicc.smgk.chart.informant;


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
			 File dir = new File("charts/2008/q1/beijing1/");
				if (!dir.exists()) {
					dir.mkdir();
				}
				// 生成PNG图片
				ChartUtilities.saveChartAsPNG(new File(dir,"comparisonwithprevious.png"), chart, 500, 270);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	}


	public static javax.swing.JPanel createDemoPanel(){
		return new javax.swing.JPanel();
	} 
 
    protected CategoryDataset createDataset() {
    	
    	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(new Double(91.65),"2007(Q1-Q4)","secton A1");
        dataset.addValue(new Double(100.00),"2008 Q1","secton A1");
        dataset.addValue(new Double(88.05),"2007(Q1-Q4)","secton A2");
        dataset.addValue(new Double(92.86),"2008 Q1","secton A2");
        dataset.addValue(new Double(93.53),"2007(Q1-Q4)","secton A3");
        dataset.addValue(new Double(100.00),"2008 Q1","secton A3");
        dataset.addValue(new Double(85.66),"2007(Q1-Q4)","secton B1");
        dataset.addValue(new Double(73.91),"2008 Q1","secton B1");
        dataset.addValue(new Double(80.30),"2007(Q1-Q4)","secton B2");
        dataset.addValue(new Double(70.00),"2008 Q1","secton B2");
        dataset.addValue(new Double(84.03),"2007(Q1-Q4)","secton B3");
        dataset.addValue(new Double(77.78),"2008 Q1","secton B3");             
        dataset.addValue(new Double(68.17),"2007(Q1-Q4)","Follow up");
        dataset.addValue(new Double(50.00),"2008 Q1","Follow up");

        dataset.addValue(new Double(84.12),"2007(Q1-Q4)","Overall");
        dataset.addValue(new Double(76.8),"2008 Q1","Overall");        
        
        return dataset;
    }   

    protected JFreeChart createChart(CategoryDataset dataset) {

        JFreeChart chart = ChartFactory.createBarChart3D(
        	createTitle,       // chart title
            "secton",                     // domain axis label
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
		PerformanceComparedWithAverageBarChart demo = new PerformanceComparedWithAverageBarChart("comparison with previous performance");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);

	}
}
