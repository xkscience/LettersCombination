package letter.combination;

import static org.junit.Assert.assertThat;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

public class LetterCombinationTest {
	LetterCombination lc;

	@Before
	public void init() {
		lc = new LetterCombination();
	}

	@Test
	public void inputArrayIsNull() {
		int[] inputArr = null;
		List<String> list = lc.combine(inputArr);
		assertThat(list.size(), CoreMatchers.is(0));
	}

	@Test
	public void inputArrayIsEmpty() {
		int[] inputArr = {};
		List<String> list = lc.combine(inputArr);
		assertThat(list.size(), CoreMatchers.is(0));
	}

	@Test
	public void inputArrayIsZero() {
		int[] inputArr = { 0 };
		List<String> list = lc.combine(inputArr);
		assertThat(list.size(), CoreMatchers.is(0));
	}

	@Test
	public void inputArrayIsOne() {
		int[] inputArr = { 1 };
		List<String> list = lc.combine(inputArr);
		assertThat(list.size(), CoreMatchers.is(0));
	}

	@Test
	public void inputArrayIsZeroAndOne() {
		int[] inputArr = { 0, 1 };
		List<String> list = lc.combine(inputArr);
		assertThat(list.size(), CoreMatchers.is(0));
	}

	@Test
	public void inputArrayContains2To9() {
		int[] inputArr = { 2, 3 };
		List<String> list = lc.combine(inputArr);
		// 3*3=9
		assertThat(list.size(), CoreMatchers.is(9));
		assertThat(list.toString(), CoreMatchers.containsString("AD"));

		int[] inputArr2 = { 4, 5, 6, 7, 8, 9 };
		list = lc.combine(inputArr2);
		// 3*3*3*4*3*4
		assertThat(list.size(), CoreMatchers.is(3 * 3 * 3 * 4 * 3 * 4));
		assertThat(list.toString(), CoreMatchers.containsString("GKNQUY"));
	}

	@Test
	public void inputArrayContainsNumberWhichMapLetterOrNot() {
		int[] inputArr = { 0, 1, 2, 3, 6, 7 };
		List<String> list = lc.combine(inputArr);
		assertThat(list.size(), CoreMatchers.is(3 * 3 * 3 * 4));
		assertThat(list.toString(), CoreMatchers.containsString("CEOR"));
	}

	@Test
	public void inputArrayContainsNumberGreaterThan10() {
		int[] inputArr = { 0, 12 };
		List<String> list = lc.combine(inputArr);
		assertThat(list.size(), CoreMatchers.is(0));

		int[] inputArr2 = { 12, 3, 4 };
		list = lc.combine(inputArr2);
		assertThat(list.size(), CoreMatchers.is(9));
		assertThat(list.toString(), CoreMatchers.containsString("DH"));
	}
}
