package dynamic;

import java.util.Random;
import java.util.UUID;

/**
 * @author: Xie
 * @Description: TODO
 * @Contact: qq307954865
 * @Date: 2020/12/10 11:35
 */

// 划分型动态规划
public class DecodeWays {
    public static void main(String[] args){
        System.out.println(numDecodings("0"));
    }
    public static int numDecodings(String s) {
        // write your code here
        char[] arr = s.toCharArray();
        int len = s.length();
        int[] dy_num = new int[len];

        if (s.length() == 0){
            return 0;
        }
        if (s.charAt(0) =='0'){
            return 0;
        }

        dy_num[0] = 1;
        for (int i = 1; i < s.length(); i++){
            // 按一位解析
            if (arr[i] >= '1' && arr[i] <= '9'){
                dy_num[i] += dy_num[i-1];
            }
             // 按两位解析
            int temp = 10 * (arr[i-1] - '0') + arr[i] - '0';
            if(arr[i-1] != '0' && temp <= 26){
                if (i >= 2){
                    dy_num[i] += dy_num[i-2];
                }else {
                    dy_num[i]++;
                }
            }
        }
        return dy_num[s.length() - 1];
    }
}
