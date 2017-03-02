package p1.p20;

import java.util.HashMap;
import java.util.Map;

public class P1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,4};
		int[] res = P1.twoSum(nums, 6);
		res = P1.twoSum2(nums, 6);
		System.out.println(res.toString());
	}
	public static int[] twoSum2(int[] numbers, int target) {
	    int[] result = new int[2];
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < numbers.length; i++) {
	        if (map.containsKey(target - numbers[i])) {
	            result[1] = i + 1;
	            result[0] = map.get(target - numbers[i]);
	            return result;
	        }
	        map.put(numbers[i], i + 1);
	    }
	    return result;
	}
	public static int[] twoSum(int[] nums, int target) {
		int length = nums.length;
		int i, j;
		int[] result = new int[2];
		for(i = 0;i < length - 1;i ++){
			for(j = i + 1;j < length;j ++){
				if(nums[i] + nums[j] == target){
					result[0] = i;
					result[1] = j;
					break;
				}
			}
		}
		return result;
    }
}
