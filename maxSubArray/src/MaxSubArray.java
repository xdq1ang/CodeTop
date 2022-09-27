class Solution {
    // 分治法
    public int maxSubArray(int[] nums) {
        int right = nums.length-1;
        int max = getMax(nums, 0, right);
        return max;

    }
    public int getMax(int[] nums, int left, int right){
        if (left==right){
            return nums[left];
        }
        int mid = left+(right-left)/2;
        int maxLeft = getMax(nums, left, mid);
        int maxRight = getMax(nums, mid+1, right);

        int INT_MIN = -465464;
        int left_sum = INT_MIN;
        int right_sum = INT_MIN;
        for (int i=mid, sum = 0; i>=left; i--){
            sum += nums[i];
            left_sum = max(sum, left_sum);
        }

        for (int i=mid+1, sum = 0; i<=right; i++){
            sum += nums[i];
            right_sum = max(sum, right_sum);
        }

        int crossMax = left_sum + right_sum;

        return max(max(maxLeft, maxRight), crossMax);

    }
    public int max(int n1, int n2){
        return n1>n2?n1:n2;
    }
}

class Solution2{
    // 动态规划
    public int maxSubArray(int[] nums) {
        int[] res = new int[nums.length];
        int maxRes = -45454667;
        for (int i = 0; i<=nums.length-1; i++){
            if(i==0){
                res[i] = nums[i];
            }else {
                if((nums[i]+res[i-1])>nums[i]){
                    res[i] = nums[i]+res[i-1];
                }else {
                    res[i] = nums[i];
                }
            }
            if (res[i]>maxRes){
                maxRes = res[i];
            }

        }
        return maxRes;
    }

}