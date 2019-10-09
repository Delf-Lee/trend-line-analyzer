import core.LineChart;
import core.TrendLine;
import core.TrendLineResult;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Analyzer {
	private Set<LineChart> lineChartSet = new HashSet<>();

	public void addLineChart(LineChart lineChart) {
		lineChartSet.add(lineChart);
	}

	public TrendLineResult getAnalysisResult(String trendLineName, List<String> pattern) {
		TrendLineResult result = new TrendLineResult();
		for (LineChart lineChart : lineChartSet) {
			result.merge(lineChart.getPatternResult(trendLineName, pattern));
		}
		return result;
	}

	public TrendLineResult getAnalysisResult(TrendLine trendLine, int latestDay) {
		return getAnalysisResult(trendLine.getName(), trendLine.getElementsOfLatest(latestDay));
	}

	@Override
	public String toString() {
		return "Analyzer{" +
				"lineChartSet=" + lineChartSet +
				'}';
	}
}
