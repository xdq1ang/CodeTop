import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i <= nums.length-1; i++){
            for (int j = i+1; j <= nums.length-1; j++){
                if((nums[i] + nums[j])==target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}

class Solution2{
    public int[] twoSum(int[] nums, int target) {
        // 创建一个hashMap用于存储遍历过后的元素
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i<=(nums.length-1); i++){
            // 如果 target - x 存在hash表中  则返回
            if(hashMap.containsKey(target-nums[i])){
                return new int[]{i, hashMap.get(target-nums[i])};
            }
            // 值存放在hashmap中
            hashMap.put(nums[i], i);

        }
        return new int[]{};
    }
}