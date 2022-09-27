/*
 *   @author : xdqiang
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int[] res = new Solution2().twoSum(nums, 9);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
