package LT150T200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LT187 {
	public List<String> findRepeatedDnaSequences(String s) {
		Set<String> tmp = new HashSet<>();
		Set<String> res = new HashSet<>();
		for (int i = 0; i < s.length() - 9; i++) {
			String sub = s.substring(i, i + 10);
			if (tmp.contains(sub)) {
				tmp.remove(sub);
				res.add(sub);
			} else if (!res.contains(sub)) {
				tmp.add(sub);
			}
		}
		return new ArrayList<String>(res);
	}
}
