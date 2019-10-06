package core;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TrandLineResult {
	private Map<String, Integer> counter = new HashMap<>();

	public TrandLineResult(String ... trends) {
		for(String trend : trends) {
			add(trend);
		}
	}

	public TrandLineResult merge(TrandLineResult patternResult) {
		for (String trend : patternResult.counter.keySet()) {
			counter.merge(trend, patternResult.counter.get(trend), Integer::sum);
		}
		return this;
	}

	public void add(String trend) {
		counter.merge(trend, 1, Integer::sum);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TrandLineResult that = (TrandLineResult) o;

		return Objects.equals(counter, that.counter);

	}

	@Override
	public int hashCode() {
		return counter != null ? counter.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "PatternResult{" +
				"counter=" + counter +
				'}';
	}
}
