package core;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TrendLineTest {

	private TrendLine trendLine = new TrendLine("A", Arrays.asList("u", "u", "d", "m", "d", "m", "d", "u", "m"));

	@Test
	public void 추세선() {
		List<String> pattern = Arrays.asList("m", "d");
		TrendLineResult patternResult = trendLine.getResult(pattern);

		assertThat(patternResult, equalTo(new TrendLineResult("m", "u")));
	}

	@Test
	public void 추세선2() {
		List<String> pattern = Arrays.asList("m");
		TrendLineResult patternResult = trendLine.getResult(pattern);

		assertThat(patternResult, equalTo(new TrendLineResult("d", "d")));
	}

	@Test
	public void 추세선3() {
		List<String> pattern = Arrays.asList("u", "d", "m", "d");
		TrendLineResult patternResult = trendLine.getResult(pattern);

		assertThat(patternResult, equalTo(new TrendLineResult("m")));
	}
}
