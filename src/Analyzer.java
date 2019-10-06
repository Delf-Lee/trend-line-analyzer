import core.LineChart;
import core.TrendLineResult;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Analyzer {
	private Set<LineChart> lineChartSet = new HashSet<>();

	public void addLineChart(LineChart lineChart) {
		lineChartSet.add(lineChart);
	}

	public TrendLineResult getAnalysisResult(String TrendLineName, List<String> pattern) {
		TrendLineResult result = new TrendLineResult();
		for (LineChart lineChart : lineChartSet) {
			result.merge(lineChart.getPatternResult(TrendLineName, pattern));
		}
		return result;
	}

	@Override
	public String toString() {
		return "Analyzer{" +
				"lineChartSet=" + lineChartSet +
				'}';
	}
}
