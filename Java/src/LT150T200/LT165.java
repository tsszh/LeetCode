package LT150T200;

import java.util.Arrays;

/**
 * 165. Compare Version Numbers
 * 
 * Compare two version numbers version1 and version2.
 * 
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * 
 * Here are examples of version numbers ordering:
 * 
 * 0.1 < 1.1 < 1.2 < 13.37
 * 
 * 1.0.1 > 1
 * 
 * @author Zehao
 *
 */
public class LT165 {
	public int compareVersion(String version1, String version2) {
		return compareVersionHelper(version1, version2);
	}
	private int compareVersionHelper( String a, String b ) {
		String[] as = a.split("\\.");
		String[] bs = b.split("\\.");
		if (as.length < bs.length) {
			as = Arrays.copyOf(as, bs.length);	
		} else if (as.length > bs.length) {
			bs = Arrays.copyOf(bs, as.length);
		}
		for (int i = 0; i < as.length; i++) {
			if (compareStringNumber(as[i], bs[i]) < 0) return -1;
			if (compareStringNumber(as[i], bs[i]) > 0) return 1;
		}
		return 0;
	}
	private int compareStringNumber(String a, String b) {
		int ia = 0, ib = 0;
		if (a != null && a.length() != 0) ia = Integer.parseInt(a);
		if (b != null && b.length() != 0) ib = Integer.parseInt(b);
		return ia - ib;
	}
}
