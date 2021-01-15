package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和39 {
    public static void main(String[] args){
        int[] nums = {2, 3, 5};
        combinationSum(nums, 8);
    }
    static List<List<Integer>> lists = new ArrayList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); // 从小到大排序
        int index = 0; // 表示当前计算到哪一位了
        int total = 0;
        List<Integer> list = new ArrayList<>();
        f(candidates, index, total, target, list);
        return lists;
    }
    public static void F(){

    }
    public static boolean f(int[] candidates, int index, int total, int target, List<Integer> list){
        if (index >= candidates.length){
            return false;
        }
        int temp = candidates[index];
        if(total + temp == target){
            list.add(temp);
            total += temp;
        }else if (total + temp > target){
            return false;
        }
        for (int i = index; i < candidates.length; i++){
            List<Integer> list1 = new ArrayList<>(list);
            if (!f(candidates, i, total + candidates[i], target, list1)){ // 如果此路行不通，则后面的路也都不必走了
                break;
            }
        }
        return false;
    }
}
