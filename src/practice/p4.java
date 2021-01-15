package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class p4 {
    public static void main(String[] args){
        int[] nums = {38,49,91,59,14,76,84,12};
        int k = 3;
        minimumTimeRequired(nums, k);
    }
    public static int minimumTimeRequired(int[] j, int k) {
        Integer[] jobs = new Integer[j.length];
        for (int i = 0; i < jobs.length; i++){
            jobs[i] = j[i];
        }
        Arrays.sort(jobs, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        // 91 84 76 59 49 38 14 12
        int n = jobs.length % k;
        Integer[] newjob = new Integer[jobs.length - n];
        for (int i = 0; i < newjob.length - n; i++){
            newjob[i] = jobs[i];
        }
        for (int i = newjob.length - n; i < newjob.length; i++){
            newjob[i] = jobs[i] + jobs[i + n];
        }

        Arrays.sort(newjob, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        int[] result = new int[k];
        int mini = 0; // 记录最大的index
        for (int i = 0; i < newjob.length; i++){
            result[mini] += newjob[i];
            mini = getMinIndex(result);
        }
        int max = getMaxIndex(result);
        return max;
    }

    public static int getMinIndex(int[] result){
        int mini = 0;
        int min = result[mini];
        for (int i = 1; i < result.length; i++){
            if (result[i] < min){
                min = result[i];
                mini = i;
            }
        }
        return mini;
    }
    public static int getMaxIndex(int[] result){
        int max = result[0];
        for (int i = 1; i < result.length; i++){
            if (result[i] > max){
                max = result[i];
            }
        }
        return max;
    }
}
