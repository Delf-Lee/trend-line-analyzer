package core;

import java.util.ArrayList;
import java.util.List;

public class TrendLine {
	private String name;
	private List<String> elements = new ArrayList<>();

	public TrendLine(String name, List<String> elements) {
		this.name = name;
		this.elements = elements;
	}

	public TrendLineResult getResult(List<String> pattern) {
		TrendLineResult result = new TrendLineResult();
		for (int i = 0; i < elements.size() - 1; i++) {
			if (isSamePattern(i, pattern)) {
				result.add(elements.get(i + pattern.size()));
			}
		}
		return result;
	}

	private boolean isSamePattern(int startIdx, List<String> pattern) {
		if (!elements.get(startIdx).equals(pattern.get(0))) {
			return false;
		}
		if (startIdx + pattern.size() + 1 > elements.size()) {
			return false;
		}

		return elements.subList(startIdx, startIdx + pattern.size()).equals(pattern);
	}

	@Override
	public String toString() {
		return "TrendLine{" +
				"name='" + name + '\'' +
				", elements=" + elements +
				'}';
	}
}