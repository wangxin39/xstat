package cn.iaicc.smgk.util;

import java.awt.Paint;

import org.jfree.chart.renderer.category.BarRenderer;

public class CustomBarRenderer extends BarRenderer {
	private static final long serialVersionUID = -7748940839979812289L;
    private Paint[] colors;
    public CustomBarRenderer(Paint[] colors) {
        this.colors = colors;
    }
    public Paint getItemPaint(int row, int column) {
        return this.colors[column % this.colors.length];
    }
}

