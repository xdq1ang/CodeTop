/*
 *   @author : xdqiang
 */
public class sortArray {
    public static void main(String[] args) {
        int[] ints = new int[]{2,1,3,5};
        new Solution().sortArray(ints);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
    }
}
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }
    public void quickSort(int[] nums, int l, int r){
        int start = l;
        int end = r;
        if(start >= end){
            return;
        }
        int pivot = nums[l];

        while (l < r){
            while (l < r && nums[r--] > pivot)
            if(l<r){nums[l++] = nums[r];}

            while (l < r && nums[l++] < pivot)
            if(l<r){nums[r--] = nums[l];}
        }
        nums[l] = pivot;
        quickSort(nums, start, l-1);
        quickSort(nums, l+1, end);
    }
}