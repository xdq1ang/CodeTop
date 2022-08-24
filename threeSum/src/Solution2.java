import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *   @author : xdqiang
 */
public class Solution2 {
    public  List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 如果数组大小小于3则返回空数组
        if(nums.length < 3){
            return res;
        }
        // 数组容量大于3，排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int r = nums.length-1;
            int l = i+1;
            if(nums[i] > 0 ){
                break;
            }
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            while (l < r){
                if((nums[i] + nums[l] + nums[r]) == 0){
                    List<Integer> threeNums = new ArrayList<>();
                    threeNums.add(nums[i]);
                    threeNums.add(nums[l]);
                    threeNums.add(nums[r]);
                    res.add(threeNums);
                    while (l < r && nums[l] == nums[l+1]){
                        l++;
                    }
                    while (l < r && nums[r]==nums[r-1]){
                        r--;
                    }
                    l++;
                    r--;
                }else if((nums[i] + nums[l] + nums[r]) < 0){
                    while (l < r && nums[l] == nums[l+1]){
                        l++;
                    }
                    l++;
                }else if((nums[i] + nums[l] + nums[r]) > 0){
                    while (l < r && nums[r]==nums[r-1]){
                        r--;
                    }
                    r--;
                }
            }
        }
        return res;
    }
}
