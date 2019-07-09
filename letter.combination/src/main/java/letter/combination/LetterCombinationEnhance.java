package letter.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * For new requirement: support converting digits 0-99
 *
 */
public class LetterCombinationEnhance implements ICombine {

	private NumberLetters nl = new NumberLetters();

	/**
	 * add one step, check the element whether greater than 10, if so, divide it
	 * into 2 numbers between 0 and 9.
	 */
	public List<String> combine(int[] intArr) {
		if (intArr == null || intArr.length == 0) {
			return new ArrayList<String>();
		}

		intArr = checkElementAndDivideIfGreaterThanTen(intArr);

		List<String> list = new ArrayList<String>();
		list.add("");

		for (int i = 0; i < intArr.length; i++) {
			int key = intArr[i];
			char[] letters = nl.getMap().get(key);
			int size = list.size();
			for (int k = 0; k < size; k++) {
				boolean isLettersEmpty = true;
				for (int j = 0; j < letters.length; j++) {
					list.add(list.get(0) + letters[j]);
					isLettersEmpty = false;
				}
				if (!isLettersEmpty) {
					list.remove(0);
				}
			}
		}
		if (list.size() == 1 && list.get(0).equals("")) {
			list.remove(0);
		}
		return list;
	}

	private int[] checkElementAndDivideIfGreaterThanTen(int[] intArr) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < intArr.length; i++) {
			if (intArr[i] >= 10) {
				String temp = "" + intArr[i];
				list.add(Integer.parseInt(temp.charAt(0) + ""));
				list.add(Integer.parseInt(temp.charAt(1) + ""));
			} else {
				list.add(intArr[i]);
			}
		}
		int[] intArrNew = new int[list.size()];
		int k = 0;
		for (int i : list) {
			intArrNew[k++] = i;
		}
		return intArrNew;
	}

	public void printCombinations(List<String> list) {
		if (list == null || list.size() == 0) {
			System.out.print("");
		} else {
			int k = 1;
			for (String s : list) {
				System.out.print(s + " ");
				if (k++ % 10 == 0) {
					System.out.println();
				}
			}
		}
	}

	public static void main(String[] args) {
		LetterCombinationEnhance lce = new LetterCombinationEnhance();
		int[] intArr = { 0, 12, 31,4 };
		List<String> list = lce.combine(intArr);
		lce.printCombinations(list);
	}
}
