package core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LineChart {
	private String title;
	private Map<String, TrendLine> trendLines;

	public LineChart(String title) {
		this.title = title;
		this.trendLines = new HashMap<>();
	}

	public LineChart(String title, Map<String, TrendLine> trendLines) {
		this.title = title;
		this.trendLines = trendLines;
	}

	public void add(String name, TrendLine trendLine) {
		trendLines.put(name, trendLine);
	}

	public TrendLineResult getPatternResult(String name, List<String> pattern) {
		TrendLine trendLine = trendLines.get(name);
		return trendLine.getResult(pattern);
	}

	@Override
	public String toString() {
		return "\nLineChart{" +
				"title='" + title + '\'' +
				", trendLines=" + trendLines +
				'}';
	}
}
