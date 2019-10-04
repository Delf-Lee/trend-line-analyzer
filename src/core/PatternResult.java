package core;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PatternResult {
	private Map<String, Integer> counter = new HashMap<>();

	public PatternResult(String ... trends) {
		for(String trend : trends) {
			add(trend);
		}
	}

	public void add(String trend) {
		counter.merge(trend, 1, Integer::sum);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		PatternResult that = (PatternResult) o;

		return Objects.equals(counter, that.counter);

	}

	@Override
	public int hashCode() {
		return counter != null ? counter.hashCode() : 0;
	}
}
