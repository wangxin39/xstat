package cn.iaicc.smgk.chart;


import java.awt.Color;
import java.awt.GradientPaint;
import java.io.File;
import java.io.IOException;
import java.util.List;

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
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

import cn.iaicc.smgk.chart.bo.PartDatasetInfo;

public class ComparisonBarChartUtil {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3581821582782839970L;

	private String createTitle = null;
	private String savePath = null;
	private String filename = null;	
	private DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	private List<PartDatasetInfo> datasetList = null;
	
	public ComparisonBarChartUtil() {
	}
	
	public void init(String title,String filename,String savePath,List<PartDatasetInfo> datasetList) {
		this.createTitle = title;
		this.filename = filename;
		this.savePath = savePath;
		this.datasetList = datasetList;
		
		for(PartDatasetInfo info:datasetList) {
			dataset.addValue(info.getScore(), info.getName(), info.getPart());
		}		
		JFreeChart chart = createChart(dataset);
		ChartPanel chartPanel = new ChartPanel(chart,false);
		chartPanel.setPreferredSize(new java.awt.Dimension(600,400));
		try {
			// 生成PNG图片
			ChartUtilities.saveChartAsPNG(new File(""+savePath+"/"+filename), chart, 500, 270);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	}


	public static javax.swing.JPanel createDemoPanel(){
		return new javax.swing.JPanel();
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
        //显示数�?    
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
            
        categoryplot.setDataset(1, dataset);    
            
        LineAndShapeRenderer lineandshaperenderer = new LineAndShapeRenderer();    
        lineandshaperenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());    
        lineandshaperenderer.setSeriesPaint(0, new Color(255, 137, 255)); // 粉红     
            
        categoryplot.setRenderer(1, lineandshaperenderer);    
        categoryplot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);            
        

        return chart;

    }

	public String getCreateTitle() {
		return createTitle;
	}

	public void setCreateTitle(String createTitle) {
		this.createTitle = createTitle;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public DefaultCategoryDataset getDataset() {
		return dataset;
	}

	public void setDataset(DefaultCategoryDataset dataset) {
		this.dataset = dataset;
	}

	public List<PartDatasetInfo> getDatasetList() {
		return datasetList;
	}

	public void setDatasetList(List<PartDatasetInfo> datasetList) {
		this.datasetList = datasetList;
	}
}
