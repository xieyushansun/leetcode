package Graph;

import java.util.*;

class Solution1 {
    public static void main(String[] args){
        String ring = "ifotfo";
        String key = "fioot";
        System.out.println(findRotateSteps(ring, key));
    }
    static int ringLength;
    public static int findRotateSteps(String ring, String key) {
        ringLength = ring.length();
        Map<Character, List<Integer>> map = new LinkedHashMap<>();
        int[][] dp = new int[key.length()][ring.length()];
        for (int i = 0; i < ring.length(); i++){
            char ch = ring.charAt(i);
            List<Integer> list = map.getOrDefault(ch, new ArrayList<>());
            list.add(i);
            map.put(ch, list);
        }
        int flag = 0;
        int last = 0;
        for (int i = 0; i < key.length(); i++){
            List<Integer> list = map.get(key.charAt(i));
            if (flag == 0){
                for (int j = 0; j < list.size(); j++){
                    int target = list.get(j);
                    dp[i][target] = getMin(last, target);
                }
                flag = 1;
            }else {
                List<Integer> lastList = map.get(key.charAt(i-1));
                for (int p = 0; p < list.size(); p++){
                    int target = list.get(p);
                    dp[i][target] = dp[i-1][lastList.get(0)] + getMin(lastList.get(0), target);
                    for (int q = 1; q < lastList.size

                            (); q++){
                        dp[i][target] = Math.min(dp[i][target], dp[i-1][lastList.get(q)] + getMin(lastList.get(q), target));
                    }
                }
            }
        }
        List<Integer> l = map.get(key.charAt(key.length() - 1));
        int min = dp[key.length() - 1][l.get(0)];
        for (Integer i: l) {
            if (dp[key.length() - 1][i] < min){
                min = dp[key.length() - 1][i];
            }
        }
        return min;
    }
    public static int getMin(int last, int target){
        int left = 0;
        int right = 0;
        if (last == target){
            return 1;
        }
        if (last < target){
            right = target - last;
            left = last + ringLength - target;
        }else {
            left = last - target;
            right = target + ringLength - last;
        }
        return Math.min(left, right) + 1;
    }
}