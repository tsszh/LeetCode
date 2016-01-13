package Medium1;

import java.util.Arrays;

/**
 * 71. Simplify Path
 * 
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * path = "/../", => "/"
 * 
 * @author Zehao
 *
 */
public class LT071 {
	/**
	 * Take advantage of Stack
	 * 
	 */
	public String simplifyPath(String path) {
		String[] paths = path.split("/");
		String[] res = new String[paths.length];
		int j = 0;
		for (String temp : paths) {
			if (temp.equals("") || temp.equals("."))
				continue;
			if (temp.equals("..")) {
				if (j > 0) {
					res[j--] = "";
				}
			} else {
				res[j++] = temp;
			}
		}
		return "/" + String.join("/", Arrays.copyOfRange(res, 0, j));
	}
}
