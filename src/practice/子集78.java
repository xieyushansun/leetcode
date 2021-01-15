package practice;

import java.util.ArrayList;
import java.util.List;

public class 子集78 {
    public static void main(String[] args){
        int[] nums = {1,2,3};
        subsets(nums);
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int l = nums.length;
        int m = (int)Math.pow(2, l);
        for (int i = 0; i < m; i++){
            String b = Integer.toBinaryString(i);
            int re = nums.length - b.length();
            List<Integer> list = new ArrayList<>();
            for (int j = b.length() - 1; j >= 0; j--){
                if (b.charAt(j) == '1'){
                    list.add(nums[j + re]);
                }
            }
            result.add(list);
        }
        return result;
    }
}
