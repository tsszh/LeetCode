package Contest;

public class P1 {
	public int maxRotateFunction(int[] A) {
		int res = rotate(A, 0);
//		System.out.println(res);
		for (int n = 1; n < A.length; n++) {
			int tmp = rotate(A, n);
//			System.out.println(tmp);
			if (tmp > res) res = tmp;
		}
		return res;
    }
	private int rotate(int[] A, int k) {
		int len = A.length;
		int res = 0;
		for (int n = 0; n < len; n++) {
			res += n * A[(n-k+len)%len];
		}
		return res;
	}
}
