package cn.iaicc.smgk.chart.informant;


import java.awt.Color;
import java.awt.GradientPaint;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAnchor;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;


public class ComparisonBarChart extends org.jfree.ui.ApplicationFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3581821582782839970L;

	private String createTitle = null;
	
	public ComparisonBarChart(String title) {
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
				ChartUtilities.saveChartAsPNG(new File(dir,"performance.png"), chart, 500, 270);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	}


	public static javax.swing.JPanel createDemoPanel(){
		return new javax.swing.JPanel();
	} 
 
    protected CategoryDataset createDataset() {    	
    	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(new Double(100.00),"score of Beijing I","secton A1");
        dataset.addValue(new Double(92.86),"score of Beijing I","secton A2");
        dataset.addValue(new Double(100.00),"score of Beijing I","secton A3");
        dataset.addValue(new Double(73.91),"score of Beijing I","secton B1");
        dataset.addValue(new Double(70.00),"score of Beijing I","secton B2");
        dataset.addValue(new Double(77.78),"score of Beijing I","secton B3");             
        dataset.addValue(new Double(50.00),"score of Beijing I","Follow up");
        
        return dataset;
    }   

    protected CategoryDataset createDataset2() {    	
    	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(new Double(100.00),"average score of PCs","secton A1");
        dataset.addValue(new Double(97.4),"average score of PCs","secton A2");
        dataset.addValue(new Double(94.70),"average score of PCs","secton A3");
        dataset.addValue(new Double(94.2),"average score of PCs","secton B1");
        dataset.addValue(new Double(87.7),"average score of PCs","secton B2");
        dataset.addValue(new Double(92.3),"average score of PCs","secton B3");             
        dataset.addValue(new Double(89.5),"average score of PCs","Follow up");
        
        return dataset;
    }       
    
    protected JFreeChart createChart(CategoryDataset dataset) {

        JFreeChart chart = ChartFactory.createStackedBarChart(
        	createTitle,       // chart title
            "secton",                     // domain axis label
            "performance(%)",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // the plot orientation
            true,                    // include legend
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
        
      
        //创建Renderer    
        GroupedStackedBarRenderer groupedstackedbarrenderer = new GroupedStackedBarRenderer();                  
        //显示数值    
        groupedstackedbarrenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());    
        //可见?    
        groupedstackedbarrenderer.setBaseItemLabelsVisible(true);    
        //显示位置    
        groupedstackedbarrenderer.setPositiveItemLabelPositionFallback(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.BOTTOM_CENTER));    
        groupedstackedbarrenderer.setItemMargin(0.05000000000000001D);    
            
        CategoryPlot categoryplot = (CategoryPlot)chart.getPlot();    
        categoryplot.setDomainGridlinePosition(CategoryAnchor.MIDDLE);    
            
        //横网格线    
        categoryplot.setRangeGridlinesVisible(true);    
        //竖风格线    
        categoryplot.setDomainGridlinesVisible(false);    
            
        //横轴    
        CategoryAxis domainAxis=categoryplot.getDomainAxis();    
        //间隔    
        domainAxis.setCategoryMargin(0.2);    
            
        categoryplot.setRenderer(groupedstackedbarrenderer);    
        categoryplot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);    
            
        categoryplot.setDataset(1, createDataset2());    
            
        LineAndShapeRenderer lineandshaperenderer = new LineAndShapeRenderer();    
        lineandshaperenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());    
        lineandshaperenderer.setSeriesPaint(0, new Color(255, 137, 255)); // 粉红     
            
        categoryplot.setRenderer(1, lineandshaperenderer);    
        categoryplot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);            
        

        return chart;

    }
    
	public static void main(java.lang.String[] args)
	{
		ComparisonBarChart demo = new ComparisonBarChart("Beijing I performance compared with overall average performance");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);

	}
}
