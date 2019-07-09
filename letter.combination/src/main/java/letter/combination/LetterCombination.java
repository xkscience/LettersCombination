package letter.combination;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination implements ICombine {
	private NumberLetters nl = new NumberLetters();

	/**
	 * if input array contains number>=10, 
	 * then this element will be skip, only
	 * support converting numbers between 0 and 9.
	 */
	public List<String> combine(int[] intArr) {
		if (intArr == null || intArr.length == 0) {
			return new ArrayList<String>();
		}
		List<String> list = new ArrayList<String>();
		list.add("");
		for (int i = 0; i < intArr.length; i++) {
			int key = intArr[i];
			if (key >= 10) {
				System.out.println("Sorry,currently we don't support converting the number greater than 10!");
				continue;
			}
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
		LetterCombination lc = new LetterCombination();
		int[] intArr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		List<String> list = lc.combine(intArr);
		lc.printCombinations(list);
	}
}
