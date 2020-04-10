import core.LineChart;
import core.TrendLine;
import core.TrendLineResult;

import java.io.*;
import java.util.*;

public class Main {


	private static final List<String> rawDataThirdTrendLineA = Arrays.asList("M", "M", "U", "U", "U", "U", "M", "D", "U", "M", "M", "M", "U", "U", "U", "U", "M", "M", "M");
	private static final List<String> rawDataThirdTrendLineB = Arrays.asList("U", "U", "M", "D", "M", "M", "U", "M", "D", "U", "U", "U", "D", "M", "M", "D", "U", "U", "U");
	private static final List<String> rawDataThirdTrendLineC = Arrays.asList("D", "D", "D", "M", "D", "D", "D", "U", "M", "D", "D", "D", "M", "D", "D", "M", "D", "D", "D");

	private static final String 떡상 = "U";
	private static final String 평타 = "M";
	private static final String 떡락 = "D";

	public static void main(String[] args) {
		Map<String, List<String>> dataMapper = readFile();

		Analyzer analyzer = createAnalyzer(dataMapper);
		System.out.println(analyzer + "\n");

		TrendLine thirdTrendLineA = new TrendLine("A", rawDataThirdTrendLineA);
		TrendLine thirdTrendLineB = new TrendLine("B", rawDataThirdTrendLineB);
		TrendLine thirdTrendLineC = new TrendLine("C", rawDataThirdTrendLineC);

		int end = 5;

		for (int i = 1; i < end; i++) {

			System.out.println(">>> current " + i + " days");
			TrendLineResult resultA = analyzer.getAnalysisResult(thirdTrendLineA, i);
			//System.out.println(resultA);
			printProbability(resultA);

			TrendLineResult resultB = analyzer.getAnalysisResult(thirdTrendLineB, i);
			//System.out.println(resultB);
			printProbability(resultB);

			TrendLineResult resultC = analyzer.getAnalysisResult(thirdTrendLineC, i);
			//System.out.println(resultC);
			printProbability(resultC);
		}
	}

	private static void printProbability(TrendLineResult result) {
		/*System.out.printf("떡상 = %.2f %%\n", result.getProbability(떡상) * 100);
		System.out.printf("평타 = %.2f %%\n", result.getProbability(평타) * 100);
		System.out.printf("떡락 = %.2f %%\n", result.getProbability(떡락) * 100);*/
		//System.out.println(result);
		System.out.printf("%.2f\n", result.getProbability(떡상) * 100);
		System.out.printf("%.2f\n", result.getProbability(평타) * 100);
		System.out.printf("%.2f\n", result.getProbability(떡락) * 100);
	}

	private static Analyzer createAnalyzer(Map<String, List<String>> mapper) {
		Analyzer analyzer = new Analyzer();
		for (String fileName : mapper.keySet()) {
			analyzer.addLineChart(createLineChart(fileName, mapper.get(fileName)));
		}
		return analyzer;
	}

	private static LineChart createLineChart(String fileName, List<String> lineChartStringData) {
		LineChart lineChart = new LineChart(fileName.split("\\.")[0]);
		for (String s : lineChartStringData) {
			String trendLineName = getTrendLineNameFromInputString(s);
			lineChart.add(trendLineName, createTrendLine(s));
		}
		return lineChart;
	}

	private static String getTrendLineNameFromInputString(String s) {
		return s.split(",")[0];
	}

	private static TrendLine createTrendLine(String trendLineString) {
		String[] split = trendLineString.split(",");
		return new TrendLine(split[0], Arrays.asList(split).subList(1, split.length));
	}

	private static Map<String, List<String>> readFile() {
		Map<String, List<String>> mapper = new HashMap<>();

		try {
			File dir = new File("/Users/delf/Documents/data/ch");
			File[] fileList = dir.listFiles();
			for (File file : fileList) {
				if (!file.isFile() || !file.getName().endsWith("csv")) {
					continue;
				}
				// System.out.println(file.getName());
				FileReader filereader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(filereader);

				String sLine = null;
				List<String> input = new ArrayList<>();
				while ((sLine = bufferedReader.readLine()) != null) {
					input.add(sLine);
				}

				mapper.put(file.getName(), input);

				filereader.close();
				bufferedReader.close();
			}

		} catch (FileNotFoundException e) {
			System.err.println("[ERROR] No such file.");
		} catch (IOException e) {
			System.out.println(e);
		}

		return mapper;
	}
}
