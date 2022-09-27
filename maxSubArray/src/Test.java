/*
 *   @author : xdqiang
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        System.out.println(solution.maxSubArray(nums));
        System.out.println(solution2.maxSubArray(nums));
    }
}
