package Contest;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class P3 {
	private Map<Integer, String> map;
	public P3(int[] nums) {
        this.map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
        	int tmp = nums[i];
        	if (map.containsKey(tmp)) {
        		map.put(tmp, map.get(tmp) + ":"+i);
        	} else {
        		map.put(tmp, "" + i);
        	}
        }
    }
    
    public int pick(int target) {
        String[] pool = this.map.get(target).split(":");
        Random rand = new Random();
        int randonNum = rand.nextInt(pool.length);
        return Integer.parseInt(pool[randonNum]);
    }
}
