import java.util.HashMap;

public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "dvdf";
        int subLen = new Solution().lengthOfLongestSubstring(s);
        System.out.println(subLen);
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        byte[] bytes = s.getBytes();
        int longest = 0;

        if(bytes.length==1){
            return 1;
        }

        HashMap<String, String> subStringHashMap = new HashMap<>();
        int start = 0;
        for (int i = 0; i < bytes.length; i++) {
            subStringHashMap.put(new String(bytes, i, 1),"data");
            if(subStringHashMap.size() < i-start+1 ){
                int subSize = subStringHashMap.size();
                if(longest < subSize){
                    longest = subSize;
                }
                subStringHashMap.clear();
                i = ++ start -1;
            }
        }
        longest = Math.max(longest, subStringHashMap.size());
        return longest;
    }
}