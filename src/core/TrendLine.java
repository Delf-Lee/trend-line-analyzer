package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrendLine {
	private String category;
	private List<String> elements = new ArrayList<>();

	public TrendLine(String category, List<String> elements) {
		this.category = category;
		this.elements = elements;
	}

	public PatternResult getResult(List<String> pattern) {
		PatternResult result = new PatternResult();
		for (int i = 0; i < elements.size() - 1; i++) {
			if (isSamePattern(i, pattern)) {
				result.add(elements.get(i + pattern.size()));
			}
		}
		return result;
	}

	private boolean isSamePattern(int index, List<String> pattern) {
		for (String trend : pattern) {
			if (elements.get(index).equals(trend) && isEqualPattern(index, pattern)) {
				return false;
			}
		}
		return true;
	}

	private boolean isEqualPattern(int startIdx, List<String> pattern) {
		return elements.subList(startIdx, startIdx + pattern.size()).equals(pattern);
	}

	public static void main(String[] args) {
		TrendLine trendLine = new TrendLine("A", Arrays.asList("u", "u", "d", "m", "d", "m", "d", "u", "m"));
		List<String> pattern = Arrays.asList("m", "d");
		System.out.println(trendLine.isEqualPattern(3, pattern));

	}
}