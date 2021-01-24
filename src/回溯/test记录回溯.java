package 回溯;

import java.util.*;

class test记录回溯 {
    public static void main(String[] args){
        int[] nums = {2,3,5};
        int target = 8;
    }
//    static Set<List<Integer>> sets;
//    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        sets = new HashSet<>();
//        Arrays.sort(candidates);
//        for (int i = 0; i < candidates.length; i++){
//            List<Integer> list = new ArrayList<>();
//            f(0, candidates, target, list, candidates[i]);
//        }
//
//        return new ArrayList<>(sets);
//    }
//    public static boolean f(int currentTotal, int[] candidates, int target, List<Integer> list, int num){
//        if (currentTotal + num == target){
//            list.add(num);
//            list.sort(new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    return o1-o2;
//                }
//            });
//            sets.add(list);
//            return false;
//        }else if (currentTotal + num > target){
//            return false;
//        }else {
//            currentTotal += num;
//            list.add(num);
//        }
//        for (int i = 0; i < candidates.length; i++){
//            List<Integer> temp = new ArrayList<>();
//            temp.addAll(list);
//            boolean result = f(currentTotal, candidates, target, temp, candidates[i]);
//            if (!result){
//                break;
//            }
//        }
//        return true;
//    }
}
