/*
 *   @author : xdqiang
 */
public class findKthLargest {
    public static void main(String[] args) {
        int[] ints = new int[]{-1, 2, 0};
        int kthLargest = new Solution().findKthLargest(ints, 3);
        int kthLargest1 = new Solution2().findKthLargest(ints, 3);
        System.out.println(kthLargest1);

    }
}

class Solution {
    // 确定数据量的情况下可以使用快速选择算法
    public int findKthLargest(int[] nums, int k) {
        int i = quickSelect(nums, k-1, 0, nums.length-1);
        return nums[i];
    }
    public int quickSelect(int[] nums, int k,  int l, int r){
        // 从大到小排序
        // 取第一个元素为轴值
        int pivot = nums[l];
        while (l != r){
            while(l < r && nums[r] <= pivot){
                r--;
            }
            if(l!=r){
                nums[l++] = nums[r];
            }
            while (l < r && nums[l] >= pivot){
                l++;
            }
            if(l!=r){
                nums[r--] = nums[l];
            }

        }
        nums[l] = pivot;
        // 返回轴值index
        if(k==l){
            return l;
        } else if (k > l) {
            return quickSelect(nums, k, l+1, nums.length-1);
        }else {
            return quickSelect(nums,k,0, l-1);
        }
    }
}

class Solution2 {
    // 确定数据量的情况下可以使用快速选择算法
    public int findKthLargest(int[] nums, int k) {
        buildMaxHeap(nums,nums.length);

        for (int i = 1; i < k; i++) {
            delMax(nums);
        }
        return nums[0];
    }
    public void buildMaxHeap(int[] nums, int size){
        int lastRoot = (size)/2-1;
        for (int i = lastRoot ; i >= 0 ; i--) {
            maxFy(nums, i);
        }
    }
    public void maxFy(int[] nums, int root){
        int left = 2*root+1;
        int right = 2*root+2;
        if(root > (nums.length-1)/2-1){
            return;
        }
        if(nums[root] < nums[left] || nums[root] < nums[right]){
            if (nums[left] > nums[right]) {
                swap(nums, root, left);
                maxFy(nums, left);
            } else {
                swap(nums, root, right);
                maxFy(nums, right);
            }
        }
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
    public void delMax(int[] nums){
        nums[0] = nums[nums.length-1];
        buildMaxHeap(nums, nums.length-1);
    }

}