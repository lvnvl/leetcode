package contest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Contest22P1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Contest22P1.findPairs(new int[]{3,1,4,1,5}, 2));
		System.out.println(Contest22P1.findPairs(new int[]{1,2,3,4,5}, 1));
		System.out.println(Contest22P1.findPairs(new int[]{1,3,1,5,4}, 0));
	}
	
	public static int findPairs(int[] nums, int k) {
		int result = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Map<Integer, Integer> solved = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i ++){
			if(map.containsKey(nums[i])){
				continue;
			} else {
				map.put(nums[i], i);
			}
		}
		Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Integer, Integer> en = it.next();
			if(solved.containsKey((int)en.getKey()))
				continue;
			if(map.containsKey((int)en.getKey() + k)){
				result ++;
				solved.put((int)en.getKey() + k, 1);
			}
			if(map.containsKey((int)en.getKey() - k)){
				result ++;
				solved.put((int)en.getKey() - k, 1);
			}
		}
		return result;
    }
}
