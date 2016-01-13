package Medium2;

public class LT134 {
	public static void main ( String[] args ) {
		int[] gas = new int[] {
				-2,3,2,-4,1
		};
		int[] cost = new int[gas.length];
		System.out.println(canCompleteCircuit(gas,cost));
	}
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int start = -1, sum = 0, frontSum = -1;
		for ( int i = 0; i < gas.length; i++ ) {
			int temp = gas[i]-cost[i];
			sum+=temp;
			if ( frontSum >= 0 ) {
				frontSum += temp;
			} else {
				frontSum = temp;
				start = i;
			}
		}
		if ( sum < 0 ) return -1;
		return start;
    }
}
