import java.util.*;

/*
 *   @author : xdqiang
 */
public class threeSum {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.threeSum(new int[]{0,-1,1,2,-1,-4}));
    }
}

class Solution1 {
    public  List<List<Integer>> threeSum(int[] nums) {
        HashSet<ThreeNum> lists = new HashSet<>();
        List<List<Integer>> lists1 = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                for (int k = 0; k < nums.length; k++) {
                    if((nums[i] + nums[j] + nums[k]) == 0 && (i != j && i != k && j != k)){
                        ThreeNum threeNum = new ThreeNum(nums[i], nums[j], nums[k]);
                        lists.add(threeNum);
                    }
                }
            }
        }
        for (ThreeNum e : lists) {
            lists1.add(e.getList());
        }
        return lists1;
    }
}

class ThreeNum{
//    HashSet<Integer> threes = new HashSet<>();
    List<Integer> threes = new LinkedList<>();
    public ThreeNum(int num1, int num2, int num3){
        if(num1==0 && num2 == 0 && num3 == 0){
            System.out.println(1);
        }
        this.threes.add(num1);
        this.threes.add(num2);
        this.threes.add(num3);

    }
    public List<Integer> getList(){
        List<Integer> list = new LinkedList<>();
        list.addAll(threes);
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        List<Integer> list0 = ((ThreeNum) o).getList();
        List<Integer> list1 = getList();
        if (o == null || getClass() != o.getClass()) return false;
        boolean removed = true;
        for (Integer e : list0) {
            removed = list1.remove(e);
            if(!removed){
                break;
            }
        }
        return removed;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "ThreeNum{" +
                "threes=" + threes +
                '}';
    }
}

