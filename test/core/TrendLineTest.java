package core;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TrendLineTest {
	@Test
	public void 추세선() {
		TrendLine trendLine = new TrendLine("A", Arrays.asList("u", "u", "d", "m", "d", "m", "d", "u", "m"));
		List<String> pattern = Arrays.asList("m", "d");
		PatternResult patternResult = trendLine.getResult(pattern);

		assertThat(patternResult, equalTo(new PatternResult("m", "u")));
	}
}
