package practice;

import java.util.PriorityQueue;

public class 滑动窗口最大值239 {
    public static void main(String[] args){
        int[] nums = {4, 1, 2, 2, 1, 1, 1, 1};
        int k = 4;
        int[] result = maxSlidingWindow(nums, k);
        for (int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        return result;
    }
}
