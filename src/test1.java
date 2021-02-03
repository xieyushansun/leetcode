import java.util.*;

/**
 * @author: Xie
 * @Description: TODO
 * @Contact: qq307954865
 * @Date: 2021/1/26 9:22
 */
public class test1 {
    public static void main(String[] args){
        int[][] nums = {{1,2},{2,1},{3,4},{5,6}};
        numEquivDominoPairs(nums);
    }
    public static int numEquivDominoPairs(int[][] dominoes) {
        int[][] count = new int[10][10];
        for (int[] domino : dominoes) {
            count[domino[0]][domino[1]]++;
        }
        int res = 0;
        for (int i = 1; i < 10; i++) {
            if (count[i][i] >= 1) {
                res += count[i][i] * (count[i][i] - 1) / 2;
            }
            for (int j = i + 1; j < 10; j++) {
                int t = count[i][j] + count[j][i];
                if (t >= 1) {
                    res += t * (t - 1) / 2;
                }
            }
        }
        return res;
    }
}
