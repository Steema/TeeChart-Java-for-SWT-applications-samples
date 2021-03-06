/*
 * MultiDemo.java
 *
 * <p>Copyright: Copyright (c) 2005-2008 by Steema Software SL. All Rights Reserved.</p>
 *
 * <p>Company: Steema Software SL</p>
 */
package features.style.pie;

import org.eclipse.swt.widgets.Composite;

import com.steema.teechart.Rectangle;
import com.steema.teechart.events.ChartDrawEvent;
import com.steema.teechart.events.SeriesPaintAdapter;
import com.steema.teechart.styles.MarksStyle;
import com.steema.teechart.styles.Pie;

import features.ChartSample;

/**
 * @author tom
 * 
 */
public class MultiDemo extends ChartSample {

	public MultiDemo(Composite c) {
		super(c);
	}

	protected void initContent() {
		super.initContent();
		getButtonPane().setVisible(false);
	}

	protected void initChart() {
		super.initChart();
		chart1.getHeader().setVisible(true);
		chart1.getLegend().setVisible(false);
		chart1.setText("Multiple Pies");
		chart1.getAspect().setView3D(false);
		chart1.getAspect().setChart3DPercent(15);
		chart1.getAspect().setElevation(315);
		chart1.getAspect().setOrthogonal(false);
		chart1.getAspect().setPerspective(0);
		chart1.getAspect().setRotation(360);
		initSeries();
	}

	protected void initSeries() {
		Pie pieSeries;
		final int margin = 20;

		for (int i = 2; i < 6; i++) {
			pieSeries = new com.steema.teechart.styles.Pie(chart1.getChart());
			if ((i % 2) == 1) {
				pieSeries.getMarks().setStyle(MarksStyle.VALUE);
			}
			pieSeries.getMarks().getFrame().setVisible(false);
			pieSeries.getMarks().setVisible(true);
			pieSeries.fillSampleValues(i * 2);
		}

		chart1.getSeries(1).addSeriesPaintListener(new SeriesPaintAdapter() {
			public void seriesPainting(ChartDrawEvent e) {
				chart1.getChart().setChartRect(new Rectangle(0 + margin, 0 + margin, (chart1.getWidth() / 2) - (margin * 2), (chart1.getHeight() / 2) - (margin * 2)));
			}
		});
		chart1.getSeries(0).addSeriesPaintListener(new SeriesPaintAdapter() {
			public void seriesPainting(ChartDrawEvent e) {
				chart1.getChart().setChartRect(new Rectangle((chart1.getWidth() / 2) + margin, 0 + margin, (chart1.getWidth() / 2) - (margin * 2), (chart1.getHeight() / 2) - (margin * 2)));
			}
		});
		chart1.getSeries(2).addSeriesPaintListener(new SeriesPaintAdapter() {
			public void seriesPainting(ChartDrawEvent e) {
				chart1.getChart().setChartRect(new Rectangle(0 + margin, (chart1.getHeight() / 2) + margin, (chart1.getWidth() / 2) - (margin * 2), (chart1.getHeight() / 2) - (margin * 2)));
			}
		});
		chart1.getSeries(3).addSeriesPaintListener(new SeriesPaintAdapter() {
			public void seriesPainting(ChartDrawEvent e) {
				chart1.getChart().setChartRect(
						new Rectangle((chart1.getWidth() / 2) + margin, (chart1.getHeight() / 2) + margin, (chart1.getWidth() / 2) - (margin * 2), (chart1.getHeight() / 2) - (margin * 2)));
			}
		});
		chart1.getSeries().setApplyZOrder(false);
	}

}
