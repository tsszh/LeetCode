package Medium1;

import static org.junit.Assert.*;

import org.junit.Test;

public class LT071Test {
	LT071 sol = new LT071();

	@Test
	public void test1() {
		String res = sol.simplifyPath("/home//cost/./haha/my");
		assertEquals("/home/cost/haha/my", res);
		res = sol.simplifyPath("/a/./b/../../c/");
		assertEquals("/c", res);
		res = sol.simplifyPath("/home/");
		assertEquals("/home", res);
	}

	@Test
	public void test2() {
		String res;
		res = sol.simplifyPath("home");
		assertEquals("/home", res);

		res = sol.simplifyPath("/../");
		assertEquals("/", res);

		res = sol.simplifyPath("");
		assertEquals("/", res);
	}
}
