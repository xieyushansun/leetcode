package practice;

import java.util.ArrayList;
import java.util.List;

public class 汇总区间228 {
    public static void main(String[] args){

    }
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int start = nums[0];
        int end = nums[0];
        for(int i = 1; i < nums.length; i++){
            if (nums[i] == end + 1){
                end = nums[i];
            }else {
                if (start == end){
                    result.add(start + "");
                }else {
                    result.add(start + "->" + end);
                }
                start = nums[i];
                end = nums[i];
            }
        }
        if (start == end){
            result.add(start + "");
        }else {
            result.add(start + "->" + end);
        }
        return result;
    }
}
