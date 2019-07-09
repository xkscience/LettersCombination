package letter.combination;

import java.util.HashMap;
import java.util.Map;

public class NumberLetters {
	public static final char[] NUM0 = {};
	public static final char[] NUM1 = {};
	public static final char[] NUM2 = { 'A', 'B', 'C' };
	public static final char[] NUM3 = { 'D', 'E', 'F' };
	public static final char[] NUM4 = { 'G', 'H', 'I' };
	public static final char[] NUM5 = { 'J', 'K', 'L' };
	public static final char[] NUM6 = { 'M', 'N', 'O' };
	public static final char[] NUM7 = { 'P', 'Q', 'R', 'S' };
	public static final char[] NUM8 = { 'T', 'U', 'V' };
	public static final char[] NUM9 = { 'W', 'X', 'Y', 'Z' };
	
	private Map<Integer, char[]> map;

	public NumberLetters() {
		map = new HashMap<Integer, char[]>();
		map.put(0, NUM0);
		map.put(1, NUM1);
		map.put(2, NUM2);
		map.put(3, NUM3);
		map.put(4, NUM4);
		map.put(5, NUM5);
		map.put(6, NUM6);
		map.put(7, NUM7);
		map.put(8, NUM8);
		map.put(9, NUM9);
	}

	public Map<Integer, char[]> getMap() {
		return map;
	}

}
