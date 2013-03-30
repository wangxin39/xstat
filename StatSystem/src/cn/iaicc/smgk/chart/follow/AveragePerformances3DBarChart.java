package cn.iaicc.smgk.chart.follow;

import java.awt.Paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategorySeriesLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.StandardGradientPaintTransformer;

import cn.iaicc.smgk.util.CustomBarRenderer;


public class AveragePerformances3DBarChart extends org.jfree.ui.ApplicationFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3581821582782839970L;

	private String createTitle = null;
	
	public AveragePerformances3DBarChart(String title) {
		super(title);
		CategoryDataset dataset = createDataset();
		this.createTitle = title;
		 JFreeChart chart = createChart(dataset);
		 ChartPanel chartPanel = new ChartPanel(chart,false);
		 chartPanel.setPreferredSize(new java.awt.Dimension(500,270));
		 setContentPane(chartPanel);
		 try {
			 File dir = new File("charts/2008/q1/a_follow/");
			 if (!dir.exists()) {
				dir.mkdir();
			}
			// 生成PNG图片
			 //charts/20080915/2008q1
			ChartUtilities.saveChartAsPNG(new File(dir,"average_performances_in_section_A1.png"), chart, 500, 270);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	}


	public static javax.swing.JPanel createDemoPanel(){
		return new javax.swing.JPanel();
	} 
 
    protected CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(58.89, "2007 average score", "2007 average score");
        dataset.addValue(89.47, "2008 Q1", "2008 Q1");
        return dataset;
    }   

    protected JFreeChart createChart(CategoryDataset dataset) {

        JFreeChart chart = ChartFactory.createBarChart3D(
        	createTitle,       // chart title
            "Quarter",                     // domain axis label
            "average performances(%)",                  // range axis label
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
		AveragePerformances3DBarChart demo = new AveragePerformances3DBarChart("average performances in follow up");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
	}
}
