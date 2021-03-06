/*
 * ExponentialTrendDemo.java
 *
 * <p>Copyright: (c) 2005-2008 by Steema Software SL. All Rights Reserved.</p>
 *
 * <p>Company: Steema Software SL</p>
 */

package features.function.trend;

import org.eclipse.swt.widgets.Composite;

import com.steema.teechart.drawing.Color;
import com.steema.teechart.functions.Trend;
import com.steema.teechart.functions.TrendStyle;
import com.steema.teechart.styles.FastLine;
import com.steema.teechart.styles.Line;

import features.ChartSample;

/**
 * @author tom
 *
 */
public class ExponentialTrendDemo extends ChartSample {
    
	public ExponentialTrendDemo(Composite c) {
		super(c);
	}

	protected void initContent() {
		super.initContent();
        getButtonPane().setVisible(false);
	}

	protected void initChart() {
		super.initChart();
        chart1.getHeader().setVisible(false);
        chart1.getAspect().setView3D(false);
        chart1.getLegend().setCheckBoxes(true);
        FastLine sourceSeries = new com.steema.teechart.styles.FastLine(chart1.getChart());
        {
            sourceSeries.setColor(Color.RED);
            sourceSeries.getMarks().setVisible(false);
            sourceSeries.fillSampleValues(100);
        }

        FastLine tmpFastLine = new com.steema.teechart.styles.FastLine(chart1.getChart());
        {
            tmpFastLine.setTitle("Exp. Trend");
            tmpFastLine.setColor(Color.BLUE);
            tmpFastLine.getMarks().setVisible(false);
            tmpFastLine.setDataSource(sourceSeries);

            tmpFastLine.setFunction(new com.steema.teechart.functions.Trend());
            ((Trend)tmpFastLine.getFunction()).setTrendStyle(TrendStyle.EXPONENTIAL);
        }

        Line tmpLine = new com.steema.teechart.styles.Line(chart1.getChart());
        {
            tmpLine.setActive(false);
            tmpLine.setTitle("Trend");
            tmpLine.setColor(Color.GREEN);
            tmpLine.getMarks().setVisible(false);
            tmpLine.getPointer().setVisible(false);

            tmpLine.setDataSource(sourceSeries);

            tmpLine.setFunction(new com.steema.teechart.functions.Trend());
            ((Trend)tmpLine.getFunction()).setTrendStyle(TrendStyle.NORMAL);
        }        
	}   			
}
