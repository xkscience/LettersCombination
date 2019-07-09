package letter.combination;

import static org.junit.Assert.assertThat;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

public class LetterCombinationEnhanceTest {
	LetterCombinationEnhance lce;

	@Before
	public void init() {
		lce = new LetterCombinationEnhance();
	}

	@Test
	public void inputArrayContainsNumbersLessThan10() {
		int[] inputArr = { 2, 3, 4 };
		List<String> list = lce.combine(inputArr);
		assertThat(list.size(), CoreMatchers.is(27));
		assertThat(list.toString(), CoreMatchers.containsString("BDG"));
	}

	@Test
	public void inputArrayContainsNumbersGreaterThan10() {
		int[] inputArr = { 12, 3, 41, 99 };
		List<String> list = lce.combine(inputArr);
		assertThat(list.size(), CoreMatchers.is(3 * 3 * 3 * 4 * 4));
		assertThat(list.toString(), CoreMatchers.containsString("CFHXZ"));
	}
}
