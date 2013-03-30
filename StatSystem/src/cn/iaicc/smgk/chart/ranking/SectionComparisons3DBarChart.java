package cn.iaicc.smgk.chart.ranking;

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


public class SectionComparisons3DBarChart extends org.jfree.ui.ApplicationFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3581821582782839970L;

	private String createTitle = null;
	
	public SectionComparisons3DBarChart(String title) {
		super(title);
		CategoryDataset dataset = createDataset();
		this.createTitle = title;
		 JFreeChart chart = createChart(dataset);
		 ChartPanel chartPanel = new ChartPanel(chart,false);
		 chartPanel.setPreferredSize(new java.awt.Dimension(600,400));
		 setContentPane(chartPanel);
		 try {
			File dir = new File("charts/2008/q1/a_ranking/");
			if (!dir.exists()) {
				dir.mkdir();
			}
			// 生成PNG图片
			ChartUtilities.saveChartAsPNG(new File(dir,
					"sectioncomparisons3d.png"), chart, 500, 270);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	}


	public static javax.swing.JPanel createDemoPanel(){
		return new javax.swing.JPanel();
	} 
 
    protected CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(76.78, "BeiJing I", "BeiJing I");
        dataset.addValue(97.06, "BeiJing II", "BeiJing II");
        dataset.addValue(94.17, "ChengDu", "ChengDu");
        dataset.addValue(96.59, "ChongQing", "ChongQing");
        dataset.addValue(93.14, "DaLian", "DaLian");
        dataset.addValue(88.83, "GuangZhou", "GuangZhou");                
        dataset.addValue(87.29, "HangZhou", "HangZhou");
        dataset.addValue(91.18, "QingDao", "QingDao");
        dataset.addValue(89.60, "ShangHai", "ShangHai");
        dataset.addValue(90.69, "ShenYang", "ShenYang");
        dataset.addValue(99.03, "TianJin", "TianJin");
        dataset.addValue(98.05, "WenZhou", "WenZhou");
        dataset.addValue(93.63, "WuHan", "WuHan");                
        dataset.addValue(92.65, "Xi'An", "Xi'An");
        dataset.addValue(99.03, "XiaMen", "XiaMen");
        dataset.addValue(93.63, "NanJing", "NanJing");
        dataset.addValue(97.07, "KunMing", "KunMing");
        dataset.addValue(86.87, "Hong Kong", "Hong Kong");
        dataset.addValue(79.9, "Macau", "Macau");   
     
        return dataset;
    }   

    protected JFreeChart createChart(CategoryDataset dataset) {

        JFreeChart chart = ChartFactory.createBarChart3D(
        	createTitle,       // chart title
            "City",                     // domain axis label
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
		SectionComparisons3DBarChart demo = new SectionComparisons3DBarChart("Q1 overall score");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);

	}
}
